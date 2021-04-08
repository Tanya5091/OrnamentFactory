import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  public roles = [
    {name: 'SALES MANAGER', code: 'SALES_MANAGER'},
    {name: 'MANAGER', code: 'MANAGER'},
    {name: 'WORKER', code: 'FACTORY_WORKER'},
  ];


  public loginForm: FormGroup | undefined;
  public error = '';
  public loading = false;
  selectedRole: string;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private httpClient: HttpClient
  ) {
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      login: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8)]],
      role: ['', Validators.required],
    });
  }

  onSubmit(): void {
    const user = {
      login: this.loginForm.get('login').value,
      password: this.loginForm.get('password').value,
      permission: this.loginForm.get('role').value.code
    };
    console.log(user);
    this.loading = true;
    this.httpClient.post('/api/v1/register', user).subscribe(res => {
      alert('register success!');
      this.router.navigate(['login']);
    }, error1 => {
      this.loading = false;
      alert('register ERROR!');
    });
  }
}
