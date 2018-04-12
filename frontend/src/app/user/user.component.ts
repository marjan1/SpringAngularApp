import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {User} from '../models/user.model';
import {UserService} from '../service/user.service';

import {CompanyDTO} from '../models/company.model';
import {CompanyService} from '../service/company.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styles: []
})
export class UserComponent implements OnInit {

  users: User[];
  companies: CompanyDTO[];

  constructor(private router: Router, private userService: UserService,
              private companyService: CompanyService) {

  }

  ngOnInit() {
    this.userService.getUsers()
      .subscribe(data => {
        this.users = <User[]> data;
      });
    this.companyService.getCompanies()
      .subscribe(data => {
        this.companies = <CompanyDTO[]> data;
      });
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe(data => {
        this.users = this.users.filter(u => u !== user);
      });
  }

}
