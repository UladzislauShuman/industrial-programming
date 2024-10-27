package org.conwrk_ex.objects.exceptions;

import java.util.HashMap;

public class PresentException extends Exception {
    public static enum Message{
        NULL_ARRAYLIST,
        NULL_PRESENT,
        NULL_SWEETS,
        NULL_ADD_SWEET,
        NULL_COMPARATOR,
        NULL_PREDICATE
    };
    private static HashMap<PresentException.Message,String> map = new HashMap<>();
    static  {
        map.put(Message.NULL_ARRAYLIST, "ArrayList of Sweet-s is null");
        map.put(Message.NULL_PRESENT, "Present is null");
        map.put(Message.NULL_SWEETS, "Sweet ... sweets is null");
        map.put(Message.NULL_ADD_SWEET, "add(sweet), sweet is null");
        map.put(Message.NULL_COMPARATOR, "sort(comparator), comparator is null");
        map.put(Message.NULL_PREDICATE, "find(predicate), predicate is null");
    }
    public PresentException(PresentException.Message message, String information)
    {
        this(map.get(message) + " ||| " + information);
    }
    public PresentException(PresentException.Message message)
    {
        this(map.get(message));
    }
    private PresentException(String message) {
        super(message);
    }
}
