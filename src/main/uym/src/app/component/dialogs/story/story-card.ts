import { Component, input } from '@angular/core';
import { Story } from '../../../../api';
import { Tooltip } from 'primeng/tooltip';
import { Skeleton } from 'primeng/skeleton';

@Component({
	selector: 'app-story',
	imports: [
		Tooltip,
		Skeleton,
	],
	templateUrl: './story-card.html',
	styleUrl: './story-card.css',
})
export class StoryCard {

	readonly story = input<Story>()

}
