import {Component, OnInit, ViewChild} from '@angular/core';
import {MatMenuTrigger} from "@angular/material/menu";
import {Router} from "@angular/router";
import {TeamService} from "@team-handling/teams/services/team.service";

@Component({
  selector: 'app-teams-handling-header',
  templateUrl: './teams-handling-header.component.html',
  styleUrls: ['./teams-handling-header.component.scss']
})
export class TeamsHandlingHeaderComponent implements OnInit {

  constructor(private router: Router,
              private teamService: TeamService) {
  }

  ngOnInit(): void {
  }

  navigateToDeleteTeam() {
    this.teamService.pushMessage('Select a team to delete');
    this.router.navigate([`teams`])
      .catch();
  }

  navigateToUpdateTeam() {
    this.teamService.pushMessage('Select a team to edit');
    this.router.navigate([`teams`])
      .catch();
  }

  navigateToCreateTeam() {
    this.router.navigate([`team/add`])
      .catch();
  }

  navigateToTeamList() {
    this.teamService.pushMessage('List of teams');
    this.router.navigate([`teams`])
      .catch();
  }
}
