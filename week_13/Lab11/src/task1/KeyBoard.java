package task1;

import java.util.ArrayList;
import java.util.List;

public class KeyBoard implements Subject
{
    private List<Observer<String>> observers = new ArrayList<>();
    public String state;

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : this.observers)
        {
            observer.update(this.state);
        }
    }
}
