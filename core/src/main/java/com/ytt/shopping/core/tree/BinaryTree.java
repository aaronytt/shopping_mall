package com.ytt.shopping.core.tree;

import com.ytt.shopping.core.exception.FormatNoMatchException;
import com.ytt.shopping.core.exception.OutOfRootTreeNodeException;
import com.ytt.shopping.core.util.ListUtil;
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

    public BinaryTree(T data) {
        super(data);
    }

    public final static int BREADTH = 0;
    public final static int DEPTH = 1;

    public void buildBinaryTree(List<T> src) {
        if(null == src || src.isEmpty()){
            return;
        }
        buildNodes(src);
        buildByBreadthSequence(this);
    }

    @Deprecated
    public void buildBinaryTree(List<T> src, int level) {
        if(null == src || src.isEmpty()){
            return;
        }
        buildNodes(src);
        if(level == BREADTH){
            buildByBreadthSequence(this);
        } else if(level == DEPTH){
            buildByDepthPreorder(this);
        }
    }

    private final static int FRIST = 0;
    private final static boolean LEFT = true;
    private final static boolean RIGHT = false;

    //用于快速获取特定位置的node
    private List<TreeNode<T>> nodes;

    //深度优先构建
    @Deprecated
    protected void buildByDepthPreorder(BinaryTree<T> root){
        //写入左孩子还是右孩子
        final boolean leftOrRight[] = {LEFT};
        //父节点
        final TreeNode parentNode[] = {this};
        root.nodes.parallelStream()
                .forEach(markNode -> {
                    //准备写入父节点左孩子
                    if(leftOrRight[FRIST]){
                        //当前节点不空，可以写入父节点左孩子
                        if(null != markNode){
                            //标记元素位置
                            //写入当前节点的父节点
                            markNode.setParent(parentNode[FRIST]);
                            //写入父节点左孩子
                            parentNode[FRIST].setLeftChild(markNode);
                            //初始化父节点
                            //当前节点成为下次使用的父节点
                            parentNode[FRIST] = markNode;
                        }
                        //当前节点为空，切换到右边孩子，下次准备写入有孩子
                        else {
                            //初始化写入方向：写入右孩子方向
                            leftOrRight[FRIST] = RIGHT;
                        }
                    }
                    //准备写入父节点右孩子
                    else{
                        //当前节点不空，可以写入父节点右孩子
                        if(null != markNode){
                            //标记元素位置
                            //写入当前节点的父节点
                            markNode.setParent(parentNode[FRIST]);
                            //写入父节点右孩子
                            parentNode[FRIST].setRightChild(markNode);
                            //初始化父节点
                            //当前节点成为下次使用的父节点
                            parentNode[FRIST] = markNode;
                            //初始化写入方向：写入左孩子方向
                            leftOrRight[FRIST] = LEFT;
                        }
                        //当前节点为空
                        else{
                            //初始化父节点：为父节点的父节点
                            parentNode[FRIST] = parentNode[FRIST].getParent();
                            //当父节点为空时抛出超出根节点异常
                            if(null == parentNode[FRIST]){
                                throw new OutOfRootTreeNodeException();
                            }
                            while (null != parentNode[FRIST].getRightChild()){
                                if(null == parentNode[FRIST]){
                                    break;
                                }else {
                                    parentNode[FRIST] = parentNode[FRIST].getParent();
                                }
                            }
                        }
                    }
                });
    }

    //广度优先优先构建
    protected void buildByBreadthSequence(BinaryTree<T> root){
        root.getNodes().parallelStream()
                .forEach(markNode ->{
                    if(null == markNode || FRIST == ((BinaryTree)markNode).getIndex()){
                        return;
                    }

                    int i = ((BinaryTree<Object>) markNode).getIndex();

                    //位置
                    int parentIndex = (i-1) >> 1;

                    TreeNode<T> parentNode = this.nodes.get(parentIndex);

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

    protected List<TreeNode<T>> buildNodes(List<T> src){
        this.nodes = src.parallelStream()
                .map(e -> {
                    if(null == e){
                        return null;
                    }
                    int i = src.indexOf(e);
                    BinaryTree<T> markNode;
                    if(FRIST == i){
                        markNode = this;
                    }else {
                        markNode = new BinaryTree<>();
                    }
                    markNode.setIndex(i);
                    markNode.setData(src.get(i));
                    return markNode;
                })
                .collect(ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);
        return this.nodes;
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

    @Override
    public boolean isEmpty() {
        return ListUtil.isEmpty(this.nodes) || super.isEmpty();
    }
}
