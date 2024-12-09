package mvc.view;

import collection.MyCollection;

import javax.swing.*;

public class MyLabelView extends JLabel implements MyView
{

    private MyCollection myCollection;

    public MyLabelView(MyCollection myCollection)
    {
        this.myCollection = myCollection;
        this.update();
    }

    @Override
    public void update() {
        this.setText(myCollection.toString());
    }
}
