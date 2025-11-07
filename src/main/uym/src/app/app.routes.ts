import { Routes } from '@angular/router';

export const routes : Routes = [
	{ path: '', pathMatch: 'full', loadComponent: () => import('./component/pages/landing/landing').then(m => m.Landing) },
];
