import {Component, Input, OnInit} from '@angular/core';
import { ScenesService } from '../scene/scenes.service';

@Component({
  selector: 'app-simulator',
  template: `<h1 class="title">Simulator</h1>
<div class="buttons">
  <div>
    <div class="button-row">
      <app-simulator-control [record]="record" [sceneId]="1" [playable]="playable1"></app-simulator-control>
      <app-simulator-control [record]="record" [sceneId]="2" [playable]="playable2"></app-simulator-control>
      <app-simulator-control [record]="record" [sceneId]="3" [playable]="playable3"></app-simulator-control>
    </div>
    <div class="button-row">
      <app-simulator-control [record]="record" [sceneId]="4" [playable]="playable4"></app-simulator-control>
      <app-simulator-control [record]="record" [sceneId]="5" [playable]="playable5"></app-simulator-control>
      <app-simulator-control [record]="record" [sceneId]="6" [playable]="playable6"></app-simulator-control>
    </div>
    <div class="button-row">
      <app-simulator-control [record]="record" [sceneId]="7" [playable]="playable7"></app-simulator-control>
      <app-simulator-control [record]="record" [sceneId]="8" [playable]="playable8"></app-simulator-control>
      <app-simulator-control [record]="record" [sceneId]="9" [playable]="playable9"></app-simulator-control>
    </div>
  </div>
  <div class="record">
    <mat-slide-toggle [checked]="record" (change)="toggleRecord()">Record mode</mat-slide-toggle>
  </div>
</div>
`,
  styleUrls: [ './simulator.component.css' ]
})
export class SimulatorComponent implements OnInit{

  playableButtons: boolean[];
  recordedButtons: boolean[];

  record: boolean = false;

  playable1: string = 'gray';
  playable2: string = 'gray';
  playable3: string = 'gray';
  playable4: string = 'gray';
  playable5: string = 'gray';
  playable6: string = 'gray';
  playable7: string = 'gray';
  playable8: string = 'gray';
  playable9: string = 'gray';

  playColor: string;

  constructor(private sceneService: ScenesService) {
  }

  toggleRecord() {
    this.record = !this.record;
    this.fillInColors();
  }

  ngOnInit(): void {
    this.sceneService.getButtons().subscribe(data => {

      this.recordedButtons = data;

      this.playableButtons = this.inverted(this.recordedButtons);
      console.log(this.playableButtons);
      this.fillInColors();





    });
  }

  inverted(bools: boolean[]): boolean[] {
    return bools.map(function (bool) {
      return !bool;
    })
  }

  fillInColors() {

    if (!this.record) {
      this.playColor = 'green';
    } else {
      this.playColor = 'red';
    }

    if (this.playableButtons[0]) {
      this.playable1 = this.playColor;
    }
    if (this.playableButtons[1]) {
      this.playable2 = this.playColor;
    }
    if (this.playableButtons[2]) {
      this.playable3 = this.playColor;
    }
    if (this.playableButtons[3]) {
      this.playable4 = this.playColor;
    }
    if (this.playableButtons[4]) {
      this.playable5 = this.playColor;
    }
    if (this.playableButtons[5]) {
      this.playable6 = this.playColor;
    }
    if (this.playableButtons[6]) {
      this.playable7 = this.playColor;
    }
    if (this.playableButtons[7]) {
      this.playable8 = this.playColor;
    }
    if (this.playableButtons[8]) {
      this.playable9 = this.playColor;
    }
  }

}
