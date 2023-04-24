import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormateurService } from './Formateur.service';
import { HttpClientModule } from '@angular/common/http';import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    HttpClientModule, FormsModule, BrowserAnimationsModule
  ],
  providers: [FormateurService],
  bootstrap: [AppComponent],
})
export class AppModule { }
