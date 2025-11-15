import { ApplicationConfig, importProvidersFrom, Injectable, provideBrowserGlobalErrorListeners, provideZonelessChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { providePrimeNG } from 'primeng/config';
import Aura from '@primeuix/themes/aura';
import { provideAnimations } from '@angular/platform-browser/animations';
import { HttpClient, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { ApiModule, Configuration, ConfigurationParameters } from '../api';
import { environment } from '../environments/environment';
import { provideTranslateLoader, provideTranslateService, TranslateLoader, TranslationObject } from '@ngx-translate/core';
import { parse } from 'yaml';
import { map, Observable } from 'rxjs';

function apiConfigFactory() : Configuration {
	const params : ConfigurationParameters = {
		basePath: environment.base_url,
		// set configuration parameters here.
	}
	return new Configuration(params);
}

@Injectable()
class TranslateYamlHttpLoader implements TranslateLoader {
	private path : string = '/public/i18n/'

	constructor(
		private http : HttpClient,
	) { }


	public getTranslation(lang : string) : Observable<TranslationObject> {
		return this.http
			.get(`${this.path}${lang}.yaml`, { responseType: 'text' })
			.pipe(map((data) => {
				const a = parse(data);
				return a;
			}));
	}
}


export const appConfig : ApplicationConfig = {
	providers: [
		importProvidersFrom(ApiModule.forRoot(apiConfigFactory)),
		provideBrowserGlobalErrorListeners(),
		provideZonelessChangeDetection(),
		provideHttpClient(withInterceptorsFromDi()),
		provideRouter(routes),
		provideTranslateService({
			loader: provideTranslateLoader(TranslateYamlHttpLoader),
			fallbackLang: 'en',
			lang: localStorage.getItem("language") || 'en',
		}),
		provideAnimations(),
		providePrimeNG({
			theme: {
				preset: Aura,
				options: {
					darkModeSelector: false
				}
			}
		})
	]
};
