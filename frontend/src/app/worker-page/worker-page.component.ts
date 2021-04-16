import {Component, Input, OnInit} from '@angular/core';
import {OrderModel, OrderStatus} from '../models/order-model.interface';
import {OrdersService} from "../servises/orders.service";
import {MaterialModel} from "../models/material-model.interface";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {DialogComponent} from "../dialog/dialog.component";

@Component({
  selector: 'app-worker-page',
  templateUrl: './worker-page.component.html',
  styleUrls: ['./worker-page.component.scss']
})
export class WorkerPageComponent implements OnInit {

  validatingForm: FormGroup;

  orders: Array<OrderModel>;

  activeOrders: Array<OrderModel>;
  doneOrders: Array<OrderModel>;

  collapseActive: boolean = false
  collapseDone: boolean = false
  materials: Array<MaterialModel>;

  constructor(private ordersService: OrdersService) {
  }

  ngOnInit(): void {
    // this.ordersService.getAllOrders().subscribe(res => {
    //   this.orders = res;
    //   this.activeOrders = this.orders.filter((item) => item.status == OrderStatus.ACTIVE);
    //   this.doneOrders = this.orders.filter((item) => item.status == OrderStatus.DONE);
    // });

    this.validatingForm = new FormGroup({
      newMatFormModalName: new FormControl('', Validators.required)
    });

    this.ordersService.assignOrderToDone.asObservable().subscribe(res => {
      if (res) {
        const index = this.activeOrders.findIndex(value => value.id === res.order_id);
        let order = this.activeOrders.find(el => el.id === res.order_id);
        order.status = OrderStatus.DONE;
        this.activeOrders.splice(index, 1);
        this.doneOrders.push(order);
      }
    });
    const user = JSON.parse(localStorage.getItem('user'));
    this.ordersService.getUserById(user.id).subscribe(res => {
      this.activeOrders = res.orders.filter((item) => item.status == OrderStatus.ACTIVE);
      this.doneOrders = res.orders.filter((item) => item.status == OrderStatus.DONE);
      // this.doneOrders = res.orders;
    });
    this.ordersService.getAllMaterials().subscribe(res => {
      this.materials = res;
    });

  }

  get newMatFormModalName() {
    return this.validatingForm.get('newMatFormModalName');
  }

  public createMaterial(){
    // add logic that creates new material
  }


}
