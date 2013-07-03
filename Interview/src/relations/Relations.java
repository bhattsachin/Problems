package relations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Relations {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		Map<String, List<String>> maps = new HashMap<String, List<String>>();
		
		
		BufferedReader br = new BufferedReader(new FileReader("/Users/bhatt/git/Problems/Interview/src/relations/pairs.txt"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        String[] pair;
	        String[] part2;
	        List<String> values;
	        String key;
	        String value;
	        String value2;

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            //System.out.println(line);
	            line = br.readLine();
	            if(line!=null && line.contains("~")){
		            pair = line.split("~");
		            part2 = pair[1].split(" | ");
		            //System.out.println(pair[0].trim() + "->" + part2[1]);
		            //System.out.println(pair[0].trim() + "->" + part2[3]);
		            key = new String(pair[0].trim());
		            value = new String(part2[1]);
		            value2 = new String(part2[3]);
		            if(maps.containsKey(key)){
		            	 values = maps.get(key);
		            	 values.add(part2[1]);
		            	 values.add(part2[3]);
		            	 maps.put(key,  values);
		            	 
		            }else{
		            	values = new ArrayList<String>();
		            	values.add(value);
		            	values.add(value2);
		            	maps.put(key, values);
		            	
		            }
		           
	            }
	            
	        }
	        String everything = sb.toString();
	        //System.out.println(everything);
	    } finally {
	        br.close();
	    }
	    //Set<String> keys = maps.keySet();
		for(String keys : maps.keySet()){
			System.out.println(keys + " -> " + maps.get(keys));
		}
		

	}

}
