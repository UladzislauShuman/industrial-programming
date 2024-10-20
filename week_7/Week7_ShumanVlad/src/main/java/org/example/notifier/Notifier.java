package org.example.notifier;

import java.util.HashSet;
import java.util.Set;

public class Notifier<T extends Notifiable>
{
    private Set<T> notifiables;

    public Notifier(Set<T> notifiables)
    {
        this.notifiables = new HashSet<T>();
        this.notifiables.addAll(notifiables);
    }

    public void doNotifyAll(String message)
    {
        for (T notifiable: this.notifiables)
        {
            notifiable.notify(message);
        }
    }
}
