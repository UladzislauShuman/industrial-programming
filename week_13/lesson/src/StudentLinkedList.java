import java.util.Iterator;

public class StudentLinkedList implements StudentList, Iterable<StudentLinkedList.StudentNode>
{
    protected class StudentNode
    {
        private Student data;
        private StudentNode next;

        public StudentNode(Student data)
        {
            this.data = data;
            this.next = null;
        }
        public StudentNode()
        {
            this.data = null;
            this.next = null;
        }
        public boolean isEmpty(){return this.data == null;}

        public Student getData(){return this.data;}
        public StudentNode getNext(){return this.next;}
        public void setData(Student data){this.data = data;}

        public void setNext(StudentNode next){this.next = next;}
        public void setNext(Student student){this.next = new StudentNode(student);}
    }

    StudentNode head;

    public StudentLinkedList()
    {
        this.head = new StudentNode();
    }


    @Override
    public void add(Student student) {
        if(this.head.isEmpty()) {
            this.head.setData(student);
            return;
        }
        StudentNode last = this.head;
        Iterator<StudentNode> iterator = this.iterator();

        while (iterator.hasNext())
            last = iterator.next();

        last.setNext(student);

    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<StudentNode> iterator = this.iterator();
        while(iterator.hasNext())
            stringBuilder.append(iterator.next().getData().toString()).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public Iterator<StudentNode> iterator() {
        return new Iterator<StudentNode>() {
            private StudentNode currenStudentNode = head;

            public void setFirst(){this.currenStudentNode = head;}
            @Override
            public boolean hasNext() {
                return !(this.currenStudentNode.next == null);
            }

            @Override
            public StudentNode next() {
                StudentNode temp = this.currenStudentNode;
                this.currenStudentNode = this.currenStudentNode.getNext();
                return temp;
            }
        };
    }
}
