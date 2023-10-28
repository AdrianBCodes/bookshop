import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-sidebar-item',
  templateUrl: './sidebar-item.component.html',
  styleUrls: ['./sidebar-item.component.css']
})
export class SidebarItemComponent {
  @Input() title: String = ''
  @Input() content : Map<String, Number> = new Map();

  contentToArray(){
    return Array.from(this.content.entries());
  }
}
