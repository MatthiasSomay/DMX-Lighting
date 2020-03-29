import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Scenes } from '../scene/scenes';
import { Observable } from 'rxjs';
import { Reply } from '../scene/reply';
import {map} from 'rxjs/operators';
import {Sceneslist} from './sceneslist';

@Injectable()
export class ScenesService {

  private scenesUrl: string;
  private deleteUrl: string;
  private getUrl: string;

  constructor(private http: HttpClient) {
    this.scenesUrl = "http://localhost:8080/api/sceneslist";
    this.deleteUrl = "http://localhost:8080/api/deletescene/";
    this.getUrl = "http://localhost:8080/api/getscene/";
  }

  /*public findAll(): Observable<Array<Scenes>> {
    return this.http.get('/api/sceneslist').pipe(
      map(response => {

        return response.sceneslist.map(scenes => Sceneslist.fromJSON(scenes));
      })
    );
  }*/

  public findAll(): Observable<Scenes[]> {
    return this.http.get<Scenes[]>(this.scenesUrl);
  }

  public delete(scene_id: string): void {
    console.log("deleting...");
    this.http.get(this.deleteUrl + scene_id).subscribe();
  }

  public get(scene_id: string): Observable<Scenes> {
    return this.http.get<Scenes>(this.getUrl + scene_id);
  }

}
