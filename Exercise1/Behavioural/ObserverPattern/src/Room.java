import java.util.ArrayList;
import java.util.List;

public class Room implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String status = "Empty"; // default

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }
}
