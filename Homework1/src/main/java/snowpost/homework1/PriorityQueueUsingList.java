package snowpost.homework1;

/**
 *
 * @author Dominick Sora
 */
public class PriorityQueueUsingList implements PriorityQueue {
    PriorityQueueUsingList copyInternal;
    private Node<Employee> head = null;
    private Node<Employee> tail = null;
    private int size = 0;
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
    public PriorityQueueUsingList () {
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
    public PriorityQueueUsingList(Node<Employee> Head, Node<Employee> Tail, int size) {    
        this.head = Head;
        this.tail = Tail;
        this.size = size;
    }
    /**
     * 
     * @return current size of the queue 
     */
    @Override
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
     *
     * @return the first item in the queue but does not remove it
     */
    public Employee peek() { //looks at first element and returns element from head node
        if (isEmpty()) {
            return null;
        } else {
            return head.getElement();
        }
    }
    /**
     *
     * @return the last item in the queue
     */
    public Employee last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();

    }
    /**
     * adds employee to the list, most recent at the top
     * @param e Employee to be add
     */
    @Override
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
    @Override
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
     * @return The largest value in the queue
     */
    @Override
    public Employee getMax() { //acts as poll
        Employee answer;
        Node<Employee> current = head;
        Node<Employee> check = current;
        Node<Employee> peri = current;
        if (isEmpty()) {
            return null;
        }
        if (size <= 1) {/*do nothing*/
        } else if (size == 2) {
            if (current.getElement().getSalary() < current.getNext().getElement().getSalary()) {
                check = head.getNext();
            }
        } else {

            for (int i = 1; i < size; i++) {
                if (check.getElement().getSalary() < current.getNext().getElement().getSalary()) {
                    check = current.getNext();
                    peri = current;
                }
                current = current.getNext();
            }
        }
        answer = check.getElement();
        if (check.equals(head)) {
            head = head.getNext();
        } else {
            peri.setNext(check.getNext());
        }
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
      /**
     * 
     * @param other My List to be copied
     */
    PriorityQueueUsingList(PriorityQueueUsingList other) {
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
    public PriorityQueueUsingList makeCopy() {
        PriorityQueueUsingList copyExternal = new PriorityQueueUsingList(head, tail, size);
        return copyExternal;
    }
}
