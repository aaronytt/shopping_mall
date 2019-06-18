package com.ytt.shopping.core.util;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:14 2019/6/8
 * @Modiflid By:
 */
@Slf4j
public class ArrayUtil {

    private final static Random RANDOM = new Random();

    /**
     * 冒泡排序
     * @param array
     * @param comparator true, change;
     * @param <T>
     */
    public static <T> void subbleSort(T[] array, Comparator<T> comparator){
        long stratTime = System.nanoTime();

        //比较执行次数
        int comparatorCounter = 0;
        //交换执行次数
        int changeCounter = 0;

        for (int i = 0; i <array.length - 1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                comparatorCounter++;
                if(comparator.compare(array[j],array[j+1]) > 0) {
                    changeCounter++;
                    exchangeValue(array, j, j+1);
                }
            }
        }

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", comparatorCounter: "+ comparatorCounter
                + ", changeCounter: "+ changeCounter
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     * 冒泡排序：已经有序提前结束
     * @param array
     * @param comparator
     * @param <T>
     */
    public static <T> void subbleSorted(T[] array, Comparator<T> comparator){
        long stratTime = System.nanoTime();

        //比较执行次数
        int comparatorCounter = 0;
        //交换执行次数
        int changeCounter = 0;

        for (int i = 0; i <array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length-i-1; j++) {
                comparatorCounter++;
                if(comparator.compare(array[j],array[j+1]) > 0) {
                    changeCounter++;
                    exchangeValue(array, j, j+1);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", comparatorCounter: "+ comparatorCounter
                + ", changeCounter: "+ changeCounter
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     * 冒泡排序：有序区究极优化
     * @param array
     * @param comparator true, change;
     * @param <T>
     */
    public static <T> void subbleSortBorder(T[] array, Comparator<T> comparator){
        long stratTime = System.nanoTime();

        //比较执行次数
        int comparatorCounter = 0;
        //交换执行次数
        int changeCounter = 0;

        int sortBorder = array.length-1;
        int lastIndex = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                comparatorCounter++;
                if(comparator.compare(array[j],array[j+1]) > 0) {
                    changeCounter++;
                    exchangeValue(array, j, j+1);
                    isSorted = false;
                    lastIndex = j;
                }
            }
            sortBorder = lastIndex;
            if(isSorted){
                break;
            }
        }

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", comparatorCounter: "+ comparatorCounter
                + ", changeCounter: "+ changeCounter
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     * 鸡尾酒排序（双向冒泡排序）
     * @param array
     * @param comparator
     * @param <T>
     */
    public static <T> void cocktailSort(T[] array, Comparator<T> comparator){
        long stratTime = System.nanoTime();

        //比较执行次数
        int comparatorCounter = 0;
        //交换执行次数
        int changeCounter = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                comparatorCounter++;
                if(comparator.compare(array[j],array[j+1]) > 0) {
                    changeCounter++;
                    exchangeValue(array, j, j+1);
                }
            }
            for (int j = array.length-i-1; j > i; j--) {
                comparatorCounter++;
                if(comparator.compare(array[j],array[j-1]) < 0) {
                    changeCounter++;
                    exchangeValue(array, j, j-1);
                }
            }
        }

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", comparatorCounter: "+ comparatorCounter
                + ", changeCounter: "+ changeCounter
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     * 鸡尾酒排序（双向冒泡排序）: 已经有序提前结束
     * @param array
     * @param comparator
     * @param <T>
     */
    public static <T> void cocktailSorted(T[] array, Comparator<T> comparator){
        long stratTime = System.nanoTime();

        //比较执行次数
        int comparatorCounter = 0;
        //交换执行次数
        int changeCounter = 0;

        for (int i = 0; i < array.length - 1; i++) {

            boolean isSorted = true;
            for (int j = 0; j < array.length-i-1; j++) {
                comparatorCounter++;
                if(comparator.compare(array[j],array[j+1]) > 0) {
                    changeCounter++;
                    exchangeValue(array, j, j+1);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }

            isSorted = true;
            for (int j = array.length-i-1; j > i; j--) {
                comparatorCounter++;
                if(comparator.compare(array[j],array[j-1]) < 0) {
                    changeCounter++;
                    exchangeValue(array, j, j-1);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", comparatorCounter: "+ comparatorCounter
                + ", changeCounter: "+ changeCounter
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     * 鸡尾酒排序（双向冒泡排序）: 已经有序提前结束
     * @param array
     * @param comparator
     * @param <T>
     */
    public static <T> void cocktailSortBorder(T[] array, Comparator<T> comparator){
        long stratTime = System.nanoTime();

        //比较执行次数
        int comparatorCounter = 0;
        //交换执行次数
        int changeCounter = 0;

        int endborder = array.length-1;
        int lastIndex = 0;

        int startborder = 0;
        int fristIndex = 0;

        for (int i = 0; i < array.length/2; i++) {

            boolean isSorted = true;
            for (int j = startborder; j < endborder; j++) {
                comparatorCounter++;
                if(comparator.compare(array[j],array[j+1]) > 0) {
                    changeCounter++;
                    exchangeValue(array, j, j+1);
                    isSorted = false;
                    lastIndex = j;
                }
            }
            endborder = lastIndex;
            if(isSorted){
                break;
            }

            isSorted = true;
            for (int j = endborder; j > startborder; j--) {
                comparatorCounter++;
                if(comparator.compare(array[j],array[j-1]) < 0) {
                    changeCounter++;
                    exchangeValue(array, j, j-1);
                    isSorted = false;
                    fristIndex = j;
                }
            }
            startborder = fristIndex;
            if(isSorted){
                break;
            }
        }

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", comparatorCounter: "+ comparatorCounter
                + ", changeCounter: "+ changeCounter
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     * 快速排序(双边循环法-递归)： 注意栈溢出 StackOverflowError
     * @param array
     * @param comparator
     * @param <T>
     */
    @Deprecated
    public static <T> void quickSortDoubleRecursive(T[] array, Comparator<T> comparator){

        long stratTime = System.nanoTime();

        quickSortRecursive(array, 0, array.length-1, comparator, true);

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     * 快速排序(单边循环法-递归)： 注意栈溢出 StackOverflowError
     * @param array
     * @param comparator
     * @param <T>
     */
    @Deprecated
    public static <T> void quickSortSingleRecursive(T[] array, Comparator<T> comparator){
        long stratTime = System.nanoTime();

        quickSortRecursive(array,0, array.length-1, comparator, false);

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     * 快速排序: 可以在选定的区间段内排序
     * @param <T>
     * @param array
     * @param startIndex
     * @param endIndex
     * @param comparator
     * @param singleOrDouble
     */
    @Deprecated
    public static <T> void quickSortRecursive(T[] array, int startIndex, int endIndex, Comparator<T> comparator, boolean singleOrDouble){
        if(startIndex >= endIndex){
            return;
        }

        int pivotIndex = singleOrDouble ? partitionDouble(array, startIndex, endIndex, comparator) : partitionSingle(array, startIndex, endIndex, comparator);

        quickSortRecursive(array, startIndex, pivotIndex-1, comparator, true);
        quickSortRecursive(array, pivotIndex+1, array.length-1, comparator, true);
    }

    /**
     * 快速排序(双边循环法-递归)： 注意栈溢出 StackOverflowError
     * @param array
     * @param comparator
     * @param <T>
     */
    public static <T> void quickSortDoubleStack(T[] array, Comparator<T> comparator){
        long stratTime = System.nanoTime();

        quickSortStack(array, 0, array.length-1, comparator, true);

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     * 快速排序(单边循环法-递归)： 注意栈溢出 StackOverflowError
     * @param array
     * @param comparator
     * @param <T>
     */
    public static <T> void quickSortSingleStack(T[] array, Comparator<T> comparator){
        long stratTime = System.nanoTime();

        quickSortStack(array,0, array.length-1, comparator, false);

        long endTime = System.nanoTime();

//        log.debug(""method: {}, comparatorCounter: {}, changeCounter: {}, time: {}, result: {}", comparatorCounter, changeCounter, endTime - stratTime, Arrays.toString(array));

        System.out.println("method: "+ PrintUtil.textCode(Thread.currentThread().getStackTrace()[1].getMethodName(), PrintUtil.RED, PrintUtil.BOLD)
                + ", time: " + PrintUtil.textCode((endTime - stratTime)+"", PrintUtil.RED)
                + ", \n result: " + Arrays.toString(array));
    }

    /**
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @param comparator
     * @param singleOrDouble
     * @param <T>
     */
    public static <T> void quickSortStack(T[] array, final int startIndex, final int endIndex, Comparator<T> comparator, boolean singleOrDouble){
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();

        //数列的起止下标，入栈
        quickSortStackPushMap(quickSortStack, startIndex, endIndex);

        while (!quickSortStack.isEmpty()){
            //栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();

            final int _startIndex = param.get("startIndex");
            final int _endIndex = param.get("endIndex");

            int pivotIndex = singleOrDouble ? partitionDouble(array, _startIndex, _endIndex, comparator) : partitionSingle(array, _startIndex, _endIndex, comparator);
            //根据基准元素分成两部分，把 每一部分的起止下标都入栈
            if(_startIndex < pivotIndex-1){
                quickSortStackPushMap(quickSortStack, _startIndex, pivotIndex-1);
            }
            if(pivotIndex+1 < _endIndex){
                quickSortStackPushMap(quickSortStack, pivotIndex+1, _endIndex);
            }
        }
    }

    private static void quickSortStackPushMap(Stack<Map<String,Integer>> quickSortStack,final int startIndex, final int endIndex){
        quickSortStack.push(new HashMap<String, Integer>(){{
            put("startIndex",startIndex);
            put("endIndex",endIndex);
        }});
    }

    /**
     * 分治（双向循环法）
     * @param array
     * @param startIndex
     * @param endIndex
     * @param comparator
     * @param <T>
     * @return
     */
    private static <T> int partitionDouble(T[] array, int startIndex, int endIndex, Comparator<T> comparator){
        //三数取中
        int pivotIndex = (endIndex-startIndex)/2 + startIndex;
        exchangeValue(array, startIndex, pivotIndex);
        pivotIndex = startIndex;
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            while (left < right && comparator.compare(array[right], array[pivotIndex]) > 0){
                right--;
            }
            while (left < right && comparator.compare(array[left], array[pivotIndex]) <= 0){
                left++;
            }
            if(left < right){
                exchangeValue(array, left, right);
            }
        }
        exchangeValue(array, pivotIndex, left);
        return left;
    }

    /**
     * 分治（单向循环法）
     * @param array
     * @param startIndex
     * @param endIndex
     * @param comparator
     * @param <T>
     * @return
     */
    private static <T> int partitionSingle(T[] array, int startIndex, int endIndex, Comparator<T> comparator){
        //三数取中
        int pivotIndex = (endIndex-startIndex)/2 + startIndex;
        exchangeValue(array, startIndex, pivotIndex);
        pivotIndex = startIndex;

        int mark = startIndex;
        for (int i = startIndex+1; i <= endIndex; i++) {
            if(comparator.compare(array[i], array[pivotIndex]) < 0){
                mark++;
                exchangeValue(array, i, mark);
            }
        }

        exchangeValue(array, pivotIndex, mark);

        return mark;
    }

    /**
     * 交换数组指定位置的值
     * @param array
     * @param fristIndex
     * @param secondIndex
     * @param <T>
     * @return
     */
    public static <T> boolean exchangeValue(T[] array, int fristIndex, int secondIndex){
        T temp = array[fristIndex];
        array[fristIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return true;
    }

    /**
     * 比较两个数组是否相等
     * @param fristArray
     * @param secondArray
     * @param <T>
     * @return
     */
    public static <T> boolean arrayEquals(T[] fristArray, T[] secondArray) {
        if(fristArray.equals(secondArray)){
            return true;
        }
        if(fristArray.length == secondArray.length){
            for (int i = 0; i < fristArray.length; i++) {
                if(!fristArray[i].equals(secondArray[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     *
     * @param length
     * @param start
     * @param end
     * @return
     */
    public static Integer[] createRandomArray(int length,int start ,int end) {
        return new Random().ints(start,end).parallel().distinct().limit(length).boxed().toArray(Integer[]::new);
    }

    /**
     *
     * @param src
     * @return
     */
    public static Integer[] copyArray(Integer[] src){
        Integer[] array = new Integer[src.length];
        System.arraycopy(src,0,array,0,array.length);
        return array;
    }

}
