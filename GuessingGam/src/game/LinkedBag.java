package game;

import utils.Node;

@SuppressWarnings({ "unchecked" })
public class LinkedBag <T> implements BagInterface <T> {
	
	private Node <T> head;
	private int numberOfEntries;
	
	public LinkedBag() {
		head = null;
		numberOfEntries = 0;
	}
	
	@Override
	public boolean add(T newEntry) {
		Node <T> toAdd = new Node<>(newEntry);
		toAdd.setNext(head);
		head = toAdd;
		numberOfEntries++;
		return true;
	}
	
	public boolean contains(T anEntry) {
		for(int i = 0; i < numberOfEntries; i++) {
			if(anEntry.equals(numberOfEntries)) {
				return true;
			}
		}
		return false;
	}

	public T remove() {
		if(isEmpty())
			return null;
		T outData = head.getData();
		head = head.getNext();
		numberOfEntries --;
		return outData;
	}
	
	public boolean remove(T anEntry) {
		for(Node <T> curr = head; curr != null; curr = curr.getNext()) {
			if(anEntry.equals(curr.getData())) {
				curr.setData(head.getData());
				head = head.getNext();
				numberOfEntries--;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	
	@Override
	public Object[] toArray(){
		Object[] result = new Object [numberOfEntries];
		int index = 0;
		for(Node <T> curr = head; curr!= null; curr = curr.getNext()) {
			result[index++] =curr.getData();
		}
		return result;
	}
	
	@Override
	public int getFrequencyOf(T anEntry) {
		int count =0;
		for(Node <T> curr = head; curr != null; curr = curr.getNext()) {
			if(anEntry.equals(curr)) {
				count+= 1;
			}
		}
		
		return count;
	}

	@Override
	public void clear() {
		head = null;
		numberOfEntries = 0;
	}
	
	@Override
	public boolean equals(Object o) {
		LinkedBag <T> otherBag = (LinkedBag <T>) o;
		if (otherBag.getCurrentSize() != numberOfEntries)
		return false;
		otherBag = otherBag.copy();
		for (Node <T> currNode = head; currNode != null; currNode =
		currNode.getNext()) {
		if (!otherBag.remove(currNode.getData()))
		return false;
		}
		return true;
	}
	
	public LinkedBag <T> union (LinkedBag <T> otherBag) {
		LinkedBag <T> result = otherBag.copy();
		for (Node <T> currNode = head; currNode != null; currNode =
		currNode.getNext())
			result.add (currNode.getData());
		return result;
	}
	
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	public LinkedBag <T> copy(){
		LinkedBag <T> result = new LinkedBag <> ();
		for (Node <T> currNode = head; currNode != null; currNode = currNode.getNext())
			result.add (currNode.getData());
		return result;
	}
	
	public LinkedBag<T> intersection(LinkedBag<T> other) {
		LinkedBag <T> result = new LinkedBag<>();
		other = other.copy();
		for(Node<T> curr = head; curr != null; curr.getNext()) {
			T item = curr.getData();
			if(other.remove(item))
				result.add(item);
		}
		
		return result;
	}
}
