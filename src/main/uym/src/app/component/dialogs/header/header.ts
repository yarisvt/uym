import { Component } from '@angular/core';
import { RouterLinks } from '../router-links/router-links';

@Component({
	selector: 'app-header',
	imports: [
		RouterLinks
	],
	templateUrl: './header.html',
	styleUrl: './header.css',
})
export class Header {

}
