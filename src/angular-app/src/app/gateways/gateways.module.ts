import { NgModule } from "@angular/core";
import { AuthenticationGateway } from "./authentication-gateway";


@NgModule({
  providers: [
   AuthenticationGateway
  ]
})
export class GatewaysModule {
}
