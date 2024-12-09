package strategy;

import java.util.ArrayList;
import java.util.List;

public class Strategy2 implements MyStrategy
{
    @Override
    public List<Integer> sort(List<Integer> unsortedList) {
        List<Integer> sorted = new ArrayList<>(unsortedList);
        sorted.sort(null);
        return sorted;
    }
}
