package TopK;

/**
 * Created by User on 2017/5/18.
 * KlogN
 */
public class HeapNode {
    public int value;//值是多少
    public int arrNum;//来自哪个数组
    public int index;//哪个数组的具体位置
    public HeapNode(int value,int arrNum,int index){
        this.value = value;
        this.arrNum = arrNum;
        this.index = index;
    }
}
