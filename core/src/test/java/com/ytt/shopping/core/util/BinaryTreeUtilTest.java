package com.ytt.shopping.core.util;

import com.ytt.shopping.core.tree.BinaryTree;
import org.assertj.core.util.Arrays;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:35 2019/6/10
 * @Modiflid By:
 */
public class BinaryTreeUtilTest {

    @Test
    public void testGetBinaryTreeDepth() {
        BinaryTree binaryTree = new BinaryTree(){
            {
                buildBinaryTree(Arrays.asList(new Integer[]{1314, 2, 4, 8, null, null, 9, null, null, 5, 10, null, null, 11, null, null, 3, 6, 12, null, null, 13, null, null, 7, 14, null, null, 15}), BinaryTree.DEPTH);
            }
        };
    }

    @Test
    public void testGetBinaryTreeBreadth(){
        BinaryTree binaryTree = BinaryTreeUtil
                .buildBianaryTree(getIntList(7));
        System.out.println(binaryTree);
    }

    private List<Integer> getIntList(int j){
        return Stream.iterate(0,i -> i+1).limit(j).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

}
