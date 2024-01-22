import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimalCardComponentComponent } from './animal-card-component.component';

describe('AnimalCardComponentComponent', () => {
  let component: AnimalCardComponentComponent;
  let fixture: ComponentFixture<AnimalCardComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnimalCardComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AnimalCardComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
