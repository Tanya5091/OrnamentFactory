import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {NewOrderModel, OrderModel, OrderStatus} from "../models/order-model.interface";
import {MaterialModel} from "../models/material-model.interface";

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  public assignUserOrder: Subject<{ user_id: number, order_id: number }> = new Subject<{ user_id: number; order_id: number }>();
  public assignOrderToDone: Subject<{ order_id: number }> = new Subject<{ order_id: number }>();

  constructor(private http: HttpClient) {
  }

  public getAllOrders(): Observable<Array<OrderModel>> {
    return this.http.get<Array<OrderModel>>('/api/v1/get_orders');
  }

  public createOrder(order: NewOrderModel): Observable<any> {
    return this.http.post('/api/v1/create_order', order);
  }

  public deleteOrder(id: number): Observable<any> {
    return this.http.post('/api/v1/delete_order', id);
  }

  public changeStatus(id: number): Observable<any> {
    return this.http.post('/api/v1/change_status', {
      id,
      status: OrderStatus.DONE
    });
  }

  public getAllMaterials() {
    return this.http.get<Array<MaterialModel>>('/api/v1/get_materials');
  }

  public getAllWorkers() {
    return this.http.get<any>('/api/v1/get_users/FACTORY_WORKER');
  }

  public assignOrderToWorker(id_user: number, id_order: number) {
    return this.http.post(`/api/v1/addUserOrder/${id_user}/${id_order}`, {});
  }

  public getUserById(id: number) {
    return this.http.get<any>(`/api/v1/get_user/${id}`);
  }
}
