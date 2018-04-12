import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AddUserComponent } from './add-user/add-user.component';
import { AppRoutingModule } from './app.routing.module';
import {UserService} from './service/user.service';
import {CompanyService} from './service/company.service';
import {HttpClientModule} from '@angular/common/http/';
import { CompanyComponent } from './company/company.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddUserComponent,
    CompanyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

  ],
  providers: [CompanyService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
