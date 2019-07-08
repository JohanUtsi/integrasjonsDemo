import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Avtalestatus} from '../avtale/avtalestatus.model';
import {Forsikring} from './forsikring.model';

@Injectable({
  providedIn: 'root'
})
export class ForsikringService {
  private url: string = environment.backendUrl+"/forsikring";
  constructor(private httpClient: HttpClient) { }

  createAvtale(forsikring: Forsikring):Observable<Avtalestatus>{
    return this.httpClient.post<Avtalestatus>(this.url, forsikring);
  }
}
