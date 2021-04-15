import { Injectable, Component, Input, OnDestroy, OnChanges, SimpleChanges } from "@angular/core";
import { Router, NavigationStart } from "@angular/router";
import { TranslateService } from "@ngx-translate/core";
import { SnotifyPosition, SnotifyService, SnotifyToastConfig, ToastDefaults } from "ng-snotify";

import { Subject, Subscription } from "rxjs";
import { filter } from "rxjs/operators";

import { ValidationError } from "../commons/errors";
import { Notification, MessageNotification, NotificationType } from "../commons/notifications";


export const NotificationBrokerProvider = {
   provide: "SnotifyToastConfig",
   useValue: ToastDefaults
};

@Injectable()
export class UiToolkit {

   private busyStates: Map<string, BusyState> = new Map<string, BusyState>();

   constructor(
      router: Router,
      private translationService: TranslateService,
      private snotifyService: SnotifyService,
   ) {
      const config = {} as SnotifyToastConfig;

      config.timeout = 6000;
      config.position = SnotifyPosition.rightTop;
      config.closeOnClick = true;
      config.showProgressBar = false;
      config.pauseOnHover = false;
      config.bodyMaxLength = 400;

      this.snotifyService.setDefaults({toast: config});

      router.events.pipe(
         filter(event => event instanceof NavigationStart)
      ).subscribe(() => this.snotifyService.clear());
   }

   public translate(key: string, params?: any){
      return this.translationService.get(key, params);
   }

   public handleError(error: Error): void {
      if (error instanceof ValidationError) {
         for (const reason of error.reasons()) {
            this.notify(new MessageNotification(NotificationType.Warning, reason.message, reason.messageParameters));
         }
      } else {
         const holder: any = error;
         if (holder.NotificationType) {
            this.notify(holder as Notification);
         } else {
            this.notify(new MessageNotification(NotificationType.Error, "ERROR.SYSTEM.UNEXPECTED"));
         }
      }
   }

   public notify(notification: Notification): void {
      this.translationService.get(notification.message, notification.messageParameters).toPromise().then(text => {

         let method: (msg: string) => void;
         switch (notification.type){
            case NotificationType.Warning:
               method = this.snotifyService.warning;
               break;
            case NotificationType.Success:
               method = this.snotifyService.success;
               break;
            case NotificationType.Information:
               method = this.snotifyService.info;
               break;
            case NotificationType.Success:
               method = this.snotifyService.error;
               break;
            default:
               method = this.snotifyService.error;
               break;
         }

         method(text);
      });

   }

   resolveState(name: string): BusyState {
      let state: BusyState | null = this.busyStates[name];

      if (state == null) {
         state = new BusyState();
         this.busyStates[name] = state;
      }

      return state;
   }

   public waitFor<T>(workSupplier: (ctx: WaitContext) => Promise<T>, target: string = "viewport"): Promise<T> {
      return new Promise<T>((resolve, reject) => window.setTimeout(() => {

            const context = new WaitContext();
            const blockOn = this.resolveState(target);

            const work = workSupplier(context);

            blockOn.increment();

            work.then((payload: T) => {

               resolve(payload);

               blockOn.decrement();

            }).catch((error: any) => {

               this.handleError(error);

               reject(error);

               blockOn.decrement();
            });

         }, 1)
      );
   }

}

export class WaitContext {

}

class BusyState {

  private stackCount = 0;
  private stateSubject = new Subject<BusyState>();
  stateObservabe = this.stateSubject.asObservable();

  public increment(): void {
    this.stackCount = this.stackCount + 1;
    this.stateSubject.next(this);
  }

  public decrement(): void{
    this.stackCount = this.stackCount - 1;
    this.stateSubject.next(this);
  }

  public get isVisible(): boolean {
    return this.stackCount > 0;
  }
}

@Component({
  selector: "wait-panel",
  templateUrl: "./wait-panel.component.html"
})
export class WaitPanelComponent implements OnDestroy, OnChanges {

  @Input() name: string;

  isVisible = false;

  private subscription: Subscription;

  constructor(
    private ui: UiToolkit
  ) {
  }

  get isTotalOverlay(): boolean {
    return this.name === "viewport";
  }

  public ngOnChanges(changes: SimpleChanges): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }

    this.subscription = this.ui.resolveState(this.name).stateObservabe
      .subscribe((state: BusyState) => {
        this.isVisible = state.isVisible;
      });
  }

  public ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
