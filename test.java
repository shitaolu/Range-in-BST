package A3Q1;
import java.util.*;

/**
 * Tests BSTRange
 * 
 * @author jameselder
 */
public class test {

    public static void main(String[] args) {
        BSTRange<Integer, String> medals = new BSTRange<Integer, String>();
        PositionalList<Entry<Integer, String>> medalList;
        Iterator<Entry<Integer, String>> entryIter;
        int k1 = 3;
        int k2 = 7;
        long startTime = System.nanoTime();
        System.out.println("2018 Winter Olympics Medal Standings:");
        
        //test case 1:
        try { //should output nothing
            medalList = medals.findAllInRange(k1, k2);
            entryIter = medalList.iterator();

            System.out.print("From " + k1 + " to " + k2 + " are: ");
            while (entryIter.hasNext()) {
                System.out.print(entryIter.next().getValue());
            }
            System.out.println();
        } catch (Exception x) {
            System.out.println("Test Case 1 Failed");
        }

        medals.put(1, "Norway");
        medals.put(2, "Germany");
        medals.put(3, "Canada");
        medals.put(4, "USA");
        medals.put(5, "Netherlands");
        medals.put(6, "Sweden");
        medals.put(7, "South Korea");
        medals.put(8, "Switzerland");
        medals.put(9, "France");
        medals.put(10, "Austria");
        
//        medals.put(1, "1_Norway");
//        medals.put(7, "7_South Korea");
//        medals.put(2, "2_Germany");
//        medals.put(3, "3_Canada");
//        medals.put(9, "9_France");
//        medals.put(5, "5_Netherlands");
//        medals.put(4, "4_USA");
//        medals.put(8, "8_Switzerland");
//        medals.put(6, "6_Sweden");
//        medals.put(10, "10_Austria");
        
        //test case 2: 
        try { //should output Canada, USA, Netherlands, Sweden, South Korea 
            medalList = medals.findAllInRange(k1, k2);
            entryIter = medalList.iterator();

            System.out.print("From " + k1 + " to " + k2 + " are: ");
            while (entryIter.hasNext()) {
                System.out.print(entryIter.next().getValue() + " ");
            }
            System.out.println();
        } catch (Exception x) {
            System.out.println("Test Case 2 Failed");
        }
        
       medals.put(-6, "-6_Mexico");
       medals.put(-10, "-10_Cuba");
       medals.put(-9, "-9_Russia");
       medals.put(-12, "-12_Japan");
       //test case 3: 
       k1 = -10;
       k2 = -9;
        try { //should output nothing
            medalList = medals.findAllInRange(k1, k2);
            entryIter = medalList.iterator();

            System.out.print("From " + k1 + " to " + k2 + " are: ");
            while (entryIter.hasNext()) {
                System.out.print(entryIter.next().getValue() + " ");
            }
            System.out.println();
        } catch (Exception x) {
            System.out.println("Test Case 3 Failed");
        }
       
       //test case 4: 
       k1 = 5;
       k2 = 4;
       try { //should output nothing
            medalList = medals.findAllInRange(k1, k2);
            entryIter = medalList.iterator();

            System.out.print("From " + k1 + " to " + k2 + " are: ");
            while (entryIter.hasNext()) {
                System.out.print(entryIter.next().getValue());
            }
            System.out.println();
        } catch (Exception x) {
            System.out.println("Test Case 4 Failed");
        }

       k1 = 3;
       k2 = 3;
       try {//should output Canada
            medalList = medals.findAllInRange(k1, k2);
            entryIter = medalList.iterator();

            System.out.print("From " + k1 + " to " + k2 + " in are: ");
            while (entryIter.hasNext()) {
                System.out.print(entryIter.next().getValue());
            }
            System.out.println();
        } catch (Exception x) {
            System.out.println("Test Case 5 Failed");
        }

       k1 = -10;
       k2 = 10;
       try {//should output Norway, Germany, Canada, USA, Netherlands, Sweden, South Korea, Switzerland, France, Austria
            medalList = medals.findAllInRange(k1, k2);
            entryIter = medalList.iterator();

            System.out.print("From " + k1 + " to " + k2 + " are: ");
            while (entryIter.hasNext()) {
                System.out.print(entryIter.next().getValue() + " ");
            }
            System.out.println();
        } catch (Exception x) {
            System.out.println("Test Case 6 Failed");
        }
       
       System.out.println();
       long stopTime = System.nanoTime();
       double elapsedTime = (double) (stopTime - startTime) / 1000000; //in msec
       System.out.println("Execution time: " + elapsedTime);
    }
}