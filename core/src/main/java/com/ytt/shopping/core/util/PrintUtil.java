package com.ytt.shopping.core.util;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 1:04 2019/6/9
 * @Modiflid By:
 */
public class PrintUtil {

    public static final int WHITE = 30;             // 白色
    public static final int WHITE_BACKGROUND = 40;  // 白色背景
    public static final int RED = 31;               // 红色
    public static final int RED_BACKGROUND = 41;    // 红色背景
    public static final int GREEN = 32;             // 绿色
    public static final int GREEN_BACKGROUND = 42;  // 绿色背景
    public static final int YELLOW = 33;            // 黄色
    public static final int YELLOW_BACKGROUND = 43; // 黄色背景
    public static final int BLUE = 34;              // 蓝色
    public static final int BLUE_BACKGROUND = 44;   // 蓝色背景
    public static final int MAGENTA = 35;           // 品红（洋红）
    public static final int MAGENTA_BACKGROUND = 45;// 品红背景
    public static final int CYAN = 36;              // 蓝绿
    public static final int CYAN_BACKGROUND = 46;   // 蓝绿背景
    public static final int BLACK = 37;             // 黑色
    public static final int BLACK_BACKGROUND = 47;  // 黑色背景

    public static final int BOLD = 1;       // 粗体
    public static final int ITATIC = 3;     // 斜体
    public static final int UNDERLINE = 4;  // 下划线
    public static final int REVERSE = 7;    // 反转

    public static String textCode(String text, int... codes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int code : codes) {
            stringBuffer.append(code + ";");
        }
        String _code = stringBuffer.toString();

        if (_code.endsWith(";")) {
            _code = _code.substring(0, _code.length() - 1);
        }
        return (char) 27 + "[" + _code + "m" + text + (char) 27 + "[0m";
    }

//    /**
//     * 打印不换行
//     */
//    public static void P(String txt, int... codes) {
//        System.out.print(FMT(txt, codes));
//    }
//
//    /**
//     * 打印并换行
//     */
//    public static void PN(String txt, int... codes) {
//        System.out.println(FMT(txt, codes));
//    }
//
//    public static void main(String[] args) {
//        PRINT.PN("黑色", PRINT.BLACK);
//        PRINT.PN("白色", PRINT.WHITE);
//        PRINT.PN("红色", PRINT.RED);
//        PRINT.PN("绿色", PRINT.GREEN);
//        PRINT.PN("黄色", PRINT.YELLOW);
//        PRINT.PN("蓝色", PRINT.BLUE);
//        PRINT.PN("品红", PRINT.MAGENTA);
//        PRINT.PN("蓝绿", PRINT.CYAN);
//        PRINT.PN("黑底白字", PRINT.WHITE, PRINT.BLACK_BACKGROUND);
//        PRINT.PN("白底黑字", PRINT.BLACK, PRINT.WHITE_BACKGROUND);
//        PRINT.PN("蓝底红字", PRINT.RED, PRINT.BLUE_BACKGROUND);
//        PRINT.PN("加粗倾斜", PRINT.BOLD, PRINT.ITATIC);
//        PRINT.PN("黄底白字下划线", PRINT.WHITE, PRINT.YELLOW_BACKGROUND, PRINT.UNDERLINE);
//        PRINT.PN("红字颜色反转", PRINT.RED, PRINT.REVERSE);
//    }
}
