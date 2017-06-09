package LocalMin;
/**
 * Created by User on 2017/5/24.
 */

/**
 * 局部最小，找出一个数组中的局部最小值，
 * 当数组长度为1时，那么arr[0]就是局部最小
 * i<0,i<n-1,既有arr[i]<arr[i-1],又有arr[i]<arr[i+1];
 * 给定无序数组，且相邻不重复，返回局部最小数出现的位置即可
 * 算法复杂度（logN）
 */
public class LocalMin {
    public static int geilessIndex(int[] arr){
        if(arr == null|| arr.length == 0){
            return -1;//不存在；
        }

        if(arr.length == 1 || arr[0] < arr[1]){
            return  0;
        }
        if(arr[arr.length-1] < arr[arr.length-2]){
            return  arr.length-1;
        }
        int left = 1;
        int right = arr.length-2;
        int mid = 0;
        while (left < right){
            mid = (left + right )/2;
            if(arr[mid]>arr[mid-1]){
                right = mid -1;
            }else if(arr[mid]>arr[mid + 1]){
                left =mid+1;
            }else{
                return  mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a={7,2,1,3,5,6};
        System.out.println(geilessIndex(a));
    }
}
