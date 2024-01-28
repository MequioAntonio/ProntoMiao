import { Component, Inject } from '@angular/core';
import {
  MatDialog,
  MatDialogRef,
  MatDialogActions,
  MatDialogClose,
  MatDialogTitle,
  MatDialogContent,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { Annuncio } from '../../model/Annuncio';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-richiesta-confirm',
  standalone: true,
  imports: [MatButtonModule, MatDialogActions, MatDialogClose, MatDialogTitle, MatDialogContent],
  templateUrl: './richiesta-confirm.component.html',
  styleUrl: './richiesta-confirm.component.scss'
})
export class RichiestaConfirmComponent {
  constructor(public dialogRef: MatDialogRef<RichiestaConfirmComponent>,@Inject(MAT_DIALOG_DATA) public annuncio: Annuncio) {}

  closeDialog(result: string){
    this.dialogRef.close(result)
  }
}
