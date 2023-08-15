package org.example.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(5); // 5 表示打印次数

        Runnable printFoo = () -> System.out.print("Foo");
        Runnable printBar = () -> System.out.print("Bar");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }
}
