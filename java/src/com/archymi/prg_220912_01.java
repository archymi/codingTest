package com.archymi;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/118667?language=java
public class prg_220912_01 {

    private static int answer;

    private static int firstSize = 0;

    private static int secondSize = 0;

    public static void greedy(LinkedList<Integer> queue1, LinkedList<Integer> queue2, int count) {
        if (count == 0) {
            answer = -1;
            firstSize = queue1.size();
            secondSize = queue2.size();
        }
        IntSummaryStatistics queue1Statistics =
                queue1
                        .stream()
                        .mapToInt(s -> s)
                        .summaryStatistics();
        IntSummaryStatistics queue2Statistics =
                queue2
                        .stream()
                        .mapToInt(s -> s)
                        .summaryStatistics();

        if (count > firstSize * 2 ) {
            return;
        }
        if (count > secondSize * 2 ) {
            return;
        }
        if ((queue1Statistics.getSum() + queue2Statistics.getSum()) % 2 == 1) {
            return;
        }
        if (queue1Statistics.getSum() == queue2Statistics.getSum()) {
            answer = count;
        } else if (queue1Statistics.getSum() > queue2Statistics.getSum()) {
            LinkedList<Integer> newQueue1 = (LinkedList<Integer>) queue1.clone();
            LinkedList<Integer> newQueue2 = (LinkedList<Integer>) queue2.clone();

            Integer a = newQueue1.remove(0);
            newQueue2.add(a);
            count += 1;

            greedy(newQueue1, newQueue2, count);
        } else {
            LinkedList<Integer> newQueue1 = (LinkedList<Integer>) queue1.clone();
            LinkedList<Integer> newQueue2 = (LinkedList<Integer>) queue2.clone();

            Integer a = newQueue2.remove(0);

            newQueue1.add(a);
            count += 1;

           greedy(newQueue1, newQueue2, count);
        }
    }

    public static int solution(int[] queue1, int[] queue2) {
        LinkedList<Integer> newQueue1 = new LinkedList<>();
        LinkedList<Integer> newQueue2 = new LinkedList<>();

        for (int a : queue1) {
            newQueue1.add(a);
        }

        for (int a : queue2) {
            newQueue2.add(a);
        }

        greedy(newQueue1, newQueue2, 0);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solution(new int[]{1,1}, new int[]{1, 5}));
        System.out.println(solution(new int[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 }, new int[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
    }
}
