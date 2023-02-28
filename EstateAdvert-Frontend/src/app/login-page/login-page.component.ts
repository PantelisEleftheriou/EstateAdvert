import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit{
  form!: FormGroup;
  constructor(private formBuilder:FormBuilder,
              private http:HttpClient,
              private router:Router,
              private authService: AuthService) {
  }
  ngOnInit(): void {
    this.form = this.formBuilder.group({
      email: '',
      password: ''
    });
  }

  submit(): void {
      this.authService.login(this.form.get("email")?.value,this.form.get("password")?.value)
        .subscribe((response)=>{this.router.navigate(["advert"])});
  }
}
