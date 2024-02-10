import { Component, OnInit, SecurityContext } from '@angular/core';
import { AdoptionCardComponent } from '../../components/adoption-card/adoption-card.component';
import { MatButtonModule } from '@angular/material/button';
import { FeedbackCardComponent } from '../../components/feedback-card/feedback-card.component';
import { Centro } from '../../model/Centro';
import { ActivatedRoute, Router } from '@angular/router';
import { AnnuncioDatabaseService } from '../../services/database-services/annuncio-database.service';
import { Annuncio } from '../../model/Annuncio';
import { HttpClient } from '@angular/common/http';
import { Richiesta } from '../../model/Richiesta';
import { Recensione } from '../../model/Recensione';
import { RichiestaDatabaseService } from '../../services/database-services/richiesta-database.service';
import { RecensioneDatabaseService } from '../../services/database-services/recensione-database.service';
import { CommonModule } from '@angular/common';
import { CentroAdozioniDatabaseService } from '../../services/database-services/centro-adozioni-database.service';
import { RequestCardComponent } from '../../components/request-card/request-card.component';
import { AuthService } from '../../services/auth.service';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import * as Leaflet from 'leaflet';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { JwtHelperService } from '../../services/jwt-helper.service';

@Component({
  selector: 'app-center-profile-private',
  standalone: true,
  imports: [LeafletModule, AdoptionCardComponent, FeedbackCardComponent, MatButtonModule, CommonModule, RequestCardComponent],
  templateUrl: './center-profile-private.component.html',
  styleUrl: './center-profile-private.component.scss',
})
export class CenterProfilePrivateComponent implements OnInit{
  //string immagine?
  centro!: Centro;

  annunci?: Annuncio[] = new Array();


  richieste?: Richiesta[] = new Array();

  recensioni?: Recensione[] = new Array();

  sanitizedUrl: SafeUrl = "";

  map!: Leaflet.Map;

  options: Leaflet.MapOptions = {
    center: Leaflet.latLng(45.3212164, 16.2432423),
    layers: this.getLayers(),
    zoom: 1,

  };

  constructor(
    private cds: CentroAdozioniDatabaseService,
    private ric: RichiestaDatabaseService,
    private rds: RecensioneDatabaseService,
    private as: AuthService,
    private ads: AnnuncioDatabaseService,
    private router: Router,
    private sanitizer: DomSanitizer,
    private http: HttpClient,
    private jwtHelper: JwtHelperService, private route: ActivatedRoute
  ) {}
    isCentro = this.as.isCentro()

    ngOnInit(): void {
      this.jwtHelper.receiveAndSet(this.route)

      const path = this.router.url;
      const parts = path.split("/");
      const lastElement = parts[parts.length - 1];

      this.cds.getCenterByID(lastElement).subscribe(data=>{
        this.centro = data;
      })

      this.ric.getAllRichiesteByCentro(lastElement).subscribe(data=>{
        console.warn(data)
        this.richieste = data;
      })

      this.ads.getAllAnnunciByCentro(lastElement).subscribe(data=>{
        this.annunci = data;

      })

      this.rds.getAllRecensioniByCentro(lastElement).subscribe(data=>{
        this.recensioni = data;
      })


    }


    onMapReady(map: Leaflet.Map) {
      this.map = map;
      console.log(this.centro.indirizzo)
      this.http.get<any>("https://nominatim.openstreetmap.org/search?q=" + encodeURI(this.centro.indirizzo) + "&format=json&limit=1").subscribe(data => {
        console.log(data)
        if (data.length > 0) {
          setTimeout(()=>{
            map.flyTo(new Leaflet.LatLng(data[0].lat, data[0].lon), 15);
            var newMarker = new Leaflet.Marker(new Leaflet.LatLng(data[0].lat, data[0].lon), {
              icon: new Leaflet.Icon({
                iconSize: [50, 41],
                iconAnchor: [13, 41],
                iconUrl: 'assets/imgs/logo.png',
              }),
              title: 'Workspace'
            } as Leaflet.MarkerOptions).addTo(map);
          }, 500)
        }
      }, (error) => {
        console.log(error)
      })

  }

  //RICORDARSI DI FARE I METODI AGGIUNGIANNUNCIO E MODIFICAPROFILO

  //Fare modificaProfilo
  modificaProfilo() {}

  aggiungiAdozione() {
    location.href = '/adoption-form';
  }

  getLayers(): Leaflet.Layer[] | undefined {
    return [
      new Leaflet.TileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; OpenStreetMap contributors'
      } as Leaflet.TileLayerOptions)
    ] as Leaflet.Layer[];

  }

  getMarkers() {
    return [
      new Leaflet.Marker(new Leaflet.LatLng(45.3212164, 16.2432423), {
        icon: new Leaflet.Icon({
          iconSize: [50, 41],
          iconAnchor: [13, 41],
          iconUrl: 'assets/imgs/logo.png',
        }),
        title: 'Workspace'
      } as Leaflet.MarkerOptions),
    ] as Leaflet.Marker[];
  }

}

