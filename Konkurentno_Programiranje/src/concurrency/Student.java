package concurrency;

import java.util.Random;

public class Student {
    private int id;
    private long vremeDolaska;
    private long trajanjeOdbrane;

    public Student(int id) {
        this.id = id;
        //vreme dolaska u ms (0 < x <=1)
        this.vremeDolaska = new Random().nextInt(1000);
        //tempo u ms(0.5 <= x <=1)
        this.trajanjeOdbrane = new Random().nextInt(500)+500;
    }

    public long getTrajanjeOdbrane() {
        return trajanjeOdbrane;
    }

    public void setTrajanjeOdbrane(long trajanjeOdbrane) {
        this.trajanjeOdbrane = trajanjeOdbrane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getVremeDolaska() {
        return vremeDolaska;
    }

    public void setVremeDolaska(long vremeDolaska) {
        this.vremeDolaska = vremeDolaska;
    }


}
