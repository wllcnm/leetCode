package org.example.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {


    CountDownLatch zeroLatch = new CountDownLatch(0); //0
    CountDownLatch evenLatch = new CountDownLatch(1); //奇数
    CountDownLatch oddLatch = new CountDownLatch(1);  //偶数
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroLatch.await();
            printNumber.accept(0); //把0传进去
            zeroLatch = new CountDownLatch(1);
            if ((i & 1) == 1) oddLatch.countDown();
            else evenLatch.countDown();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                evenLatch.await();
                printNumber.accept(i);
                evenLatch = new CountDownLatch(1);
                zeroLatch.countDown();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
                if ((i & 1)==0){
                    oddLatch.await();;
                    printNumber.accept(i);
                    oddLatch=new CountDownLatch(1);
                    zeroLatch.countDown();
                }
        }
    }
}
