package com.ytt.shopping.core.util;

import com.ytt.shopping.core.heap.BinaryHeap;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 4:57 2019/6/12
 * @Modiflid By:
 */
public class BinaryHeapTest {

    @Test
    public void testBuildHeap(){
        BinaryHeap<Integer> binaryHeap = BinaryHeapUtil
                .getBinaryHeap(Arrays.asList(ArrayUtil.createRandomArray(7,-10000,10000)));
        System.out.println(binaryHeap);
    }

}
