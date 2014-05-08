package srm.first100;

/**
 * SRM 25
 * @author root
 *
 */
public class Inventory {

	public static void main(String[] args) {
		Inventory ivt = new Inventory();
		System.out.println(ivt.monthlyOrder(new int[]{1115,7264,3206,6868,7301}, new int[]{1,3,9,4,18}));
		System.out.println(ivt.monthlyOrder(new int[]{8773}, new int[]{16}));
		System.out.println(ivt.monthlyOrder(new int[]{75,120,0,93}, new int[]{24,30,0,30}));
		System.out.println(ivt.monthlyOrder(new int[]{5}, new int[]{15}));
	}
	
	public int monthlyOrder(int[] sales, int[] daysAvailable){
		double total=0;
		int size=0;
		
		for(int i=0;i<sales.length;i++){
			/**
			 * only compute if number of days are more
			 */
			if(daysAvailable[i]>0){
				total = total + ((double)(sales[i]*30)/(daysAvailable[i]));
				size++;
			}
		}
		total = total - 1e-9;
		total /=size;
		
		return (int)Math.ceil(total);
	}

}
