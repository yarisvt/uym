import { ApplicationConfig, importProvidersFrom, provideBrowserGlobalErrorListeners, provideZonelessChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { providePrimeNG } from 'primeng/config';
import Aura from '@primeuix/themes/aura';
import { provideAnimations } from '@angular/platform-browser/animations';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { ApiModule, Configuration, ConfigurationParameters } from '../api';
import { environment } from '../environments/environment';
import { provideTranslateService } from '@ngx-translate/core';
import { provideTranslateHttpLoader } from '@ngx-translate/http-loader';


function apiConfigFactory() : Configuration {
	const params : ConfigurationParameters = {
		basePath: environment.base_url,
		// set configuration parameters here.
	}
	return new Configuration(params);
}


export const appConfig : ApplicationConfig = {
	providers: [
		importProvidersFrom(ApiModule.forRoot(apiConfigFactory)),
		provideBrowserGlobalErrorListeners(),
		provideZonelessChangeDetection(),
		provideHttpClient(withInterceptorsFromDi()),
		provideRouter(routes),
		provideTranslateService({
			loader: provideTranslateHttpLoader({
				prefix: '/assets/i18n/',
				suffix: '.json'
			}),
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
