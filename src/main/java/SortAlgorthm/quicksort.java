package SortAlgorthm;

public class quicksort{
	//use divide and conquer algorithm 
	/*
	to partion the array into two parts;
	which change the place of elements when array[lo] > key or array[hi] <key

	return hi
	*/
	public static int partition(int[] array,int lo,int hi){
		int key=array[lo];
		while(lo<hi){
			while(array[hi]>=key&&hi>lo){
				hi--;
			}
			array[lo] = array[hi];
			while(array[lo]<=key && hi>lo){
				lo++;
			}
			array[hi]=array[lo];
		}
		array[hi] =key;
		return hi;
	}

//recursion function 
	public static void sort(int[] array,int lo,int hi){
		if(lo>=hi)
			return;
		int index = partition(array,lo,hi);
		sort(array,lo,index-1);
		sort(array,index+1,hi);
	}
	public static void AtoString(int[] array){
        for(int i:array){
            System.out.print(i+" ");
        }
    }
	 public static void main(String[] args) {
	 	int[] array = {87,45,78,32,17,65,53,9,122};
	 	sort(array,0,array.length-1);
	 	AtoString(array);
	 }	
}