import { TestBed } from '@angular/core/testing';

import { AnimaleDatabaseService } from './animale-database.service';

describe('AnimaleDatabaseService', () => {
  let service: AnimaleDatabaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnimaleDatabaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
