import { Input, Directive } from "@angular/core";
import { ControlValueAccessor } from "@angular/forms";
import { UiInputComponent, UiState } from "../ui-toolkit-components";

@Directive()
export abstract class AbstractInputComponent<T> implements ControlValueAccessor , UiInputComponent {

   public static inputs = ["block", "testId", "placeholder", "emptyText", "isEnabled", "isRequired", "isReadonly"];

   private innerValue: T;
   private changed: Array<(value: T) => void> = [];

   @Input() block: string;
   @Input() testId: string;

   @Input() placeholder = this.defaultPlaceholder;
   @Input() emptyText: string | null;

   @Input() isEnabled = true;
   @Input() isRequired = false;
   @Input() isReadonly = false;

   protected uiState: UiState;

   constructor(
      private defaultPlaceholder: string
   ){
      this.uiState = new UiState(this);
   }

   get value(): T {
      return this.innerValue;
   }

   set value(value: T) {
      if (this.innerValue !== value) {
         this.innerValue = value;
         this.changed.forEach(f => f(value));
      }
   }

   writeValue(value: T): void {
      this.innerValue = value;
   }

   registerOnChange(fn: (value: T) => void): void {
      this.changed.push(fn);
   }

   registerOnTouched(fn: () => void): void {}

}
