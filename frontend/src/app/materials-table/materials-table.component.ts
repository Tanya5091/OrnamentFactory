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
  @Input() tableData: Array<MaterialModel>;

  constructor() { }

  ngOnInit(): void {
  }

  // TODO change event listener to do some logic
  public tableAction() {
    console.log('Click');
  }

}
