package com.company;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = scanstr.nextLine();
        System.out.println("Введите подстроку: ");
        String podstr = scanstr.nextLine();

        int res = B_Mura(str, podstr);
        int[] res_1 = pfl(str, podstr);
        System.out.println("Строка входит с символа: " + res);
        System.out.println("Массив вхождений: " + Arrays.toString(res_1));

    }

    public static int B_Mura(String str, String podstr){
        int strLen = str.length();
        int podstrLen = podstr.length();
        if (podstrLen > strLen) {
            return -1;
        }
        HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
        for (int i = 0; i <= 255; i++) {
            offsetTable.put((char) i, podstrLen);
        }
        for (int i = 0; i < podstrLen - 1; i++) {
            offsetTable.put(podstr.charAt(i), podstrLen - i - 1);
        }
        int i = podstrLen - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= strLen - 1) {
            j = podstrLen - 1;
            k = i;
            while (j >= 0 && str.charAt(k) == podstr.charAt(j)) {
                k--;
                j--;
            }
            i += offsetTable.get(str.charAt(i));
        }
        if (k >= strLen - podstrLen) {
            return -1;
        } else {
            return k + 1;
        }
    }
/**
    public static int[] kmp(String str, String podstr) {
        int pl = str.length();
        int tl = podstr.length();
        int[] answer = new int[];
        int[] p = prefixFunction(str + "#" + podstr);
        int count = 0;
        for (int i = 0; i <= tl - 1; i++) {
            if (p[pl + i + 1] == pl)
                answer[count++] = i;
        }
        return answer;
    }

    public static int[] prefixFunction(String s) {
        int[] p = new int[];
        int k;
        p[0] = 0;
        for (int i = 1; i <= s.length() - 1; i++) {
            k = p[i - 1];
            while (k > 0 && s.charAt(i) != s.charAt(k))
                k = p[k - 1];
            if  (s.charAt(i) == s.charAt(k)
            k++;
            p[i] = k;
        }
        return p;
    }
**/
    public static int[] pfl(String str, String podstr)
    {
        String t = podstr + "#" + str;
        char[] text = t.toCharArray();
        int[] pfl = new int[text.length];
        pfl[0] = 0;

        for (int i = 1; i < text.length; ++i)
        {
            int k = pfl[i - 1];
            while (text[k] != text[i] && k > 0)
            {
                k = pfl[k - 1];
            }
            if (text[k] == text[i])
            {
                pfl[i] = k + 1;
            }
            else
            {
                pfl[i] = 0;
            }
        }

        System.out.println("Строка входит с символов:");
        for (int i = podstr.length() + 1 ; i <= pfl.length - 1; i++){
            if (pfl[i] == podstr.length()) {
                int vh = i - 2*podstr.length() ;
                System.out.print(vh  + " ");
            }
        }
        System.out.println();

        return pfl;
    }

}
