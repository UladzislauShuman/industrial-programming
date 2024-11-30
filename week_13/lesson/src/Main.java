public class Main {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.add(new Student("Anton"));
        list.add(new Student("Vlad"));
        list.add(new Student("Sergay"));

        list.print();
    }
}