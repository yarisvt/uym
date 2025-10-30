import { Component, inject, OnInit } from '@angular/core';
import { Story, WattpadControllerService } from '../../../../api';
import { Observable, tap } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { StoryComponent } from '../../dialogs/story/story.component';

@Component({
  selector: 'app-wattpad',
  imports: [
    AsyncPipe,
    StoryComponent,
  ],
  templateUrl: './wattpad.component.html',
  styleUrl: './wattpad.component.css',
})
export class WattpadComponent implements OnInit {

  private wattpadController = inject(WattpadControllerService)

  stories ?: Observable<Story[]>
  loading = true

  ngOnInit(): void {
    this.stories = this.wattpadController.getStories().pipe(tap(_ => this.loading = false))
  }

  numSequence(n: number): Array<number> {
    return Array(n);
  }

}
