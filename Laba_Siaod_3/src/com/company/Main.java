package com.company;

public class Main {

    public static void main(String[] args) {
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Введите строку: ");
        Scanner scanstr = new Scanner(System.in);
        String str = scantxt.nextLine();
        System.out.println("Введите подстроку: ");
        Scanner scanpodstr = new Scanner(System.in);
        String podstr = scantxt.nextLine();

        B-Mura;

    }

    public static void B-Mura(String str; String podstr){
        int strLen = str.length();
        int podstr = podstr.length();
        if (podstrLen > strLen) {
            break;
        }
        HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
        for (int i = 0; i <= 255; i++) {
            offsetTable.put((char) i, templateLen);
        }
        for (int i = 0; i < templateLen - 1; i++) {
            offsetTable.put(template.charAt(i), templateLen - i - 1);
        }
        int i = templateLen - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= sourceLen - 1) {
            j = templateLen - 1;
            k = i;
            while (j >= 0 && source.charAt(k) == template.charAt(j)) {
                k--;
                j--;
            }
            i += offsetTable.get(source.charAt(i));
        }
        if (k >= sourceLen - templateLen) {
            return -1;
        } else {
            return k + 1;
        }
    }
}
