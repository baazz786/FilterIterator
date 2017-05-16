package com.bharadwaz.java.filteriterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilteringIterator implements Iterator<Object> {

	private Iterator<Object> myIterator;
	private IObjectTest myTestObject;
	private Object nextObj;

	/**
	 * @param myIterator
	 * @param myTestObject
	 */
	public FilteringIterator(Iterator<Object> myIterator, IObjectTest myTestObject) {
		this.myIterator = myIterator;
		this.myTestObject = myTestObject;
		findNextMatch();
	}

	@Override
	public boolean hasNext() {
		return nextObj != null;
	}

	@Override
	public Object next() {
		if(nextObj == null)
			throw new NoSuchElementException("No more elements in the Iterator that match the filter");
		Object matchedObj = nextObj;
		findNextMatch();
		return matchedObj;
	}

	private void findNextMatch() {
		nextObj = null;
		while(myIterator.hasNext()){
			Object obj = myIterator.next();
			if(obj != null && myTestObject.test(obj) ){
				nextObj = obj;
				break;
			}
		}
		
	}
}
