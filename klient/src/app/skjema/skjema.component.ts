import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BonusService} from '../bonus/bonus.service';
import {Bonus} from '../bonus/bonus.model';
import {ForsikringService} from '../forsikring/forsikring.service';
import {Forsikring} from '../forsikring/forsikring.model';
import {Avtalestatus} from '../avtale/avtalestatus.model';

@Component({
  selector: 'app-skjema',
  templateUrl: './skjema.component.html',
  styleUrls: ['./skjema.component.css']
})
export class SkjemaComponent implements OnInit {

  skjema: FormGroup;
  bonuses: Bonus[];
  avtaleStatus: Avtalestatus = null;
  skjemaFaila: boolean = false;

  constructor(private formBuilder: FormBuilder, private bonusService: BonusService,
              private forsikringService: ForsikringService) { }

  ngOnInit() {
    this.klargjorSkjema();
  }

  private klargjorSkjema(): void {
    this.skjema = this.formBuilder.group({
      regNummer: [{value:'', disabled: false}, Validators.required],
      bonus: [{value:'', disabled: false}, Validators.required],
      fodselsnummer: [{value:'', disabled: false}, [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
      fornavn: [{value:'', disabled: false}, Validators.required],
      etternavn: [{value:'', disabled: false}, Validators.required],
      epost: [{value:'', disabled: false}, [Validators.email, Validators.required]]
    });
    this.bonusService.getBonuses().subscribe(bonuses=>{
      this.bonuses = bonuses.bonus;
    });
  }

  submit(){
    if(this.skjema.valid){
      let forsikring = new Forsikring();
      forsikring.bonusid = this.skjema.controls['bonus'].value;
      forsikring.epost = this.skjema.controls['epost'].value;
      forsikring.fornavn = this.skjema.controls['fornavn'].value;
      forsikring.etternavn = this.skjema.controls['etternavn'].value;
      forsikring.regNummer = this.skjema.controls['regNummer'].value;
      forsikring.fodselsnummer = this.skjema.controls['fodselsnummer'].value;
      console.log(forsikring);
      this.forsikringService.createAvtale(forsikring).subscribe(status=>{
        this.avtaleStatus = status;
      }, () =>{
        this.skjemaFaila = true;
      });
    }else{
      Object.keys(this.skjema.controls).forEach(key => {
        this.skjema.get(key).markAsTouched();
      });
    }
  }

  cancel(){
    Object.keys(this.skjema.controls).forEach(key => {
      this.skjema.get(key).setValue(null);
    });
  }

}
