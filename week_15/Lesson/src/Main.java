import collection.MyCollection;
import mvc.controller.Controller;
import strategy.Strategy1;
import strategy.Strategy2;
import visitor.StringVisitor;

public class Main {
    public static void main(String[] args) {
        MyCollection myList = new MyCollection();
        for (int i = 9; i != 0; i--)
            myList.add(i);
        System.out.println(myList);

        System.out.println("after Strategy2");
        myList.setStrategy(new Strategy2());

        System.out.println("myList.sort(): ");
        System.out.println(myList.sort());

        System.out.println("myList: ");
        System.out.println(myList);

        System.out.println();

        System.out.println("after Strategy1");
        myList.setStrategy(new Strategy1());

        System.out.println("myList.sort(): ");
        System.out.println(myList.sort());

        System.out.println("myList: ");
        System.out.println(myList);

        //применить Visitor, а не делать метод в классе
        //тогда весь смысл теряется

        System.out.println("StringVisitor:");
        StringVisitor stringVisitor = new StringVisitor();
        myList.accept(stringVisitor);
        System.out.println(stringVisitor.getString());

        Controller controller = new Controller(myList);

    }
}