package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class cuckoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> eggs = Arrays.stream(sc.nextLine().split(" ")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList()); // dos not check for "-" or incorrect egg structure
        List<Integer> cuckoo = new ArrayList<>(); // add cuckoo egs here

        for (int i = 0; i < eggs.size(); i++) {
            if (findCuckoo(eggs.get(i))) cuckoo.add(eggs.get(i)); // check if egg is cuckoo
        }

        System.out.println(cuckoo);

    }

    public static boolean findCuckoo(int egg) {
        int lastDigit = egg % 10, tmp;
        egg = egg / 10;

        while (egg != 0) {
            tmp = egg % 10;
            if (lastDigit - tmp != 1) return false;
            lastDigit = tmp;
            egg = egg / 10;
        }
        return true;
    }
}
