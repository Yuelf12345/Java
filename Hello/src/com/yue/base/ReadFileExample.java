package com.yue.base;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileExample {
    public static void main(String[] args) {
        // 获取项目根目录
        String projectDir = System.getProperty("user.dir");
        // 构建文件路径
        String filePath = projectDir + "/Hello/src/hello.txt";

        if (!fileExists(filePath)) {
            if (!askUserToCreateFile()) {
                System.out.println("程序已退出。");
                return;
            }
        }


        writeFile(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean fileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    public static boolean askUserToCreateFile() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("文件不存在，是否创建文件？(y/n): ");
        try {
            String input = reader.readLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("无效输入，请输入 y 或 n。");
                return askUserToCreateFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void writeFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // 写入数据
            bw.write("Hello, World!");
            bw.newLine(); // 换行
            bw.write("This is a test file.");
            bw.newLine();
            bw.write("今天天气真好!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createDir(String dir) {
        File d = new File(dir);
        // 检查目录是否存在，如果不存在则创建目录
        if (!d.exists()) {
            d.mkdirs();
        }
    }

    public static void readDir(String filePath) {
        File dir = new File(filePath);
        if (dir.exists() && dir.isDirectory()) {
            readFilesRecursively(dir);
        } else {
            System.out.println("指定的路径不是一个有效的目录: " + filePath);
        }
    }

    private static void readFilesRecursively(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    readFilesRecursively(file); // 递归读取子目录
                } else {
                    System.out.println("文件: " + file.getAbsolutePath());
                }
            }
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("文件删除成功！");
            } else {
                System.out.println("文件删除失败！");
            }
        } else {
            System.out.println("文件不存在！");
        }
    }
}
