package Threads;

//INFO: Race Conditions
// atomar: entweder Aktion wird ganz ausgeführt oder garnicht -> sie kann nicht unterbrochen werden
public class RaceConditions extends Thread{
        static int counter = 0;

    @Override
    public void run() {

            for (int i = 0; i < 10000; i++) {
                counter++;// INFO: ist nicht atomar
            }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new RaceConditions();
        Thread t2 = new RaceConditions();

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter);
    }
}
