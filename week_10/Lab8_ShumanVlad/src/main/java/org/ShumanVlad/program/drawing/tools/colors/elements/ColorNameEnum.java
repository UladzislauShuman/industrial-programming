package org.ShumanVlad.program.drawing.tools.colors.elements;

public enum ColorNameEnum {

    BLACK("Black"),
    RED("Red");

    private String name;

    ColorNameEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
