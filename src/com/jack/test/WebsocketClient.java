package com.jack.test;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
 
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
 
/**
 * Created by jack on 2017/10/25.
 */
public class WebsocketClient {
    public static WebSocketClient client;
    public static void main(String[] args) {
        try {
            client = new WebSocketClient(new URI("ws://localhost:9090/websocket"),new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("������");
                }
 
                @Override
                public void onMessage(String s) {
                    System.out.println("�յ���Ϣ"+s);
                }
 
                @Override
                public void onClose(int i, String s, boolean b) {
                    System.out.println("�����ѹر�");
                }
 
                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    System.out.println("���������ѹر�");
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
 
        client.connect();
        System.out.println(client.getDraft());
       while(!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
            System.out.println("��û�д�");
        }
        System.out.println("����");
        try {
            send("hello world".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        client.send("hello world I am webSocketClient");
        client.close();
    }
 
 
    public static void send(byte[] bytes){
        client.send(bytes);
    }
 
}