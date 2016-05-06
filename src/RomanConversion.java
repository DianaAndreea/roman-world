public class RomanConversion {

private static int getNr(char RomanNr){
	switch(RomanNr){
case 'I':
	return 1;
case 'V':
	return 5;
case 'X':
	return 10;
case 'L':
	return 50;
case 'C':
	return 100;
case 'D':
	return 500;
case 'M':
	return 1000;
default:
		throw new IllegalArgumentException(RomanNr + " is not a valid roman numeral.");
	}		
}

/* Conversion of Roman numerals into Arab numbers.
 * First, we validate the number.
 * If the number is validated, then each roman numeral is transformed through the switch case.
 * If the current digit is bigger than the next one, the result will be a sum of the digits and 
 * it will be contained in the variable result.
 * If the current digit is equal with the next one, the result will be a sum of the digits 
 * and it will be contained in a auxiliary variable.
 * If the current digit is lower than the next one, then the lower digit it will become a negative one 
 * and it will be substracted from the bigger one.
 * */
public static int RomanToArab(String RomanNr){
	
int lungime = RomanNr.length();
int result = 0;
int aux = 0;
	
if(!ValidateRoman(RomanNr)){
	System.out.println("Your number, "+ RomanNr +", is not a valid roman numeral. Check the Help tab!");
	return 0;
}

for(int i = 0; i < lungime - 1; i++){	
	
	if(getNr(RomanNr.charAt(i)) > getNr(RomanNr.charAt(i+1))){			
		result += getNr(RomanNr.charAt(i)) + aux;
		aux = 0;
	}
	else if(getNr(RomanNr.charAt(i)) == getNr(RomanNr.charAt(i+1))){					
				aux += getNr(RomanNr.charAt(i));										
	}
	else if(getNr(RomanNr.charAt(i)) < getNr(RomanNr.charAt(i+1))){					
		
		aux = -aux - getNr(RomanNr.charAt(i));
	}			
}						
result += aux + getNr(RomanNr.charAt(lungime - 1));

return result;
}

public static boolean ValidateRoman(String roman){

int lungime = roman.length();
int count = 0;
	
if( lungime == 1 ) return true;		
		
/* Treats all possible cases. 
 * After I can appear only I,V,X and so on.
*/
for(int i = 0; i < lungime - 1; i++){

	if((roman.charAt(i) == 'I' && !("IVX".contains("" + roman.charAt(i+1)))) ||
(roman.charAt(i) == 'V' && !("I".contains("" + roman.charAt(i+1)))) ||
(roman.charAt(i) == 'X' && !("IVXLC".contains("" + roman.charAt(i+1)))) ||
(roman.charAt(i) == 'L' && !("IVX".contains("" + roman.charAt(i+1)))) ||
(roman.charAt(i) == 'D' && !("IVXLC".contains("" + roman.charAt(i+1))))){
	
		return false;
}

/* roman.charAt(j) contains the current number. 
 * This is compared with each digit of the number. 
 * If the current digit is lower than the next digit, countLowerNum grows. 
 * This case prevents numbers like IXC. */

if(getNr(roman.charAt(i)) < getNr(roman.charAt(i+1))){
	int j = i;
	int countLowerNum = 0;
	while(j >= 0){
		if(getNr(roman.charAt(j)) < getNr(roman.charAt(i+1))){
			countLowerNum++;
		}else {
			break;
		}
		if(countLowerNum > 1){
			return false;
		}
		j--;
	}
}

/* This case allows the user to have numbers like XXXIX.
 * For this case, it will return false if the current digit is different than 'XCM', 
 * the length is bigger than 3 and the first digit is equal with the last one.
*/
if(!("XCM".contains("" + roman.charAt(i))) && getNr(roman.charAt(i)) != getNr(roman.charAt(i+1)) && i+2 < lungime && getNr(roman.charAt(i)) == getNr(roman.charAt(i+2))){
		return false;												
}

/* This case is for numbers like XXCX, when exists multiplied lower number than i+1.
 * If the current digit is lower than the next one and the current digit has more than 2 matches before, then returns false.
*/
if(count >= 1 && getNr(roman.charAt(i)) < getNr(roman.charAt(i+1))){
	return false;
}

//Count how many matches are.
if(roman.charAt(i) == roman.charAt(i+1)){
	count++;
}else {
	count = 0;
}	

/* VLD must appear in the number for maximum 1 time. 
 * The rest of them, IXCM, can appear for 3 times (with exceptions like 39).
*/
if((count == 1 && ("VLD".contains("" + roman.charAt(i)))) || count == 3){
			return false;
		}
	}
	return true;
}

//Divide my expression by brackets and operators and replace Roman Numerals to Arab Numbers
	public static String convertExpression(String expression){
		String convertedExpression = expression;
		for(String romanNumber: expression.split("[\\(\\)\\+\\-\\*\\/]")){
			if(romanNumber.trim().equals("")) continue;
			convertedExpression = convertedExpression.replaceFirst(romanNumber, "" + RomanToArab(romanNumber.trim()));
		}
		return convertedExpression;
	}
}
