import { TestBed } from '@angular/core/testing';

import { UtentePrivatoDatabaseService } from './utente-privato-database.service';

describe('UtentePrivatoDatabaseService', () => {
  let service: UtentePrivatoDatabaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UtentePrivatoDatabaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
