import { InjectableRxStompConfig } from '@stomp/ng2-stompjs';

export const appRxStompConfig: InjectableRxStompConfig = {

  brokerURL: 'ws://192.168.0.197:8080/stomp/websocket',

  heartbeatIncoming: 0,
  heartbeatOutgoing: 20000,
  reconnectDelay: 5000,

  debug: (msg: string): void => {
    console.log(new Date().toLocaleString('nl'), msg);
  }
}

