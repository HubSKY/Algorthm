package StrGetValue;

/**
 * Created by User on 2017/6/8.
 * 给定一个字符串，将里面的数值类型 的字符加起来，求和 复杂度时间复杂度O(N),空间复杂度O(1)
 * 如：A12CD33 返回45
 *    a-1B2--2D6 返回 7
 */
public class GetStrNumValue {
    public static int numSum(String str){
        if(str == null){
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res =0;
        int num = 0;
        boolean posi =true;
        int cur =0;
        for(int i=0;i<charArr.length;i++){
            cur =charArr[i] - '0';
            if(cur<0||cur>9){
                res+=num;
                num = 0;
                if(charArr[i] == '-'){
                    if(i-1>-1&&charArr[i-1] == '-'){
                        posi = true;
                    }else{
                        posi = false;
                    }
                }else{
                    posi = true;
                }
            }else{
                num = num *10 +(posi?cur:-cur);
            }
        }
        res+=num;
        return res;
    }

    public static void main(String[] args) {
        String testStr = "A-1B--2D6E";
        System.out.println(numSum(testStr));
    }
}
