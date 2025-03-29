import { TestBed } from '@angular/core/testing';

import { WorldapiService } from './worldapi.service';

describe('CricapiService', () => {
  let service: WorldapiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorldapiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
