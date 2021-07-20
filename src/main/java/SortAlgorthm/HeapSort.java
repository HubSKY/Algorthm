package SortAlgorthm;

public class HeapSort {
    private static void heapSort(int[] arr) {
        for (int i = (arr.length - 1) / 2; i > 0; i--) {
            adjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i);
        }
    }

    public static void adjust(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int lChild = 2 * parent + 1;
        while (lChild < length) {
            int rChild = lChild + 1;
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }
            if (temp >= arr[lChild]) {
                break;
            }

            arr[parent] = arr[lChild];

            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {90,11,45,67,12,45,11,44};
        heapSort(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }
}
