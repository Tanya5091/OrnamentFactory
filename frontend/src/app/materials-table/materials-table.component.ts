import { Component, Input, OnInit, Output } from '@angular/core';
import * as EventEmitter from 'events';
import { MaterialModel } from '../models/material-model.interface';

@Component({
  selector: 'app-materials-table',
  templateUrl: './materials-table.component.html',
  styleUrls: ['./materials-table.component.scss']
})
export class MaterialsTableComponent implements OnInit {

  // TODO change mock data to a database data
  @Input() tableData: Array<MaterialModel> = [
    {
      name: 'Гачок',
      quantity: 500,
      // ' ':() => {console.log('add')}
    },
    {
      name: 'Напилення червоне',
      quantity: 30,
      // ' ':() => {console.log('add')}
    },
    {
      name: 'Кулі',
      quantity: 1000
    },
    {
      name: 'Напилення синє',
      quantity: 257,
    },
    {
      name: 'Напилення біле',
      quantity: 25,
    },
    {
      name: 'Напилення зелене',
      quantity: 25,
    },
    {
      name: 'Коронка',
      quantity: 15000,
    },
    {
      name: 'Напилення рожеве',
      quantity: 25,
    },
    {
      name: 'Напилення жовте',
      quantity: 25,
    },
    {
      name: 'Напилення чорне',
      quantity: 25,
    },
  ]

  constructor() { }

  ngOnInit(): void {
  }

  // TODO change event listener to do some logic
  public tableAction() {
    console.log('Click');
  }

}
