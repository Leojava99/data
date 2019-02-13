package array;
/**
 * 实现支持动态扩容的数组
 * @author leo
 * @param <T>
 *
 */
public class DynArray<T> {

	T[] arr;
	int size;
	
	@SuppressWarnings("unchecked")
	public DynArray(int capacity) {
		size = 0;
		arr = (T[]) new Object[capacity];
	}
	public DynArray() {
		this(3);
		System.out.println("初始大小"+arr.length);
	}
	
	public void add(int index,T t) {
		if(index < 0 || index > arr.length) {
			throw new IllegalArgumentException("位置无法插入");
		}
		if(size == arr.length) {
			expand(arr.length*2);
		}
		
		for (int i = size-1; i >= index; i--) {
			arr[i+1]=arr[i];
		}
		arr[index] = t;
		for (T e : arr) {
			System.out.print(e+"..");
		}
		System.out.println();
		size++;
	}
	
	//数组动态扩容方法
	private void expand(int capacity) {
		@SuppressWarnings("unchecked")
		T[] newArr = (T[]) new Object[capacity];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
		System.out.println("扩容后的大小"+arr.length);
	}
	
	
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		
		DynArray<Object> dd = new DynArray<>();
		dd.add(0, a);
		dd.add(1, b);
		dd.add(2, c);
		dd.add(3, d);
		dd.add(4, e);
		dd.add(5, f);
	}
	
}
