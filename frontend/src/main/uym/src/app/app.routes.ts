import { Routes } from '@angular/router';

export const routes : Routes = [
	{ path: '', redirectTo: 'home', pathMatch: 'full' },
	{ path: 'home', loadComponent: () => import('./component/pages/wattpad/wattpad.component').then(m => m.WattpadComponent) }

];
