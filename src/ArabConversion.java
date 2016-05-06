import java.util.LinkedHashMap;

public class ArabConversion {	
	public static String ArabToRoman(int aNumber){
        String romanNumber = "";

        for(int i=0; i<numeralMap.size(); i++){
            while(aNumber >= GetNumberAt(i)){
            	romanNumber += GetNumeralAt(i);
                aNumber -= GetNumberAt(i);
            }
        }
 
        return romanNumber;
    }
	
	 private static LinkedHashMap<Integer, String> numeralMap = new  LinkedHashMap<Integer, String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		put(1000,"M");
		put(900,"CM");
		put(500,"D");
		put(400,"CD");
		put(100,"C");
		put(90,"XC");
		put(50,"L");
		put(40,"XL");
		put(10,"X");
		put(9,"IX");
		put(5,"V");
		put(4,"IV");
		put(1,"I");
	}};
	
	private static int GetNumberAt(int index){
		return (int)numeralMap.keySet().toArray()[index];
	}
	
	private static String GetNumeralAt(int index){
		return "" + numeralMap.values().toArray()[index];
	}
}
