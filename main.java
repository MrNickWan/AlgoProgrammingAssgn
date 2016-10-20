

	import java.util.*;
	public class main {
		private static ArrayList<Integer> values = new ArrayList<Integer>();
		
		
		//first used to calculate sums
		private static void calculatesums(ArrayList<Integer> array){
			if(array.size()==1)
				values.add(array.get(0));
			else{
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
		}
		//recalculate sums after element is removed
		private static void REcalculatesums(ArrayList <Integer>array, int indexoflastremoved){
			
			int i =indexoflastremoved;
			values.remove(indexoflastremoved);
			
			int prei,posti,preprei;
			try{
				prei=array.get(i-1);
			}
			catch(IndexOutOfBoundsException e){
				prei=1;
			}
			try{
				System.out.println(i);
				posti=array.get(i+1);
			}
			catch(IndexOutOfBoundsException e){
				posti=1;
			}
			try{
				preprei=array.get(i-2);
			}
			catch(ArrayIndexOutOfBoundsException e){
				preprei=1;
			}
			values.set(i, array.get(i)*posti*prei);
			try{
			
				values.set(i-1, prei*preprei*array.get(i));
			}
			catch(IndexOutOfBoundsException e){
				
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
	    
		if(indexoflastremoved==-1)
	    
			calculatesums(array);
	        
	        else
	        	REcalculatesums(array,indexoflastremoved);
	        
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
	        long start = System.currentTimeMillis();
            for(int i =0;i<1000;i++)
            	A.add(i);
	             
	        System.out.println("maxsum " +pickBoxes(A,0,-1));
	        long duration = System.currentTimeMillis()-start;
	        System.out.println("program duration " + duration);
	        
	     }   
	}

