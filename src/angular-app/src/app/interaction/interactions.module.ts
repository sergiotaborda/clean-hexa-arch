import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { TranslateModule } from "@ngx-translate/core";
import { FormsModule } from "@angular/forms";
import { LoginViewComponent } from "./views/login/login.view";
import { BooksViewComponent } from "./views/books/books.view";
import { UiToolkitModule } from "../toolkit/ui-toolkit.module";
import { InteractionsComponentsModule } from './components/interactions-components.module';

@NgModule({
   imports: [
      CommonModule,
      TranslateModule,
      FormsModule,
      UiToolkitModule,
      InteractionsComponentsModule
   ],
   declarations: [
      LoginViewComponent,
      BooksViewComponent
   ],
   exports: [
      LoginViewComponent,
      BooksViewComponent
   ]
})
export class InteractionsModule {
}
