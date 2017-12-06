
import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { DataService } from '../data.service';

@Component({
  selector: 'users-list',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})

export class UsersComponent implements OnInit {
  users: User[];
  selectedUser: User;

  constructor(private dataService: DataService) {}

  getUsers() {
     this.dataService.getUsers().then(users => this.users = users);
  }

  ngOnInit(): void {
     this.getUsers();
  }
  
  onSelect(user: User): void {
    this.selectedUser = user;
  }

}