import { Component } from "@angular/core";
import { RoutePath } from 'src/app/app.route.paths';
import { Router } from '@angular/router';
import { AuthenticationGateway } from 'src/app/gateways/authentication-gateway';


@Component({
  selector: "navigation-menu",
  templateUrl: "./navigation-menu.component.html"
})
export class NavigationMenuComponent {
   
  //private application: Application;
  
  menu = new Menu("root", "root", null, false);
  userFullName: string;

  constructor(
    private router: Router,
    private authenticationGateway: AuthenticationGateway,
//    private sessionService: SessionService,
//    applicationGateway: ApplicationGateway,
  ) {
//    applicationGateway.getApplication()
//      .then(application => this.application = application);

    const currentUrl = this.router.url.substr(1);

   this.authenticationGateway.currentSubject()
      .then((subject) => {
      
      this.userFullName = subject.fullName;

      this.menu
        .add(new Menu("MENU.REGISTRIES")
            .add(new Menu("MENU.BOOKS", "books", RoutePath.Books))
            .add(new Menu("MENU.BOOKS", "books", RoutePath.Books))
         )

      for (const item of this.menu.children) {
        if (item.routePath == currentUrl) {
          item.isSelected = true;
          break;
        } else if (item.haveSubmenu) {
          for (const child of item.children) {
            if (child.routePath == currentUrl) {
              child.isSelected = true;
              item.isSelected = true;
            }
          }
        }
      }

    });
  }

  get version(): string {
    return "0.1.0"; //this.application.version;
  }

  arrow(menu: Menu) {
    return menu.isSubmenuOpen ? "\u25B2" : "\u25BC";
  }

  public navigateTo(menu: Menu) {
    if (menu.routePath != null) {
      this.router.navigateByUrl(menu.routePath);
    }
  }

  public openOrCloseSubmenu(menu: Menu) {
    menu.isSubmenuOpen = !menu.isSubmenuOpen;
  }

  public submenuNavigate(menu: Menu, submenu: Menu) {
    menu.isSubmenuOpen = false;
    this.navigateTo(submenu);
  }
}

class Menu {

  private itens = new Array<Menu>();
  public isSelected = false;
  public isSubmenuOpen = false;

  constructor(
    public captionKey: string,
    public iconName?: string,
    public routePath?: RoutePath,
    public isVisible: boolean = true
  ) { }

  public get testId(): string {
    return this.routePath == null ? "" : this.routePath + "_menu";
  }

  public get haveSubmenu(){
    return  this.itens.every(it => it.isVisible);
  }

  public get children(): Array<Menu> {
    return this.itens;
  }

  public add(child: Menu): Menu {
    this.itens.push(child);
    return this;
  }

}
