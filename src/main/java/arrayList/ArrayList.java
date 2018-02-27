package arrayList;

import java.util.Arrays;

public class ArrayList<T>{

	private static final int INITIAL_CAPACITY = 2;

	private T[] arr;
	private int capacity;
	private int count;

	public ArrayList(int capacity){
		this.capacity = capacity;
		this.arr = (T[]) new Object[this.capacity];
	}
	
	public ArrayList(){
		this.capacity = INITIAL_CAPACITY;
		this.arr = (T[]) new Object[this.capacity];
	}

	public int getCount() {
		return this.count;
	}


	public T get(int index) {
		if (index < 0 || index > this.count - 1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return this.arr[index];
	}


	public void add(T element) {
		if (count == capacity) {
			increaseCapacity();
		}
		this.arr[this.count] = element;
		this.count++;
	}

	public T removeAt(int index) {
		if (index < 0 || index > this.count - 1) {
			throw new IllegalArgumentException();
		}
		T element = this.arr[index];
		this.arr[index] = null;
		shift(index);
		this.count--;
		if (this.count < this.capacity / 3) {
			reduceCapacity();
		}
		return element;
	}
	

	public void set(int index, T item) {
		if (index < 0 || index > this.count - 1) {
			throw new IllegalArgumentException();
		}
		this.arr[index] = item;
	}

	private void increaseCapacity() {
		T[] newArr = Arrays.copyOf(this.arr, this.capacity * 2);
		this.capacity *= 2;
		this.arr = newArr;
	}

	private void reduceCapacity() {
		T[] newArr = Arrays.copyOf(this.arr, this.capacity / 2);
		this.capacity /= 2;
		this.arr = newArr;
	}

	private void shift(int index) {
		for (int i = index; i < this.count - 1; i++) {
			T temp = this.arr[i];
			this.arr[i] = this.arr[i + 1];
			this.arr[i + 1] = temp;
		}
	}
}
