package snowpost.homework1;


public class MyHashTable {
    MyList  list = new MyList();
    public MyList[] buckets;
    MyHashTable copyInternal;
    private int size;
    /**
     * default constructor 
     */
    public MyHashTable() {
        buckets = new MyList[size];
        size = 1000;
    }
    /**
     * 
     * @param buckets1
     * @param size1 
     */
    public MyHashTable(MyList[] buckets1, int size1) {
        this.buckets = buckets1;
        this.size = size1;
    }
    /**
     * 
     * @param Size the amount of employees read from the json
     * initialize the array 
     */
    public void hashTable(int Size) {
        //size = Size;
        buckets = new MyList[Size];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyList();
        }
    }
    /**
     * 
     * @param e current instance of employee
     * finds the hash value of calling hashCode and adding it to the array
     */
    void add(Employee e) {
        int hashValue = e.getId();
        int index = hashValue % buckets.length;
        buckets[index].add(e);
    }
    /**
     * 
     * @param id id of the current instance of employee
     * @return the hashCode
     */
    public int hashCode(int id) { //1177
        int hash = 7;
        hash = 31 * hash + (int) id;
        return hash;
    }
    /**
     * 
     * @param id employee id that is to be found
     * @return the corresponding employee index
     */
    Employee find(int id) {
        Employee answer = null;
        int hashValue = id;
        int index = hashValue % buckets.length;
        answer = buckets[index].getFind(id);
        return answer;
    }
    /**
     * Shows all employees in the array
     */
    void show() {
        for (int i = 0; i < buckets.length; i++) {
            MyList currentBucket = buckets[i];
            while (!currentBucket.isEmpty()) {
                Employee e = currentBucket.getMax();
                Homework1.print(e);
            }
        }
    }
    /**
     * 
     * @param other MyHashTable to be copied
     */
    MyHashTable(MyHashTable other) {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = other.buckets[i].makeCopy();
        }
    }
    /**
     * @return copy of the current instance of the hashTable
     */
    public MyHashTable makeCopy() {
        MyList[] buckets2 = new MyList[size];
        for (int i = 0; i < size; i++) {
            buckets2[i]= buckets[i].makeCopy();
        }
        MyHashTable copyExternal = new MyHashTable(buckets2, size);
        return copyExternal;
    }
    
    public void makeCopyTest() {
        MyList[] buckets2 = new MyList[size];
        for (int i = 0; i < size; i++) {
            buckets2[i]= buckets[i].makeCopy();
        }
        System.out.println(buckets.equals(buckets2));
    }
}
