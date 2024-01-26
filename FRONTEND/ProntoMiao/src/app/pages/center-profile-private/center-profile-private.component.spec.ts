import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterProfilePrivateComponent } from './center-profile-private.component';

describe('CenterProfilePrivateComponent', () => {
  let component: CenterProfilePrivateComponent;
  let fixture: ComponentFixture<CenterProfilePrivateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CenterProfilePrivateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CenterProfilePrivateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
