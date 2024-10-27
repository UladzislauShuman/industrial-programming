package org.conwrk_ex.objects.exceptions;

import java.util.HashMap;

public class ChocolateException extends Exception {
    public static enum Message{
        EMPTY_FILLING,
        BAD_FILLING,
        EMPTY_TYPE,
        BAD_TYPE
    };
    private static HashMap<ChocolateException.Message,String> map = new HashMap<>();
    static  {
        map.put(Message.EMPTY_FILLING, "filling is null");
        map.put(Message.BAD_FILLING, "bad Filling value");
        map.put(Message.EMPTY_TYPE, "Type is null");
        map.put(Message.BAD_TYPE, "bad Type value");
    }
    public ChocolateException(ChocolateException.Message message, String information)
    {
        this(map.get(message) + " ||| " + information);
    }
    public ChocolateException(ChocolateException.Message message)
    {
        this(map.get(message));
    }
    private ChocolateException(String message) {
        super(message);
    }
}
