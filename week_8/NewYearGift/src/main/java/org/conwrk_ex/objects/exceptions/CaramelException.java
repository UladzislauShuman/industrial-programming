package org.conwrk_ex.objects.exceptions;

import java.util.HashMap;

public class CaramelException extends Exception {
    public static enum Message{
        EMPTY_TASTE,
        BAD_TASTE,
        EMPTY_HARDNESS,
        BAD_HARDNESS
    };
    private static HashMap<CaramelException.Message,String> map = new HashMap<>();
    static  {
        map.put(Message.EMPTY_TASTE, "taste is null");
        map.put(Message.BAD_TASTE, "bad Taste value");
        map.put(Message.EMPTY_HARDNESS, "hardness is null");
        map.put(Message.BAD_HARDNESS, "bad Hardness value");
    }
    public CaramelException(CaramelException.Message message, String information)
    {
        this(map.get(message) + " ||| " + information);
    }
    public CaramelException(CaramelException.Message message)
    {
        this(map.get(message));
    }
    private CaramelException(String message) {
        super(message);
    }

}
