package snowpost.homework1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;

/**
 *
 * @author Dominick Sora
 */
public class Homework1{
   public static Employee[] e;
   /**
    * Calls methods inside the main in the proper order they are to run to avoid the "Static" issue I receive time to time
    * @param args 
    */
    public static void main(String[] args) {
        System.out.println("\n\n");
        Homework1 hw =  new Homework1();
        hw.readFile();
        //hw.HomeWork2();
        //hw.HomeWork3();
        hw.HomeWork4();
    }

    /**
     * HomeWork 2's work
     */
    public void HomeWork4(){
        MyHashTable ht = new MyHashTable();
        MyHashTable ht2;
        ht.hashTable(e.length);
        for(Employee empl : e){//ENCHANCED for loop
            ht.add(empl);
        }
        ht2 = ht.makeCopy();    
        System.out.println("--------------------SHOWING ALL FROM COPED HASH TABLE--------------------");
        ht2.show(); //if I run this first I get an error
        System.out.println("-------------FINDING 2521,3780,1781,2521 from orginial hashtable-------------");
        print(ht.find(2521));        
        print(ht.find(3780));        
        print(ht.find(1781));        
        print(ht.find(2521));
        MyHashTable ht3;

        System.out.println(ht.equals(ht2));
        ht.makeCopyTest();
    }
    
    /**
     * HomeWork 2's work
     */
    public void HomeWork2(){
        PriorityQueueUsingList pq = new PriorityQueueUsingList();
        PriorityQueueUsingList pq2; 
        for(Employee empl : e){//ENCHANCED for loop
            pq.add(empl);
        }
        pq2 = pq.makeCopy();
        while(!pq2.isEmpty()){
             print(pq2.getMax());
        }
    }
    /**
     * HomeWork 3's work
     */
    public void HomeWork3(){
       PriorityQueueUsingHeap pqh = new PriorityQueueUsingHeap();
       Heapsort(e);
       for(Employee empl : e){//ENCHANCED for loop
            print(empl);
            //System.out.println(empl.getSalary());
        }
    }
    /**
     * 
     * @param a Employee array to be sorted
     */
    public static void Heapsort(Employee[] a){
        PriorityQueueUsingHeap heap = new PriorityQueueUsingHeap();
        PriorityQueueUsingHeap heap2 = new PriorityQueueUsingHeap();
        //int HEAP[] = new int[a.length];
        heap2 = heap.makeCopy();
        for(int i = 0; i < a.length;i++){
            heap.add(a[i]);
            heap2.add(a[i]);
        }
        //heap = heap2;
        Employee max;
        for(int i = 0; i < a.length-1;i++){
            max = heap.getMax();
            e[i] = max;
        }
        System.out.println(heap.getLenght() +" vs " + heap2.getLenght() );
    }
    /**
     * 
     * @param e Employee that needs to be displayed
     * displays employees inline print id first and last name and their salary
     */
    public static void print(Employee e){ //Should switch this to @overRide toString
            System.out.print(e.id + ": ");
            System.out.print(e.first + " ");
            System.out.print(e.last + " ");
            System.out.println("$"+e.salary +"  ");
    }
    /**
     * Reads files from json
     */
    public void readFile(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
        File file = new File("src\\main\\java\\snowpost\\homework1\\employees.json");
             FileReader fr = new FileReader(file);
             e = gson.fromJson(fr, Employee[].class); //got from slides, I dunno if this is the smartest....e is an array, add everything from json to the array, and it works, def need to ask about this
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
