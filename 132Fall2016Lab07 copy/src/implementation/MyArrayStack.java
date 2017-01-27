package implementation;
import java.util.NoSuchElementException;


@SuppressWarnings("unchecked")

public class MyArrayStack<T> implements MyStack<T> {


	private static final int originalSize = 10;

	public T[] array;
	public int size;


	T[] twiceArray;


	public MyArrayStack() {
		this.array = (T[]) new Object[originalSize];
	}


	@Override
	public void push(T element) {
		if (this.size == array.length) {
			twiceArray = (T[]) new Object[array.length*2];
			for (int i = 0; i < array.length; i++) {
				twiceArray[i] = array[i];
			}
			array = twiceArray;
			twiceArray = null;
		}
		array[size++] = element;
	}


	@Override
	public T pop() {
		
		if(this.size == 0) {
			return null;
		} else {

			this.size--;
			T result = this.array[size];
			this.array[size] = null;
			return result;

		}
	}
}

