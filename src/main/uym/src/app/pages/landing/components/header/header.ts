import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { TranslatePipe, TranslateService } from '@ngx-translate/core';
import { FormsModule } from '@angular/forms';
import { Tooltip } from 'primeng/tooltip';

@Component({
	selector: 'app-header',
	imports: [
		RouterLink,
		TranslatePipe,
		FormsModule,
		Tooltip
	],
	templateUrl: './header.html',
	styleUrl: './header.css',
})
export class Header {

	translate = inject(TranslateService)

	languages : Language[] = [
		{ key: 1, name: 'English', code: 'en', flag: '🇬🇧' },
		{ key: 2, name: 'Nederlands', code: 'nl', flag: '🇳🇱' }
	]
	selectedLanguage = this.getSelectedLanguage()

	switchLanguage(_ : Event, language : Language) {
		this.translate.use(language.code)
		localStorage.setItem('language', language.code);
	}

	getSelectedLanguage() : Language {
		const languageCode = localStorage.getItem("language");
		if (languageCode == null) {
			return this.languages[0]
		}
		return this.languages.find(l => l.code === languageCode) || this.languages[0]
	}

}

interface Language {
	key : number,
	name : string
	code : string,
	flag : string
}
