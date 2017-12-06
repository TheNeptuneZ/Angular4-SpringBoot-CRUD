import { UserDetailsComponent } from './user-details/user-details.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { SearchUsersComponent } from './search-user/search-user.component';

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
  {path: '', redirectTo: 'user', pathMatch: 'full'},
  {path: 'user', component: UsersComponent},
  {path: 'add', component: CreateUserComponent},
  {path: 'findbylastname', component: SearchUsersComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}