package snowpost.homework1;

/**
 *
 * @author Dominick Sora
 */
public interface PriorityQueue {

    public void add(Employee e);    
    
    public Employee getMax();
    
    public void clear();
    
    
    public int getLenght();
    
    public boolean isEmpty();
    
}
