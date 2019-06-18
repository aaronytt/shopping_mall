package com.ytt.shopping.core.util;

import com.ytt.shopping.core.heap.BinaryHeap;
import com.ytt.shopping.core.tree.BinaryTree;

import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 5:03 2019/6/12
 * @Modiflid By:
 */
public class BinaryHeapUtil extends BinaryTreeUtil {

    public static <T extends Comparable<T>> BinaryHeap<T> getBinaryHeap(List<T> src){
        return new BinaryHeap(){
            {
                buildBinaryHeap(src);
            }
        };
    }

}
