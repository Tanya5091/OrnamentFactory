import {Component, OnInit, Input} from '@angular/core';
import {OrderModel, OrderStatus} from '../models/order-model.interface';
import {OrdersService} from "../servises/orders.service";

@Component({
  selector: 'app-order-card',
  templateUrl: './order-card.component.html',
  styleUrls: ['./order-card.component.scss']
})
export class OrderCardComponent implements OnInit {

  @Input() newOrder: boolean = false;

  @Input() withDelete: boolean = false;

  @Input() order: OrderModel;

  active = OrderStatus.ACTIVE;
  done = OrderStatus.DONE;

  statusMapping: Record<number, string> = {
    1: 'GREEN',
    2: 'YELLOW',
    3: 'RED',
    4: 'Виконано'
  };

  @Input() worker: boolean = false;
  @Input() workerId: number;

  constructor(private orderService: OrdersService) {
  }

  ngOnInit(): void {
  }

  deleteOrder(id: number) {
    this.orderService.deleteOrder(id).subscribe(res => {
      console.log(res);
    })
  }

  changeOrderStatus(id: number) {
    this.orderService.changeStatus(id).subscribe(res => {
      console.log(res);
      this.orderService.assignOrderToDone.next({order_id: id});
    })
  }

  assignToWorker() {
    this.orderService.assignOrderToWorker(this.workerId, this.order.id).subscribe(res => {
      console.log(res);
      this.orderService.assignUserOrder.next({user_id: this.workerId, order_id: this.order.id});
    });
  }
}
