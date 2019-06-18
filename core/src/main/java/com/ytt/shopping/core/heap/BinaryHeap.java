package com.ytt.shopping.core.heap;

import com.ytt.shopping.core.tree.BinaryTree;
import com.ytt.shopping.core.tree.TreeNode;
import lombok.Data;

import java.util.Comparator;
import java.util.List;


/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:43 2019/6/12
 * @Modiflid By:
 */
@Data
public class BinaryHeap<T extends Comparable<T>> extends BinaryTree<T> {

    /**
     *
     * @param src
     */
    public void buildBinaryHeap(List<T> src){
        buildBinaryHeap(src,T::compareTo);
    }

    /**
     *
     * @param src
     * @param comparator 用于节点之间比较
     */
    public void buildBinaryHeap(List<T> src,Comparator<T> comparator){
        buildBinaryTree(src);
        for (int i = (super.getNodes().size() >> 1) - 1; i>0; i--) {
            downAdjust(comparator,i);
        }
    }

    @Override
    @Deprecated
    protected void buildByDepthPreorder(BinaryTree<T> root) {
        buildByBreadthSequence(root);
    }

    protected void upAdjust(Comparator<T> comparator){
        //比较器null,默认元素比较方式
        if(null == comparator){
            comparator = T::compareTo;
        }
        int markIndex = super.getNodes().size() - 1;
        int parentIndex = (markIndex-1) >> 1;
        //用来保存插入的叶子节点，用于最后的赋值
        TreeNode<T> markNode = super.getNodes().get(markIndex);
        TreeNode<T> parentNode = super.getNodes().get(parentIndex);
        while (markIndex > 0 && comparator.compare(markNode.getData(),parentNode.getData()) < 0){
            //赋值前更换游标
            ((BinaryTree<T>)parentNode).setIndex(markIndex);
            //无需真正的交换，单向赋值即可
            super.getNodes().set(markIndex,parentNode);
            //准备开始下一轮
            markIndex = parentIndex;
            parentIndex = parentIndex >> 1;

            parentNode = super.getNodes().get(parentIndex);

        }
        //赋值前更换游标
        ((BinaryTree<T>)markNode).setIndex(markIndex);
        super.getNodes().set(markIndex,markNode);
    }

    protected void downAdjust(Comparator<T> comparator, int parentIndex){
        //比较器null,默认元素比较方式
        if(null == comparator){
            comparator = T::compareTo;
        }
        int size = super.getNodes().size();
        int markIndex = (parentIndex << 1) + 1;
        //用来保存插入的叶子节点，用于最后的赋值
        TreeNode<T> parentNode = super.getNodes().get(parentIndex);
        //节点
        TreeNode<T> markNode;
        while (markIndex < size){
            //初始化要比较的节点
            markNode = super.getNodes().get(markIndex);

            //右孩子小于左孩子定位到右孩子
            if(markIndex+1 < size && comparator.compare(super.getNodes().get(markIndex+1).getData(), markNode.getData()) < 0){
                markIndex++;
                markNode = super.getNodes().get(markIndex);
            }
            //如果父节点较小，直接跳出
            if(comparator.compare(parentNode.getData(), markNode.getData()) <= 0){
                break;
            }
            //赋值前更换游标
            ((BinaryTree<T>)markNode).setIndex(parentIndex);
            super.getNodes().set(parentIndex,markNode);
            //准备开始下一轮
            parentIndex = markIndex;
            markIndex = (markIndex << 1) + 1;
        }
        //赋值前更换游标
        ((BinaryTree<T>)parentNode).setIndex(parentIndex);
        super.getNodes().set(parentIndex,parentNode);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
