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
  allUsers: User[];
  companies: CompanyDTO[];
  userSearch: User;
  companySelected: number;

  constructor(private router: Router, private userService: UserService,
              private companyService: CompanyService) {

  }

  ngOnInit() {
    this.userService.getUsers()
      .subscribe(data => {
        this.users = <User[]> data;
        this.allUsers = this.users;
      });
    this.companyService.getCompanies()
      .subscribe(data => {
        this.companies = <CompanyDTO[]> data;
      });
    this.userSearch = new User();
    this.userSearch.email = '';
    this.userSearch.username = '';
    this.userSearch.name = '';
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe(data => {
        this.users = this.users.filter(u => u !== user);
      });
  }

  startSearch(): void {
    console.log('Start search ' + this.userSearch.name);
    if (this.userSearch.name.length > 0 ||
      this.userSearch.username.length > 0 ||
      this.userSearch.email.length > 0) {
      console.log('calling the service');
      this.userService.searchUsers(this.userSearch.name,
        this.userSearch.username,
        this.userSearch.email,
        null)
        .subscribe(data => {
          console.log('Data received ');
          this.users = <User[]> data;
          console.log('Number of users received received ' + this.users.length);
        });
    } else {
      this.users = this.allUsers;
    }

  }


}
