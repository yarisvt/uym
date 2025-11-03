import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Wattpad } from './wattpad';

describe('Wattpad', () => {
	let component : Wattpad;
	let fixture : ComponentFixture<Wattpad>;

	beforeEach(async () => {
		await TestBed.configureTestingModule({
			imports: [Wattpad]
		})
			.compileComponents();

		fixture = TestBed.createComponent(Wattpad);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
