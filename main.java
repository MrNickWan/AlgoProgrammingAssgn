

	import java.util.*;
	public class main {
		private static ArrayList<Integer> values = new ArrayList<Integer>();
		//first used to calculate sums
		private static void calculatesums(ArrayList<Integer> array){
			
			for(int i=0;i<array.size();i++){
				if(i==0){
					values.add(array.get(0)*array.get(i+1));
				}
	            else if( i==array.size()-1)
	                values.add(array.get(i)*array.get(i-1));
	            else{
	            values.add(array.get(i-1)*array.get(i)*array.get(i+1));

	            }
			
			}
			
		}
		//recalculate sums after element is removed
		private static void REcalculatesums(ArrayList <Integer>array, int indexoflastremoved){
			for(Integer p: values)
				System.out.println(p + " ");
			System.out.println(values.get(0));
			System.out.println(array.get(0));
			values.remove(indexoflastremoved);
			
			if(indexoflastremoved==0 || indexoflastremoved == 1 && array.size()==1){
				values.set(0, array.get(0));
				
			}
			else{
				
			}
				
		}
		
		//maxANDindex array is to store the max value and the index of the max value. The Max value is store in 0 index. Index of max stored in 1 index.
		
		public static int[] maxValueandIndex(){
	
			int[] maxANDindex = new int[2];
	
			maxANDindex[0]= values.get(0);  
	
			for(int i =0;i<values.size()-1;i++){
				if(values.get(i)>maxANDindex[0]){
					maxANDindex[0]=values.get(i);
					maxANDindex[1]=i;
				}
	 
	 
	}
	return maxANDindex;
	 
	}
	public static int pickBoxes(ArrayList<Integer> array,int sum,int indexoflastremoved){
		System.out.println(indexoflastremoved + " indexoflast removed");
		if(array.size()==0)
	        return sum;
	        
		for(Integer p: values)
			System.out.println(p + " values ");
	    
		if(indexoflastremoved==-1)
	    
			calculatesums(array);
	        
	        else{
	        	System.out.println("hit recl");
	        	REcalculatesums(array,indexoflastremoved);
	        }
	        int[] maxANDindex;
	
	
	        
	       
	        maxANDindex=maxValueandIndex();
	        sum+=maxANDindex[0];
	        
	        //when there are only two elements left. Choose to remove the smaller one. The products of i*i+1 and i+1*i will be the same. 
	        if(array.size()==2){
	        	
	        	if(array.get(0)>array.get(1))
	        		array.remove(1);
	        	else
	        		array.remove(0);
	        		
	        }        	
	        else{
	        	System.out.println("removed "+ array.get(maxANDindex[1]));
	        	array.remove(maxANDindex[1]);
	        }
	        return sum=pickBoxes(array,sum,maxANDindex[1]);
	    }
	        
	        
	        
	        
	        
	        
	     public static void main(String []args){
	        ArrayList<Integer> A = new ArrayList<Integer>();
	       
	        A.add(2);
	        A.add(3);
	        
	        for (Integer p : A)
	            System.out.print(p+" ");
	     
	     
		
	     
	        
	        System.out.println("maxsum " +pickBoxes(A,0,-1));
	     }   
	}

