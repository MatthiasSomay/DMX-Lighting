import { Component, OnInit } from '@angular/core';
import { ScenesService } from '../list-saved-scenes/scenes.service';

@Component({
  selector: 'app-record',
  template: `

  <button mat-flat-button color="warn" (click)="record()" [disabled]="!recordingDone">Record</button>
  <button mat-flat-button color="primary" (click)="stop()">Stop</button>

  `,
  styles: []
})
export class RecordComponent implements OnInit {

  recordingDone: boolean;

  constructor(private sceneService: ScenesService) { }

  ngOnInit(): void {
    this.recordingDone = true;
  }

  record() {
    this.sceneService.record(0).subscribe(data => data = this.recordingDone);
  }

  stop() {

  }

}
