package com.ytt.shopping.core.tree;

import com.ytt.shopping.core.exception.FormatNoMatchException;
import com.ytt.shopping.core.exception.OutOfRootTreeNodeException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: aaron
 * @Descriotion: 递归写法容易 StackOverflowError
 * @Date: 14:35 2019/6/10
 * @Modiflid By:
 */
@Data
public class BinaryTree<T> extends TreeNode<T> {

    private int index;

    public BinaryTree() {
        super();
    }

    public BinaryTree(int index) {
        this.index = index;
    }

    public BinaryTree(T data) {
        super(data);
    }

    public final static int BREADTH = 0;
    public final static int DEPTH = 1;

    public BinaryTree(List<T> src, int level) {
        if(level == BREADTH){
            createBinaryTreeBreadth(src);
        } else if(level == DEPTH){
            createBinaryTreeDepth(src);
        }

    }

    private final static int FRIST = 0;
    private final static boolean LEFT = true;
    private final static boolean RIGHT = false;

    //用于快速获取特定位置的node
    private List<TreeNode<T>> nodes;

    //深度优先构建
    protected void createBinaryTreeDepth(List<T> src){
        if(null == src || src.size() == 0){
            return;
        }

        this.setIndex(0);
        this.setData(src.get(FRIST));

        //构建不带节点数组
        nodes = src.parallelStream()
                .skip(1)
                .map(e -> {
                    return null == e ? null : new BinaryTree<T>(e);
                })
                .collect(ArrayList<TreeNode<T>>::new,
                         ArrayList<TreeNode<T>>::add,
                         ArrayList<TreeNode<T>>::addAll);
        nodes.add(0,this);

        //写入左孩子还是右孩子
        boolean leftOrRight = LEFT;

        //父节点
        TreeNode<T> parentNode = this;

        //{0,1,3,null,null,4,null,null,2,5,null,null,6,null,null,}
        for (int i = 1; i < nodes.size(); i++) {
            //当前标记节点
            BinaryTree<T> markNode = (BinaryTree<T>)nodes.get(i);
            //准备写入父节点左孩子
            if(leftOrRight){
                //当前节点不空，可以写入父节点左孩子
                if(null != markNode){
                    //标记元素位置
                    markNode.setIndex(i);
                    //写入当前节点的父节点
                    markNode.setParent(parentNode);
                    //写入父节点左孩子
                    parentNode.setLeftChild(markNode);
                    //初始化父节点
                    //当前节点成为下次使用的父节点
                    parentNode = markNode;
                }
                //当前节点为空，切换到右边孩子，下次准备写入有孩子
                else {
                    //初始化写入方向：写入右孩子方向
                    leftOrRight = RIGHT;
                }
            }
            //准备写入父节点右孩子
            else{
                //当前节点不空，可以写入父节点右孩子
                if(null != markNode){
                    //标记元素位置
                    markNode.setIndex(i);
                    //写入当前节点的父节点
                    markNode.setParent(parentNode);
                    //写入父节点右孩子
                    parentNode.setRightChild(markNode);
                    //初始化父节点
                    //当前节点成为下次使用的父节点
                    parentNode = markNode;
                    //初始化写入方向：写入左孩子方向
                    leftOrRight = LEFT;
                }
                //当前节点为空
                else{
                    //初始化父节点：为父节点的父节点
                    parentNode = parentNode.getParent();
                    //当父节点为空时抛出超出根节点异常
                    if(null == parentNode){
                        throw new OutOfRootTreeNodeException();
                    }
                    while (null != parentNode.getRightChild()){
                        if(null == parentNode){
                            break;
                        }else {
                            parentNode = parentNode.getParent();
                        }
                    }
                }
            }
        }

    }

    //广度优先优先构建
    protected void createBinaryTreeBreadth(List<T> src){
        if(null == src || src.size() == 0){
            return;
        }

        nodes = src.parallelStream()
                .map(e -> {
                    if(null == e){
                        return null;
                    }
                    int i = src.indexOf(e);
                    BinaryTree<T> markNode = null;
                    if(FRIST == i){
                        markNode = this;
                    }else {
                        markNode = new BinaryTree<>();
                    }
                    markNode.setIndex(i);
                    markNode.setData(src.get(i));
                    return markNode;
                })
                .collect(ArrayList<TreeNode<T>>::new,
                ArrayList<TreeNode<T>>::add,
                ArrayList<TreeNode<T>>::addAll);

        nodes.parallelStream()
                .forEach(markNode ->{

                    if(null == markNode || FRIST == ((BinaryTree)markNode).getIndex()){
                        return;
                    }

                    int i = ((BinaryTree<Object>) markNode).getIndex();

                    //位置
                    int parentIndex = ((i+1) >> 1) -1;

                    TreeNode<T> parentNode = nodes.get(parentIndex);

                    if(null == parentNode && FRIST != ((BinaryTree)markNode).getIndex()){
                        throw new FormatNoMatchException();
                    }
                    //写入左孩子还是右孩子
//                    boolean leftOrRight = i%2 == 0 ? RIGHT : LEFT;
                    boolean leftOrRight = i%2 == 1;

                    if(leftOrRight){
                        parentNode.setLeftChild(markNode);
                    }else {
                        parentNode.setRightChild(markNode);
                    }
                    markNode.setParent(parentNode);

                });
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "index=" + index +
                ", data=" + super.getData() +
                "," + (null != super.getLeftChild() ? "\n" : "") + " leftChild=" + super.getLeftChild() +
                "," + (null != super.getRightChild() ? "\n" : "") + " rightChild=" + super.getRightChild() +
                "}";
    }
}
