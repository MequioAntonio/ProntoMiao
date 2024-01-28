import { TestBed } from '@angular/core/testing';

import { CentroAdozioniDatabaseService } from './centro-adozioni-database.service';

describe('CentroAdozioniDatabaseService', () => {
  let service: CentroAdozioniDatabaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CentroAdozioniDatabaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
