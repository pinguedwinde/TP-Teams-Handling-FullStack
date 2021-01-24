import {Component, OnInit, ViewChild} from '@angular/core';
import {MatMenuTrigger} from "@angular/material/menu";
import {Router} from "@angular/router";

@Component({
  selector: 'app-teams-handling-header',
  templateUrl: './teams-handling-header.component.html',
  styleUrls: ['./teams-handling-header.component.scss']
})
export class TeamsHandlingHeaderComponent implements OnInit {

  constructor(private router: Router) {

  }

  ngOnInit(): void {
  }

  navigateToDeleteTeam() {
    this.router.navigate([`teams`])
      .catch();
  }

  navigateToUpdateTeam() {
    this.router.navigate([`teams`])
      .catch();
  }

  navigateToCreateTeam() {
    this.router.navigate([`team/add`])
      .catch();
  }

  navigateToTeamLst() {
    this.router.navigate([`teams`])
      .catch();
  }
}
