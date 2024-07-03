import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AdminauthService {
  constructor() {}

  authenticate(username2: string, password2: string) {
    if (username2 == 'gk0123' && password2 == 'aloo') {
      sessionStorage.setItem('username2', username2);
      return true;
    } else return false;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username2');
    console.log('User is logged in');
    return !(user == null);
  }

  logout() {
    console.log('User is logged out');
    sessionStorage.removeItem('username2');
  }
}
