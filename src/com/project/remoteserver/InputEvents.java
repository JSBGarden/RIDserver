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

				//activvate shift
				if (isShiftPress==true)
				{
					keyPress(Buttons.PRESS_SHIFT);
				}
				
				//Alphabet
				if (key1>=29 && key1<=54){			
					keyClick(Buttons.FIRST_ALPHABET+key1+-29);			
				}
				//Numbers and their SHIFTS
				else if (key1>=7 && key1<=16){
					keyClick(Buttons.FIRST_NUMBER+key1-7);
				}
				else{
					//others
					if (specialKeys(key1)!= 0)
					keyClick(specialKeys(key1));
				}
					
					
				
				
				//dactivate shift 
				if (isShiftPress==true)
				{
					keyRelease(Buttons.PRESS_SHIFT);
					isShiftPress=false;
				}

				/*
			else {
					System.out.println("yes shift");
					keyPress(Buttons.PRESS_SHIFT);
					keyClick(Buttons.FIRST_NUMBER+key1-7);
					keyRelease(Buttons.PRESS_SHIFT);
					isShiftPress=false;
				}*/
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
		case 55:  
			a=44;
			break;

		case 56:
			a=46;
			break;
			//`~68   
		case 69:  
			a=45;
			break;
		case 70:
			a=61;
			break;
		case 71:  
			a=161;
			break;
		case 72:
			a=162;
			break;
		case 73:
			a=92;
			break;
		case 74:
			a=59;
			break;
		case 75:
			a=222;
			break;
		case 76:
			a=47;
			break;
		case 61:  
			a=9;
			break;
		case 67:
			a=8;
			break;
		case 62:
			a=32;
			break;
		case 66:
			a=10;
			break;
		}
		return a;
	}

}
