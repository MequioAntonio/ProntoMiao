import { TestBed } from '@angular/core/testing';

import { RichiestaDatabaseService } from './richiesta-database.service';

describe('RichiestaDatabaseService', () => {
  let service: RichiestaDatabaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RichiestaDatabaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
