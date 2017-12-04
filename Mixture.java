import java.util.ArrayList;
import java.util.List;

public class Mixture {
	public static void main(String[] args) {
		String str = "23jjkjkj112j%%07jkj-31ab&&-23";
		List<String> posNumList = new ArrayList<String>();
		List<String> negNumList = new ArrayList<String>();
	
		String posNum="";
		String negNum="";
		boolean negFlag=false;
		 for (int i = 0; i < str.length(); i++) {
		        Character character = str.charAt(i);
		        
		        if(character=='-') {
		        	System.out.print("setting neg flag");
		        	negFlag=true;
		        	continue;
		        }
		       
		        //accumulate all digits for positive
		        else if (Character.isDigit(character) && !negFlag) {
		        	if(character=='0') {
		        		continue;
		        	}
		        	 posNum += character;
			           
			        
			        continue;
		        }
		        //if no more digit is found
		        else if(!Character.isDigit(character)) {
		        	if(!posNum.equals("") ) {
		        		posNumList.add(posNum);
		        		System.out.println("added to posNumlist");
		        	}
		        	else if ( !negNum.equals("")) {
		        		
		        		System.out.println("added to negNumList");
		        		negNumList.add(negNum);
		        		
		        	}
		        	
		        	posNum="";
		        	negNum="";
		        	negFlag=false;
		        	continue;
		        }
		       //add to consecutive neg number
		        else if(Character.isDigit(character) && negFlag) {
		        	System.out.println("add to neg num");
		        	if(character=='0') {
		        		continue;
		        	}
		        	 negNum += character;
		        	
		        	 System.out.print("This is neg num: "+negNum);

			            continue;
		        }
		
		       
		 }
		 if(!negNum.equals("")) {
			 negNumList.add(negNum);
     		System.out.println("added to negNumlist");
		 }
		if(!posNum.equals("")) {
			 posNumList.add(posNum);
	     		System.out.println("added to posNumlist");
		}
		System.out.println(posNumList);
		System.out.println(negNumList);
		//add both posNum and negNum
		int sum=0;
		for(String elt:posNumList) {
			sum+=Integer.parseInt(elt);
		}
		for(String elt:negNumList) {
			sum-=Integer.parseInt(elt);
		}
		System.out.println(sum);
		    }
		
	}

	
