package Threads.ProducerConsumer;


import java.util.Queue;

public class Producer extends Thread{

    Queue<String> queue;

    public Producer(Queue<String> queue) {

        this.queue = queue;
    }

    //TODO Es dürfen nur maximal 100 Jobs in die Queue, wenn sie voll ist, dann warte
    //TODO: behandle Race conditions
    public void run() {
        while (!isInterrupted()){
            synchronized (queue) {
                try {
                    //Wir wollen zufällig entweder "Kopf" oder "Zahl" mit 50/50 chance einfügen in die Queue
                    int random = (int) (2 * Math.random());
                    while(queue.size() >= 100) {
                        queue.wait();
                    }
                    //Kopf einfügen
                    if (random == 0) {

                        queue.add("Kopf");

                        //Zahl einfügen
                    } else {

                        queue.add("Zahl");

                    }
                    queue.notifyAll();

                } catch (Exception e) {
                    System.out.println("Producer abgebrochen durch Exception");
                    return;
                }
            }
        }
    }
}

