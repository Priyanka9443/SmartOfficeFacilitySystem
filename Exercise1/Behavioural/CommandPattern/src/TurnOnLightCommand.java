public class TurnOnLightCommand implements Command {
    private Light light;
    public TurnOnLightCommand(Light light) { 
        this.light = light; 
    }
    @Override
    public void execute() { 
        System.out.println("Light turned ON"); 
        }
}