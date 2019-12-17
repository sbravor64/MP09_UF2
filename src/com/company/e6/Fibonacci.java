package com.company.e6;

import com.company.e5.Factorial;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    int num;

    public Fibonacci(int num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if (num >= 10) {
            return fibonacciRec();
        } else {
            return fibonacciSec();
        }
    }

    private Integer fibonacciRec() {
        Fibonacci f1 = new Fibonacci(num - 1);
        Fibonacci f2 = new Fibonacci(num - 2);

        f1.fork();
        f2.fork();

        return f1.join() + f2.join();
    }

    private Integer fibonacciSec() {
        int prev1 = 0, prev2 = 1;
        for (int i = 0; i < num; i++) {
            int savePrev1 = prev1;
            prev1 = prev2;
            prev2 = savePrev1 + prev2;
        }
        return prev1;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Fibonacci fibonacci = new Fibonacci(9);
        forkJoinPool.invoke(fibonacci);

        double result = fibonacci.join();

        System.out.println(result);
    }
}
