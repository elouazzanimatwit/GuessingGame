package game;

import java.util.Arrays;

public class bagArray <T> implements BagInterface <T>{

	private T[] bagArray;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 10;
	private int capacity;
	private boolean resizable;
	
	@SuppressWarnings("unchecked")
	public bagArray(int capacity, boolean res) {
	bagArray = (T[]) new Object[capacity];
	this.capacity = capacity;
	resizable = res;
	}
	
	public bagArray() {
		this(DEFAULT_CAPACITY, true);
	}
	
	public bagArray (boolean res) {
		this(DEFAULT_CAPACITY, false);
	}
	
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	public boolean add ( T newEntry) {
		if (isFull()) {
			if (resizable)
				doubleCapacity();
			else
				return false;
		}
		
		bagArray[numberOfEntries++] = newEntry;
		return true;
	}
	
	public boolean isArrayFull() {
		if(numberOfEntries == capacity) {
			return true;
		}
		return false;
	}
	
	public void clear() {
		while(remove()!= null) {
			this.remove();
		}
	}
	
	public boolean contains(T anEntry) {
		for(int i = 0; i < numberOfEntries; i++) {
			if(anEntry.equals(numberOfEntries)) {
				return true;
			}
		}
		return false;
	}
	
	public int getFrequencyOf (T anEntry) {
		int count = 0;
		
		for(int i = 0; i < numberOfEntries; i++) {
			if(anEntry.equals(bagArray[i])) {
				count++;
			}
		}
		
		return count;
	}
	
	private boolean isFull () {
		return (numberOfEntries == bagArray.length);
	}
	
	private void doubleCapacity() {
		capacity *= 2;
		bagArray = Arrays.copyOf(bagArray, capacity);
	}
	
	public Object [] toArray () {
		Object [] result = new Object[numberOfEntries];
		for (int i = 0; i < numberOfEntries; i++) {
			result[i] = bagArray[i];
		}
			
		return result;
	}
	
	public T remove() {
		if (isEmpty())
			return null;
		T outData = (T) bagArray[numberOfEntries - 1];
		bagArray[-- numberOfEntries] = null;
		return outData;
	}
	
	public boolean remove(T anEntry) {
		for(int i = 0; i < numberOfEntries; i++){
			if(anEntry.equals(bagArray[i])) {
				bagArray[i] = this.remove();
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}
}
