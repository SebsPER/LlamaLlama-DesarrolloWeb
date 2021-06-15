import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompracComponent } from './comprac.component';

describe('CompracComponent', () => {
  let component: CompracComponent;
  let fixture: ComponentFixture<CompracComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompracComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompracComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
