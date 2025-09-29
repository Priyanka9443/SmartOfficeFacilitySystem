public class MainCommandDemo {
    public static void main(String[] args) {
        Light light = new Light();

        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);

        Invoker invoker = new Invoker();

        invoker.setCommand(turnOn);
        invoker.pressButton();

        invoker.setCommand(turnOff);
        invoker.pressButton();
    }
}
