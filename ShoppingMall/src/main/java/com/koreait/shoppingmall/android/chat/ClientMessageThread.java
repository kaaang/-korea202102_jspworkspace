package com.koreait.shoppingmall.android.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//말하는 타이밍은 사용자가 결정하지만, 듣는 타이밍은 실시간으로 루프를 이용해서 청취해야 하므로, 무한 루프가 필요하다
//따라서 별도의 스레드를 정의하여 듣기를 처리하자
public class ClientMessageThread extends Thread{
	ChatClient chatClient;
	Socket socket;
	BufferedReader buffr;//듣기용
	BufferedWriter buffw;//말하기용
	
	
	
	public ClientMessageThread(ChatClient chatClient,Socket socket) {
		this.chatClient=chatClient;
		this.socket=socket;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//듣기
	public void listen() {
		while(true) {
			String msg = null;
			try {
				msg=buffr.readLine();
				chatClient.area.append(msg+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//말하기
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		while(true) {
			listen();
		}
	}
	
}
