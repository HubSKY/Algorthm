package MaxSubString;

/**
 * Created by User on 2017/6/5.
 * 运用动态规划，求两个字符串的最长公共子串
 * 字符串str1和str2构造M*N的矩阵dp;
 * dp[i][j]表示把str1[i]和str2[j]当成公共串的最后一个字符的情况下，公共子串最长能有多长
 */
public class MaxSubStr {
    public static int[][] getDp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < str2.length; j++) {
            if (str2[j] == str1[0]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if(str1[i] == str2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }


            }
        }
        return dp;
    }
    public static String maxSubString(String str1,String str2){
        if(str1 == null|| str2 == null || str1.equals("")||str2.equals("")){
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 =str2.toCharArray();
        int[][] dp = getDp(chs1,chs2);
        int end =0;
        int max = 0;

        for(int i=0;i<chs1.length;i++){
            for(int j=0;j<chs2.length;j++){
                if(dp[i][j]>max){
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max +1,end+1);

    }


    public static void main(String[] args) {
        String str1="ABCD";
        String str2="AFG";
        System.out.println(maxSubString(str1,str2));

    }
}
