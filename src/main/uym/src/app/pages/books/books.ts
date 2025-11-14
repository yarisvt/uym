import { Component } from '@angular/core';
import { Character } from './components/character/character';
import { TranslatePipe } from '@ngx-translate/core';

@Component({
	selector: 'app-books',
	imports: [
		Character,
		TranslatePipe
	],
	templateUrl: './books.html',
	styleUrl: './books.css',
})
export class Books {

}
