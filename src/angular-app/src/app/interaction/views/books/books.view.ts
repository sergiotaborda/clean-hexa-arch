import { Component } from "@angular/core";

import { UiToolkit } from "../../../toolkit/ui-toolkit";
import { Book } from 'src/app/services/model/book.model';
import { PageContainer } from 'src/app/commons/model/page-container.model';


@Component({
  selector: "books",
  templateUrl: "./books.view.html"
})
export class BooksViewComponent {


  filter : any= {};//Bookfilter
  private items = new Array<Book>(); 

  pageContainer = PageContainer.fetchByArray(this.items); 
  
  constructor(
    private ui: UiToolkit,
  ) {
      for (let i =0; i <= 14; i++){
         const book = new Book();
         book.name = "Livro " + (i+1);
         this.items.push(book);
      }

      this.pageContainer.fetchFirst();
      
  }

  applyFilter(){
   
  }
  
  addItem(){
   
   }
   
   edit(item:Book){
      
   }
}
