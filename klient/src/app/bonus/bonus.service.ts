import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Bonus} from './bonus.model';
import {Bonuses} from './bonuses.model';

@Injectable({
  providedIn: 'root'
})
export class BonusService {

  private url: string = environment.backendUrl2+"/bonus";

  constructor(private httClient: HttpClient) { }

  getBonuses():Observable<Bonuses>{
    return this.httClient.get<Bonuses>(this.url);
  }

}
