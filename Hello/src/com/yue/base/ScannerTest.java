package com.yue.base;

import java.util.Scanner;
// 用户输入
public class ScannerTest {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");

//        if(scanner.hasNext()){
//            String str = scanner.next(); // 读取一行 nextLine()
//            System.out.println(str);
//        }
//        scanner.close();

//       判断输入是否是数字
//        if(scanner.hasNextInt()){
//            int i = scanner.nextInt();
//            System.out.println(i);
//        }else{
//            System.out.println("输入有误");
//        }
//        scanner.close();

//        计算器
        double count = 0;
        int num = 0;
        while(scanner.hasNextDouble()){
            double num1 = scanner.nextDouble();
            num +=1;
            count += num1;
        }
        System.out.println("输入了" + num + "个数，总和为" + count);
        scanner.close();
    }
}
