/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.remoteserver;

import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.project.remoteprotocol.global.Events;

/**
 *
 * @author mintjunk
 */
public class RemoteServerGUI extends javax.swing.JFrame {

	private Preferences pref;
	int okpass;
	static Robot robot=null;
	static InputEvents inpuItEvents=null;
	int okport;

	private String port="",pass="";
	private JPanel contentPane;

	/**
	 * Creates new form remoteinputdroid
	 */
	public static int numberOfDevices;


	public RemoteServerGUI() {

		initComponents();
		numberOfDevices=0;



	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		lblip = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		lblnumberdevice = new javax.swing.JLabel();
		lblIpaddress = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		menuItemChangePort = new javax.swing.JMenuItem();
		menuItemChangePassword = new javax.swing.JMenuItem();
		menuItemShowPassword = new javax.swing.JMenuItem();
		menuItemShowPort = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		jLabel1.setText("The server IP:");

		jLabel2.setText("The number of devices connected are:");

		lblnumberdevice.setText("0");

		lblIpaddress.setText("please wait");

		jMenu1.setText("File");

		jMenuItem1.setText("Exit");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Setting");

		menuItemChangePort.setText("Change Port");
		menuItemChangePort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItemChangePortActionPerformed(evt);
			}
		});
		jMenu2.add(menuItemChangePort);

		menuItemChangePassword.setText("Change Password");
		menuItemChangePassword.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItemChangePasswordActionPerformed(evt);
			}
		});
		jMenu2.add(menuItemChangePassword);

		menuItemShowPassword.setText("Show Password");
		menuItemShowPassword.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItemShowPasswordActionPerformed(evt);
			}
		});
		jMenu2.add(menuItemShowPassword);

		menuItemShowPort.setText("Show Port");
		menuItemShowPort.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItemShowPortActionPerformed(evt);
			}
		});
		jMenu2.add(menuItemShowPort);

		jMenuBar1.add(jMenu2);

		jMenu3.setText("Help");

		jMenuItem4.setText("About Us");
		jMenu3.add(jMenuItem4);

		jMenuItem5.setText("user guide");
		jMenu3.add(jMenuItem5);

		jMenuBar1.add(jMenu3);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lblIpaddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(jLabel2))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGap(31, 31, 31)
														.addComponent(lblnumberdevice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(lblip, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addContainerGap(57, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(107, 107, 107)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(lblip)
								.addComponent(lblIpaddress))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(lblnumberdevice))
										.addContainerGap(122, Short.MAX_VALUE))
				);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
		System.exit(0);

		// TODO add your handling code here:
	}//GEN-LAST:event_jMenuItem1ActionPerformed

	private void menuItemChangePortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemChangePortActionPerformed
		String port1=JOptionPane.showInputDialog("Enter new Port:");
		pref.putInt("port", Integer.parseInt(port1));
		
		// TODO add your handling code here:
	}//GEN-LAST:event_menuItemChangePortActionPerformed

	private void menuItemChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemChangePasswordActionPerformed

		JPasswordField jp2=new JPasswordField();
		okpass=JOptionPane.showConfirmDialog(null,jp2,"Please enter New port number:",JOptionPane.PLAIN_MESSAGE);
		if(okport==JOptionPane.OK_OPTION)
		{
			String pass1=new String(jp2.getPassword());
			pref.put("pass",pass1);
		}
		// TODO add your handlig code here:
	}//GEN-LAST:event_menuItemChangePasswordActionPerformed

	private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		pref=Preferences.userRoot().node(this.getClass().getName());

		showIP();    
		new SocketThread(null).start();


	}//GEN-LAST:event_formWindowOpened

	private void menuItemShowPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemShowPortActionPerformed
		JOptionPane.showMessageDialog(null,"The current port is: "+(pref.getInt("port", 5555)));
		// TODO add your handling code here:
	}//GEN-LAST:event_menuItemShowPortActionPerformed

	private void menuItemShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemShowPasswordActionPerformed
		JOptionPane.showMessageDialog(null,"The current passis: "+(pref.get("pass", "a")));        // TODO add your handling code here:
	}//GEN-LAST:event_menuItemShowPasswordActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(RemoteServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(RemoteServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(RemoteServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(RemoteServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>


		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new RemoteServerGUI().setVisible(true);
			}
		});
	}







	private static class SocketThread extends Thread {
		private Socket socket;

		public SocketThread(Socket socket){

		}
		public void run() {

			try {
				robot = new Robot();
				inpuItEvents = new InputEvents(robot);

				ServerSocket listener = new ServerSocket(8081);		            		            
				try {
					while (true) {
						new ClientDealer(listener.accept()).start();
					}
				} finally {
					listener.close();
				}
			} catch (Exception e) {
			}

		}
	}


	private static class ClientDealer extends Thread {
		private Socket socket;

		public ClientDealer(Socket socket){
			this.socket=socket;			 
		}			


		public void run() {
			try{
				RemoteServerGUI.numberOfDevices++;
				RemoteServerGUI r = new RemoteServerGUI();
				r.updateClients();

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
					RemoteServerGUI.numberOfDevices--;
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	//function to display number of clients connected
	public void updateClients(){
		lblnumberdevice.setText(RemoteServerGUI.numberOfDevices+"");
	}


	//function to display ip address of the server    
	private void showIP(){
		String ip;
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface iface = interfaces.nextElement();
				// filters out 127.0.0.1 and inactive interfaces
				if (iface.isLoopback() || !iface.isUp())
					continue;

				Enumeration<InetAddress> addresses = iface.getInetAddresses();
				while(addresses.hasMoreElements()) {
					InetAddress addr = addresses.nextElement();
					ip = addr.getHostAddress();
					lblIpaddress.setText(ip);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JLabel lblIpaddress;
	private javax.swing.JLabel lblip;
	private javax.swing.JLabel lblnumberdevice;
	private javax.swing.JMenuItem menuItemChangePassword;
	private javax.swing.JMenuItem menuItemChangePort;
	private javax.swing.JMenuItem menuItemShowPassword;
	private javax.swing.JMenuItem menuItemShowPort;
	// End of variables declaration//GEN-END:variables
}
