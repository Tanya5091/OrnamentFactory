export class OrderModel {
  id: number;
  toyName: string;
  status: OrderStatus;
  deadline: string;
  quantity: number;
  priority: Priority;
  salesID: number;
}

export class NewOrderModel {
  toyName: string;
  priority: Priority;
  deadline: string;
  quantity: number;
  salesID: number;
}

export enum OrderStatus {
  ACTIVE = 'ACTIVE', DONE = 'DONE', NEW = 'NEW'
}

export enum Priority {
  GREEN = 'GREEN',
  YELLOW = 'YELLOW',
  RED = 'RED'
}
