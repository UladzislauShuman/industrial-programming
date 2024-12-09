package visitor;

public class CountVisior implements MyVisitor<Integer>
{
    private int count = 0;

    @Override
    public void visit(Integer item) {
        this.count++;
    }
    public int getCount(){return this.count;}
}
