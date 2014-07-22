package srm.first100;

public class IsomorphicWord {

	public static void main(String[] args) {
		IsomorphicWord word = new IsomorphicWord();
		System.out.println(word.isIsomorphic("abca".toCharArray(), "zbxz".toCharArray()));

	}
	
	boolean isIsomorphic(char[] source, char[] target){
		
		/**
		 * if length not same, discard
		 */
		if(source.length!=target.length){
			return false;
		}
		
		/**
		 * if all are small letter alphabets
		 */
		char[] map = new char[123];
		char[] reversemap = new char[123];
		
		for(int i=0;i<source.length;i++){
			if(map[source[i]]=='\u0000' && reversemap[target[i]]=='\u0000'){
				map[source[i]] = (char) (target[i]);
				reversemap[target[i]] = (char) source[i];
			}else{
				if(map[source[i]]!=target[i] || reversemap[target[i]]!=source[i]){
					return false;
				}
			}
			
		}
		
		return true;
	}

}
