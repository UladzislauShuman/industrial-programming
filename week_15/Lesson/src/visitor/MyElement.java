package visitor;

//пересмотреть название
// интерфейс, который может принимать MyVisitor
public interface MyElement<Type>
{
    void accept(MyVisitor<Type> visitor);
}
