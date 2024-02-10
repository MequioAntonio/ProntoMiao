import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JwtHelperService } from '../../services/jwt-helper.service';

@Component({
  selector: 'app-not-found',
  standalone: true,
  imports: [],
  templateUrl: './not-found.component.html',
  styleUrl: './not-found.component.scss'
})
export class NotFoundComponent implements OnInit {

  constructor(private jwtHelper: JwtHelperService, private route: ActivatedRoute){}

  ngOnInit(): void {

    this.jwtHelper.receiveAndSet(this.route)
  }

}
