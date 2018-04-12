import {CompanyDTO} from './company.model';

export class User {

  idUsers: string;
  name: string;
  username: string;
  email: string;
  statusCode: number;
  password: string;
  companyDTO: typeof CompanyDTO;
}
