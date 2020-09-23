

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UserEditComponent } from './user-edit/user-edit.component';


@NgModule({
    declarations: [
        AppComponent,
        UserListComponent,
        UserEditComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        BrowserAnimationsModule,
        MatButtonModule,
        MatCardModule,
        MatInputModule,
        MatListModule,
        MatToolbarModule,
        FormsModule,
        ReactiveFormsModule,
        MatAutocompleteModule


    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
