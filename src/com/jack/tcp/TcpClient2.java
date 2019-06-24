package com.jack.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端2启动.........");
		//实现客户端和服务端收发过程，创建客户端对象
		Socket s=new Socket("192.168.2.155", 1004);
		OutputStream out=s.getOutputStream();
		out.write("服务端我来了".getBytes());
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		String text=new String(buf,0,len);
		System.out.println(text);
		s.close();
	}

}
