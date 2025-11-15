import { Component, input } from '@angular/core';
import { TranslatePipe } from '@ngx-translate/core';
import { Story, User } from '../../../api';
import { StoryCard } from './components/story-card/story-card';

@Component({
	selector: 'app-stories',
	imports: [
		StoryCard,
		TranslatePipe,
	],
	templateUrl: './stories.html',
	styleUrl: './stories.css',
})
export class Stories {

	readonly stories = input<Story[] | null>()
	readonly user = input<User | null>()

}
