import { Component, OnInit, Input } from '@angular/core';
import { OrderModel } from '../models/order-model.interface';

@Component({
  selector: 'app-order-card',
  templateUrl: './order-card.component.html',
  styleUrls: ['./order-card.component.scss']
})
export class OrderCardComponent implements OnInit {
  @Input() order: OrderModel 
  // = {        // mock-data
  //   name: "Кульки з синім напиленням",
  //   status: 2,
  //   dueDate: `${new Date().getDate().toString()}.${new Date().getMonth()}.${new Date().getFullYear()}`,
  //   quantity: 100
  // };

  statusMapping: Record<number,string> ={
    1: 'green',
    2: 'yellow',
    3: 'red',
    4: 'Прийнято'
  }

  @Input() worker : boolean = false

  constructor() { }

  ngOnInit(): void {
  }

}
