package Threads.ProducerConsumer;


import java.util.Queue;

public class Producer extends Thread{

    Queue<String> queue;

    public Producer(Queue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        while (!isInterrupted()){
            try {



                //Wir wollen zufällig entweder "Kopf" oder "Zahl" mit 50/50 chance einfügen in die Queue
                int random = (int)(2*Math.random());
                if (random == 0){
                    //Kopf einfügen
                    synchronized (queue){

                        //TODO Es dürfen nur maximal 100 Jobs in die Queue, wenn sie voll ist, dann warte


                        queue.add("Kopf");
                        queue.notifyAll();
                    }

                } else {
                    //Zahl einfügen
                    synchronized (queue){
                        queue.add("Zahl");
                        queue.notifyAll();
                    }

                }

            } catch (Exception e){
                System.out.println("Producer abgebrochen durch Exception");
                return;
            }
        }
    }
}

