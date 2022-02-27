package Day_004_Dropdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compare_Two_dropdowns {

	public static void main(String[] args) {
		
		List<String> sourceList = new ArrayList<String>();
		sourceList.add("India");
		sourceList.add("UK");
		
		List<String> targetList = new ArrayList<String>();
		targetList.add("India");
		targetList.add("UK");
		
		
		boolean str=sourceList.equals(targetList);
		if(str)
			System.out.println("Matching");
		else
			System.out.println("Not Matched");
		
		
		boolean str1=sourceList.containsAll(targetList);
		if(str1)
			System.out.println("Matching Perfect");
		else
			System.out.println("Matching Failed");
		
		
		 //copying to avoid rearranging original lists
		List<String> list1 = new ArrayList<String>();
		list1.add("India");
		list1.add("UK");
		
		
		
		
		List<String> list2 = new ArrayList<String>(); 
		list2.add("India");
		list2.add("UK");
	 
	    Collections.sort(list1);
	    Collections.sort(list2);      
	    
	    
	    boolean str2=list1.equals(list2);
		if(str2)
			System.out.println("list1 and list2 matched");
		else
			System.out.println("list1 and list2 matching Failed");

	}

}
