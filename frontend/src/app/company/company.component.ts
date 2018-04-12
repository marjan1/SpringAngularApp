import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {CompanyDTO} from '../models/company.model';
import {CompanyService} from '../service/company.service';
import {UserService} from '../service/user.service'   ;


@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  companies: CompanyDTO[];
  editMode: boolean;
  companyForEdit: CompanyDTO;

  constructor(private router: Router, private userService: UserService,
              private companyService: CompanyService) {
    this.editMode = false;
  }

  ngOnInit() {
    this.companyService.getCompanies()
      .subscribe(data => {
        this.companies = <CompanyDTO[]> data;
      });
  }

  openEditMode(company: CompanyDTO) {
    console.log('comnany : ', company.companyName);
    this.editMode = true;
    this.companyForEdit = company;

  }

  cancelEditCompany() {
    this.editMode = false;
  }

  saveEditedCompany() {
    this.editMode = false;
    this.companyService.updateCompany(this.companyForEdit).subscribe( data => {
      alert('Company updated successfully.');
    });
  }

}
