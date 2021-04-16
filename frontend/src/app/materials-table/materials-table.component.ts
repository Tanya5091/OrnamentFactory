import {Component, Input, OnInit, Output} from '@angular/core';
import * as EventEmitter from 'events';
import {MaterialModel} from '../models/material-model.interface';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {DialogComponent} from "../dialog/dialog.component";
import {OrdersService} from "../servises/orders.service";

@Component({
  selector: 'app-materials-table',
  templateUrl: './materials-table.component.html',
  styleUrls: ['./materials-table.component.scss']
})
export class MaterialsTableComponent implements OnInit {

  // TODO change mock data to a database data
  @Input() tableData: Array<MaterialModel>;
  validatingForm: FormGroup;

  constructor(private matDialog: MatDialog,
              private ordersService: OrdersService) {
  }

  ngOnInit(): void {
    this.validatingForm = new FormGroup({
      matQuantityFormModalNumber: new FormControl('', Validators.required)
    });
  }

  get matQuantityFormModalNumber() {
    return this.validatingForm.get('matQuantityFormModalNumber');
  }

  // TODO change event listener to do some logic
  public tableAction() {
    console.log('Click');
  }

  public removeMaterials() {
    // add logic that removes materials from database
  }

  public addMaterials() {
    // add logic that adds materials to database
  }

  openDialog(): void {
    const modalDialog = this.matDialog.open(DialogComponent, {
      data: {addMaterial: true},
      disableClose: true
    });

    modalDialog.afterClosed().subscribe(result => {
      if (result) {
        this.ordersService.createMaterial(result).subscribe(res => {
          console.log(res);
          if (res) {
            this.tableData.push(res);
          }
        })
      }
    });

  }

  editDialog(col: MaterialModel): void {
    const modalDialog = this.matDialog.open(DialogComponent, {
      data: {addMaterial: false, item: col},
      disableClose: true
    });

    modalDialog.afterClosed().subscribe(result => {
      if (result) {
        console.log(result);
        const input = this.tableData.find(el => el.name === col.name).quantity;
        if ((input - result) > 0) {
          this.ordersService.subQuantity(col.id, input - result).subscribe(res => {
            console.log(res);
            this.tableData.find(el => el.name === col.name).quantity = result;
          })
        } else {
          this.ordersService.addQuantity(col.id, result - input).subscribe(res => {
            console.log(res);
            this.tableData.find(el => el.name === col.name).quantity = result;
          })
        }

      }
    });

  }

  deleteMaterial(col: MaterialModel) {
    this.ordersService.deleteMaterial(col.id).subscribe(res => {
      console.log(res);
      this.tableData.splice(this.tableData.findIndex(el => el.id === col.id), 1);
    })
  }
}
