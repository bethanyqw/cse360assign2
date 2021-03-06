/******************
 * Bethany Whitehead
 * Class ID: 122
 * Assignment 2
 * simpleList file contains:
 * add method
 * remove method
 * count method
 * inString method
 * search method
 * append method
 * first method
 * last method
 * size method
 ********************/

/******************************************************
 * Description:
 * simpleList has several methods that manipulate the 
 * contents of an array called list. 
 ******************************************************/

package cse360assign2;
import java.util.Arrays;
import java.util.Scanner;

//define private globals int array and int count
public class SimpleList 
{
	private int list[];
	//list = Arrays.copyOf(list, (list.length/2) + list.length);
	private int count;
	
	//method that sets count to 0 and array list to store 10 ints
	public SimpleList() 
	{
		count = 0;
		list = new int[10];
	}
	
	//method that adds any parameter passes in to the list to the beginning
	//the rest of the list is then shifted to the right
	//if the list is full the last item will "fall off"
	//parameter integer num
	//returns nothing
	public void add(int num) 
	{
		if(count == list.length)
        {
            list = Arrays.copyOf(list, (list.length/2) + list.length);
            
            for(int index = count - 1; index >= 0; index--)
       		{
       			list[index + 1] = list[index];
       		}
               list[0] = num;
        }
		else 
		{
	   		for(int index = count - 1; index >= 0; index--)
	   		{
	   			list[index + 1] = list[index];
	   			//System.out.println(list[index]);
	   		}
   		list[0] = num;
		}
		count++;
    }
	
	
	//method that removes parameter from array list
	//the elements of the list are then adjusted 
	//takes parameter num
	//returns nothing
	public void remove(int num)
	{
		int numEmpty = 0;
		int removeIndex = 0;
		boolean inList = false;
		
		//searches through array
		for(int element : list) 
		{
			//if n is in the array
			if(element == num)
			{
				//sets inList to true
				inList = true;
			}
			
		}
		//if statement to confirm that element is in list
		if(inList = true) 
		{
			//for loop to get the index of n
			for(int index = 0; index<list.length; index++)
			{
				if(list[index] == num) 
				{
					removeIndex = index;
				}
			}
			//for loop that removes index and adjusts list
			for(int index = removeIndex; index < list.length -1; index++)
			{
				list[index] = list[index+1];
			}
			
			list[count - 1] = 0;
			count--;
		}
		
		for(int index = 0; index<list.length; index++) 
		{
			if(list[index] == 0)
			{
				numEmpty++;
			}
		}
		if(numEmpty > list.length/4) 
		{
			list = Arrays.copyOf(list, list.length - 1);
		}
			
	}
	
	//simple method returns the count
	//count keeps track of the number of elements in list
	public int count()
	{
		return count;
	}
	
	//method that converts list to a string
	//returns a string value 
	public String toString() 
	{
		 StringBuilder sb = new StringBuilder();
		 for(int index = 0; index < list.length; index++)
		 {
			 sb.append(" " + list[index] + " ");
		 }
		String newList = sb.toString();
			
		return newList;
	}
	
	//method that searches list for the element passed in
	//takes parameters int num
	//retuns the index of num
	public int search(int num) 
	{
		int location = -1;
		
		for(int index = 0; index < list.length; index++) 
		{
			if(list[index] == num)
			{
				location = index;
			}
		}
		return location;
	}
	
	
	//append method adds element at the last end of the list
	public void append(int num) 
	{
		//checks to see if count has reached list size
		if(count == list.length)
        {
			//copies list into larger list 
            list = Arrays.copyOf(list, (list.length/2) + list.length);
            list[count] = num;
            count++;
        }
       
       else 
       {
    	   list[count] = num;
    	   count++;
       }  
	
	}
	
	
	//first method returns first element in list
	public int first() 
	{
		if(list == null) 
		{
			return -1; 
		}
		else 
		{
			return list[0];
		}
	}
	
	//last method returns last element in list
	public int last() 
	{
		if(list == null) 
		{
			return -1; 
		}
		else 
		{
			return list[count-1];
		}
	}
	
	//returns the size of the list
	//includes spaces they may not have been filled with elements 
	public int size() 
	{
		return list.length;
	}
	
}