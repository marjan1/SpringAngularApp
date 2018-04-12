import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {CompanyDTO} from '../models/company.model';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CompanyService {

  constructor(private http: HttpClient) {
  }

  private backendURL = 'http://localhost:8080/api';
  private updateURL = 'http://localhost:8080/api/update';

  public getCompanies() {
    return this.http.get(this.backendURL + '/allcompanies');
  }

  public updateCompany(company) {
    console.log('Edit company request sending ...');
    return this.http.post(this.updateURL, company);
  }


}
