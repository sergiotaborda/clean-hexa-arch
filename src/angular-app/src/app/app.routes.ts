import { Route } from "@angular/router";
import { RoutePath } from "./app.route.paths";
import { LoginViewComponent } from "./interaction/views/login/login.view";
import { BooksViewComponent } from "./interaction/views/books/books.view";

export const AppRoutes: Array<Route> = [
   {
    path: RoutePath.Books,
    pathMatch: "full",
    component: BooksViewComponent
  },
  {
    path: RoutePath.Login,
    pathMatch: "full",
    component: LoginViewComponent
  },
  { // must be last one
    path: "**",
    pathMatch: "full",
    redirectTo: RoutePath.Login
  }

];
