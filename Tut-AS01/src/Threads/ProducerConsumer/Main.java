package Threads.ProducerConsumer;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        //Queue<String> queue = new LinkedList<>();
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        try{

            sleep(3000);
            p1.interrupt();
            p2.interrupt();
            c1.interrupt();
            c2.interrupt();

        } catch (Exception e){}

    }
}
