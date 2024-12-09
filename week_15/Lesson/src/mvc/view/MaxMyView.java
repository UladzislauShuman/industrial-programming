package mvc.view;

import collection.MyCollection;

import javax.swing.*;

public class MaxMyView extends JLabel implements MyView
{
    private MyCollection myCollection;

    public MaxMyView(MyCollection myCollection)
    {
        super();
        this.myCollection = myCollection;
        this.update();
    }

    @Override
    public void update() {
        this.setText(this.myCollection.getMax().toString());
    }
}

