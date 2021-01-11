import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { TranslateModule } from "@ngx-translate/core";
import { FormsModule } from "@angular/forms";
import { AngularSvgIconModule } from 'angular-svg-icon';

import { UiToolkit, WaitPanelComponent } from "./ui-toolkit";
import { PageComponent, PageTopComponent, PageContentComponent, PageFooterComponent } from "./components/page/page.component";
import { CommandComponent } from "./components/command/command.component";
import { TextFieldComponent } from "./components/text-field/text-field.component";
import { PasswordFieldComponent } from "./components/password-field/password-field.component";
import { IconComponent } from './components/icon/icon.component';
import { PageNavigatorComponent } from './components/page-navigator/page-navigator.component';

@NgModule({
   imports: [
      AngularSvgIconModule, // support the icon component
      CommonModule,
      TranslateModule,
      FormsModule
   ],
   declarations: [
      IconComponent,
      WaitPanelComponent,
      PageComponent,
      PageTopComponent,
      PageContentComponent,
      PageFooterComponent,
      PageNavigatorComponent,
      CommandComponent,
      TextFieldComponent,
      PasswordFieldComponent
   ],
   exports: [
      IconComponent,
      WaitPanelComponent,
      PageComponent,
      PageTopComponent,
      PageContentComponent,
      PageFooterComponent,
      PageNavigatorComponent,
      CommandComponent,
      TextFieldComponent,
      PasswordFieldComponent
   ],
   providers: [
      UiToolkit
   ]
})
export class UiToolkitModule {
}
