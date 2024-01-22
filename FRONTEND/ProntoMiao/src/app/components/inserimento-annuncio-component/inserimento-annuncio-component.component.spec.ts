import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InserimentoAnnuncioComponentComponent } from './inserimento-annuncio-component.component';

describe('InserimentoAnnuncioComponentComponent', () => {
  let component: InserimentoAnnuncioComponentComponent;
  let fixture: ComponentFixture<InserimentoAnnuncioComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InserimentoAnnuncioComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InserimentoAnnuncioComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
