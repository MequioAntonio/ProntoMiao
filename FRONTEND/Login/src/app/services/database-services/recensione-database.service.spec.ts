import { TestBed } from '@angular/core/testing';

import { RecensioneDatabaseService } from './recensione-database.service';

describe('RecensioneDatabaseService', () => {
  let service: RecensioneDatabaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecensioneDatabaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
