package com.bluesky.bankapp.io;

import java.util.Scanner;

public class InputReader {

    private Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readString() {
        return scanner.nextLine();
    }

    public Integer readInt() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public Double readDouble() {
        return Double.parseDouble(scanner.nextLine().trim());
    }

    public Long readLong() {
        return Long.parseLong(scanner.nextLine().trim());
    }

    public int[] readInts() {
        String line = scanner.nextLine();
        String[] lines = line.trim().split("\\s");
        int[] nums = new int[lines.length];
        for (int i = 0; i <nums.length; i++) {
            nums[i] = Integer.parseInt(lines[i]);
        }
        return nums;
    }
}
