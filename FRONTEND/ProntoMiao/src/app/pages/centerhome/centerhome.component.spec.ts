import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterhomeComponent } from './centerhome.component';

describe('CenterhomeComponent', () => {
  let component: CenterhomeComponent;
  let fixture: ComponentFixture<CenterhomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CenterhomeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CenterhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
