import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TeamService} from "@team-handling/teams/services/team.service";
import {Router} from "@angular/router";
import {Team} from "@team-handling/teams/models/team";

@Component({
  selector: 'app-team-edit-page',
  templateUrl: './team-edit-page.component.html',
  styleUrls: ['./team-edit-page.component.scss']
})
export class TeamEditPageComponent implements OnInit {
  editTeamForm! : FormGroup;
  teamToEdit: Team | null;

  constructor(private formBuilder: FormBuilder,
              private teamService: TeamService,
              private router: Router) {
    this.teamToEdit = null;
  }

  ngOnInit(): void {
    this.teamService.pullTeam().subscribe(team => this.teamToEdit = team);
    this.editForm();
  }

   editTeam() {
    if (this.editTeamForm.invalid) {
      return
    }

    if(this.teamToEdit) {
      console.log(this.teamToEdit.id);
      const team: Team = {
        id: this.teamToEdit.id,
        name: this.editTeamForm.value.name,
        slogan: this.editTeamForm.value.slogan
      };

      this.teamService
        .updateTeam(team)
        .subscribe(_ => this.router.navigate(['teams']));
    }
  }

  backToTeamList(): void{
    this.router.navigate([`teams`])
      .catch();
  }

  private editForm(): void{
    if(this.teamToEdit){
      this.editTeamForm = this.formBuilder.group({
        name: [this.teamToEdit.name,  Validators.required],
        slogan: [this.teamToEdit.slogan,  Validators.required],
      });
    }
  }
}
