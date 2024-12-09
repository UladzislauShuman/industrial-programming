package mvc.view;

import collection.MyCollection;

import javax.swing.*;

public class LabelMyView extends JLabel implements MyView
{

    private MyCollection myCollection;

    public LabelMyView(MyCollection myCollection)
    {
        super();
        this.myCollection = myCollection;
        this.update();
    }

    @Override
    public void update() {
        this.setText(myCollection.toString());
    }
}
