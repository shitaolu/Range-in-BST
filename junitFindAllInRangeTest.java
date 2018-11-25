package A3Q1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class junitFindAllInRangeTest {

	@Test
	//test empty map
	public void test1() {
		BSTRange<Integer, String> medals = new BSTRange<>();
		PositionalList<Entry<Integer, String>> medalList;
		
		medalList = medals.findAllInRange(3, 7);
		assertTrue(medalList.size() == 0);
		
		medalList = medals.findAllInRange(-1, -10);
		assertTrue(medalList.size() == 0);
	}
	
	
	@Test
	//test k1 > k2
	public void test2() {
		BSTRange<Integer, String> medals = new BSTRange<>();
		PositionalList<Entry<Integer, String>> medalList;
		
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
        
		medalList = medals.findAllInRange(7, 3);
		assertTrue(medalList.size() == 0);
		
		medalList = medals.findAllInRange(-1, -10);
		assertTrue(medalList.size() == 0);
	}
	
	@Test
	//test k1 = k2
	public void test3() {
		BSTRange<Integer, String> medals = new BSTRange<>();
		PositionalList<Entry<Integer, String>> medalList;
		List<Integer> actual = new ArrayList<>();

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
        
		medalList = medals.findAllInRange(3, 3);
		for (Entry<Integer, String> entry : medalList) {
			actual.add(entry.getKey());
		}
		Integer[] expected = {3};	
		assertEquals(Arrays.asList(expected), actual);
	}
	
	@Test
	public void test4() {
		BSTRange<Integer, String> medals = new BSTRange<>();

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
        
        Random rnd = new Random();
        for (int i = 0; i < 10000; i++) {
    		PositionalList<Entry<Integer, String>> medalList;
    		List<Integer> actual = new ArrayList<>();
        	int k1 = rnd.nextInt(10) + 1;
        	int k2 = rnd.nextInt(10) + 1;
    		medalList = medals.findAllInRange(k1, k2);

    		if (k1 > k2) {
    			assertTrue(medalList.size() == 0);
    		}
    		else {
        		List<Integer> expected = new ArrayList<>();

        		for (Entry<Integer, String> entry : medalList) {
        			actual.add(entry.getKey());
        		}

        		for (int j = k1; j <= k2; j++) {
        			expected.add(j);
        		}
        		assertEquals(expected, actual);
    		}
        }
	}
	
	
	@Test
	public void test5() {
		BSTRange<Integer, String> medals = new BSTRange<>();

        medals.put(7, "Norway");
        medals.put(4, "Germany");
        medals.put(10, "Canada");
        medals.put(1, "USA");
        medals.put(3, "Netherlands");
        medals.put(8, "Sweden");
        medals.put(9, "South Korea");
        medals.put(2, "Switzerland");
        medals.put(5, "France");
        medals.put(6, "Austria");
        
        Random rnd = new Random();
        for (int i = 0; i < 10000; i++) {
    		PositionalList<Entry<Integer, String>> medalList;
    		List<Integer> actual = new ArrayList<>();
        	int k1 = rnd.nextInt(10) + 1;
        	int k2 = rnd.nextInt(10) + 1;
    		medalList = medals.findAllInRange(k1, k2);

    		if (k1 > k2) {
    			assertTrue(medalList.size() == 0);
    		}
    		else {
        		List<Integer> expected = new ArrayList<>();

        		for (Entry<Integer, String> entry : medalList) {
        			actual.add(entry.getKey());
        		}

        		for (int j = k1; j <= k2; j++) {
        			expected.add(j);
        		}
        		assertEquals(expected, actual);
    		}
        }
	}
	
	
	@Test
	public void test6() {
		BSTRange<Integer, String> medals = new BSTRange<>();

        medals.put(-10, "Norway");
        medals.put(-7, "Germany");
        medals.put(-20, "Canada");
        medals.put(-15, "USA");
        medals.put(1, "Netherlands");
        medals.put(4, "Sweden");
        medals.put(8, "South Korea");
        medals.put(2, "Switzerland");
        medals.put(9, "France");
        medals.put(6, "Austria");
        
        Random rnd = new Random();
        for (int i = 0; i < 10000; i++) {
    		PositionalList<Entry<Integer, String>> medalList;
    		List<Integer> actual = new ArrayList<>();
        	int k1 = rnd.nextInt(41) - 20;
        	int k2 = rnd.nextInt(41) - 20;
    		medalList = medals.findAllInRange(k1, k2);

    		if (k1 > k2) {
    			assertTrue(medalList.size() == 0);
    		}
    		else {
        		List<Integer> expected = new ArrayList<>();
        		List<Integer> keys = new ArrayList<>();
        		
        		for (Integer key : medals.keySet()) {
        			keys.add(key);
        		}

        		for (Entry<Integer, String> entry : medalList) {
        			actual.add(entry.getKey());
        		}

        		for (int j = k1; j <= k2; j++) {
        			if (keys.contains(j)) {
            			expected.add(j);
        			}
        		}
        		assertEquals(expected, actual);
    		}
        }
	}
}
