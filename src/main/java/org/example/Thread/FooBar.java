package org.example.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public class FooBar {

    LinkedBlockingQueue l1;
    LinkedBlockingQueue l2;
    private int n;

    private int flag;

    public FooBar(int n) {
        this.n = n;
        this.flag = 0;
        l1 = new LinkedBlockingQueue(1);

        l2 = new LinkedBlockingQueue(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            l1.put(i);
            printFoo.run();
            l2.put(i);
            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            l2.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            l1.take();
        }
    }
}
