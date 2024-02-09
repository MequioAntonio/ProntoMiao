import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SegnalationFormComponent } from './segnalation-form.component';

describe('SegnalationFormComponent', () => {
  let component: SegnalationFormComponent;
  let fixture: ComponentFixture<SegnalationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SegnalationFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SegnalationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
