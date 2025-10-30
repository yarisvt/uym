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
	templateUrl: './story.component.html',
	styleUrl: './story.component.css',
})
export class StoryComponent {

	readonly story = input<Story>()

}
