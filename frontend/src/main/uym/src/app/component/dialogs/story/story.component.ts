import { Component, input } from '@angular/core';
import { Story } from '../../../../api';
import { Tooltip } from 'primeng/tooltip';

@Component({
	selector: 'app-story',
	imports: [
		Tooltip
	],
	templateUrl: './story.component.html',
	styleUrl: './story.component.css',
})
export class StoryComponent {

	readonly story = input.required<Story>()

}
