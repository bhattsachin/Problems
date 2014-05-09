package srm.first100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SRM-20 
 * problem 3 - 1000 points
 * @author root
 *
 */
public class PickTeam {
	List<Integer[]> items = new ArrayList<Integer[]>();

	public static void main(String[] args) {
		PickTeam pt = new PickTeam();
		int[][] base = new int[][]{{0,1,-1,3},{1,0,2,-4},{-1,2,0,2},{3,-4,2,0}};
		//System.out.println(pt.getPairSum(base, new Integer[]{1,1,0,1}));
		System.out.println(Arrays.toString(pt.pickPeople(13, new String[]{"A 0 2 8 7 1 -4 -3 1 8 2 8 2 1 -3 7 1 3 9 -6 -5",
				 "A 2 0 0 7 -7 -5 8 -8 -9 -9 6 -9 -4 -8 8 1 7 0 3 3",
				 "A 8 0 0 -5 -5 -7 1 -3 1 9 -6 6 1 5 6 -9 8 6 -8 -8",
				 "A 7 7 -5 0 7 -5 3 9 8 3 -6 -5 -5 2 -6 2 -2 -1 -2 8",
				 "B 1 -7 -5 7 0 7 -2 -9 3 7 0 -2 1 1 -9 -3 -2 2 1 -2",
				 "B -4 -5 -7 -5 7 0 4 8 6 0 -1 4 1 -2 -9 4 0 -7 6 -2",
				 "B -3 8 1 3 -2 4 0 8 -1 1 -2 -7 5 0 -6 9 0 -3 1 3",
				 "B 1 -8 -3 9 -9 8 8 0 0 -2 5 0 5 8 3 5 2 4 5 4",
				 "C 8 -9 1 8 3 6 -1 0 0 8 -3 8 -6 -4 7 -4 1 -5 5 4",
				 "C 2 -9 9 3 7 0 1 -2 8 0 -9 -6 6 5 -8 -3 -8 2 2 4",
				 "C 8 6 -6 -6 0 -1 -2 5 -3 -9 0 2 7 8 2 -6 -4 -6 4 4",
				 "C 2 -9 6 -5 -2 4 -7 0 8 -6 2 0 0 -3 6 7 -1 2 -4 -2",
				 "D 1 -4 1 -5 1 1 5 5 -6 6 7 0 0 -7 -4 8 -6 -3 4 -6",
				 "D -3 -8 5 2 1 -2 0 8 -4 5 8 -3 -7 0 7 -3 5 -8 5 1",
				 "D 7 8 6 -6 -9 -9 -6 3 7 -8 2 6 -4 7 0 9 -5 -5 -8 3",
				 "D 1 1 -9 2 -3 4 9 5 -4 -3 -6 7 8 -3 9 0 -2 -7 8 -7",
				 "E 3 7 8 -2 -2 0 0 2 1 -8 -4 -1 -6 5 -5 -2 0 6 0 5",
				 "E 9 0 6 -1 2 -7 -3 4 -5 2 -6 2 -3 -8 -5 -7 6 0 4 8",
				 "E -6 3 -8 -2 1 6 1 5 5 2 4 -4 4 5 -8 8 0 4 0 1",
				 "E -5 3 -8 8 -2 -2 3 4 4 4 4 -2 -6 1 3 -7 5 8 1 0"})));

	}

	/**
	 * finds all possible combinations/selections given a n and k (selection size)
	 * n>=k
	 * @param arr
	 * @param curr
	 * @param limit
	 * @param itemsToBeChosen
	 * @param sumSoFar
	 */
	public void enumerateAll(Integer[] arr, int curr, int limit,
			int itemsToBeChosen, int sumSoFar) {
		for (int k = 0; k < 2; k++) {
			// either present or not
			if (k == 1) {
				sumSoFar++;
			}
			arr[curr] = k;

			if (curr >= limit) {
				// only add if this has desired selections
				if (sumSoFar == itemsToBeChosen) {
					this.items.add(arr.clone());
				}

				// exit this
				//return;
			} else {
				enumerateAll(arr, curr+1, limit, itemsToBeChosen, sumSoFar);
			}
		}
	}
	
	/**
	 * Returns pair sum represented by base
	 * @param base
	 * @param arr
	 * @return
	 */
	public int getPairSum(int[][] base, Integer[] arr){
		int sum=0;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]==1){
				for(int k=i+1;k<arr.length;k++){
					if(arr[k]==1){
						sum+=base[i][k];
						
					}
				}
			}
		}
		return sum;
	}
	
	/**
	 * returns most compatible people
	 * @param teamSize
	 * @param people
	 * @return
	 */
	public String[] pickPeople(int teamSize, String[] people){
		int total = people.length;
		int[][] base = new int[total][total];
		String[] items;
		String[] idx=new String[total];
		int i=0;
		for(String peo : people){
			items = peo.split(" ");
			idx[i]=items[0];
			for(int k=1;k<items.length;k++){
				base[i][k-1] = Integer.parseInt(items[k]);
			}
			
			i++;
		}
		
		
		
		/**
		 * list all combinations
		 */
		this.items = new ArrayList<Integer[]>();
		this.enumerateAll(new Integer[total], 0, total-1, teamSize, 0);
		Integer[] best=null;
		int bestScore=-Integer.MIN_VALUE;
		int curr;
		for(Integer[] itm : this.items){
			curr = this.getPairSum(base, itm);
			if(curr>bestScore){
				best = itm;
				bestScore = curr;
			}
		}
		String[] team = new String[teamSize];
		for(int g=0,s=0;g<total;g++){
			if(best[g]==1){
				team[s] = idx[g];
				s++;
			}
		}
		
		return team;
	}

}
