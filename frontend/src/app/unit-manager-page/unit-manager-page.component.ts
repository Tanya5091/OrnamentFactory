import { Component, OnInit, Input } from '@angular/core';
import { OrderModel } from '../models/order-model.interface';

@Component({
  selector: 'app-unit-manager-page',
  templateUrl: './unit-manager-page.component.html',
  styleUrls: ['./unit-manager-page.component.scss']
})
export class UnitManagerPageComponent implements OnInit {

  @Input() newOrders: Array<OrderModel> = [
    {
      name: "Кульки з синім напиленням",
    status: 3,
    dueDate: `${new Date().getDate().toString()}.${new Date().getMonth()}.${new Date().getFullYear()}`,
    quantity: 100
    }
  ]


  @Input() orders: Array<OrderModel> = [
    {
      name: "Кульки з синім напиленням",
    status: 3,
    dueDate: `${new Date().getDate().toString()}.${new Date().getMonth()}.${new Date().getFullYear()}`,
    quantity: 100
    },
    {
      name: "Кульки з зеленим напиленням",
    status: 2,
    dueDate: `${new Date().getDate().toString()}.${new Date().getMonth()}.${new Date().getFullYear()}`,
    quantity: 300
    },
    {
      name: "Кульки з білим напиленням",
    status: 4,
    dueDate: `${new Date().getDate().toString()}.${new Date().getMonth()}.${new Date().getFullYear()}`,
    quantity: 200
    }
  ]

  activeOrders: Array<OrderModel> = this.orders.filter((item) => item.status < 4)
  doneOrders: Array<OrderModel> = this.orders.filter((item) => item.status === 4)

  collapseActive : boolean = false
  collapseDone: boolean = false
  newOrdersCollapse: boolean = false

  constructor() { }

  ngOnInit(): void {
  }

}
