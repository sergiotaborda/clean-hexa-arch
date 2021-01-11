import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule, HttpClient } from "@angular/common/http";
import { TranslateModule, TranslateLoader } from "@ngx-translate/core";
import { TranslateHttpLoader } from "@ngx-translate/http-loader";
import { RouterModule } from "@angular/router";
import { FormsModule } from "@angular/forms";

import { SnotifyModule, SnotifyService, ToastDefaults } from "ng-snotify";
import { AngularSvgIconModule } from "angular-svg-icon";

import { AppComponent } from "./app.component";
import { InteractionsModule } from "./interaction/interactions.module";
import { AppRoutes } from "./app.routes";
import { UiToolkitModule } from "./toolkit/ui-toolkit.module";
import { GatewaysModule } from "./gateways/gateways.module";

// AoT requires an exported function for factories
export function HttpLoaderFactory(http: HttpClient): TranslateHttpLoader {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
   FormsModule,
   BrowserModule,
   HttpClientModule,
   TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
   RouterModule.forRoot(AppRoutes),
   SnotifyModule.forRoot(), // notificatino support
   AngularSvgIconModule.forRoot(), // svg support
   // UI Toolkit
   UiToolkitModule,
   // application
   InteractionsModule,
   GatewaysModule
  ],
  providers: [
    SnotifyService,
    { provide: "SnotifyToastConfig", useValue: ToastDefaults},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
