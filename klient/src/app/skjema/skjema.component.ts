import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BonusService} from '../bonus/bonus.service';
import {Bonus} from '../bonus/bonus.model';

@Component({
  selector: 'app-skjema',
  templateUrl: './skjema.component.html',
  styleUrls: ['./skjema.component.css']
})
export class SkjemaComponent implements OnInit {

  skjema: FormGroup;
  bonuses: Bonus[];

  constructor(private formBuilder: FormBuilder, private bonusService: BonusService) { }

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
      console.log("valid");
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
