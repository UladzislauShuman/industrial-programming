package elements;

import javax.swing.*;

public class TypeBox extends JComboBox<String>
{
    public TypeBox()
    {
        super(new String[]{
                "Liner",
                "Exponential"
        });
    }
}
