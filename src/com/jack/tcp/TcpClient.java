package com.jack.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
 public static void main(String[] args) throws UnknownHostException, IOException {
	System.out.println("客户端运行");
	Socket socket=new Socket("192.168.2.155", 10003);
	OutputStream  outputStream=socket.getOutputStream();
	outputStream.write("hello tcp is coming ".getBytes());
	socket.close();
}
}
