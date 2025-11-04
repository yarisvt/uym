import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouterLinks } from './router-links';

describe('RouterLinks', () => {
	let component : RouterLinks;
	let fixture : ComponentFixture<RouterLinks>;

	beforeEach(async () => {
		await TestBed.configureTestingModule({
			imports: [RouterLinks]
		})
			.compileComponents();

		fixture = TestBed.createComponent(RouterLinks);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
