import {Component, OnInit} from '@angular/core';
import {AdvertService} from "../services/advert.service";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";


@Component({
  selector: 'app-advert-page',
  templateUrl: './advert-page.component.html',
  styleUrls: ['./advert-page.component.css']
})
export class AdvertPageComponent implements OnInit{
  public create!: FormGroup;
  public adverts: any | undefined;


  constructor(private advertService:AdvertService,
              private formBuilder:FormBuilder,
              private router:Router) {
  }

  ngOnInit(): void {
    this.create = this.formBuilder.group({
      price: '',
      location: '',
      availability:'',
      squareMeters:''
    });
  this.advertService.getAdvert().subscribe(
    (response) => {
      this.adverts = response;
    },
    (error) =>{
      alert(error.message());
    }
  )
  }

  logout() {
    this.router.navigate(["login"]);
    localStorage.clear();
  }

  submit(): void {
    this.advertService.createAdvert(this.create.value).subscribe(
      (response)=>{
        this.adverts.push(response);
      }
    );
  }

  delete(id:number) {
    this.advertService.deleteAdvert(id).subscribe();
  }


}
