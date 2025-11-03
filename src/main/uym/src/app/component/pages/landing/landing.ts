import { Component, OnInit } from '@angular/core';
import { Footer } from '../../dialogs/footer/footer';
import { Wattpad } from '../wattpad/wattpad';
import { Home } from '../home/home';
import { Books } from '../books/books';
import { ActivatedRoute } from '@angular/router';
import { Header } from '../../dialogs/header/header';
import { About } from '../about/about';

@Component({
	selector: 'app-landing',
	imports: [
		Footer,
		Wattpad,
		Home,
		Books,
		Header,
		About
	],
	templateUrl: './landing.html',
	styleUrl: './landing.css',
})
export class Landing implements OnInit {

	constructor(private activatedRoute : ActivatedRoute) {
	}

	ngOnInit() {
		this.activatedRoute.fragment.subscribe((fragment : string | null) => {
			if (fragment) this.jumpToSection(fragment);
		});
	}

	jumpToSection(section : string | null) {
		if (section) document.getElementById(section)?.scrollIntoView({ behavior: 'smooth' });
	}

}
