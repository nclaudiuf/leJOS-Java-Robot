import lejos.nxt.Button;
import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class test
{

 public static void main(String[] args) {
  
  int speed = 70;
  boolean run = true;
  
  UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S1);
  
  System.out.println("Press any button");
  Button.waitForAnyPress();
  
  
  while (run) {

   MotorPort.A.controlMotor(70, 1);
   MotorPort.B.controlMotor(70, 1);

   while (ultra.getDistance() < 70) {
    while (MotorPort.A.getTachoCount() < 180 && MotorPort.A.getTachoCount() < 180)
    {
     MotorPort.A.controlMotor(speed, 1);
     MotorPort.B.controlMotor(70, 1);
    }
    MotorPort.A.resetTachoCount();
    MotorPort.B.resetTachoCount();
    
    speed += 1;
    MotorPort.A.controlMotor(speed, 1);
    MotorPort.B.controlMotor(70, 1);
   }
   speed = 70;
   
   while (ultra.getDistance() > 70) {
    while (MotorPort.A.getTachoCount() < 180 && MotorPort.A.getTachoCount() < 180)
    {
     MotorPort.A.controlMotor(70, 1);
     MotorPort.B.controlMotor(speed, 1);
    }
    MotorPort.A.resetTachoCount();
    MotorPort.B.resetTachoCount();
    
    speed += 1;
    MotorPort.A.controlMotor(70, 1);
    MotorPort.B.controlMotor(speed, 1);
   }
   
   speed = 70;
   
   // if corner
   if (ultra.getDistance() < 35)
   {
    while (MotorPort.A.getTachoCount() < 360)
    {
     MotorPort.A.controlMotor(70, 1);
     MotorPort.B.controlMotor(0, 1);
    }
   }
  }
  
  MotorPort.A.controlMotor(70, 4);
  MotorPort.B.controlMotor(70, 4);

 }
}