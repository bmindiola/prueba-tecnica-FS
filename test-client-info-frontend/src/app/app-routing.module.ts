import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientFormComponent } from './components/client-form/client-form.component';
import { ClientResumeComponent } from './components/client-resume/client-resume.component';

const routes: Routes = [
  { path: '', component: ClientFormComponent },
  { path: 'resume', component: ClientResumeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
