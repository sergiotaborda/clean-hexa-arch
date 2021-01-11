import { Component, Input, forwardRef } from "@angular/core";
import { NG_VALUE_ACCESSOR } from "@angular/forms";
import { AbstractInputComponent } from "../abstract-input.component";


@Component({
  selector: "password-field",
  template: `
   <div class="{{block}} field state-password"
      [class.state-filled]="!!value"
      [class.state-readonly]="isReadonly"
      [class.state-disabled]="!isEnabled"
      [class.state-required]="isRequired">
   <input type="password"
            [attr.data-testId]="testId"
            class="field__input state-password"
            *ngIf="!isReadonly"
            [(ngModel)]="value"
            [class.state-filled]="!!value"
            [class.state-disabled]="!isEnabled"
            [class.state-required]="isRequired"
            [placeholder]="uiState.placeholder | translate"
            [disabled]="!isEnabled"
            [required]="isRequired"
            [maxlength]="maxLength"
   />

   <input type="password"
            [attr.data-testId]="testId"
            class="field__input state-password state-readonly"
            *ngIf="isReadonly"
            [placeholder]="isReadonly"
            readonly
            [ngModel]="value || uiState.emptyText"
   />
   </div>
  `,
   inputs: AbstractInputComponent.inputs,
   providers: [{
      provide: NG_VALUE_ACCESSOR,
      multi: true,
      useExisting: forwardRef(() => PasswordFieldComponent)
   }]

})
export class PasswordFieldComponent extends AbstractInputComponent<string>{

   constructor(){
      super("PASSWORD.INPUT.PLACEHOLDER");
   }

   @Input() maxLength = 50;




}
