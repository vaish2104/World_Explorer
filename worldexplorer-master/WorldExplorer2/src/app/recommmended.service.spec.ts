import { TestBed } from '@angular/core/testing';

import { RecommmendedService } from './recommmended.service';

describe('RecommmendedService', () => {
  let service: RecommmendedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecommmendedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
