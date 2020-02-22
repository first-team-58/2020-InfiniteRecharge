package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class JoystickAnalogButton extends Button {
    private XboxController stick;
    private int axis;
    private direction dir;
    private double deadzone = 0.2;

    public static enum direction {
        UP, DOWN
    }
    

    public JoystickAnalogButton(XboxController joy, int axis, direction dir) {
      this.stick = joy;
      this.axis = axis;
      this.dir = dir;
    }

    public boolean get() {
      switch (dir) {
      case UP:
        if (stick.getRawAxis(axis) > deadzone) {
          return true;
        } else {
          return false;
        }
      case DOWN:
        deadzone = deadzone * -1;
        if (stick.getRawAxis(axis) < deadzone) {
          return true;
        } else {
          return false;
        }
      default:
        return false;
      }
    }
  }