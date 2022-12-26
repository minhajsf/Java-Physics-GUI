/**
* <h1>Calculate for Physics!</h1>
* The Calculate program implements an application that
* finds the variable in a given case for a standard
* kinematics question.
* <p>
* User can choose between the three formulas to solve
* a kinematics question that is asking for a 
* specific variable through the use of alegbra.
* I set the variables as object Double’s instead of primitive 
* doubles because I could set the object variables as null 
* for the missing variable a student needed to solve.
* @author  Minhaj Fahad
* @version 1.8.6
* @since   2020-12-03 
*/
public class Calculate 
{
   /**
   *  Displacement variable can have magnitude and direction. 
   */
   private Double displacement;
   /**
   *  Velocity variable can have magnitude and direction. 
   */
   private Double velocity;
   /**
   *  Initial velocity variable can have magnitude and direction. 
   */
   private Double iniVelocity;
   /**
   *  Acceleration variable can have magnitude and direction. 
   */
   private Double acceleration;
   /**
   *  Time variable can only have magnitude, no negatives. 
   */
   private Double time;
   /**
   *  Basic constructor, sets all instance
   *  variables to null when ran. 
   */
   public Calculate()
   { 
     displacement = (Double) null;
     velocity = (Double) null;
     iniVelocity = (Double) null;
     acceleration = (Double) null;
     time = (Double) null;
   } 
   /**
   *   Sets the displacement when ran.
   *   @param displacment 
   */
   public void setDis(Double displacement)
   {  
     this.displacement = displacement;
   }
   /**
   *   Sets the velocity when ran.
   *   @param velocity 
   */
   public void setVel(Double velocity)
   { 
     this.velocity = velocity;
   }
   /**
   *   Sets the initial velocity when ran.
   *   @param iniVelocity 
   */
   public void setIniVel(Double iniVelocity)
   { 
     this.iniVelocity = iniVelocity;
   }
   /**
   *   Sets the acceleration when ran.
   *   @param acceleration 
   */
   public void setAcc(Double acceleration)
   { 
     this.acceleration = acceleration;
   }
   /**
   *   Sets the time when ran.
   *   @param time 
   */
   public void setTime(Double time)
   { 
     this.time = time;
   } 
   /**
   *   Method for the physics velocity equation: v^2 = v0^2+2a(Δx)
   *   No parameters needed and finds the missing variable when
   *   called upon if it is null for each case. 
   *   @return value of missing variable
   */
   public double velWithoutTime()  
   {
     double answer = 0;
     if (velocity == null) 
     { 
       answer = Math.sqrt((iniVelocity) + (2*acceleration*displacement));
     }
     else if (iniVelocity == null) 
     { 
       answer = Math.sqrt((velocity) - (2*acceleration*displacement));
     }
     else if (acceleration == null) 
     { 
       answer = (velocity-iniVelocity)/(2*displacement);
     }
     else if (displacement == null) 
     { 
       answer = (velocity-iniVelocity)/(2*acceleration);
     }    
     return answer;  
   }
   /**
   *   Method for the physics velocity equation: v = v0+at
   *   No parameters needed and finds the missing variable when
   *   called upon if it is null for each case. 
   *   @return value of missing variable
   */
   public double velWithoutDis()  
   {
     double answer = 0;
     if (velocity == null) 
     { 
       answer = iniVelocity + (acceleration*displacement);
     }
     else  if (iniVelocity == null) 
     { 
       answer = velocity - (acceleration*displacement);
     }
     else if (acceleration == null) 
     { 
       answer = (velocity-iniVelocity)/(time);
     }
     else if (time == null) 
     { 
       answer = (velocity-iniVelocity)/(acceleration);
     }    
     return answer;  
   }
   /**
   *   Method for the physics displacement equation: Δx = v0t+1/2at^2
   *   No parameters needed and finds the missing variable when
   *   called upon if it is null for each case. 
   *   @return value of missing variable
   */
   public double displacementWithoutVel() 
   {
     double answer = 0;
     if (displacement == null) 
     { 
       answer = iniVelocity*time + ((1.0/2)*acceleration*Math.pow(time, 2));
     }
     else if (iniVelocity == null) 
     { 
       answer = (displacement - (1.0/2)*acceleration*Math.pow(time, 2))/time;
     }
     else if (acceleration == null) 
     { 
       answer = (displacement-iniVelocity)/((1.0/2)*Math.pow(time, 2));
     }
     else if (time == null) 
     { 
       answer = Math.sqrt((displacement-iniVelocity)/((1.0/2)*acceleration));
     }    
     return answer;  
   }
   /**
   *  Main method tests the methods to make sure they are 
   *  working correcly when called upon with different objects.
   *  and different questions. 
   */
   public static void main(String[] args)
   {
     Calculate a = new Calculate();
     a.setDis(3.0);
     a.setVel(0.0);
     a.setIniVel((Double)null);
     a.setAcc(-10.0);
     a.setTime((Double)null);
     System.out.println(a.velWithoutTime());   
     
     Calculate b = new Calculate();
     b.setDis((Double)null);
     b.setVel(6.0);
     b.setIniVel(16.0);
     b.setAcc((Double)null);
     b.setTime(4.0);
     System.out.println(b.velWithoutDis());
     
     Calculate c = new Calculate();
     c.setDis(40.0);
     c.setVel((Double)null);
     c.setIniVel(0.0);
     c.setAcc((Double)null);
     c.setTime(4.0);
     System.out.println(c.displacementWithoutVel());
     
     Calculate d = new Calculate();
     d.setDis(-5.0);
     d.setVel((Double)null);
     d.setIniVel(0.0);
     d.setAcc(-10.0);
     d.setTime(1.0);
     System.out.println(d.velWithoutTime());
   }
}