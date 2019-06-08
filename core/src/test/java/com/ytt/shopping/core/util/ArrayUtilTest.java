package com.ytt.shopping.core.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.ytt.shopping.core.util.ArrayUtil.*;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:29 2019/6/8
 * @Modiflid By:
 */
public class ArrayUtilTest {

    @Test
    public void sortTest(){

        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = null;

        try {
            pool = Executors.newFixedThreadPool(16);

            final Integer[] array = createArray(10,-100000,100000);

            System.out.println(Arrays.toString(array));
            System.out.println();

            //冒泡排序
            pool.submit(()->{
                subbleSort(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
            });
//
//        pool.submit(()->{
//            subbleSorted(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
//        });
//
//        pool.submit(()->{
//            subbleSortBorder(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
//        });
//
//        //鸡尾酒排序
//        pool.submit(()->{
//            cocktailSort(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
//        });
//
//        pool.submit(()->{
//            cocktailSorted(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
//        });
//
//            pool.submit(()->{
//                cocktailSortBorder(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
//            });
//
//            //快输排序
//            // 递归
            pool.submit(()->{
                quickSortDoubleRecursive(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
            });
//
//            pool.submit(()->{
//                quickSortSingleRecursive(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
//            });

            // 栈，模拟递归
            pool.submit(()->{
                quickSortDoubleStack(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
            });
//
//            pool.submit(()->{
//                quickSortSingleStack(copyArray(array),(Integer fisrt , Integer second) -> fisrt - second);
//            });

            pool.shutdown();
            while(!pool.isTerminated()){
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(pool != null){
                pool.shutdownNow();
            }
        }


    }

}
