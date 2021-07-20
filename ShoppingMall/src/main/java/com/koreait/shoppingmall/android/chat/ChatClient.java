package com.koreait.shoppingmall.android.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	JPanel p_north;
	JTextField t_ip, t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	Socket socket;//대화용 소켓
	ClientMessageThread cmt;
	
	public ChatClient() {
		p_north = new JPanel();
		t_ip = new JTextField("220.72.128.42",13);
		t_port = new JTextField("7777",5);
		bt = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField();
		
		
		area.setBackground(Color.YELLOW);
		
		p_north.add(t_ip);
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		add(t_input,BorderLayout.SOUTH);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//엔터를 치면 서버에 메시지 보내기
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					cmt.send(t_input.getText());
					t_input.setText("");
				}
			}
		});
		
		
		setSize(350,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	//채팅 서버에 접속하기
	public void connect() {
		String ip = t_ip.getText();
		int port = Integer.parseInt(t_port.getText());
		
		try {
			socket = new Socket(ip,port);
			area.append("서버에 접속\n");
			//이 타이밍에 대화용 쓰레드 생성하여 가동!
			cmt = new ClientMessageThread(this, socket);
			cmt.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}

}
