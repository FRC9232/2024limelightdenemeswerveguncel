package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.*;


public class IntakeSubsystem extends SubsystemBase {
    
    private VictorSPX rightMotor;
    private VictorSPX leftMotor;
    public AnalogInput sharp = new AnalogInput(0);

    
    public IntakeSubsystem(){
        rightMotor = new VictorSPX(3);
        leftMotor = new VictorSPX(4);
        
        rightMotor.setInverted(true);
        leftMotor.setInverted(true);

        rightMotor.setSelectedSensorPosition(0);
        leftMotor.setSelectedSensorPosition(0);

    }

    public void setIntake(Boolean open){
        if (open == true){
            rightMotor.set(ControlMode.PercentOutput, 0.55);
            leftMotor.set(ControlMode.PercentOutput, 0.55);
        }
        else{
            rightMotor.set(ControlMode.PercentOutput, 0.0);
            leftMotor.set(ControlMode.PercentOutput, 0.0); 
        }
    }
    public void setIntakeReversed(){
     
        rightMotor.set(ControlMode.PercentOutput, -0.6);
        leftMotor.set(ControlMode.PercentOutput, -0.6);

    }
    public void intakeToShooter(){

        rightMotor.set(ControlMode.PercentOutput, 1.0);
        leftMotor.set(ControlMode.PercentOutput, 1.0);
    }
    public void autoIntake(){
      
        rightMotor.set(ControlMode.PercentOutput, 0.55);
        leftMotor.set(ControlMode.PercentOutput, 0.55);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("SharpSensor", sharp.getValue()); 
     
    }
}