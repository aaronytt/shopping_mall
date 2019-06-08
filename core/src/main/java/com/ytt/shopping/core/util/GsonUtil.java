package com.ytt.shopping.core.util;

import com.google.gson.Gson;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:58 2019/5/30
 * @Modiflid By:
 */
public class GsonUtil {

    private static final Gson GSON = new Gson();

    public static Gson getGson(){
        return GSON;
    }

}
