import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimalPostComponentComponent } from './animal-post-component.component';

describe('AnimalPostComponentComponent', () => {
  let component: AnimalPostComponentComponent;
  let fixture: ComponentFixture<AnimalPostComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnimalPostComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AnimalPostComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
