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
    private router: Router,
    private formBuilder: FormBuilder,
    private httpClient: HttpClient
  ) {
  }

  ngOnInit(): void {
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
    this.httpClient.post('/api/v1/login', user).subscribe(res => {
      alert('login success!');
      this.router.navigate(['home']);
    }, error1 => {
      alert('login ERROR!');
      // this.router.navigate(['home']);
      this.loading = false;
    });
  }
}
