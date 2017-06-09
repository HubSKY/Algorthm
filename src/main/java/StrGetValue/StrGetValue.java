package StrGetValue;

import java.util.LinkedList;

/**
 * Created by User on 2017/6/6.
 * 给定字符串表达式 STR q求表达式的值
 * 如str ="3+4*1" 返回7
 */
public class StrGetValue {
    public static int getValue(String exp){
        return  value(exp.toCharArray(),0)[0];
    }
    public static int[] value(char[] chars,int i){
        LinkedList<String> deq =new LinkedList<String>();
        int pre =0;
        int[]  bra = null;
        while(i<chars.length&&chars[i]!=')'){
            if(chars[i] >='0'&&chars[i]<='9'){
                pre = pre*10+chars[i++]-'0';//将字符串数字拼成字符
            }else if(chars[i] != '('){
                addNum(deq,pre);
                deq.addLast(String.valueOf(chars[i++]));
                pre =0;
            }else{
                bra = value(chars,i+1);
                pre = bra[0];
                i = bra[1]+1;
            }
        }
        addNum(deq,pre);
        return new int[] {getNum(deq),i};

    }

    public static void addNum(LinkedList<String> deq, int num) {
        if(!deq.isEmpty()){
            int cur = 0;
            String top = deq.removeLast();
            if(top.equals("+")||top.equals("-")){
                deq.addLast(top);
            }else{
                cur = Integer.valueOf(deq.removeLast());
                num = top.equals("*")?(cur*num):(cur/num);
            }
        }
        deq.addLast(String.valueOf(num));
    }
    public static int getNum(LinkedList<String> deq){
        int res =0;
        boolean add =true;
        String cur = null;
        int num = 0;
        while(!deq.isEmpty()){
            cur = deq.removeFirst();
            if(cur.equals("+")){
                add =true;
            }else if(cur.equals("-")){
                add =false;
            }else{
                num = Integer.valueOf(cur);
                 res+=add?num:(-num);
            }
        }
        return  res;
    }

    public static void main(String[] args) {

        System.out.println(getValue("48*(9+11)+2"));
    }
}
