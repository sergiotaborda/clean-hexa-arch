
export interface InvalidationReason {
   messageParameters: object[];
   message: string;

}

export class ValidationResult {

   private invalidations: Array<InvalidationReason> = [];

   reasons(): Array<InvalidationReason> {
      return this.invalidations;
   }

}
