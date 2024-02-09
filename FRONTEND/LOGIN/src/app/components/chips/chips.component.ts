import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {Component, Input, inject} from '@angular/core';
import {MatChipEditedEvent, MatChipInputEvent, MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldAppearance, MatFormFieldModule} from '@angular/material/form-field';
import {LiveAnnouncer} from '@angular/cdk/a11y';

export interface Elements {
  name: string;
}

@Component({
  selector: 'app-chips',
  standalone: true,
  imports: [MatFormFieldModule, MatChipsModule, MatIconModule],
  templateUrl: './chips.component.html',
  styleUrl: './chips.component.scss'
})
export class ChipsComponent {
  addOnBlur = true;
  readonly separatorKeysCodes = [ENTER, COMMA] as const;
  elements: Elements[] = [];
  @Input() appearance: MatFormFieldAppearance = 'fill' as MatFormFieldAppearance;

  announcer = inject(LiveAnnouncer);

  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();

    if (value) {
      this.elements.push({name: value});
    }

    event.chipInput!.clear();
  }

  remove(fruit: Elements): void {
    const index = this.elements.indexOf(fruit);

    if (index >= 0) {
      this.elements.splice(index, 1);

      this.announcer.announce(`Removed ${fruit}`);
    }
  }

  edit(fruit: Elements, event: MatChipEditedEvent) {
    const value = event.value.trim();


    if (!value) {
      this.remove(fruit);
      return;
    }

    const index = this.elements.indexOf(fruit);
    if (index >= 0) {
      this.elements[index].name = value;
    }
  }
}
