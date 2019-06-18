package com.ytt.shopping.core.util;

import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 2:59 2019/6/12
 * @Modiflid By:
 */
public class ListUtil {

    /**
     * 交换List指定位置的值
     * @param list
     * @param fristIndex
     * @param secondIndex
     * @param <T>
     * @return
     */
    public static <T> boolean exchangeValue(List<T> list, int fristIndex, int secondIndex){
        T temp = list.get(fristIndex);
        list.set(fristIndex,list.get(secondIndex));
        list.set(secondIndex,temp);
        return true;
    }

    public static boolean isEmpty(List list){
        return null == list|| list.isEmpty();
    }

}
