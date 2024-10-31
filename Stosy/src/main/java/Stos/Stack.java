package Stos;

public class Stack {
    private String[] stos;
    private int wielkosc;

    public Stack() {
        this.stos = new String[0];
        this.wielkosc = 0;
    }

    public void nowyStos(){
        String[] nowyStos = new String[wielkosc];
        int mniejsze;
        if (stos.length < wielkosc){
            mniejsze = stos.length;
        }
        else {
            mniejsze = wielkosc;
        }
        for(int i = 0; i < mniejsze; i += 1){
            nowyStos[i] = stos[i];
        }
        stos = nowyStos;
    }

    public String[] getStos(){
        return stos;
    }

    public void push(String wloz){
        if (wloz==null){
            throw new RuntimeException("Element nie moze byc pusty");
        }
        wielkosc += 1;
        nowyStos();
        stos[wielkosc - 1] = wloz;
    }

    public String pop() {
        if (wielkosc == 0) {
            throw new RuntimeException("Stos jest pusty!");
        }
            String ostatni = stos[wielkosc - 1];
            wielkosc -= 1;
            nowyStos();
            return ostatni;
    }

    public String peek(){
        if (wielkosc == 0) {
            throw new RuntimeException("Stos jest pusty!");
        }
        return stos[wielkosc - 1];
    }
}