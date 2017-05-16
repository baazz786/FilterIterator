package com.bharadwaz.test.filteriteraor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.bharadwaz.java.filteriterator.FilteringIterator;
import com.bharadwaz.java.filteriterator.IObjectTest;

public class FilteringIteratorTest {
	
	private List<Object> list;
	private Iterator<Object> iterator;

	@Test
	public void prepInput() {
		list = new ArrayList<Object>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		iterator = list.iterator();
		
	}
	
	IObjectTest testObject = new IObjectTest() {
		
		@Override
		public boolean test(Object obj) {
			
			return ((Integer)obj) % 3 == 0;
		}
	};
	
	public void testCase1() {
		
		Iterator<Object> threeMultiples = new FilteringIterator(iterator, testObject);
		
		assertTrue(threeMultiples.hasNext());
		assertEquals(3, threeMultiples.next());
		assertEquals(6, threeMultiples.next());
		assertEquals(9, threeMultiples.next());
		assertFalse(threeMultiples.hasNext());

	}

}
