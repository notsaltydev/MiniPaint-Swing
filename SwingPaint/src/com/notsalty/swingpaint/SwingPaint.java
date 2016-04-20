package com.notsalty.swingpaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;

 
public class SwingPaint extends DrawArea{

  /**
	 * 
	 */
private static final long serialVersionUID = 1L;

private JButton chooseButton = new JButton("Choose Color");

private JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn;

protected DrawArea drawArea;

Color wybranyKolor;

  ActionListener actionListener = new ActionListener() {
 
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == clearBtn) {
        drawArea.clear();
      } else if (e.getSource() == blackBtn) {
        drawArea.black();
      } else if (e.getSource() == blueBtn) {
        drawArea.blue();
      } else if (e.getSource() == greenBtn) {
        drawArea.green();
      } else if (e.getSource() == redBtn) {
        drawArea.red();
      } else if (e.getSource() == magentaBtn) {
        drawArea.magenta();
      }
      
    }
  
  };

  public static void main(String[] args) {
    new SwingPaint().show();
  }
public SwingPaint() {
	 chooseButton.addActionListener(new ButtonListener());
	 wybranyKolor = Color.red;
}
  
  //Color Chooser Begin
  private class ButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	Color c = JColorChooser.showDialog(null, "Choose a Color", wybranyKolor);
	        if (c != null)
	        	drawArea.setBackground(wybranyKolor);
	    }
	  }
  //End
  public void paintComponent(){
	  drawLine(wybranyKolor, currentX,currentY,0,0);
  }
 
 
  private void drawLine(Color wybranyKolor2, int currentX, int currentY, int i, int j) {
	// TODO Auto-generated method stub
	
}
public void show() {  
	  
    // create main frame
    JFrame frame = new JFrame("Swing Paint");
    Container content = frame.getContentPane();
    // set layout on content pane
    content.setLayout(new BorderLayout());
    // create draw area
    drawArea = new DrawArea();
 
    // add to content pane
    content.add(drawArea, BorderLayout.CENTER);
 
    // create controls to apply colors and call clear feature
    JPanel controls = new JPanel();
    clearBtn = new JButton("Clear");
    clearBtn.addActionListener(actionListener);
    blackBtn = new JButton("Black");
    blackBtn.addActionListener(actionListener);
    blueBtn = new JButton("Blue");
    blueBtn.addActionListener(actionListener);
    greenBtn = new JButton("Green");
    greenBtn.addActionListener(actionListener);
    redBtn = new JButton("Red");
    redBtn.addActionListener(actionListener);
    magentaBtn = new JButton("Magenta");
    magentaBtn.addActionListener(actionListener);
 
    // add to panel
    controls.add(chooseButton);
    controls.add(greenBtn);
    controls.add(blueBtn);
    controls.add(blackBtn);
    controls.add(redBtn);
    controls.add(magentaBtn);
    controls.add(clearBtn);
 
    // add to content pane
    content.add(controls, BorderLayout.NORTH);

    frame.setSize(600, 600);
    // can close frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // show the swing paint result
    frame.setVisible(true);
 
    // Now you can try our Swing Paint !!! Enjoy
  }
 
}