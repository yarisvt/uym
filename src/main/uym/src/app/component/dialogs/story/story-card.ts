import { Component, input } from '@angular/core';
import { Story } from '../../../../api';
import { Tooltip } from 'primeng/tooltip';
import { TranslatePipe } from '@ngx-translate/core';

@Component({
	selector: 'app-story',
	imports: [
		Tooltip,
		TranslatePipe,
	],
	templateUrl: './story-card.html',
	styleUrl: './story-card.css',
})
export class StoryCard {

	readonly story = input.required<Story>()

}
