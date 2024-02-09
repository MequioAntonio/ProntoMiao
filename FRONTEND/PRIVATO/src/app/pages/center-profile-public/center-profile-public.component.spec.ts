import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterProfilePublicComponent } from './center-profile-public.component';

describe('CenterProfilePublicComponent', () => {
  let component: CenterProfilePublicComponent;
  let fixture: ComponentFixture<CenterProfilePublicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CenterProfilePublicComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CenterProfilePublicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
