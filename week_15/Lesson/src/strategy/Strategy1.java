package strategy;

import java.util.List;

public class Strategy1 implements MyStrategy
{
    @Override
    public List<Integer> sort(List<Integer> unsortedList) {
        return unsortedList.stream().sorted().toList();
    }
}
