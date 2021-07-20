package com.koreait.shoppingmall.android.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	
	ServerSocket server;
	Thread serverThread;
	Vector<ServerMessageThread> clientList;
	
	public ChatServer() {
		//생성
		p_north = new JPanel();
		t_port = new JTextField("7777",10);
		bt = new JButton("Server On");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		clientList = new Vector<ServerMessageThread>();
		
		//스타일
		
		//조립
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		
		
		serverThread = new Thread() {
			@Override
			public void run() {
				startServer();
			}
		};
		//이벤트 연결
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				serverThread.start();
			}
		}); 
		
		
		//보여주기
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void startServer(){
		int port = Integer.parseInt(t_port.getText());
		try {
			server = new ServerSocket(port);
			area.append("서버 가동...\n");
			
			while(true) {
				Socket socket = server.accept();//접속자 감지를 위한 대기
				ServerMessageThread smt = new ServerMessageThread(this,socket);//메시지 전용 객체 생성
				smt.start();
				clientList.add(smt);//접속자 명단에 추가
				area.append("현재까지 접속자 수 : "+clientList.size()+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
