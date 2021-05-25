package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class Task_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\input\\input9.txt")));
        Stack<Character> st = new Stack<Character>();
        Stack<Boolean> num = new Stack<Boolean>();
        Stack<Character> letter = new Stack<Character>();
        Stack<Boolean> preanswer = new Stack<Boolean>();
        int i = 0;

        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            st.add(ch);
        }

        for (char r : st) {
            if (Character.isDigit(r)) {
                if (r == '0')
                    num.push(false);
                else
                    num.push(true);
            }
        }

        for (char r : st) {
            if (Character.isAlphabetic(r)) {
                letter.push(r);
            }
        }

        while (preanswer.size() != 6) {
            char s = letter.pop();
            switch (s) {
                case ('O'):
                    boolean num1 = num.pop();
                    boolean num2 = num.pop();
                    preanswer.add(num1 || num2);
                    break;
                case ('X'):
                    boolean num3 = num.pop();
                    boolean num4 = num.pop();
                    if (num3 != num4) {
                        preanswer.add(true);
                    } else {
                        preanswer.add(false);
                    }
                    break;
                case ('A'):
                    boolean num5 = num.pop();
                    boolean num6 = num.pop();
                    preanswer.add(num5 && num6);
                    break;
                case ('N'):
                    boolean num7 = num.pop();
                    if (num7) {
                        preanswer.add(false);
                    } else {
                        preanswer.add(true);
                    }
                    break;
                case ('F'):
                    preanswer.add(false);
                    break;
                case ('T'):
                    preanswer.add(true);
                    break;
            }
        }

        Iterator <Boolean> iterator2 = preanswer.iterator();
        boolean answer = false;
        while (iterator2.hasNext()) {
            if (iterator2.next()){
                answer = true;
            }
        }
        System.out.println(answer);
    }
}
