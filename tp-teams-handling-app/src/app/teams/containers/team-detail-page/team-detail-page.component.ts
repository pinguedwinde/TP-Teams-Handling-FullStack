import {Component, OnInit} from '@angular/core';
import {Team} from "@team-handling/teams/models/team";
import {TeamService} from "@team-handling/teams/services/team.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from '@angular/common';
import {mergeMap} from "rxjs/operators";

@Component({
  selector: 'app-team-detail-page',
  templateUrl: './team-detail-page.component.html',
  styleUrls: ['./team-detail-page.component.scss']
})
export class TeamDetailPageComponent implements OnInit {

  team: Team | null;

  constructor(private teamService: TeamService,
              private route: ActivatedRoute,
              private router: Router,
              private location: Location) {
    this.team = {id: 0, name: '', slogan: ''};
  }

  ngOnInit(): void {
    this.teamService.pullTeam().subscribe(team => this.team = team)
    if (this.team?.name === '') {
      /* This method does a request to the API, what is not necessary and not optimum*/
      //*
      this.route.params.pipe(
        mergeMap(params => this.teamService.getTeamById(params['id'])))
        .subscribe(team => this.team = team);
      //*/
    }
  }

  /** Just navigate to /teams url
   backToTeamList(): void {
    this.router.navigate(['teams'])
      .catch();
  }
   */

  /** Navigate back to the previous location url**/
  back(): void {
    this.location.back();
  }

  goToEditTeam() {
    this.router.navigate(['team/edit'])
      .catch();
  }

  removeTeam(team: Team) {
    this.teamService.deleteTeam(team.id)
      .subscribe(_ => this.router.navigate(['teams']));

  }
}
