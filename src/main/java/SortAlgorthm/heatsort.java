package SortAlgorthm;

public class heatsort{
	public static int[] buildMaxHeap(int[] array){
		for(int i=(array.length-2)/2;i>=0;i--){
			adjustDownToUp(array,i,array.length);
		}
		return array;
	}

	/**heap adjust 
		first step is to find the left child array[2*k+1]
		second step is to compare the left child and right child which is bigger,
		third step ,if the bigger one is bigger than parent,then change the element of the parent and the bigger one;
		loop until the first elenmet

	**/
	public static void  adjustDownToUp(int[] array,int k, int length){
		int temp = array[k];
		for(int i=2*k+1;i<length-1;i=2*i+1){
			if(i<length&&array[i]<array[i+1]){
				i++;
			}
			if(temp>=array[i]){
				break;
			}else{
				array[k] = array[i];
				k=i;
			}

		}
		array[k] = temp;
	}
	/*
	to build heap 
	chang the first element and the last element
	than adjust the heap
	cut the last one of array(array.length -1)
	repeat the above step until i=0;

	*/
	public static int[] heapSort(int[] array){
		array = buildMaxHeap(array);
		for(int i=array.length-1;i>1;i--){
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			adjustDownToUp(array, 0,i);
		}
		return array;
	}
	public static int[] deleteMax(int[] array){
		array[0] = array[array.length-1];
		array[array.length-1] = -99999;
		adjustDownToUp(array,0,array.length);
		return array;
	}

	public static int[] insertData(int[] array,int data){
		array[array.length-1] = data;
		int k = array.length-1;
		int parent =(k-1)/2;
		while(parent >= 0&&data>array[parent]){
			array[k] = array[parent];
			k = parent;
			if(parent!=0){
				parent = (parent-1)/2;
			}else{
				break;
			}
		}
		array[k] = data;
		return array;
	}
	public static void AtoString(int[] array){
        for(int i:array){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
		int[] array = {87,45,78,32,17,65,53,9,122};
        System.out.print("struct");
        AtoString(buildMaxHeap(array));
        System.out.print("\n"+"delete:");
        AtoString(deleteMax(array));
        System.out.print("\n"+"insert:");
        AtoString(insertData(array, 63));
        System.out.print("\n"+"sort:");
        AtoString(heapSort(array));
	}
}
