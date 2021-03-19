import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public loginForm: FormGroup | undefined;
  public error = '';
  public loading = false;

  constructor(
    public router: Router,
    private formBuilder: FormBuilder,
    private httpClient: HttpClient
  ) {
  }

  ngOnInit(): void {
    localStorage.clear();
    this.loginForm = this.formBuilder.group({
      login: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  onSubmit(): void {
    const user = {
      login: this.loginForm.get('login').value,
      password: this.loginForm.get('password').value
    };
    this.loading = true;
    this.httpClient.post('/api/v1/login', user).subscribe((res: any) => {
      localStorage.setItem('user', JSON.stringify(res));
      if (res.role === 'SALES_MANAGER') {
        this.router.navigate(['sales-manager']);
      } else if (res.role === 'MANAGER'){
        this.router.navigate(['unit-manager-page']);
      } else if (res.role === 'FACTORY_WORKER'){
        this.router.navigate(['worker-page']);
      }
    }, error1 => {
      alert('login ERROR!');
      this.loading = false;
    });
  }
}
