import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TeamService} from "@team-handling/teams/services/team.service";
import {Team} from "@team-handling/teams/models/team";
import {Router} from "@angular/router";

@Component({
  selector: 'app-team-add-page',
  templateUrl: './team-add-page.component.html',
  styleUrls: ['./team-add-page.component.scss']
})
export class TeamAddPageComponent implements OnInit {

  /* Possibly null. Nullable object*/
  addTeamForm! : FormGroup;

  constructor(private formBuilder: FormBuilder,
              private teamService: TeamService,
              private router: Router) { }

  ngOnInit(): void {
    this.createForm();
  }

  createTeam(){

    if (this.addTeamForm.invalid) {
      return
    }

    const team: Team = {
      name: this.addTeamForm.value.name,
      slogan: this.addTeamForm.value.slogan
    };

    this.teamService
      .createTeam(team)
      .subscribe(_ => this.router.navigate(['teams']));

  }

  backToTeamList(): void{
    this.router.navigate([`teams`])
      .catch();
  }

  private createForm(): void{
      this.addTeamForm = this.formBuilder.group({
        name: ['',  Validators.required],
        slogan: ['',  Validators.required],
    });
  }
}
