package com.archymi;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class prg_220910_01 {

    public static void calculateChoices(int choice, String type, Map<Character, Integer> score) {
        Character left = type.charAt(0);
        Character right = type.charAt(1);

        Integer before = null;
        switch (choice) {
            case 1:
                before = score.get(left);
                score.put(left, before + 3);
                break;
            case 2:
                before = score.get(left);
                score.put(left, before + 2);
                break;
            case 3:
                before = score.get(left);
                score.put(left, before + 1);
                break;
            case 4:
                break;
            case 5:
                before = score.get(right);
                score.put(right, before + 1);
                break;
            case 6:
                before = score.get(right);
                score.put(right, before + 2);
                break;
            case 7:
                before = score.get(right);
                score.put(right, before + 3);
                break;
            default:
                break;
        }
    }

    public static String solution(String[] survey, int[] choices) {
        StringBuilder ans = new StringBuilder();

        Map<Character, Integer> score = new HashMap<>();
        initMap(score);
        for (int i = 0; i < survey.length; i++) {
            calculateChoices(choices[i], survey[i], score);
        }

        if (score.get('T') > score.get('R')) {
            ans.append('T');
        } else {
            ans.append('R');
        }

        if (score.get('C') >= score.get('F')) {
            ans.append('C');
        } else {
            ans.append('F');
        }

        if (score.get('J') >= score.get('M')) {
            ans.append('J');
        } else {
            ans.append('M');
        }

        if (score.get('A') >= score.get('N')) {
            ans.append('A');
        } else {
            ans.append('N');
        }

        System.out.println("ans.toString() = " + ans.toString());
        return ans.toString();
    }

    private static void initMap(Map<Character, Integer> score) {
        Character[] keys = {'R', 'T', 'F', 'C', 'M', 'J', 'A', 'N'};
        for (Character key : keys) {
            score.put(key, 0);
        }
    }

    public static void main(String[] args) {
        solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
    }
}
