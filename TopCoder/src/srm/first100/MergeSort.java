package srm.first100;

import java.util.Arrays;
/**
 * 
 * @author root
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		MergeSort st = new MergeSort();
		System.out.println(st.howManyComparisons(new int[]{-2,2,0,0,0,-2,2,0,0,0}));
		System.out.println(st.howManyComparisons(new int[]{2,3,2}));
		

	}
	
	/**
	 * count comparison between 2 lists
	 * @param list1
	 * @param list2
	 * @return
	 */
	public int countComparisonBetweenLists(int[] list1, int[] list2){
		int count=0;
		int i=0,j=0;
		while(i<list1.length && j<list2.length){
			if(list1[i]==list2[j]){
				i++;
				j++;
			}else if(list1[i]>list2[j]){
				j++;
			}else{
				i++;
			}
			count++;
			
		}
		
		return count;
	}
	
	
	
	
	/**
	 * this can be recursive
	 * @param items
	 * @return
	 */
	public int howManyComparisons(int[] items){
		if(items.length==0|| items.length==1){
			return 0;
		}
		
		//split it
		int itmlen = items.length;
		int[] array1 = Arrays.copyOfRange(items, 0, (itmlen/2));
		int[] array2 = Arrays.copyOfRange(items, itmlen/2, itmlen);
		int[] sortedArray1 = array1.clone();
		int[] sortedArray2 = array2.clone();
		Arrays.sort(sortedArray1);
		Arrays.sort(sortedArray2);
			
		return howManyComparisons(array1) + howManyComparisons(array2) + countComparisonBetweenLists(sortedArray1,sortedArray2);
		
		
	}

}
