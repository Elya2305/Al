package com.company.other.dynamic_programming;

public class FibonacciTabulation {
    public static void main(String[] args) {
        FibonacciSimpleSolution solution = new FibonacciSimpleSolution();
        FibonacciTabulationSolution solution1 = new FibonacciTabulationSolution();

        System.out.println(solution.fib(6));
        System.out.println(solution1.fib(6));
    }
}

class FibonacciSimpleSolution {
    public int fib(int n) {
        int one = 0; // 0 -> 0
        int two = 1; // 1 -> 1
        int res = one + two; // 2 -> 3

        if (n == 0) return one;
        if (n == 1) return two;

        for (int i = 3; i <= n; i++) {
            one = two;
            two = res;
            res = two + one;
        }

        return res;
    }
}

class FibonacciTabulationSolution {

    public int fib(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;

        for (int i = 0; i < n - 1; i++) {
            arr[i + 1] = arr[i + 1] + arr[i];
            arr[i + 2] = arr[i + 2] + arr[i];
        }

        return arr[n];

    }
}

