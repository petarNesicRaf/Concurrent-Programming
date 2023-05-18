package concurrency;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static BlockingQueue<Student> que = new LinkedBlockingQueue<>();
    public static CyclicBarrier barijera = new CyclicBarrier(2);
    public static long pocetakOdbrane;
    public static AtomicInteger zbirOcena = new AtomicInteger(0);
    public static AtomicInteger brojOcena = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Unesi broj studenata za odbranu: ");
        Scanner scanner = new Scanner(System.in);
        int brojStudenata = scanner.nextInt();

        for(int i =0; i<brojStudenata; i++)
        {
            Student student = new Student(i);
            que.add(student);
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        pocetakOdbrane = System.currentTimeMillis();
        Runnable profesor1 = new Profesor(1);
        Runnable profesor2 = new Profesor(2);
        Runnable asistent = new Asistent(0);

        threadPool.submit(profesor1);
        threadPool.submit(profesor2);
        threadPool.submit(asistent);

        Thread.sleep(5000);

        threadPool.shutdownNow();

        System.out.println("Prosecna ocena: " + zbirOcena.get() * 1.0 / brojOcena.get());

    }
}
