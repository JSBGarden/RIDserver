package com.project.remoteserver;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

import com.project.remoteprotocol.global.Buttons;

public class InputEvents {
	public Robot robot;
	private static Boolean isShiftPress;

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
				keyClick(Buttons.FIRST_NUMBER+key1-7);
		
		}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
 	
}
