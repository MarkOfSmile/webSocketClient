package com.jack.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ͻ���2����.........");
		//ʵ�ֿͻ��˺ͷ�����շ����̣������ͻ��˶���
		Socket s=new Socket("192.168.2.155", 1004);
		OutputStream out=s.getOutputStream();
		out.write("�����������".getBytes());
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		String text=new String(buf,0,len);
		System.out.println(text);
		s.close();
	}

}
