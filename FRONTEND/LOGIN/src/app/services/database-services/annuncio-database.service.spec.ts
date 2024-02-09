import { TestBed } from '@angular/core/testing';

import { AnnuncioDatabaseService } from './annuncio-database.service';

describe('AnnuncioDatabaseService', () => {
  let service: AnnuncioDatabaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnnuncioDatabaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
