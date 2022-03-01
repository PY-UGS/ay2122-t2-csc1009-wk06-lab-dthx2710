import java.util.LinkedList;
import java.util.Random;

public class Qn123 {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.add(1);
        llist.add(3);
        llist.add(5);
        llist.add(7);
        llist.add(9);
        llist.add(11);
        System.out.println("=== LinkedList Implementation ===");
        System.out.println("Before: " + llist);
        addAndSort(llist, 6);
        System.out.println("After addAndSort: " + llist);
        swapValues(llist, 1, 5);
        System.out.println("After swapValues: " + llist);
        System.out.println("Random LinkedList Index: " + randomLinkedList());
    }
    public static void addAndSort(LinkedList llist, int v){
        // if new value is bigger, simply append to list
        int size = llist.size();
        if ((int)llist.get(size-1)<v){
            llist.add(v);
        }
        // bruteforce method: check elements 1 by 1 to see which index position to insert into
        // O(n) complexity
        else{
            int i = 0;
            while ((int)llist.get(i)<v){
                ++i;
            }
            llist.add(i, v);
        }
    }
    public static void swapValues(LinkedList llist, int v1, int v2){
        int index1 = llist.indexOf(v1);
        int index2 = llist.indexOf(v2);
        if (index1 == -1 || index2 == -1){
            return;
        }
        // swap set
        llist.set(index1, v2);
        llist.set(index2, v1);
    }
    public static int randomLinkedList(){
        Random rand = new Random();
        LinkedList llist = new LinkedList();
        int index = -1;
        // generate 500 random integers
        for (int i=0;i<500;++i){
            // add 1000-9999, in random order
            llist.add(rand.nextInt(1000, 10000));
        }
        int randInt = rand.nextInt(1000,10000);
        System.out.println("RandInt: " + randInt);
        for (int i=0;i<500;++i){
            if ((int)llist.get(i)==randInt){
                index = i;
                break;
            }
        }
        return index;
    }
}