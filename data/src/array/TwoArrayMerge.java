package array;
/**
 * 实现两个有序数组合并为一个有序数组
 * @author leo
 *
 */
public class TwoArrayMerge {

	public int[] arrayMerge(int[] fArray,int[] sArray) {
		int[] mArray = new int[fArray.length+sArray.length];
		
		if(fArray[fArray.length-1]<sArray[0]) {
			mArray = connectArray(fArray,sArray);
			return mArray;
		}
		if(sArray[sArray.length-1]<fArray[0]) {
			mArray = connectArray(sArray,fArray);
			return mArray;
		}
		
		int fArrayIdx = 0;
		int sArrayIdx = 0;
		int mArrayIdx = 0;
		while(fArrayIdx <= fArray.length-1 || sArrayIdx <= sArray.length-1) {
			if(fArray[fArrayIdx] < sArray[sArrayIdx]) {
				mArray[mArrayIdx] = fArray[fArrayIdx];
				fArrayIdx++;
			}else {
				mArray[mArrayIdx] = sArray[sArrayIdx];
				sArrayIdx++;
			}
			
			if(fArrayIdx > fArray.length-1) {
				System.arraycopy(sArray, sArrayIdx, mArray, fArray.length+sArrayIdx, sArray.length-sArrayIdx);
				return mArray;
			}
			
			if(sArrayIdx > sArray.length-1) {
				System.arraycopy(fArray, fArrayIdx, mArray, sArray.length+fArrayIdx, fArray.length-fArrayIdx);
				return mArray;
			}
			
			mArrayIdx++;
		}
		return null;
		
		
	}

	private int[] connectArray(int[] fArray, int[] sArray) {
		int[] mArray = new int[fArray.length+sArray.length];
		System.arraycopy(fArray, 0, mArray, 0, fArray.length);
		System.arraycopy(sArray, 0, mArray, fArray.length, sArray.length);
		return mArray;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,8,11,22,33};
		int[] b = {5,6,12,16,88};
		int[] arrayMerge = new TwoArrayMerge().arrayMerge(a, b);
		for (int i : arrayMerge) {
			System.out.print(i+"...");
		}
	}
}
