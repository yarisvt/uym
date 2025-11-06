import { Component, input } from '@angular/core';
import { Story, User } from '../../../../api';
import { StoryCard } from '../../dialogs/story/story-card';

@Component({
	selector: 'app-stories',
	imports: [
		StoryCard,
	],
	templateUrl: './stories.html',
	styleUrl: './stories.css',
})
export class Stories {

	readonly stories = input.required<Story[]>()
	readonly user = input.required<User>()

}
