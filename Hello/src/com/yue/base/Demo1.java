package com.yue.base;

/**
 * Created by yue on 2024/7/6.
 * @author yue
 * @version 1.0.0
 * @since 1.8
 */

public class Demo1 {
    String name;

    /**
     * 获取姓名
     * @param name
     * @return
     */
    public String getName(String name) {
        return name;
    }


    public static void main(String[] args) {
        print99();
    }
    // 打印99乘法表
    public static void print99() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
