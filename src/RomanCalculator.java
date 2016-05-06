import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanCalculator {
	
	public static String calculate(String expression){
		
	expression = expression.replaceAll(" ", ""); // eliminate all spaces
	String result = RomanConversion.convertExpression(expression);
	result = "(" + result + ")";
	
	while(result.contains("(")){
		int endIndex = getFirstEndBracketIndex(result);
		int startIndex = getLastStartBracketIndex(result, endIndex);
		String deepBracket = result.substring(startIndex+1, endIndex);
		String res = calculateExpression(deepBracket);		
		result = result.replaceFirst(Pattern.quote("("+deepBracket+")"), res);
		
	}
	return result;
}

//Get the index of the first close bracket	
private static int getFirstEndBracketIndex(String expression){		
	return expression.indexOf(')');
}

//Get the index of the last start bracket
private static int getLastStartBracketIndex(String expression, int firstEndBracketIndex){		
	return expression.lastIndexOf('(', firstEndBracketIndex);
}

private static String calculateExpression(String expression){		
	
	List<String> numbers = new LinkedList<String>(), operators = new LinkedList<String>();
	
	for(String number: expression.split("[\\+\\-\\*\\/]")){
		numbers.add(number);
		expression = expression.replaceFirst(number, "");
	}
	operators.addAll(Arrays.asList(expression.split(""))); // operators are transfered in this list
	
	return calcExpression(numbers, operators);
}

private static String calcExpression(List<String> numbers,List<String> operators){
	
	List<String> nums = new LinkedList<>(numbers), ops = new LinkedList<>(operators);
	
	Pattern pat = Pattern.compile("[\\*\\/]");
	Pattern pat_1 = Pattern.compile("[\\+\\-]");
	
	Matcher mat = pat.matcher(ops.toString());	
	Matcher mat_1 = pat_1.matcher(ops.toString());
	
	while(mat.find()){
		int index = ops.indexOf(mat.group());
		String result = "" ;
		if(ops.get(index).equals("*")){
			result = "" + Integer.parseInt(nums.get(index))*Integer.parseInt(nums.get(index+1));
		}else 
			result = "" + Integer.parseInt(nums.get(index))/Integer.parseInt(nums.get(index+1));			
			nums.remove(index+1);
			nums.remove(index);			
			ops.remove(index);			
			nums.add(index, result);
			mat = pat.matcher(ops.toString());
		}
	
	while(mat_1.find()){
		int index = ops.indexOf(mat_1.group());
		String result = "" ;
		if(ops.get(index).equals("+")){
			result = "" + (Integer.parseInt(nums.get(index))+Integer.parseInt(nums.get(index+1)));
		}else 
			result = "" + (Integer.parseInt(nums.get(index))-Integer.parseInt(nums.get(index+1)));			
			nums.remove(index+1);
			nums.remove(index);			
			ops.remove(index);			
			nums.add(index, result);
			mat_1 = pat_1.matcher(ops.toString());
		}
		return nums.get(0);
	}
	
}
