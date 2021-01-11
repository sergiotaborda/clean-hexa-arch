import { Component } from "@angular/core";
import { Router } from "@angular/router";

import { UiToolkit } from "../../../toolkit/ui-toolkit";
import { AuthenticationGateway } from "../../../gateways/authentication-gateway";
import { RoutePath } from "../../../app.route.paths";


@Component({
  selector: "login",
  templateUrl: "./login.view.html"
})
export class LoginViewComponent {

  credentials = {username: "", password: ""};

  constructor(
    private router: Router,
    private ui: UiToolkit,
    private authenticationGateway: AuthenticationGateway
  ) {

  }

  public onLogin(): void {
   this.ui.waitFor(() => this.authenticationGateway.authenticate(this.credentials.username, this.credentials.password))
   .then(() => {
      return this.router.navigateByUrl(RoutePath.Books);
   })
   .catch(() => {
      this.credentials.password = "";
   })

  }

}
