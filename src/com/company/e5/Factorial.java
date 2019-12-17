package com.company.e5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Factorial extends RecursiveTask<Double> {
    double num;

    public Factorial(double num) {
        this.num = num;
    }

    @Override
    protected Double compute() {
        if(num <= 3){
            return factorialSec();
        } else {
            return factorialRec();
        }
    }

    private double factorialRec() {
        Factorial task = new Factorial(num-1);
        task.fork();
        return num * task.join();
    }

    private Double factorialSec() {
        double temp = num;
        for (int i = 1; i <num ; i++) {
            temp = temp * i;
        }
        return temp;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Factorial factorial = new Factorial(5);
        forkJoinPool.invoke(factorial);

        double result = factorial.join();

        System.out.println(result);
    }

}
