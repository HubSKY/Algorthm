package MaxLength;

/**
 * Created by User on 2017/5/22.
 */

/**
 * given array unsorted,to get the max length of array
 * for in sum of array is k;
 */
public class MaxLength_array {
    public int getMaxLength(int[] array,int k){
        int length = 0;
        if(array == null || array.length == 0 || k <= 0){
            return  0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < array.length){
            if(sum == k){
                length = Math.max(length,right-left + 1);
                sum = sum - array[left];
                left++;
            }else if(sum < k ){
                right++;
                if(right == array.length){
                    break;
                }
                sum += array[right];
            }else {
                sum -= array[left];
                left--;

            }
        }
        return length;
    }
}
