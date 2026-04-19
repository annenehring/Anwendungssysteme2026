package Threads;

public class CounterThread implements Runnable{

    String name;
    final int counter;

    public CounterThread(String name, int counter) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= counter; i++) {
            System.out.println(name+": "+i);
        }
    }

    public static void main(String[] args) {
        //TODO wie können wir einen CounterThread namens "john" und counter = 1000 erstellen?
        CounterThread counterThread1 = new CounterThread("john", 1000);
        Thread t1 = new Thread(counterThread1);

        //TODO "richard" mit 1000
        CounterThread counterThread2 = new CounterThread("richard", 1000);
        Thread t2 = new Thread(counterThread2);

        //TODO wie können wir Thread ausführen?
        t1.start();
        t2.start();

    }
}
