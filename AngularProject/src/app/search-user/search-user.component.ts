import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {DataService} from '../data.service';
 
@Component({
  selector: 'search-users',
  templateUrl: './search-user.component.html',
  styleUrls: ['./search-user.component.css']
})
 
export class SearchUsersComponent implements OnInit {
  lastName: string;
  users: User[];
  
  constructor(private dataService: DataService) {}
 
  ngOnInit() {
    this.lastName = "";
  }
 
  private searchUsers() {
    this.dataService.getUsersByLastName(this.lastName).then(users => this.users = users);
  }
 
  onSubmit() {
    this.searchUsers();
  }
 
}