import { Component, OnInit } from '@angular/core';
import { Formateur } from './Formateur';
import { FormateurService } from './Formateur.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  public Formateur: Formateur[];
  public editFormateur: Formateur;
  public deleteFormateur: Formateur;

  constructor(private FormateurService: FormateurService){}

  ngOnInit() {
    this.getFormateur();
  }

  public getFormateur(): void {
    this.FormateurService.getFormateur().subscribe(

      (response: Formateur[]) => {
this.Formateur = response;
        console.log(this.Formateur);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }

    );
  }

  public onAddFormateur(addForm: NgForm): void {
    document.getElementById('add-Formateur-form').click();
    this.FormateurService.addFormateur(addForm.value).subscribe(
      (response: Formateur) => {
        console.log(response);
        this.getFormateur();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateFormateur(formateur: Formateur): void {
    this.FormateurService.updateFormateur(formateur).subscribe(
      (response: Formateur) => {
        console.log(response);
        this.getFormateur();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteFormateur(formateurId: number): void {
    this.FormateurService.deleteFormateur(formateurId).subscribe(
      (response: void) => {
        console.log(response);
        this.getFormateur();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchFormateurs(key: string): void {
    console.log(key);
    const results: Formateur[] = [];
    for (const formateur of this.Formateur) {
      if (formateur.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || formateur.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || formateur.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || formateur.classe.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(formateur);
      }
    }
    this.Formateur = results;
    if (results.length === 0 || !key) {
      this.getFormateur();
    }
  }

  public onOpenModal(formateur: Formateur, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addFormateurModal');
    }
    if (mode === 'edit') {
      this.editFormateur = formateur;
      button.setAttribute('data-target', '#updateFormateurModal');
    }
    if (mode === 'delete') {
      this.deleteFormateur = formateur;
      button.setAttribute('data-target', '#deleteFormateurModal');
    }
    container.appendChild(button);
    button.click();
  }



}
