package visitor;

//может StringBuilder запихнуть?
public class PrintVisitor implements  MyVisitor<Integer>{
    @Override
    public void visit(Integer item) {
        System.out.println(item);
    }
}
