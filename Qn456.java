import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Qn456 {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put(0, 1);
        hm.put(1, 3);
        hm.put(2, 5);
        hm.put(3, 7);
        hm.put(4, 9);
        hm.put(5, 11);
        System.out.println("=== HashMap Implementation ===");
        System.out.println("Before: " + hm);
        putAndSort(hm, 6);
        System.out.println("After putAndSort: " + hm);
        swapValues(hm, 1, 5);
        System.out.println("After swapValues: " + hm);
        System.out.println("Random HashMap Index: " + randomHashMap());
    }
    public static void putAndSort(HashMap hm, int v){
        // if new value is bigger, simply append element to hmap
        int size = hm.size();
        if ((int)hm.get(size-1)<v){
            hm.put(size, v);
        }
        else{
            int i = 0;
            // find index to insert
            while ((int)hm.get(i)<v){
                ++i;
            }
            // check starting from index i
            // move all other above elements' key  up by 1 (to make space for new element), starting from top down
            // top is index of last element, we make top element key up by 1 (e.g. 5=11 -> 6=11)
            int top = size-1;
            for (int j=i;j<size;++j){
                hm.put(top+1,hm.get(top));
                --top;
            }
            hm.put(i, v);
        }
    }
    public static void swapValues(HashMap hm, int v1, int v2){
        int tempStore1 = (int)hm.get(v1);
        int tempStore2 = (int)hm.get(v2);

        // remove and put to swap
        hm.remove(v1);
        hm.put(v1, tempStore2);
        hm.remove(v2);
        hm.put(v2, tempStore1);
    }
    public static int randomHashMap(){
        Random rand = new Random();
        HashMap hm = new HashMap();
        AtomicInteger randIndex = new AtomicInteger(-1);
        // generate 500 random integers
        for (int i=0;i<500;++i){
            // put 1000-9999, in random order
            hm.put(i, rand.nextInt(1000, 10000));
        }
        int randInt = rand.nextInt(1000,10000);
        System.out.println("RandInt: " + randInt);
        if (hm.containsValue(randInt)){
            hm.forEach((k,v)->{
               if ((int)v==randInt){
                   randIndex.set((int)k);
                   // need to find a way to break out of foreach to get first hit instead of last hit
                   // otherwise, use same loop method as in linkedlist (q123), will work fine.
               }
            });
        }
        return randIndex.get();
    }
}