export interface UiInputComponent {
  placeholder?: string;
  emptyText?: string | null;
  isRequired?: boolean;
}

export class UiState {

  constructor(private component: UiInputComponent) {
  }

  public get placeholder(): string | undefined {
   // return UiConfigurationService.stateCalculator.getState(this.component).placeholder;
   return this.component.placeholder;
  }

  public get emptyText(): string | undefined {
   // return UiConfigurationService.stateCalculator.getState(this.component).emptyText;
      return this.component.placeholder;
  }


}