import { TestBed } from '@angular/core/testing';

import { CompraserviceService } from './compraservice.service';

describe('CompraserviceService', () => {
  let service: CompraserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompraserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
