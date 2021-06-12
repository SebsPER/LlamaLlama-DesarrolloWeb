import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: string | undefined;
  email: string | undefined;
  password: string | undefined;
  confirmpassword: string | undefined;

  constructor() { }

  ngOnInit(): void {
  }

  register(){
    console.log(this.user);
    console.log(this.email);
    console.log(this.password);
    console.log(this.confirmpassword);
  }

}
