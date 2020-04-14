package activity7;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Activity7 extends JFrame implements ItemListener,ActionListener{
    
    
    public static void main(String[] args) {
       new Activity7();
    }

    public Activity7(){
        createFrame(270,110);
        addCheckBoxes();
        addRadioButtons();
    }
    
    public void createFrame(int width, int height){
        this.setTitle("Checkboxes and Radiobuttons");
        this.setSize(width, height);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    JCheckBox cbRed, cbGreen, cbBlue;
    boolean r,g,b;
    public void addCheckBoxes(){
        // instantiate
        cbRed = new JCheckBox("Red");
        cbGreen = new JCheckBox("Green");
        cbBlue = new JCheckBox("Blue");
        // define bounds
        cbRed.setBounds(10, 10, 60, 25);
        cbGreen.setBounds(10, 30, 60, 25);
        cbBlue.setBounds(10, 50, 60, 25);
        // add listener
        cbRed.addItemListener(this);
        cbGreen.addItemListener(this);
        cbBlue.addItemListener(this);
        // add to frame
        this.add(cbRed); this.add(cbGreen); this.add(cbBlue);
    }
    
    JRadioButton rbYes, rbNo;
    boolean y,n;
    public void addRadioButtons(){
        // instantiate
        rbYes = new JRadioButton("Yes");
        rbNo = new JRadioButton("No");
        // define bounds
        rbYes.setBounds(80, 10, 60, 25);
        rbNo.setBounds(80, 30, 60, 25);
        // button group
        ButtonGroup group = new ButtonGroup();
        group.add(rbYes);
        group.add(rbNo);
        // add to frame
        this.add(rbYes); this.add(rbNo);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        if(e.getStateChange() == ItemEvent.SELECTED){
            if(source == cbRed){
                System.out.println("Red selected!");
                r = true;
            }
            else if(source == cbGreen){
                System.out.println("Green selected!");
                g = true;
            }
            else if(source == cbBlue){
                System.out.println("Blue selected!");
                b = true;
            }
            
        }
        else if(e.getStateChange() == ItemEvent.DESELECTED){
            if (source == cbRed) {
                System.out.println("Red deselected!");
                r = false;
            } else if (source == cbGreen) {
                System.out.println("Green deselected!");
                g = false;
            } else if (source == cbBlue) {
                System.out.println("Blue deselected!");
                b = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = e.getActionCommand();
        if(text.equals("Yes")){
            System.out.println("Let's do this!");
            y = true; n = false;
        }
        else if(text.equals("No")){
            System.out.println("Okay, maybe next time.");
            y = false; n = true;
        }
    }

   
    
}

