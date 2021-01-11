import { Component, Input, Output, EventEmitter } from "@angular/core";


@Component({
  selector: "command",
  template: `
      <button type="button" class=" {{block}} command" 
         [class.state-primary]="isPrimary" 
         [class.state-secondary]="isSecondary"   
         [class.with-icon]="isIconVisible"
         [class.with-caption]="isCaptionVisible"    
         (click)="action.emit($event)" 
         [disabled]="!isEnabled"
         [title]=title>
         <icon class="command__icon" [type]="iconType" *ngIf="mustShowIcon(-1)"></icon>
         <span class="command__caption" *ngIf="mustShowCaption()">{{ caption | translate}}</span>
         <icon class="command__icon" [type]="iconType" *ngIf="mustShowIcon(1)"></icon>
      </button>
  `
})
export class CommandComponent {

  @Input() block: string;
  @Input() caption: string;
  @Input() iconType: string;

  @Input() isEnabled = true;
  @Input() kind = CommandKind.Default;
  @Input() mode = CommandMode.IconAndCaption;
  @Input() iconPosition = IconPosition.Left; // TODO get from uiToolkit

  @Output() action: EventEmitter<any> = new EventEmitter<any>();

  get title(){
      return this.caption;
  }
  
  get isPrimary(){
     return this.kind === CommandKind.Primary;
  }
  
  get isSecondary(){
     return this.kind === CommandKind.Secondary;
  }
  
  get isIconVisible(){
    return this.mode == CommandMode.IconOnly
        || this.mode == CommandMode.IconAndCaption;
  }

  get isCaptionVisible(){
    return this.mode == CommandMode.CaptionOnly
        || this.mode == CommandMode.IconAndCaption;
  }

   mustShowIcon(iconPosition : IconPosition){
      if (this.mode == CommandMode.IconOnly){
         return iconPosition == IconPosition.Left;
      } else if (this.mode == CommandMode.IconAndCaption){
         return this.iconPosition == iconPosition;
      }
      return false;
   }
   
   mustShowCaption(){
      return this.mode == CommandMode.IconAndCaption
          || this.mode == CommandMode.CaptionOnly;
   }
}

export enum CommandMode {

   IconAndCaption = "iconAndCaption",
   CaptionOnly = "captionOnly",
   IconOnly = "iconOnly"
} 

export enum CommandKind {

   Default = "default",
   Primary = "primary",
   Secondary = "secondary",
} 

export enum IconPosition {

   Rigth = 1,
   Left = -1,
} 