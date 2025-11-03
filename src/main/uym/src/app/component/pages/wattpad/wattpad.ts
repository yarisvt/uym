import { Component, inject, OnInit } from '@angular/core';
import { Story, WattpadControllerService } from '../../../../api';
import { Observable, tap } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { StoryCard } from '../../dialogs/story/story-card';

@Component({
	selector: 'app-wattpad',
	imports: [
		AsyncPipe,
		StoryCard,
	],
	templateUrl: './wattpad.html',
	styleUrl: './wattpad.css',
})
export class Wattpad implements OnInit {

	private wattpadController = inject(WattpadControllerService)

	stories ? : Observable<Story[]>
	loading = true

	ngOnInit() : void {
		this.stories = this.wattpadController.getStories().pipe(tap(_ => this.loading = false))
	}

	numSequence(n : number) : Array<number> {
		return Array(n);
	}

}
