import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {Team} from "@team-handling/teams/models/team";
import {environment} from "@team-handling-env/environment";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private subject = new BehaviorSubject<Team>({id: 0, name: '', slogan: ''});

  constructor(private http: HttpClient) {
  }

  pushTeam(team: Team): void{
    this.subject.next(team);
  }

  pullTeam(): Observable<Team>{
    return this.subject.asObservable();
  }


  getTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(`${environment.backendPoint}/teams/`);
  }

  getTeamById(id: number): Observable<Team> {
    return this.http.get<Team>(`${environment.backendPoint}/teams/${id}`);
  }

  createTeam(team: Team): Observable<Team>{
    return this.http.post<Team>(`${environment.backendPoint}/teams`, team);
  }

}
