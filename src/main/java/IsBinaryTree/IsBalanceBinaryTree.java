package IsBinaryTree;

/**
 * Created by User on 2017/6/6.
 *判断二叉树是否为平衡二叉树，并返回树的深度，通过一个中序遍历的改版
 */
public class IsBalanceBinaryTree {
    public boolean isBalance(Node head){
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head,1, res);
        return res[0];
    }
    public int getHeight(Node head,int level,boolean[] res){
        if(head == null){
            return  level;
        }
        int leftHeight = getHeight(head.left,level+1,res);
        if(!res[0]){
            return level;
        }
        int rightHeight = getHeight(head.right,level+1,res);
        if(!res[0]){
            return  level;
        }
        if(Math.abs(leftHeight-rightHeight)>1){
            res[0] = false;
        }
        return Math.max(leftHeight,rightHeight);

    }
}
