import {Component, OnInit} from '@angular/core';
import {OrderModel, OrderStatus} from '../models/order-model.interface';
import {OrdersService} from "../servises/orders.service";

@Component({
  selector: 'app-sales-manager-page',
  templateUrl: './sales-manager-page.component.html',
  styleUrls: ['./sales-manager-page.component.scss']
})
export class SalesManagerPageComponent implements OnInit {

  newOrders: Array<OrderModel>;
  orders: Array<OrderModel>;

  activeOrders: Array<OrderModel>;
  doneOrders: Array<OrderModel>;

  collapseActive: boolean = false
  collapseDone: boolean = false
  newOrdersCollapse: boolean = false

  constructor(private ordersService: OrdersService) {
  }

  ngOnInit(): void {
    this.ordersService.getAllOrders().subscribe(res => {
      this.orders = res;
      this.activeOrders = this.orders.filter((item) => item.status == OrderStatus.ACTIVE);
      this.doneOrders = this.orders.filter((item) => item.status == OrderStatus.DONE);
      this.newOrders = this.orders.filter((item) => item.status == OrderStatus.NEW);
    });
    this.ordersService.salesOrderCreate.asObservable().subscribe(res => {
      this.newOrders.push(res);
    });
  }

}
