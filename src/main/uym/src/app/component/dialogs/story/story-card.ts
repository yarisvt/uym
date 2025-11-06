import { Component, input } from '@angular/core';
import { Story } from '../../../../api';
import { Tooltip } from 'primeng/tooltip';

@Component({
	selector: 'app-story',
	imports: [
		Tooltip,
	],
	templateUrl: './story-card.html',
	styleUrl: './story-card.css',
})
export class StoryCard {

	readonly story = input.required<Story>()

}
