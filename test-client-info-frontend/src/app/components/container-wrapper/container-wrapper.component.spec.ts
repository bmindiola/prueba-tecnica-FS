import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerWrapperComponent } from './container-wrapper.component';

describe('ContainerWrapperComponent', () => {
  let component: ContainerWrapperComponent;
  let fixture: ComponentFixture<ContainerWrapperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContainerWrapperComponent]
    });
    fixture = TestBed.createComponent(ContainerWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
