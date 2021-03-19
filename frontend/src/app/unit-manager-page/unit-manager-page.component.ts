import {Component, OnInit} from '@angular/core';
import {OrderModel, OrderStatus} from '../models/order-model.interface';
import {OrdersService} from "../servises/orders.service";

@Component({
  selector: 'app-unit-manager-page',
  templateUrl: './unit-manager-page.component.html',
  styleUrls: ['./unit-manager-page.component.scss']
})
export class UnitManagerPageComponent implements OnInit {

  newOrders: Array<OrderModel>;
  orders: Array<OrderModel>;

  activeOrders: Array<OrderModel>;
  doneOrders: Array<OrderModel>;
  workers: Array<any>;
  selectedWorker: any;

  collapseActive: boolean = false
  collapseDone: boolean = false
  newOrdersCollapse: boolean = false

  constructor(private ordersService: OrdersService) {
  }

  ngOnInit(): void {
    this.ordersService.assignUserOrder.asObservable().subscribe(res => {
      if (res) {
        const index = this.workers.findIndex(value => value.id === res.user_id);
        let order = this.newOrders.find(el=> el.id === res.order_id);
        order.status = OrderStatus.ACTIVE;
        this.workers[index].orders.push(order);
        this.selectedWorker = this.workers[index];
        this.activeOrders = this.selectedWorker.orders.filter((item) => item.status == OrderStatus.ACTIVE);
        this.doneOrders = this.selectedWorker.orders.filter((item) => item.status == OrderStatus.DONE);
        this.newOrders.splice(this.newOrders.findIndex(el=> el.id === res.order_id), 1);
      }
    });

    this.ordersService.getAllWorkers().subscribe(res => {
      res.forEach(el => el.checked = false);
      this.workers = res;
      if (this.workers && this.workers[0]) {
        this.workers[0].checked = true;
        this.selectedWorker = this.workers[0];
        this.activeOrders = this.selectedWorker.orders.filter((item) => item.status == OrderStatus.ACTIVE);
        this.doneOrders = this.selectedWorker.orders.filter((item) => item.status == OrderStatus.DONE);
      }
    });
    this.ordersService.getAllOrders().subscribe(res => {
      this.orders = res;
      // this.activeOrders = this.orders.filter((item) => item.status == OrderStatus.ACTIVE);
      // this.doneOrders = this.orders.filter((item) => item.status == OrderStatus.DONE);
      this.newOrders = this.orders.filter((item) => item.status == OrderStatus.NEW);
    });
  }

  selectWorker(worker: any) {
    this.workers.forEach(el => el.checked = false);
    const index = this.workers.findIndex(value => value.id === worker.id);
    this.workers[index].checked = true;
    this.selectedWorker = this.workers[index];
    this.activeOrders = this.selectedWorker.orders.filter((item) => item.status == OrderStatus.ACTIVE);
    this.doneOrders = this.selectedWorker.orders.filter((item) => item.status == OrderStatus.DONE);
  }
}
