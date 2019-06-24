package com.jack.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpService {
	public static void main(String[] args) throws IOException {
		System.out.println("·þÎñ¶Ë¿ªÆô£¡");
		ServerSocket sc=new ServerSocket(10003);
		while(true) {
		Socket s=sc.accept();
		String ip=sc.getInetAddress().getHostAddress();
		System.out.println(ip+".......is connecting!");
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int length=in.read(buf);
		String text=new String(buf, 0,length);
		System.out.println(text);
		s.close();
		}
		//sc.close();
	}

}
