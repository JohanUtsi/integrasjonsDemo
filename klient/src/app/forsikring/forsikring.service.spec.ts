import { TestBed } from '@angular/core/testing';

import { ForsikringService } from './forsikring.service';

describe('ForsikringService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ForsikringService = TestBed.get(ForsikringService);
    expect(service).toBeTruthy();
  });
});
