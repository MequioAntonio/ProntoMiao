import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SegnalationsPageComponent } from './segnalations-page.component';

describe('SegnalationsPageComponent', () => {
  let component: SegnalationsPageComponent;
  let fixture: ComponentFixture<SegnalationsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SegnalationsPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SegnalationsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
