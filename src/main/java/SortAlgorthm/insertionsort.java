package SortAlgorthm;

public class insertionsort{
	//the sort is assume that the array
	public static void sort(int[] arrays){
		int i,j;
		int n = arrays.length;
		int target;
		for( i=1;i<n;i++){
			j=i;
			target =arrays[i];
			while(j>0 && target<arrays[j-1]){
				arrays[j] = arrays[j-1];
				j--;
			}
			arrays[j] = target;
		}
	}
	public static void main(String[] args) {
		
	}
}