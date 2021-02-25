import { Component, Input, OnInit } from '@angular/core';
import { BallTypeModel } from '../models/ball-type-model.interface';
import { FormBuilder, FormGroup } from '@angular/forms';
import { of } from 'rxjs';

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

  form: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      ballsTypes: [''],
      quantity: null,
      dueDate: null,
      priority: null
    });

    of(this.getTypes()).subscribe(ballsTypes => {
      this.ballsTypes = ballsTypes;
      this.form.controls.ballsTypes.patchValue(this.ballsTypes[0].name);
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
    console.log(this.form.value);
  }
  ngOnInit(): void {
  }

}
