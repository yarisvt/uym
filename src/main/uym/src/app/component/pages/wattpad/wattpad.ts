import { Component, input } from '@angular/core';
import { Story } from '../../../../api';
import { StoryCard } from '../../dialogs/story/story-card';

@Component({
	selector: 'app-wattpad',
	imports: [
		StoryCard,
	],
	templateUrl: './wattpad.html',
	styleUrl: './wattpad.css',
})
export class Wattpad {

	readonly stories = input.required<Story[]>()

}
