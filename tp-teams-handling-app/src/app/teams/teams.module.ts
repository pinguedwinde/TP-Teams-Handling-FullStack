import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TeamListPageComponent} from "@team-handling/teams/containers/team-list-page/team-list-page.component";
import {MatCardModule} from "@angular/material/card";
import {TeamDetailPageComponent} from "@team-handling/teams/containers/team-detail-page/team-detail-page.component";
import {MatButtonModule} from "@angular/material/button";
import {TeamAddPageComponent} from "@team-handling/teams/containers/team-add-page/team-add-page.component";
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {TeamsHandlingHeaderComponent} from "@team-handling/teams/components/teams-handling-header/teams-handling-header.component";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatMenuModule} from "@angular/material/menu";
import {RouterModule} from "@angular/router";
import { TeamEditPageComponent } from './containers/team-edit-page/team-edit-page.component';


@NgModule({
  declarations: [
    TeamListPageComponent,
    TeamDetailPageComponent,
    TeamAddPageComponent,
    TeamsHandlingHeaderComponent,
    TeamEditPageComponent
  ],
  exports: [
    TeamsHandlingHeaderComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    RouterModule
  ]
})
export class TeamsModule {
}
