import { Component, Input} from "@angular/core";
import { PageContainer } from 'src/app/commons/model/page-container.model';
import { UiToolkit } from '../../ui-toolkit';

@Component({
  selector: "page-navigator",
  templateUrl: "./page-navigator.component.html"
})
export class PageNavigatorComponent {

  @Input() testId: string;
  @Input() pageContainer: PageContainer<any>;
  
  constructor(
   private ui : UiToolkit
  ){
   
  }
  
  get paginationText(){
    return this.ui.translate("UI.PAGINATOR.DESCRIPTION");
   /* { 
       fromItem : this.currentFirstItem,
       toItem: this.currentLastItem, 
       totalItems: this.totalItemsCount,
       currentPage : this.currentPage, 
       totalPages: this.totalPagesCount
      });*/
  }

  public get previousCommandTestId(){
    return `${this.testId}-previous_command`;
  }

  public get nextCommandTestId(){
    return `${this.testId}-next_command`;
  }

  public get currentPage(): number {
    return this.pageContainer.currentPage;
  }

  public set currentPage(value: number) {
    this.pageContainer.currentPage = value * 1;
  }

  public previousPage() {
      this.pageContainer.previousPage();
  }

  public nextPage() {
      this.pageContainer.nextPage();
  }

  public loadPage() {
    // Because of an error on Angular binding the code below can't be on 'set currentPage'.
    // Is needed to guarantee that the value is a valid number because the bind is an string.

    if (isNaN(this.currentPage) || this.currentPage < 1) {
      this.pageContainer.currentPage = 1;
    }
    this.pageContainer.loadPage();
  }

  public get canNavigatePrevious() {
    return this.pageContainer.hasPrevious;
  }

  public get canNavigateNext() {
    return this.pageContainer.hasNext;
  }

  get currentFirstItem() {
    return this.pageContainer.firstItemListPosition;
  }

  get currentLastItem() {
    return this.pageContainer.lasttemListPosition;
  }

  get totalItemsCount() {
    return this.pageContainer.totalItemsCount;
  }

  get totalPagesCount() {
    return this.pageContainer.totalPagesCount;
  }
}
