import { Page } from './page.model';

export type FetchingFunction<T> = (itemsPerPage: number, pageIndex: number) => Promise<Page<T>>;

export class PageContainer<T> {

  public static fetchBy<X>(supplier: FetchingFunction<X>): PageContainer<X>{
   return new PageContainer<X>(supplier);
  }
  
  public static fetchByArray<X>(items: Array<X>): PageContainer<X>{
     return new PageContainer<X>((itemsPerPage, pageIndex) => {
         const content = items.slice((pageIndex-1)* itemsPerPage, (pageIndex) * itemsPerPage);
         return Promise.resolve(
            new Page<X>(content,
              pageIndex,
              Math.ceil(items.length / itemsPerPage) , 
              items.length, 
              itemsPerPage,
               "",
                false
            ));
     }); 
  }

  private currentPageIndex = 1;

  public currentItems = new Array<T>();
  public currentPage = 1;
  public totalPagesCount = 1;
  public totalItemsCount = 0;
  public totalItemsPerPageCount = 7;

  private constructor(
    private fetchPage: FetchingFunction<T>,
    private defaultTotalItemsPerPageCount: number = 7,
  ) {
    if (defaultTotalItemsPerPageCount) {
      this.totalItemsPerPageCount = defaultTotalItemsPerPageCount;
    }
  }

  public fetchFirst(): Promise<Page<T>> {
    return this.fetchPage(this.defaultTotalItemsPerPageCount, 1)
      .then(page => this.applyPage(page));
  }
  
  public get currentPageItems(){
     return this.currentItems;
  }

  public get hasPageItems() {
    return this.currentItems && this.currentItems.length >0;
  }
  
  public get hasItems() {
    return this.totalItemsCount > 0;
  }

  public get hasPrevious() {
    return this.currentPage * 1 > 1;
  }

  public get hasNext() {
    return (this.currentPage * 1) < this.totalPagesCount;
  }

  public previousPage() {
    if (this.hasPrevious) {
      this.currentPage = this.currentPage * 1 - 1;
      return this.loadPage();
    }
    
    return Promise.resolve();
  }

  public nextPage() : Promise<void> {
    if (this.hasNext) {
      this.currentPage = this.currentPage * 1 + 1;
      return this.loadPage();
    }

    return Promise.resolve();
  }

  public loadPage() : Promise<void> {
    this.currentPage = Math.max(1, Math.min(this.currentPage, this.totalPagesCount));

    return this.fetchPage(this.totalItemsPerPageCount, this.currentPage)
      .then(page => this.applyPage(page))
      .then( () => {});
  }

  private applyPage(page: Page<T>): Page<T> {

    this.currentItems = page.items;
    this.currentPage = page.currentPage;
    this.currentPageIndex = page.currentPage;
    this.totalItemsCount = page.totalItemsCount;
    this.totalPagesCount = page.totalPagesCount;
    this.totalItemsPerPageCount = page.totalItemsPerPageCount;

    return page;
  }

  public get firstItemListPosition() {
    return (this.currentPageIndex - 1) * this.totalItemsPerPageCount + 1;
  }

  public get lasttemListPosition() {
    return this.firstItemListPosition + this.currentItems.length - 1;
  }
}