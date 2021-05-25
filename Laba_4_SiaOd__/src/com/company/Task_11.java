package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class Task_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\input\\input11.txt")));
        Stack<Character> st = new Stack<>();
        Stack<Character> letter = new Stack<Character>();
        Stack<Character> symbols = new Stack<Character>();
        int open = 0, close = 0;
        int i = 0;
        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            st.add(ch);
        }
        for (char r : st) {
            if (Character.isAlphabetic(r)) {
                letter.push(r);
            }
        }
        for (char r : st) {
            if (!(Character.isDigit(r) || Character.isAlphabetic(r))) {
                symbols.push(r);
            }
        }

        int l = 0;
        while (letter.size() != 0) {
            char s = letter.pop();
            switch (s) {
                case ('x'):
                case ('y'):
                case ('z'):
                    l++;
                    break;
            }
        }

        int kol = 0;
        while (symbols.size() != 0) {
            char s = symbols.pop();
            switch (s) {
                case ('+'):
                case ('-'):
                    kol++;
                    break;
                case ('('):
                    open++;
                    break;
                 case (')'):
                    close++;
                    break;
            }
        }

        if ((l - 1 == kol) && (close == open))
            System.out.println("Формула верна");
        else
            System.out.println("Формула неверна");
    }
}
