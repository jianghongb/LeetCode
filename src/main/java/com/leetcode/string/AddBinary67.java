package com.leetcode.string;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary67 {

    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        StringBuilder c = new StringBuilder();
        int cInt = 0;
        while (!a.equals("") && !b.equals("")) {
            char aChar = a.charAt(a.length() - 1);
            a = a.substring(0, a.length() - 1);
            char bChar = b.charAt(b.length() - 1);
            b = b.substring(0, b.length() - 1);

            c.insert(0, (((aChar - '0') ^ (bChar - '0')) ^ cInt) != 0 ? '1' : '0');
            if ((((aChar - '0') ^ (bChar - '0')) == 0 && aChar == '1')
                    || (((aChar - '0') ^ (bChar - '0')) != 0 && cInt == 1)) {
                cInt = 1;
            } else {
                cInt = 0;
            }
            System.out.println(aChar + " ," + bChar + " ," + cInt);
        }
        while (!a.equals("")) {
            char aChar = a.charAt(a.length() - 1);
            a = a.substring(0, a.length() - 1);

            c.insert(0, ((aChar - '0') ^ cInt) != 0 ? '1' : '0');
            if (((aChar - '0') ^ cInt) == 0 && aChar == '1') {
                cInt = 1;
            } else {
                cInt = 0;
            }

        }
        while (!b.equals("")) {
            char bChar = b.charAt(b.length() - 1);
            b = b.substring(0, b.length() - 1);

            c.insert(0, ((bChar - '0') ^ cInt) != 0 ? '1' : '0');
            if (((bChar - '0') ^ cInt) == 0 && bChar == '1') {
                cInt = 1;
            } else {
                cInt = 0;
            }
        }
        if (cInt == 1) {
            c.insert(0, cInt);
        }
        return c.toString();
    }

    public String addBinaryFast(String a, String b) {
        int cnt = 0  , i = a.length()-1 , j = b.length() - 1 ;
        StringBuilder sb = new StringBuilder();
        for(;i>=0 && j>=0 ; i--,j--){
            int tmp = a.charAt(i)-'0'+b.charAt(j)-'0'+ cnt ;
            cnt = tmp/2;
            sb.append( tmp%2 );
        }
        while(i>=0||j>=0){
            int tmp = (i>=0?(a.charAt(i--)-'0'):(b.charAt(j--)-'0')) + cnt ;
            cnt = tmp/2;
            sb.append( tmp%2 );
        }
        if(cnt==1)sb.append(1);
        return sb.reverse().toString();
    }
}
