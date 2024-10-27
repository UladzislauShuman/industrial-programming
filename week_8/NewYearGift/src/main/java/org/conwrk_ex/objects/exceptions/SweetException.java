package org.conwrk_ex.objects.exceptions;

import org.conwrk_ex.objects.sweet.caramel.Caramel;
import org.conwrk_ex.objects.sweet.chocolate.Chocolate;

import java.util.HashMap;
import java.util.function.Function;

public class SweetException extends Exception {
    public static enum Message{
        NULL_SWEET,
        EMPTY_NAME,
        WEIGHT_LESS_ZERO,
        BAD_SUGAR_PERCENT
    };
    private static HashMap<Message,String> map = new HashMap<>();
    static  {
        map.put(Message.NULL_SWEET, "sweet is null");
        map.put(Message.EMPTY_NAME , "empty name to Sweet");
        map.put(Message.WEIGHT_LESS_ZERO,"sweet weight less then zero");
        map.put(Message.BAD_SUGAR_PERCENT, "sugar percent is not between 0 and 100");
    }
    public SweetException(Message message)
    {
        this(map.get(message));
    }
    private SweetException(String message) {
        super(message);
    }


}
