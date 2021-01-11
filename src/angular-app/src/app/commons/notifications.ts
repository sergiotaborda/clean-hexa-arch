export enum NotificationType {
   Information,
   Success,
   Error,
   Warning
}

export interface Notification {

   message: string;
   type: NotificationType;
   messageParameters?: object[];

}

export class MessageNotification implements Notification {

   constructor(
     public type: NotificationType,
     public message: string,
     public messageParameters: object[] = [],
   ) { }

}
