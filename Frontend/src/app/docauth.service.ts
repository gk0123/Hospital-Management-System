import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DocauthService {

  constructor() { }

  authenticate(username:string, password:string){
    if (username == 'gk0123' && password == 'gobhi') {
      sessionStorage.setItem('username', username);
      return true;
    } else return false;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log('Doctor is logged in');
    return !(user == null);
  }

  logout() {
    console.log('Doctor is logged out');
    sessionStorage.removeItem('username');
  }

}
