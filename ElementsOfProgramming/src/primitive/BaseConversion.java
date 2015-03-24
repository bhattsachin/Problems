package primitive;

/**
 * Created by bhatt on 3/23/15.
 * Convert String from base 1 to base 2
 */
public class BaseConversion {

    public static void main(String args[]){
        System.out.println(numVal('c'));
        assert(4==5);
    }

    public static String convertBase(int base1, String baseString, int base2){
        assert(base1<=16 && base2<=16);
        int numInBase10=0;
        for(char c : baseString.toCharArray()){
            
        }

        return "ok";
    }


    /**
     * convert a char value to max hex decimal value
     * @param c
     * @return
     */
    public static int numVal(char c){
        if(c>=48 && c<=57){
            return c-48;
        }

        if(c>=97 && c<=102){
            return c-97+10;
        }

        return 0;
    }
}
