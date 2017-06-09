package StrGetValue;

/**
 * Created by User on 2017/6/8.
 */
/**
 * Java实现KMP算法
 * <p>
 * 思想：每当一趟匹配过程中出现字符比较不等，不需要回溯i指针，
 * 而是利用已经得到的“部分匹配”的结果将模式向右“滑动”尽可能远
 * 的一段距离后，继续进行比较。
 * <p>
 * 时间复杂度O(n+m)
 * nextArr[i]的含义是在matich[i]之前的字符串match[0..i-1]中，必须以match[i-1]结尾的后缀子串，与必须以match[0]开头的前缀子串，最大匹配长度是多少
 *
 * @author xqh
 */
public class KMPAlgorthm {


    public static void main(String[] args) {
        String s = "abbabbbbcabca"; // 主串
        String t = "bbcabca"; // 模式串
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        System.out.println(KMP_Index(ss, tt)); // KMP匹配字符串
    }

    /**
     * 获得字符串的next函数值
     *
     * 函数值
     * @return next函数值
     */
    public static int[] next(char[] ms) {
        if(ms.length == 1)
        {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos =2;
        int cn =0;
        while(pos < next.length){
            if(ms[pos-1]==ms[cn]){
                next[pos++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[pos++]=0;
            }

        }
        return next;
    }

    /**
     * KMP匹配字符串
     *
     * @param s 主串
     * @param m 模式串
     * @return 若匹配成功，返回下标，否则返回-1
     */
    public static int KMP_Index(char[] s, char[] m) {
        int[] next = next(m);
        for(int i=0;i<next.length;i++){
            System.out.print("i = " + next[i]  +"   ");
        }
        System.out.println();

        int si = 0;
        int mi = 0;
        while (si <= s.length - 1 && mi <= m.length - 1) {
            if (s[si] == m[mi]) {
                si++;
                mi++;
            } else if(next[mi] == -1){
               si++;
            }else{
                mi = next[mi];
            }
        }

            return mi == m.length?si - mi:-1; // 返回模式串在主串中的头下标
    }


}
