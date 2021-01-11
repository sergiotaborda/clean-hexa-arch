import { Injectable } from "@angular/core";
import { Subject } from '../commons/model/subject.model';

@Injectable()
export class AuthenticationGateway {

  public authenticate(username: string, password: string): Promise<void> {
      
      return new Promise((resolve, reject) =>{
            window.setTimeout(()=> { resolve()} , 0);

      });
  }


 public currentSubject() : Promise<Subject>{
   const subject = new Subject();
   
   subject.fullName = "John Doe";
   
   return Promise.resolve(subject);
 }
}
