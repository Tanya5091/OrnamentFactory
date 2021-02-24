import { Component, OnInit, Output } from '@angular/core';
import * as EventEmitter from 'events';

@Component({
  selector: 'app-materials-table',
  templateUrl: './materials-table.component.html',
  styleUrls: ['./materials-table.component.scss']
})
export class MaterialsTableComponent implements OnInit {

  // TODO change mock data to a database data
  tableData: {}[] = [
    {
      name: 'Hook',
      quantity: 500,
      ' ':() => {console.log('add')}
    },
    {
      name: 'Red paint',
      quantity: 30,
      ' ':() => {console.log('add')}
    },
    {
      name: 'Balls',
      quantity: '1000',
    },
    {
      name: 'Blue paint',
      quantity: 257,
    },
    {
      name: 'White paint',
      quantity: 25,
    },
    {
      name: 'Green paint',
      quantity: 25,
    },
    {
      name: 'Crown',
      quantity: 15000,
    },
    {
      name: 'Pink paint',
      quantity: 25,
    },
    {
      name: 'Yellow paint',
      quantity: 25,
    },
    {
      name: 'Black paint',
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
