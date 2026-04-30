package Threads;

public class CounterThread implements Runnable{

    String name;
    int counter;

    public CounterThread(String name, int counter){
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i <= counter; i++){
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) {
        //TODO wie können wir einen CounterThread namens "john" und counter = 1000 erstellen?
        Thread t1 = new Thread(new CounterThread("John", 1000));
        //TODO "richard" mit 1000
        CounterThread t2 = new CounterThread("Richard", 1000);
        Thread b = new Thread(t2);
        //TODO wie können wir Thread ausführen?
        t1.start();
        b.start();



    }
}
