import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, Observable, of} from "rxjs";
import {Team} from "@team-handling/teams/models/team";
import {environment} from "@team-handling-env/environment";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private subject = new BehaviorSubject<Team>({id: 0, name: '', slogan: ''});
  private messageSubject = new BehaviorSubject<string>('List of teams');
  private teamsURL: string = `${environment.backendPoint}/teams`;
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {
  }

  pushTeam(team: Team): void {
    this.subject.next(team);
  }

  pullTeam(): Observable<Team> {
    return this.subject.asObservable();
  }

  pushMessage(message: string): void {
    this.messageSubject.next(message);
  }

  pullMessage(): Observable<string> {
    return this.messageSubject.asObservable();
  }

  /**
   * GET : retrieve the teams from the Server TP-Handling-API
   */
  getTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(this.teamsURL)
      .pipe(
        catchError(this.handleError<Team[]>('getTeams', []))
      );
  }

  /**
   * GET : retrieve a team by using a ID from the Server TP-Handling-API
   */
  getTeamById(id: number): Observable<Team> {
    return this.http.get<Team>(`${this.teamsURL}/${id}`)
      .pipe(
        catchError(this.handleError<Team>('getTeamById', {name:'', slogan:''}))
      );
  }

  /**
   * POST : create a team on the Server TP-Handling-API
   */
  createTeam(team: Team): Observable<Team> {
    return this.http.post<Team>(this.teamsURL, team)
      .pipe(
        catchError(this.handleError<Team>('createTeam', {name:'', slogan:''}))
      );
  }

  /**
   * PUT : update the team  on the Server TP-Handling-API
   */
  updateTeam(team: Team): Observable<any>{
    return this.http.put(`${this.teamsURL}/${team.id}`, team, this.httpOptions)
      .pipe(
        catchError(this.handleError<any>('updateTeam', {name:'', slogan:''}))
      );
  }

  /**
   * DELETE : delete the team  on the Server TP-Handling-API
   */
  deleteTeam(id: number | undefined): Observable<any>{

    if(id != undefined){
      return this.http.delete(`${this.teamsURL}/${id}`, this.httpOptions)
        .pipe(
          catchError(this.handleError<any>('deleteTeam', {name:'', slogan:''}))
        );
    }else{
      return of({id:0, name:'', slogan:''});
    }

  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    /**
     * The handleError() will be shared by many HeroService methods
     * so it's generalized to meet their different needs.
     * Instead of handling the error directly, it returns an error handler function
     * to catchError that it has configured with both the name of the operation
     * that failed and a safe return value.
     */

    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
