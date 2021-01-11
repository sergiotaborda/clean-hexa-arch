import { ValidationResult, InvalidationReason } from "./validation";

export class ValidationError extends Error {

   constructor(
      private result: ValidationResult
   ){
      super();
   }

   public reasons(): Array<InvalidationReason> {
      return this.result.reasons();
   }

}
