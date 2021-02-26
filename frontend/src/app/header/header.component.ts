import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {MenuItem, MessageService} from "primeng/api";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  selected = 'sales-manager';
  @Input() navigate;
  items: MenuItem[];


  constructor(private router: Router,
              private messageService: MessageService) {

  }

  ngOnInit(): void {
    this.items = [
      {
        label: 'Navigate',
        items: [{
          label: 'Sales Manager',
          icon: 'pi pi-external-link',
          routerLink: '/sales-manager'
        }, {
          label: 'Worker',
          icon: 'pi pi-external-link',
          routerLink: '/worker-page'
        },
          {
            label: 'Unit Manager',
            icon: 'pi pi-upload',
            routerLink: '/unit-manager-page'
          }
        ]}
    ];
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
