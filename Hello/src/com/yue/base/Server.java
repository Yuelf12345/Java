package com.yue.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 创建服务器套接字
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("HTTP Server is running and listening on port 8888...");

        while (true) {
            // 接受客户端连接
            Socket clientSocket = serverSocket.accept();

            // 创建新线程处理客户端请求
            Thread clientHandler = new Thread(() -> {
                try {
                    handleClient(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            // 启动线程
            clientHandler.start();
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        // 读取请求
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // 读取请求行
        String requestLine = in.readLine();
        if (requestLine == null || !requestLine.startsWith("GET")) {
            return; // 非 HTTP GET 请求，直接返回
        }

        // 构造 HTTP 响应
        String httpResponse = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/plain\r\n" +
                "Content-Length: 11\r\n" +
                "\r\n" + // 空行，表示头部结束
                "hello world";

        // 发送响应
        out.print(httpResponse);
        out.flush();

        // 关闭输入输出流
        in.close();
        out.close();
    }
}