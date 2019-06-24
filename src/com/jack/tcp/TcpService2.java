package com.jack.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpService2 {

	public static void main(String[] args) throws IOException {
		System.out.println("服务端2启动。。。。。");
		ServerSocket ss=new ServerSocket(1004);
		while(true) {
		Socket s=ss.accept();
		String ip=ss.getInetAddress().getHostAddress();
		System.out.println(ip+"......is connected");
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		String text=new String(buf, 0,len);
		System.out.println(text);
		OutputStream out=s.getOutputStream();
		out.write("客户端，我收到了".getBytes());
		s.close();
		}
	}

}
