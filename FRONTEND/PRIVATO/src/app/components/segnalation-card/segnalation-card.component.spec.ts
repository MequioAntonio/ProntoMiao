import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SegnalationCardComponent } from './segnalation-card.component';

describe('SegnalationCardComponent', () => {
  let component: SegnalationCardComponent;
  let fixture: ComponentFixture<SegnalationCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SegnalationCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SegnalationCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
