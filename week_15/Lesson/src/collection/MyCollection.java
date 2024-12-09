package collection;

import iterator.MyIterable;
import iterator.MyIterator;
import strategy.MyStrategy;
import strategy.Strategy1;
import visitor.CountVisior;
import visitor.MyElement;
import visitor.MyVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCollection implements MyIterable<Integer>, MyElement<Integer>
{
    private List<Integer> list;
    private MyStrategy strategy = new Strategy1();

    public MyCollection()
    {
        this.list = new ArrayList<>();
    }

    public void add(Integer element)
    {
        this.list.add(element);
    }

    @Override
    public MyIterator<Integer> createIterator() {
        return new MyIterator<Integer>() {
            private int currentIndex = 0;
            @Override
            public void first() {
                this.currentIndex = 0;
            }

            @Override
            public void next()
            {
                this.currentIndex++;
            }

            @Override
            public boolean isDone() {
                return this.currentIndex >= list.size();
            }

            @Override
            public Integer getCurrentItem() //throws MyIteratorOutOfBoundsException
            {
                //if (this.isDone())
                 //   throw new MyIteratorOutOfBoundsException("getCurrentItem isDone == true");
                return list.get(this.currentIndex);
            }


        };
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        MyIterator<Integer> iterator = this.createIterator();
        for (iterator.first();!iterator.isDone();iterator.next())
            sb.append(iterator.getCurrentItem()).append(" ");
        return sb.toString();
    }

    public void setStrategy(MyStrategy strategy)
    {
        this.strategy = strategy;
    }

    public List<Integer> sort()
    {
        return this.strategy.sort(this.list);
    }


    @Override
    public void accept(MyVisitor<Integer> visitor) {
        MyIterator<Integer> iterator = this.createIterator();
        for (iterator.first();!iterator.isDone();iterator.next())
            visitor.visit(iterator.getCurrentItem());
    }

    public int getSize()
    {
        CountVisior visitor = new CountVisior();
        this.accept(visitor);
        return visitor.getCount();
    }
    //потом сделать как Visitor
    public Integer getMax()
    {
        return Collections.max(this.list);
    }

}
