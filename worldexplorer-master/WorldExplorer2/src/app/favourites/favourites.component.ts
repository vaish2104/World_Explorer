import { Component, OnInit } from '@angular/core';
import { FavouritesService } from 'src/app/favourites.service';
import { RecommmendedService } from 'src/app/recommmended.service';
import { Recommended } from 'src/app/recommended';
import { Favs } from 'src/app/fav';
import { WorldapiService } from 'src/app/worldapi.service';


@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {

  list : Array<Favs>;
  fav: Favs;
  recom: Recommended

  // dependency injection of required services
  constructor(private favser : FavouritesService, private recomser : RecommmendedService, private cricapi : WorldapiService) { }

  // load all the favs of a particular user at the time of initialization
  ngOnInit(): void {
    this.favser.getData(sessionStorage.getItem('username'),sessionStorage.getItem('token')).subscribe(
      res => {
        this.list = res;
      },
      err => console.log(err)
    )    
  }

  // remove a player from favs of the particular user as well as send a decrease couter request to frontend
  removeFromFav(data){
    data.status = true;
    this.recomser.deleteData(data.pid, sessionStorage.getItem('token')).subscribe(
      res => this.favser.deleteDataUser(sessionStorage.getItem('username'), data.cid, sessionStorage.getItem('token')).subscribe(
        res => console.log(res),
        err => console.log(err)
      ),
      err => {
        if (err.statusText === "OK") {
          this.favser.deleteDataUser(sessionStorage.getItem('username'), data.cid, sessionStorage.getItem('token')).subscribe(
            res => location.reload(),
            err => console.log(err)
          )
        }
      }
    )
  }

}
