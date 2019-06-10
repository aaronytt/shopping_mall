package com.ytt.shopping.core.util;

import com.ytt.shopping.core.tree.BianaryTree;

import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:48 2019/6/10
 * @Modiflid By:
 */
public class BianaryTreeUtil {

    public static <T> BianaryTree<T> getBianaryTree(List<T> src,int level){
        return new BianaryTree<T>(src,level);
    }

}
