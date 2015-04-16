package com.project.remoteserver;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.project.remoteprotocol.global.Buttons;

public class InputEvents {
	public Robot robot;
	private static Boolean isShiftPress=false;

	//consturctor
	public InputEvents(Robot robot) {
		this.robot=robot;
	}


	public void keyPress(int key1){
		try {     
			Robot robot = new Robot();
			robot.keyPress(key1);			
		}
		catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void keyRelease(int key1){
		try {     
			Robot robot = new Robot();
			robot.keyRelease(key1);			
		}
		catch (AWTException e) {
			e.printStackTrace();
		}
	}
	//if single key is clicked
	public void keyClick(int key1){
		try {     
			Robot robot = new Robot();
			robot.keyPress(key1);
			robot.keyRelease(key1);
		}
		catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// if two key are to be clicked as once
	public void keyClick(int key1,int key2){
		try {
			Robot robot = new Robot();
			robot.keyPress(key1);
			robot.keyPress(key2);
			robot.keyRelease(key2);
			robot.keyRelease(key1);
		}
		catch (AWTException e) {
			e.printStackTrace();
		}
	}
	public void mouseMove(int x, int y)	  {
		PointerInfo mousePointInfo = MouseInfo.getPointerInfo();
		Point mousePosition = mousePointInfo.getLocation();
		int x_old = (int) mousePosition.getX();
		int y_old = (int) mousePosition.getY();
		robot.mouseMove(x+x_old, y+y_old); 	
	}
	
	public void mouseClick(int mouse_button)	  {
		robot.mousePress(mouse_button);
		robot.mouseRelease(mouse_button);		
	}

	public void mouseButtonDown(int mouse_button)	  {
		robot.mousePress(mouse_button);				
	}
	public void mouseButtonUp(int mouse_button)	  {
		robot.mouseRelease(mouse_button);				
	}


	public void keybordButton(int key1) {
		try{
		switch (key1)
		{
		case 59:
			isShiftPress=true;			
		default:
		if (key1>=29 && key1<=54){
			if (isShiftPress==false)
				keyClick(key1+36);
			else
			{
				keyPress(Buttons.PRESS_SHIFT);
				keyClick(Buttons.FIRST_ALPHABET+key1+-29);
				keyRelease(Buttons.PRESS_SHIFT);
				isShiftPress=false;
			}
		}
			else if (key1>=7 && key1<=16)
				if (isShiftPress==false){
				keyClick(Buttons.FIRST_NUMBER+key1-7);
				}
				else {
					
					keyClick(specialKeys(key1));
					isShiftPress=false;
				}
		}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	
	
	public int specialKeys(int key)
	{
		int a=0;
		switch(key)
		{
		case 7:
			a=KeyEvent.VK_RIGHT_PARENTHESIS;
			break;
		case 8:
			a=KeyEvent.VK_EXCLAMATION_MARK;
			break;
		case 9:
			a=KeyEvent.VK_AT;
			break;
		case 10:
			a=KeyEvent.VK_NUMBER_SIGN;
			break;
		case 11:
			a=KeyEvent.VK_DOLLAR;
			break;
		//case 12:
			//return KeyEvent.VK_PERCENT;
		case 13:
			a=KeyEvent.VK_CIRCUMFLEX;
			break;
		
		}
		return a;
	}
 	
}
