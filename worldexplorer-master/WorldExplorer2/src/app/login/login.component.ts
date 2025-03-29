import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {UserAuth} from '../userAuth';
import {RouterService} from '../router.service';
import {AuthenticationService} from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  form: FormGroup;
    loading = false;
    submitted = false;

  userAuth: UserAuth = new UserAuth();
  loginflag: boolean;

  get f() { return this.form.controls; }

  // dependency injection of required services
  constructor (private route: RouterService, private auth: AuthenticationService) {  }

  // checking if the token is already set
  ngOnInit(): void {
    if (sessionStorage.getItem('token') != null) {
      this.loginflag = true;
      this.route.todashboard();
    }
  }

  // form validation of input fields
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required,Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(8)])

  })

  get email() {
    return this.loginForm.get('email');
  }

  get password() {
    return this.loginForm.get('password');
  }

  // Log in service is called and a token is generated which is stored in Session Storage
  logIn() {
    this.userAuth.username = this.loginForm.value.email;
    this.userAuth.password = this.loginForm.value.password;
    

    this.auth.login(this.userAuth).subscribe(
      data => {
        this.auth.setBearerToken(data["Token"]);
        sessionStorage.setItem("username", this.loginForm.value.email);
        this.route.todashboard();
      },
      error => {
        console.log(error);
      });
  }

  // redirect user to signup form if he is an already registered user
  tosignup() {
    this.route.tosignup();
  }

  }

