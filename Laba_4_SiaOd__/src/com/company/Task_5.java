package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Task_5 {
    public static boolean testBrackets(String str) {
        Deque<Character> brackets = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    brackets.addFirst(c);
                    break;
                case ')':
                    if (brackets.isEmpty() || !brackets.removeFirst().equals('('))
                        return false;
                    break;
                default:
                    break;
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        try {
            File file = new File("D:\\input\\input4.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            StringBuilder line = new StringBuilder(reader.readLine());
            String tempLine = "";
            boolean bool = true;
            while (bool) {
                line.append(tempLine);
                tempLine = reader.readLine();
                if (tempLine == null)
                    bool = false;
            }
            System.out.println("Получившаяся строка: " + line);
            System.out.println("Проверка: " + (testBrackets(line.toString()) ? "OK" : "FAIL"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
