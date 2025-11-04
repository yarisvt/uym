import { Component, input } from '@angular/core';
import { User } from '../../../../api';

@Component({
	selector: 'app-about',
	imports: [],
	templateUrl: './about.html',
	styleUrl: './about.css',
})
export class About {


	readonly user = input.required<User>()
}
