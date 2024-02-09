import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdoptionsPageComponent } from './adoptions-page.component';

describe('AdoptionsPageComponent', () => {
  let component: AdoptionsPageComponent;
  let fixture: ComponentFixture<AdoptionsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdoptionsPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdoptionsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
