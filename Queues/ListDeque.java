import java.util.List; 

public class ListDeque<T> implements DequeInterface<T>{
	private List<T> list;
	private T front, back;
	private final int FRONT_INDEX = 0;
	private int backIndex;  

	public ListDeque(){
		front = null; 
		back = null;
		backIndex = 0;  
	}

	public void addToFront(T newEntry){
		list.add(FRONT_INDEX, newEntry);
		front = newEntry; 
		backIndex++;  
	}

	public void addToBack(T newEntry){
		list.add(newEntry); 
		back = newEntry;
		backIndex = list.size();  
	}

	public T removeFront(){
		T removed = list.get(FRONT_INDEX);
		list.remove(FRONT_INDEX);
		front = list.get(FRONT_INDEX);
		backIndex--; 
		return removed; 
	}

	public T removeBack(){
		T removed = list.get(backIndex); 
		list.remove(backIndex);
		backIndex--; 
		back = list.get(backIndex); 
		return removed; 
	}

	public T getFront(){
		if(!isEmpty()){
			return list.get(FRONT_INDEX);
		} else{
			throw new EmptyQueueException(); 
		}

	}

	public T getBack(){
		if(!isEmpty()){
			return list.get(backIndex);
		} else{
			throw new EmptyQueueException(); 
		}

	}
	@Override
	public boolean isEmpty(){
		return list.isEmpty(); 
	}

	public void clear(){
		list.clear(); 
	}
}