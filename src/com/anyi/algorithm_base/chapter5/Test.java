package com.anyi.algorithm_base.chapter5;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        char[] res =new char[]{'a','c','b'};
        StringBuffer s = new StringBuffer();
        s.append("a");
        System.out.println(s.toString());
        System.out.println(new String(res));
        String text = "1n2n1";
        int index = text.indexOf("");
        System.out.println(index);
    }
}
