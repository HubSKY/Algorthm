package PreOrderTraversal;

import java.util.HashMap;

/**
 * Created by User on 2017/5/23.
 * 给定先序遍历和 中序遍历不重建树的情况下求后遍历
 * 根据当前的先序数组和中序数组，设置后序数组最右边的值，然后划分出左子树的先序数组，中序数组以及右子树的先序和中序数组
 * 先根据右子树的的划分设置后后续数组
 * 再根据左子树的划分，从右边到左边依次设置好后续数组的全部位置
 */
public class PreOrder {
    public static int[] getPosArray(int[] pre,int[] in){
        if(pre == null || in == null){
            return null;
        }
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<len; i++){
            map.put(in[i],i);
        }
        setPos(pre,0,len-1,in,0,len-1,pos,len-1,map);
        return pos;
    }

    /**
     * 从右往左依次填好后序数组s
     * si为后序数组s该填入的位置，
     * 返回值为s该填的下一个位置
     * @param p
     * @param pi
     * @param pj
     * @param n
     * @param ni
     * @param nj
     * @param s
     * @param si
     * @param map
     * @return
     */
    public static int setPos(int[] p,int pi,int pj,int[] n,int ni,int nj,int[] s,int si,HashMap<Integer,Integer> map){
        if(pi>pj)
            return si;
        s[si--] = p[pi];
        int i = map.get(p[pi]);
        si = setPos(p,pj - nj+i+1,pj,n,i+1,nj,s,si,map);
        return setPos(p,pi+1,pi+i-ni,n,ni,i-1,s,si,map);


    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] in = {4,2,5,1,6,3,7};
        int[] back = getPosArray(pre,in);
        for (int i:back) {
            System.out.println(i);

        }


    }


}
