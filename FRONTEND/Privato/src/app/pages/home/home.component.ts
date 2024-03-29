import { Component, OnInit, ViewChild } from '@angular/core';
import { AdoptionCardComponent } from '../../components/adoption-card/adoption-card.component';
import {MatTabsModule} from '@angular/material/tabs';
import {MatIconModule} from '@angular/material/icon';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';

import { NgbCarousel, NgbCarouselModule, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { SmallCardComponent } from '../../components/small-card/small-card.component';
import { ActivatedRoute } from '@angular/router';
import { JwtHelperService } from '../../services/jwt-helper.service';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [AdoptionCardComponent, MatTabsModule, MatIconModule, MatGridListModule, MatCardModule, NgbCarouselModule, FormsModule, SmallCardComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent implements OnInit{
  constructor(private route: ActivatedRoute, private jh: JwtHelperService){}
  ngOnInit(): void {
    this.jh.receiveAndSet(this.route)
  }
  images = [1, 2, 3].map((n) => `./assets/imgs/home/slide${n}.jpg`);

	paused = false;
	unpauseOnArrow = false;
	pauseOnIndicator = false;
	pauseOnHover = true;
	pauseOnFocus = true;

	@ViewChild('carousel', { static: true })
  carousel: NgbCarousel = new NgbCarousel;

	togglePaused() {
		if (this.paused) {
			this.carousel.cycle();
		} else {
			this.carousel.pause();
		}
		this.paused = !this.paused;
	}

	onSlide(slideEvent: NgbSlideEvent) {
		if (
			this.unpauseOnArrow &&
			slideEvent.paused &&
			(slideEvent.source === NgbSlideEventSource.ARROW_LEFT || slideEvent.source === NgbSlideEventSource.ARROW_RIGHT)
		) {
			this.togglePaused();
		}
		if (this.pauseOnIndicator && !slideEvent.paused && slideEvent.source === NgbSlideEventSource.INDICATOR) {
			this.togglePaused();
		}
	}
}
