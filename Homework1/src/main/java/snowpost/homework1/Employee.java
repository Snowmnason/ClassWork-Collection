package snowpost.homework1;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Dominick Sora
 */
public class Employee {
    @SerializedName("id")
    int id;
    @SerializedName("first")
    String first;
    @SerializedName("last")
    String last;
    @SerializedName("salary")
    double salary;
    /**
     * default constructor 
     */
    Employee(){
        id = 0;        first = "";        last = "";        salary = 0;
    }
    /**
     * 
     * @param id Employees identifying int
     * @param first Employees first name as string
     * @param last Employees Last name as string
     * @param salary Employees salary  int
     */
    public  Employee(int id, String first, String last, double salary) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.salary = salary;
    }
    /**
    * @param other
    * which is the current instance of Employee to make a copy of it 
     */
    public Employee(Employee other){
        id = other.getId();
        first = other.getFirst();
        last = other.getLast();
        salary = other.getSalary();
        
    }
    /**
     * method called to return a deep copy of Employee
    */
    public Employee makeCopy(){
        Employee copy = new Employee(id, first, last, salary);
        
        return copy;
    }
    
    
    /**
     * getter and Setters
    */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

 
    
    
}
