import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
/**
* The PhysicsCalc program implements a GUI that
* creates a complex calculator using the 
* Calculate class methods.
* <p>
* User can choose between the three formulas to solve
* a kinematics question that is asking for a 
* specific variable through the use of Calculate,
* by inputting given variables from the question.
*
* @author  Minhaj Fahad
* @version 1.8.6
* @since   2020-12-0
*/
public class PhysicsCalc extends JFrame
    implements ActionListener
{   
    /**
    * Declares a Calculate variable to use methods.
    */
    private Calculate calc;
    /**
    * Declares a JTextField variables to input numbers.
    */
    private JTextField numberDis,numberVel, numberIniVel, numberTime, numberAcc, answer;
    /**
    * Declares a missing variable to be set to the missing number in the equation.
    */
    private double missing;
    /**
    * This contructor creates a Content Pane with a Flow Layout to 
    * put the different JLabels, JTextFields, and JButtons 
    * into. Action listener allows the calculator to use methods from 
    * the Calulate class to solve the missing variable then display it.
    */
    public PhysicsCalc()
    {
      super("Physics Calculator");
      
      Container z = getContentPane(); //content pane to add objects into 
      z.setLayout(new FlowLayout()); //creates flow layout for basic structure
      calc = new Calculate();  //Creates a Calculate object to run throught the calculator
      
      z.add(new JLabel("Δx:"));       // this block adds the label for displacement
      numberDis = new JTextField(5);  // as well as it's text field to either set the 
      numberDis.addActionListener(new ActionListener()//variable or set it to null.
      {@Override 
        public void actionPerformed(ActionEvent e) //with a sub method for action event
        {       
          String b = numberDis.getText();
          if (b.equals( ""))
            calc.setDis((Double) null);
          else 
            calc.setDis(Double.parseDouble(b));
          numberDis.setText("");
      }});
      z.add(numberDis);
      
      z.add(new JLabel("v:"));  // this block adds the label for velocity
      numberVel = new JTextField(5); // as well as it's text field to either set the
      numberVel.addActionListener(new ActionListener()//variable or set it to null.
      {@Override 
        public void actionPerformed(ActionEvent e) //with a sub method for action event
        {       
          String a = numberVel.getText();
          if (a.equals(""))
            calc.setVel((Double) null);
          else 
            calc.setVel(Double.parseDouble(a));
          numberVel.setText("");
      }});
      z.add(numberVel);
      
      z.add(new JLabel("v0:"));  // this block adds the label for initial velocity
      numberIniVel = new JTextField(5); // as well as it's text field to either set the
      numberIniVel.addActionListener(new ActionListener()//variable or set it to null.
      {@Override 
        public void actionPerformed(ActionEvent e) //with a sub method for action event
        { 
          String c = numberIniVel.getText();
          if (c.equals( ""))
            calc.setIniVel((Double) null);
          else 
            calc.setIniVel(Double.parseDouble(c));
          numberIniVel.setText("");
        }});
      z.add(numberIniVel);
      
      z.add(new JLabel("a:"));  // this block adds the label for acceleration 
      numberAcc = new JTextField(5); // as well as it's text field to either set the
      numberAcc.addActionListener(new ActionListener()//variable or set it to null.
      {@Override 
        public void actionPerformed(ActionEvent e) //with a sub method for action event
        { 
          String d = numberAcc.getText();
          if (d.equals(""))
            calc.setAcc((Double) null);
          else 
            calc.setAcc(Double.parseDouble(d));
          numberAcc.setText("");
        }});
      z.add(numberAcc);
     
      z.add(new JLabel("t:"));  // this block adds the label for acceleration
      numberTime = new JTextField(5); // as well as it's text field to either set the
      numberTime.addActionListener(new ActionListener()//variable or set it to null.
      {@Override 
        public void actionPerformed(ActionEvent e)  //with a sub method for action event
        { 
          String f = numberTime.getText();
          if (f.equals(""))
            calc.setTime((Double) null);
          else 
            calc.setTime(Double.parseDouble(f));   
          numberTime.setText("");
        }});
      z.add(numberTime);
      
      JButton button1 = new JButton("v^2 = v0^2+2a(Δx)");
      button1.addActionListener(this); //button to use velWithoutTime equation. 
      z.add(button1);
      
      JButton button2 = new JButton("v = v0+at");
      button2.addActionListener(this); //button to use velWithoutDis equation.
      z.add(button2);
      
      JButton button3 = new JButton("Δx = v0t+1/2at^2");
      button3.addActionListener(this); //button to use displacementWithoutVel equation.
      z.add(button3);

      answer = new JTextField(18);
      answer.setBackground(new Color(200,200,200));
      answer.setEditable(false); //textfield that displays the answer. 
      z.add(answer);

    }
    /**
    *  This method uses Action Listener for the buttons and 
    *  calls on the equation methods to find the missing variable.
    *  and then displays the missing variable to the user like a calculator. 
    */
    public void actionPerformed(ActionEvent e)
    {
      if (((JButton)e.getSource()).getText().equals("v^2 = v0^2+2a(Δx)"))
      {
         try 
         {
           missing = calc.velWithoutTime();  //try-catch method for user error in the calculator 
           answer.setText(" Answer: " + missing);
         } 
         catch(NullPointerException ex)      // for different types of exceptions
         {
           answer.setText("You forgot a variable! Try again.");
         }
         catch(Exception ex)
         {
           answer.setText("Something went wrong! Try again.");
         }
        
      }
      else if (((JButton)e.getSource()).getText().equals("v = v0+at"))
      {
         try 
         {
           missing = calc.velWithoutDis();   //try-catch method for user error in the calculator
           answer.setText(" Answer: " + missing);
         }
         catch(NullPointerException ex)      // for different types of exceptions
         {
           answer.setText("You forgot a variable! Try again.");
         }
         catch(Exception ex)
         {
           answer.setText("Something went wrong! Try again.");
         }
      }
      else if (((JButton)e.getSource()).getText().equals("Δx = v0t+1/2at^2"))
      {
         try 
         {
           missing = calc.displacementWithoutVel();
           answer.setText(" Answer: " + missing);  //try-catch method for user error in the calculator
         } 
         catch(NullPointerException ex)              // for different types of exceptions
         {
           answer.setText("You forgot a variable! Try again.");
         }
         catch(Exception ex)
         {
           answer.setText("Something went wrong! Try again.");
         }
      }      
    }
    /**
    *  Main method to create a new PhysicsCalc object,
    *  Runs a window for the calculator and sets parameters and colors.
    *  To use the calculator, simply input your variables and press
    *  the corresponding button for the specific equation.   
    */
    public static void main(String args[])
    {
      PhysicsCalc window = new PhysicsCalc();
      window.setBounds(100, 100, 300, 200);
      window.setDefaultCloseOperation(EXIT_ON_CLOSE);
      window.setResizable(false);
      window.setVisible(true);
      window.getContentPane().setBackground(new Color(255,150,100));
      window.setBackground(new Color(200,50,50));
    }
}