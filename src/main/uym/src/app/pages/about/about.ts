import { Component, input } from '@angular/core';
import { TranslatePipe } from '@ngx-translate/core';
import { User } from '../../../api';

@Component({
	selector: 'app-about',
	imports: [
		TranslatePipe
	],
	templateUrl: './about.html',
	styleUrl: './about.css',
})
export class About {


	readonly user = input.required<User>()
}
