import {Component, Input, OnInit} from '@angular/core';
import {BallTypeModel} from '../models/ball-type-model.interface';
import {FormBuilder, FormGroup} from '@angular/forms';
import {of} from 'rxjs';
import {NewOrderModel, OrderModel, OrderStatus, Priority} from "../models/order-model.interface";
import {OrdersService} from "../servises/orders.service";

@Component({
  selector: 'app-new-order-form',
  templateUrl: './new-order-form.component.html',
  styleUrls: ['./new-order-form.component.scss']
})
export class NewOrderFormComponent implements OnInit {

  @Input() ballsTypes: Array<BallTypeModel> = [
    {name: 'З червоним напиленням'},
    {name: 'З зеленим напиленням'},
    {name: 'З чорним напиленням'},
    {name: 'З рожевим напиленням'},
    {name: 'З білим напиленням'},
  ]

  first: Priority = Priority.GREEN;
  second: Priority = Priority.YELLOW;
  third: Priority = Priority.RED;

  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private orderService: OrdersService) {
    this.form = this.formBuilder.group({
      toyName: '',
      quantity: null,
      deadline: null,
      priority: this.first,
      salesID: Number(localStorage.getItem('id'))
    } as NewOrderModel);

    of(this.getTypes()).subscribe(toyName => {
      this.ballsTypes = toyName;
      this.form.controls.toyName.patchValue(this.ballsTypes[0].name);
    });

  }

  // change to database query to get ball types
  getTypes() {
    return [
      {name: 'З червоним напиленням'},
      {name: 'З зеленим напиленням'},
      {name: 'З чорним напиленням'},
      {name: 'З рожевим напиленням'},
      {name: 'З білим напиленням'},
    ];
  }

  submit() {
    const user = JSON.parse(localStorage.getItem('user'));
    let order = this.form.value as NewOrderModel;
    order.salesID = user.id;
    this.orderService.createOrder(order).subscribe(res => {
      const newOrder = order as OrderModel;
      newOrder.status = OrderStatus.NEW;
      newOrder.id = 0;
      this.orderService.salesOrderCreate.next(newOrder);
    });
  }

  ngOnInit(): void {
  }

  onPriority(priority: Priority) {
    this.form.controls.priority.patchValue(priority);
  }
}
