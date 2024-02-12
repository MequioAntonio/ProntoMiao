import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RichiestaConfirmComponent } from './richiesta-confirm.component';

describe('RichiestaConfirmComponent', () => {
  let component: RichiestaConfirmComponent;
  let fixture: ComponentFixture<RichiestaConfirmComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RichiestaConfirmComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RichiestaConfirmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
