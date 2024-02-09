import { TestBed } from '@angular/core/testing';

import { SegnalazioneDatabaseService } from './segnalazione-database.service';

describe('SegnalazioneDatabaseService', () => {
  let service: SegnalazioneDatabaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SegnalazioneDatabaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
