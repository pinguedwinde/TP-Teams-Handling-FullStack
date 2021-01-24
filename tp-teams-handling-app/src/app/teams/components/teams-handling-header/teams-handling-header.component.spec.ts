import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamsHandlingHeaderComponent } from './teams-handling-header.component';

describe('TeamsHandlingHeaderComponent', () => {
  let component: TeamsHandlingHeaderComponent;
  let fixture: ComponentFixture<TeamsHandlingHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeamsHandlingHeaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamsHandlingHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
