import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { TranslateModule } from "@ngx-translate/core";
import { FormsModule } from "@angular/forms";

import { NavigationMenuComponent } from './navigation-menu/navigation-menu.component';
import { UiToolkitModule } from 'src/app/toolkit/ui-toolkit.module';

@NgModule({
   imports: [
      CommonModule,
      TranslateModule,
      FormsModule,
      UiToolkitModule
   ],
   declarations: [
      NavigationMenuComponent
   ],
   exports: [
      NavigationMenuComponent
   ]
})
export class InteractionsComponentsModule {
}
