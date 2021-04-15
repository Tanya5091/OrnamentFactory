import { Component, Input, OnInit, Output } from '@angular/core';
import * as EventEmitter from 'events';
import { MaterialModel } from '../models/material-model.interface';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-materials-table',
  templateUrl: './materials-table.component.html',
  styleUrls: ['./materials-table.component.scss']
})
export class MaterialsTableComponent implements OnInit {

  // TODO change mock data to a database data
  @Input() tableData: Array<MaterialModel>;
  validatingForm: FormGroup;

  constructor() { }

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

  public removeMaterials(){
    // add logic that removes materials from database
  }

  public addMaterials(){
    // add logic that adds materials to database
  }

}
