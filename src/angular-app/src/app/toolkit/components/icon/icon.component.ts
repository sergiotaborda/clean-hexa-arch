import { Component, Input } from "@angular/core";

@Component({
  selector: "icon",
  template: `<svg-icon [src]="iconName"></svg-icon>`
})
export class IconComponent {

  @Input() type: string;

  get iconName() {
    const fileName = this.type;

    if (fileName) {
      return `assets/images/${fileName}.svg`;
    }

    console.warn(`Not found icon for ${this.type}`);

    return `assets/images/${this.type}.svg`;
  }
}