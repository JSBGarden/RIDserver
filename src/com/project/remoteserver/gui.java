package com.project.remoteserver;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Robot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import com.project.remoteprotocol.global.Events;

//import com.project.remoteprotocol.global.Eve
//import com.project.remoteserver.ServerConsole.ClientDealer;

public class gui extends JFrame {
	int okpass;
	
	private String port,pass;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				class ServerConsole    
				{

					Robot robot=null;
					InputEvents inpuItEvents=null;
					public void main(String[] args) throws IOException 
					{
						    
						try{
							robot= new Robot();
							inpuItEvents=new InputEvents(robot);


						ServerSocket listener= new ServerSocket(8081);
						//listener.setSoTimeout(10000);
						InetAddress IP=InetAddress.getLocalHost();
						System.out.println("Server IP Address="+(IP.getHostAddress()));
						System.out.println("WATING FOR CLIENT ");

						try{
							while(true){
								new ClientDealer(listener.accept()).start();				
							}

						}
						finally{
							listener.close();
						}
					}		
						catch(Exception e){}
						
					}

					class ClientDealer extends Thread {
						private Socket socket;

						public ClientDealer(Socket socket){
							this.socket=socket;			 
						}			


						public void run() {
							try{
								System.out.println("client found");
								BufferedReader in =new BufferedReader(
										new InputStreamReader(socket.getInputStream()));
								System.out.println("start");
								while (true){
									String input=in.readLine();
									System.out.println(input);
									if (input == null ) {
										break;
									}
									String data[]=input.split(",");
									int key1=Integer.parseInt(data[1]);
									
									switch (Integer.parseInt(data[0]))
									{
									
									case Events.SINGLE_BUTTON_PRESS:					
										try{
										inpuItEvents.keyClick(key1);
										}catch(Exception e){e.printStackTrace();}
										break;
									case Events.MOUSE_MOVE:						
										int mouse_x = key1;
										int mouse_y = Integer.parseInt(data[2]);												
											inpuItEvents.mouseMove(mouse_x,mouse_y);						
										break;
									case Events.MOUSE_CLICK:						
										inpuItEvents.mouseClick(key1);
										break;
									case Events.BUTTON_PRESS:
										inpuItEvents.keyPress(key1);
										break;
										
									case Events.BUTTON_RELEASE:
										inpuItEvents.keyRelease(key1);
										break;
										
									case Events.MOUSE_BUTTON_DOWN:
										inpuItEvents.mouseButtonDown(key1);
										break;
										
									case Events.MOUSE_BUTTON_UP:
										inpuItEvents.mouseButtonUp(key1);
										break;
									
									case Events.COMBINATION_BUTTON_PRESS:
										int key2=Integer.parseInt(data[2]);
										inpuItEvents.keyClick(key1,key2);
										break;
									case Events.KEYBORD_KEY_DOWN:
										inpuItEvents.keybordButton(key1);
										break;
									};
											
									
									

								}
							} catch(Exception e){

							} finally{
								try {
									
									socket.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}


			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnSetting = new JMenu("Setting");
		menuBar.add(mnSetting);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			//	 pass=JOptionPane.showInputDialog("please enter new password");
			JPasswordField jp=new JPasswordField();
			okpass=JOptionPane.showConfirmDialog(null, jp, "please enter", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			if (okpass==JOptionPane.OK_OPTION)
			{
				String pass1=new String(jp.getPassword());
				//pass=jp.getPassword().toString();
				JOptionPane.showMessageDialog(null, pass1);
			}
			
			}
		});
		mnSetting.add(mntmChangePassword);
		
		JMenuItem mntmChangePort = new JMenuItem("Change Port");
		mntmChangePort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				port=JOptionPane.showInputDialog("please enter new port");
			}
		});
		mnSetting.add(mntmChangePort);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mnHelp.add(mntmAboutUs);
		
		JMenuItem mntmUserGuide = new JMenuItem("User Guide");
		mnHelp.add(mntmUserGuide);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addComponent(lblNewLabel)
					.addContainerGap(296, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addComponent(lblNewLabel)
					.addContainerGap(155, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
