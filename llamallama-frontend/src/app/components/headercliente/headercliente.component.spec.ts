import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderclienteComponent } from './headercliente.component';

describe('HeaderclienteComponent', () => {
  let component: HeaderclienteComponent;
  let fixture: ComponentFixture<HeaderclienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderclienteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderclienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
