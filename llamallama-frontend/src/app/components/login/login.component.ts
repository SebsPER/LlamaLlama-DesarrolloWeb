import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: string | undefined;
  password: string | undefined;

  constructor() { }

  ngOnInit(): void {
  }

  ingresar(){
    console.log(this.user);
    console.log(this.password);
  }

}
