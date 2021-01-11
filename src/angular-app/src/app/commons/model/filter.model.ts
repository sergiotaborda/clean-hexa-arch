
export abstract class PaginatedFilter {
  requiredPage: number;
  totalItemsPerPageCount: number;
  sortBy: string | null;
  sortDescending: boolean = false;
}