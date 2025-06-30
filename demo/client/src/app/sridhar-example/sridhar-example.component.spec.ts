import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SridharExampleComponent } from './sridhar-example.component';

describe('SridharExampleComponent', () => {
  let component: SridharExampleComponent;
  let fixture: ComponentFixture<SridharExampleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SridharExampleComponent]
    });
    fixture = TestBed.createComponent(SridharExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
