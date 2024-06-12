package com.saravanjs.java22.console.designpatterns.command;

/**
 * @author Sarav on 08 May 2024
 * @project govtech
 * @package com.govtech.viswa.designpatterns.command
 * @class CommandPattern
 */

// Step 1: Command interface
interface Command {
    void execute();
}

// Step 3: Receiver class
class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command onCommand;
    private Command offCommand;

    public RemoteControl(Command onCommand, Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }

    public void pressOnButton() {
        onCommand.execute();
    }

    public void pressOffButton() {
        offCommand.execute();
    }
}



// Step 5: Client code
public class CommandPattern {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        RemoteControl remoteControl = new RemoteControl(lightOnCommand, lightOffCommand);

        remoteControl.pressOnButton();
        remoteControl.pressOffButton();
    }
}
