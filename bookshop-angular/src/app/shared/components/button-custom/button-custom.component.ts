import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-button-custom',
  templateUrl: './button-custom.component.html',
  styleUrls: ['./button-custom.component.css']
})
export class ButtonCustomComponent {
  @Input() text: string = '';
  @Input() disabled: boolean = false;
  @Input() padding: string = '15px 32px';
  @Output() click: EventEmitter<void> = new EventEmitter<void>();

  onClick(): void {
    this.click.emit;
  }
}
