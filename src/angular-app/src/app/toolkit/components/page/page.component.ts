import { Component, ContentChildren, QueryList, TemplateRef, ViewChild } from "@angular/core";


@Component({
  selector: "page-top",
  template: `
      <ng-template #pageTopTemplate>
        <div  class="vertical-layout__item horizontal-layout">
            <div class="horizontal-layout__item page__top">
               <ng-content></ng-content>
            </div>
         </div>
      </ng-template>
  `
})
export class PageTopComponent {

  @ViewChild("pageTopTemplate") public pageTopTemplate: TemplateRef<any>;

}

@Component({
  selector: "page-content",
  template: `
      <ng-template #pageContentTemplate>
        <div  class="vertical-layout__item   horizontal-layout">
        <div class="horizontal-layout__item page__border"></div>
            <div class="horizontal-layout__item page__content">
               <ng-content></ng-content>
            </div>
            <div class="horizontal-layout__item page__border"></div>
         </div>
      </ng-template>
  `
})
export class PageContentComponent {

  @ViewChild("pageContentTemplate") public pageContentTemplate: TemplateRef<any>;

}

@Component({
  selector: "page-footer",
  template: `
      <ng-template #pageFooterTemplate>
        <div  class="vertical-layout__item   horizontal-layout">
        <div class="horizontal-layout__item page__border"></div>
            <div class="horizontal-layout__item page__footer">
               <ng-content></ng-content>
            </div>
            <div class="horizontal-layout__item page__border"></div>
         </div>
      </ng-template>
  `
})
export class PageFooterComponent {

  @ViewChild("pageFooterTemplate") public pageFooterTemplate: TemplateRef<any>;

}

@Component({
  selector: "page",
  template: `
      <div class="page vertical_layout must-expand-max-state">
         <ng-template [ngTemplateOutlet]="top"></ng-template>
         <ng-template [ngTemplateOutlet]="content"></ng-template>
         <ng-template [ngTemplateOutlet]="footer"></ng-template>
      </div>
  `
})
export class PageComponent {

  @ContentChildren(PageTopComponent) tops: QueryList<PageTopComponent>;
  @ContentChildren(PageContentComponent) contents: QueryList<PageContentComponent>;
  @ContentChildren(PageFooterComponent) footers: QueryList<PageFooterComponent>;

  get top(){
      return this.tops && this.tops.first ? this.tops.first.pageTopTemplate : null ;
  }

  get content(){
      return this.contents && this.contents.first ? this.contents.first.pageContentTemplate : null ;
  }

  get footer(){
      return this.footers && this.footers.first ? this.footers.first.pageFooterTemplate : null ;
  }


}
