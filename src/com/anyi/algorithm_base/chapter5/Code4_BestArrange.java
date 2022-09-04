package com.anyi.algorithm_base.chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法，解决开会问题
 */
public class Code4_BestArrange {
    public static class Program{ // 一个会议的开始时间
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) { // 按照开始时间升序排列
            return o1.start - o2.start;
        }
    }
    public static int lowestLexicography(Program[] programs ,int timeStart){
        int res = 0;
        Arrays.sort(programs,new ProgramComparator()); // 按照开始时间升序排序
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeStart){
                res ++;
                timeStart = programs[i].end;
            }
        }
        return res;
    }
}
