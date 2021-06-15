import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavegaciontiendaComponent } from './navegaciontienda.component';

describe('NavegaciontiendaComponent', () => {
  let component: NavegaciontiendaComponent;
  let fixture: ComponentFixture<NavegaciontiendaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavegaciontiendaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavegaciontiendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
