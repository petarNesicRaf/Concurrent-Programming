package concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Profesor implements Runnable{
    private int id;

    public Profesor(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Student student = Main.que.take();

                Main.barijera.await();

                long pocetakOdbrane = System.currentTimeMillis() - Main.pocetakOdbrane;
                int ocena = new Random().nextInt(5) + 5;

                System.out.println("Thread: " + student.getId() + " Arrival: " + student.getVremeDolaska() + " Profesor: " + this.id +
                        " TTC: " + student.getTrajanjeOdbrane() + " : " + pocetakOdbrane + " Score: " + ocena);

                Thread.sleep(student.getTrajanjeOdbrane());

                Main.zbirOcena.addAndGet(ocena);
                Main.brojOcena.addAndGet(1);

            } catch (InterruptedException | BrokenBarrierException e) {
                //e.printStackTrace();
                break;
            }
        }
    }
}
