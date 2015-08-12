package com.morgan.screenshot;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ScreenShot extends JFrame 
{
    public static void main( String[] args )
    {
    	JFrame frame = new ScreenShot();
    	frame.setSize(300, 300); 
    	JButton button = new JButton("Take screenshot");
    	button.addActionListener(new ActionListener(){

    		public void actionPerformed(ActionEvent event){
    			Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		    	Robot robot;
		    	try {
		            robot = new Robot();
		        } catch (AWTException e) {
		            throw new RuntimeException(e);
		        }
		    	BufferedImage image = robot.createScreenCapture(new Rectangle(size));
		    	File file = new File("test.png");
		    	try{
		    		ImageIO.write(image, "png", file);
		    	} catch (IOException ex){
		    		throw new RuntimeException(ex);
		    	}
    		}

    	});
    	frame.add(button);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true); 
    }
}
