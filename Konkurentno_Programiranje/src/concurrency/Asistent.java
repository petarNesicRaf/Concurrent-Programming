package concurrency;

import java.util.Random;

public class Asistent implements Runnable{
    private int id;

    public Asistent(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        while(true) {
            try {
                Student student = Main.que.take();

                long pocetakOdbrane = System.currentTimeMillis() - Main.pocetakOdbrane;
                int ocena = new Random().nextInt(5) + 5;

                System.out.println("Thread: " + student.getId() + " Arrival: " + student.getVremeDolaska() + " Profesor: " + this.id +
                        " TTC: " + student.getTrajanjeOdbrane() + " : " + pocetakOdbrane + " Score: " + ocena);

                Thread.sleep(student.getTrajanjeOdbrane());
                Main.zbirOcena.addAndGet(ocena);
                Main.brojOcena.addAndGet(1);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                break;
            }
        }
    }
}
