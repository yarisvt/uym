import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WattpadComponent } from './wattpad.component';

describe('Wattpad', () => {
	let component : WattpadComponent;
	let fixture : ComponentFixture<WattpadComponent>;

	beforeEach(async () => {
		await TestBed.configureTestingModule({
			imports: [WattpadComponent]
		})
			.compileComponents();

		fixture = TestBed.createComponent(WattpadComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
