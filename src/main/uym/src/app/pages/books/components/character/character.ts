import { Component, input } from '@angular/core';
import { TranslatePipe } from '@ngx-translate/core';

@Component({
	selector: 'app-character',
	imports: [
		TranslatePipe
	],
	templateUrl: './character.html',
	styleUrl: './character.css',
})
export class Character {

	readonly imagePath = input.required<string>()
	readonly name = input.required<string>()

}
