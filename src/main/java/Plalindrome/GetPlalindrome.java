package Plalindrome;

/**
 * Created by User on 2017/6/2.
 */

/**
 * 给定字符串str,如果可以在str任意位置添加字符，请返回在添加最少的情况下，使得str整体都是回文字符串
 */
public class GetPlalindrome {
    /**
     * dp[i][j]的值代表子串最少添加几个字符可以使str[i..j]整体都是回文字符串
     * @param str
     * @return
     */
    public static int[][] getDp(char[] str){
        int[][] dp = new int[str.length][str.length];
        for(int j = 1; j < str.length;j++){
            dp[j-1][j] = str[j-1] ==str[j]?0:1;
            for(int i = j-2;i>-1;i--){
                if(str[i] == str[j]){
                    dp[i][j] = dp[i+1][j-1];

                }else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp;
    }
    public static String getPalindrome(String str){
        if(str == null || str.length()<2){
            return  str;
        }
        char[] chas = str.toCharArray();
        int[][] dp = getDp(chas);
        char[] res = new char[chas.length+dp[0][chas.length-1]];
        int i= 0;
        int j = chas.length-1;
        int res1 =0;
        int resr = res.length -1;
        while (i<=j) {
            if(chas[i] == chas[j]){
                res[res1++] = chas[i++];
                res[resr--] = res[j--];
            }else if(dp[i][j-1] < dp[i+1][j]){
                res[res1++] = chas[j];
                res[resr--] = chas[j--];
            }else{
                res[res1++] = chas[i];
                res[resr--] = chas[i++];
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str = "A1B2B1";
        System.out.println(getPalindrome(str));//返回用空格隔开的后面表示要添加的内容
    }
}
