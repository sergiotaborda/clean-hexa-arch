
export class Page<T> {

  public constructor(
    public items: Array<T>,
    public currentPage: number,
    public totalPagesCount: number,
    public totalItemsCount: number,
    public totalItemsPerPageCount: number,
    public sortedBy: string,
    public sortDescending: boolean
  ) { }


  public map<R>(transform: (t: T) => R): Page<R> {
    return new Page<R>(
      this.items.map(transform),
      this.currentPage,
      this.totalPagesCount,
      this.totalItemsCount,
      this.totalItemsPerPageCount,
      this.sortedBy,
      this.sortDescending
    );
  }
}