import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {MenuItem, MessageService} from "primeng/api";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  @Input() navigate;
  items: MenuItem[];
  name = 'name';
  role = '';

  constructor(private router: Router,
              private messageService: MessageService) {

  }

  ngOnInit(): void {
    this.items = [
      {
        label: 'Navigate',
        items: [{
          label: 'Sales Manager',
          routerLink: '/sales-manager'
        },
          {
            label: 'Unit Manager',
            routerLink: '/unit-manager-page'
          },
          {
            label: 'Register',
            routerLink: '/register'
          }
        ]}
    ];
    const user = JSON.parse(localStorage.getItem('user'));
    this.name = user.login;
    this.role = user.role;
  }

  update() {
    this.messageService.add({severity:'success', summary:'Success', detail:'Data Updated'});
  }

  delete() {
    this.messageService.add({severity:'warn', summary:'Delete', detail:'Data Deleted'});
  }


  onSelect(selected: string) {
    switch (selected) {
      case 'sales-manager':
        return this.router.navigate(['sales-manager']);
      case 'worker-page':
        return this.router.navigate(['worker-page']);
      case 'unit-manager-page':
        return this.router.navigate(['unit-manager-page']);
    }
  }
}
