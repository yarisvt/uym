import { Component, inject, OnInit } from '@angular/core';
import { Story, WattpadControllerService } from '../../../../api';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { StoryComponent } from '../../dialogs/story/story.component';

@Component({
	selector: 'app-wattpad',
	imports: [
		AsyncPipe,
		StoryComponent
	],
	templateUrl: './wattpad.component.html',
	styleUrl: './wattpad.component.css',
})
export class WattpadComponent implements OnInit {

	private wattpadController = inject(WattpadControllerService)

	stories ? : Observable<Story[]>

	ngOnInit() : void {
		this.stories = this.wattpadController.getStories()
	}


}
