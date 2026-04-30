package Threads.ProducerConsumer;


import jdk.jshell.spi.ExecutionControlProvider;

import java.util.Queue;
/**
Der Cosumer konsumiert entweder Kopf oder Zahl. Diese werden vom Producer produziert
und in eine Queue gepackt, die maximal 1000 Elemente haben darf
 */
public class Consumer extends Thread{

    final Queue<String> queue;
    //queue : ["Kopf", "Zahl"]
    static Integer anzKopf = 0;
    static Integer anzZahl = 0;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    //TODO: worauf synchronisieren wir? Was ist unser lock Objekt ?
    //TODO: wir wollen nur aus der queue entnehmen, wenn sie nicht leer ist
    //TODO: sage dem Producer, dass wir konsumiert haben und ein Element weniger in der queue ist
    @Override
    public void run() {
        while (!isInterrupted()){
            try {
                synchronized (queue) {
                    while(queue.isEmpty()) {
                        queue.wait();
                    }
                        String s = queue.poll();
                        if (s.equals("Kopf")) {
                            anzKopf++;
                        } else {
                            anzZahl++;
                        }
                        double wktKopf = (double) anzKopf / (anzZahl + anzKopf);
                        System.out.println("Wkt für Kopf = " + wktKopf);

                    queue.notifyAll();
                }
            } catch (Exception e){
                System.out.println("Consumer abgebrochen durch Exception");
                return;
            }
        }
    }
}

