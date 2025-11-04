import { Component } from '@angular/core';
import { RouterLink } from "@angular/router";
import { RouterLinks } from '../router-links/router-links';

@Component({
	selector: 'app-footer',
	imports: [
		RouterLinks
	],
	templateUrl: './footer.html',
	styleUrl: './footer.css',
})
export class Footer {

	currentYear = new Date().getFullYear()

}
