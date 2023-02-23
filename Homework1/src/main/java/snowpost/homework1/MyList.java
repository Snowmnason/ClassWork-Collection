package snowpost.homework1;

public class MyList{
    private Node<Employee> head = null;
    private Node<Employee> tail = null;
    private int size = 0;
    MyList copyInternal;
    /**
     * Implement Node
     */
    private class Node<Employee> {

        private Employee element;
        private Node<Employee> next;

        public Node(Employee e, Node<Employee> n) {
            element = e;
            next = n;
        }
        public Employee getElement() {
            return element;
        }
        public Node<Employee> getNext() {
            return next;
        }
        public void setNext(Node<Employee> n) {
            next = n;
        }
    }
        /**
     * default constructor 
     */
    public MyList () {
        this.head = null;
        this.tail = null;
        this.size =0;
    }
    /**
     * 
     * @param Head
     * @param Tail
     * @param size 
     */
    public MyList(Node<Employee> Head, Node<Employee> Tail, int size) {    
        this.head = Head;
        this.tail = Tail;
        this.size = size;
    }
    /**
     * 
     * @return current size of the queue 
     */
    public int getLenght() {
        return size;
    }
    /**
     *
     * @return a Boolean true if empty false if it has an item
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * adds employee to the list, most recent at the top
     * @param e Employee to be add
     */
    public void add(Employee e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }
    /**
     * Cleans the queue without displaying it
     */
    public void clear() {
        while (!isEmpty()) {
            head = head.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
        }
    }
        /**
     * @return The most recent value put into the queue
     */
    public Employee getMax() { //acts as poll
        Employee answer = head.getElement();
        head = head.getNext();
        if (isEmpty()) {
            return null;
        }
        if (size <= 1) {/*do nothing*/
        }
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
    /**
     *
     * @param id the employee id that is desired
     * @return the entire employee entry
     */
    public Employee getFind(int id) { 
        Node<Employee> currentNode = head;
        Node<Employee> nextNode = currentNode;
        if (isEmpty()) {
            return null;
        }
        if (size <= 1) {/*do nothing*/
        } else {
            while (id != currentNode.getElement().getId()) {
                nextNode = currentNode.getNext();
                currentNode = nextNode;
            }
        }
        Employee answer = currentNode.getElement();
        return answer;
    }
    /**
     * 
     * @param other My List to be copied
     */
    MyList(MyList other) {
            Node<Employee> currentNode = other.head;
            Node<Employee> nextNode = currentNode.getNext();
            for (int i = 0; i < size; i++) {
                add(currentNode.getElement().makeCopy());
                currentNode = nextNode;
                nextNode = currentNode.getNext();
            }
    }
    /**
     * @return copy of the current instance of MyList
     */
    public MyList makeCopy() {
        //MyList copyExternal = new MyList(head, tail, size);
        MyList copyExternal = new MyList(head, tail, size);/*
        copyExternal.head = this.head;
        copyExternal.tail = this.tail;
        copyExternal.size = this.size;*/
        return copyExternal;
    }
}
