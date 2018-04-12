import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {}

  private userUrl = 'http://localhost:8080/api';
  private updateURL = 'http://localhost:8080/api/update';

  public getUsers() {
    return this.http.get(this.userUrl);
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + '/' + user.idUsers);
  }

  public createUser(user) {
    return this.http.post(this.userUrl, user);
  }

  public updateCompany(company) {
    console.log('Edit company request sending ...');
    return this.http.post(this.updateURL, company);
  }

}
