import { Routes } from '@angular/router';

export const routes : Routes = [
	{ path: '', redirectTo: 'home', pathMatch: 'full' },
	{ path: 'home', loadComponent: () => import('./component/pages/landing/landing').then(m => m.Landing) },
];
