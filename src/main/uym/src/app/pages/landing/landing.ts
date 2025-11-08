import { Component, OnInit } from '@angular/core';
import { Home } from '../home/home';
import { Books } from '../books/books';
import { ActivatedRoute } from '@angular/router';
import { About } from '../about/about';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { Story, User, WattpadControllerService } from '../../../api';
import { Footer } from './components/footer/footer';
import { Stories } from '../stories/stories';
import { Header } from './components/header/header';

@Component({
	selector: 'app-landing',
	imports: [
		Footer,
		Stories,
		Home,
		Books,
		Header,
		About,
		AsyncPipe
	],
	templateUrl: './landing.html',
	styleUrl: './landing.css',
})
export class Landing implements OnInit {

	stories ? : Observable<Story[]>
	user ? : Observable<User>

	constructor(private activatedRoute : ActivatedRoute, private wattpadController : WattpadControllerService) {
	}

	ngOnInit() {
		this.activatedRoute.fragment.subscribe((fragment : string | null) => {
			if (fragment) this.jumpToSection(fragment);
		});
		this.stories = this.wattpadController.getStories();
		this.user = this.wattpadController.getUser();
	}

	jumpToSection(section : string | null) {
		if (section) document.getElementById(section)?.scrollIntoView({ behavior: 'smooth' });
	}

}
