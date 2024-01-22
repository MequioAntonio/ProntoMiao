import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimalInfoComponentComponent } from './animal-info-component.component';

describe('AnimalInfoComponentComponent', () => {
  let component: AnimalInfoComponentComponent;
  let fixture: ComponentFixture<AnimalInfoComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnimalInfoComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AnimalInfoComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
