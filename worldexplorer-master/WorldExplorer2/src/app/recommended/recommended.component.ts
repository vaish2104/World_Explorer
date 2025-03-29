import { Component, OnInit } from '@angular/core';

import { WorldapiService } from '../worldapi.service';
import { Find } from '../find';
import { FavouritesService } from '../favourites.service';
import { Favs } from '../fav';

import { RouterService } from '../router.service';
import {MatPaginatorModule} from '@angular/material/paginator';

@Component({
  selector: 'app-recommended',
  templateUrl: './recommended.component.html',
  styleUrls: ['./recommended.component.css']
})
export class RecommendedComponent implements OnInit {
 cdata:JSON;
 data:any;
  show: boolean=false;
  status:boolean;
  config: any;
  val: string;
   fav=new Favs();
  
  list: Array<Find> = [];
  list1: Array<Find> = [];

  // Dependency Injection of cric api, fav service and recommended service
  constructor(private worldapi: WorldapiService, private favser: FavouritesService,
     private route: RouterService) {
    this.val = "";
    // paginantion
    this.config = {
      itemsPerPage: 10,
      currentPage: 1,
      totalItems: this.list.length
    };

  }

  // Page events are stored in config
  pageChanged(event) {
    this.config.currentPage = event;
  }
  ngOnInit() {
    

  }

  // It will call cric api service and get list of players
  getData(val) {
    console.log(val);
    
    this.worldapi.searchCountry(val).subscribe(
      res => {
        this.list=res;
        
        for (let obj of this.list) {

          obj.status = true;
        }
       
      },
      err => {
        console.log(err)
      })
  }

  showData(data) {
    
    console.log(data);
    this.show=true;
    this.worldapi.searchByRegion(data.continents[0]).subscribe(
      res => {
        this.list1=res;
        for (let obj of this.list) {

          obj.status = true;
        }
       
      },
      err => {
        console.log(err)
      })
    
    
  }
  hideData(data){
    
    this.show=false;
  }

  // it will add a player into recommended as well as the favourites by calling there respective services
  addToFav(data) {
    data.status = false;
    
       console.log(data.capital[0]);
       console.log(data.area);
        this.fav.capital = data.capital[0];
        this.fav.area=data.area;
        this.fav.coatOfArms=data.coatOfArms.png;
        this.fav.officialname=data.name.official;
        this.fav.common_name=data.name.common;
        this.fav.population=data.population;
        this.fav.flag=data.flags.png;
        this.fav.region=data.region;
        this.fav.status = false;
        this.fav.username = sessionStorage.getItem('username');
        console.log(this.fav);
        
        this.favser.addData(this.fav, sessionStorage.getItem('token')).subscribe(
          res => console.log("added to fav"),
          err => console.log(err)
          )
      
     
  }

  // it will remove a country from the favourites by calling there respective services
  removeFromFav(data) {
    data.status = true;
    
    this.favser.deleteDataUser(sessionStorage.getItem('username'), data.pid, sessionStorage.getItem('token')).subscribe(
      res => console.log("removed from recom"),
      err => console.log(err)
    )
  }

}
