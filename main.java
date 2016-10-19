

	import java.util.*;
	public class main {
	//maxANDindex array is to store the max value and the index of the max value. The Max value is store in 0 index. Index of max stored in 1 index.
	public static int[] maxValueandIndex(int values[]){
	int[] maxANDindex = new int[2];
	maxANDindex[0]= values[0];  
	for(int i =0;i<values.length-1;i++){
	 if(values[i]>maxANDindex[0]){
	 maxANDindex[0]=values[i];
	 maxANDindex[1]=i;
	 }
	 
	 
	}
	return maxANDindex;
	 
	}
	public static int pickBoxes(ArrayList<Integer> array,int sum,int indexoflastremoved,int[] values){
	        if(array.size()==0){
	        return sum;
	        }
	int[] maxANDindex;
	// to check if this is the first iteration. If it is, just start calculating at 0. If not, start at 
	// index of last removed -1. Look to remove or make more efficient
	int start;
	if(indexoflastremoved==-1 || indexoflastremoved == 0){
		start=0;
	}
	else
		start=indexoflastremoved-1;
	//use to store the values of i-1*i*i+1. Starts at the 
	        
	        for(int i=start;i<end;i++){
	       
	            
	            //may be able to optimize but this if statement is simply to avoid a null/exception error or whatever
	            if(array.size()==1)
	            values[0]=array.get(0);
	            //also to avoid null error
	            else if(i==0)
	                values[0]=array.get(0)*array.get(i+1);
	            
	            else if( i==array.size()-1)
	                values[i]=array.get(i)*array.get(i-1);
	            else{
	            values[i]=array.get(i-1)*array.get(i)*array.get(i+1);
	            }
	            
	        }
	        maxANDindex=maxValueandIndex(values);
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
	return sum=pickBoxes(array,sum,indexoflastremoved,values);
	    }
	        
	        
	        
	        
	        
	        
	     public static void main(String []args){
	        ArrayList<Integer> A = new ArrayList<Integer>();
	        A.add(8);
	        A.add(2);
	        A.add(3);
	        A.add(6);
	        A.add(7);
	        A.add(9);
	        A.add(4);
	        int[] values=new int[A.size()];
	        System.out.println("maxsum " +pickBoxes(A,0,-1,values));
	        for (Integer p : A)
	            System.out.print(p+" ");
	     }
	}

