import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<Karta> ark;
    Kreator k;

    public Menu(Kreator k) {
        this.k = k;
        ark = k.strukturyzator();
        start();
    }

    public void start() {
        boolean czyKontynuowac = true;
        Scanner scan = new Scanner(System.in);
        while (czyKontynuowac){
            System.out.println("\nWybierz nr czynności, którą chcesz wykonać: ");
            System.out.println("0. Zakoncz program");
            System.out.println("1. Tworzenie nowej struktury");
            System.out.println("2. Wyswietlanie wszystkich elementow struktury");
            System.out.println("3. Wyswietlanie liczby elementow");
            System.out.println("4. Wyswietlanie wszystkich elementow o podanej wartosci");
            System.out.println("5. Wyswietlanie wszystkich elementow o podanym kolorze");
            System.out.println("6. Usuwanie duplikatow");
            int wybor = scan.nextInt();
            switch (wybor){
                case 0:
                    czyKontynuowac=false;
                    break;
                case 1:
                    tworzenieStruktury();
                    System.out.println("Struktura utworzona");
                    break;
                case 2:
                    wyswietlanieStruktury();
                    break;
                case 3:
                    liczbaElem();
                    break;
                case 4:
                    System.out.println("Wybierz nr wartosci, którą chcesz wyswietlic (1-13): ");
                    int w = scan.nextInt();
                    wyswietlanieWartosci(w);
                    break;
                case 5:
                    System.out.println("Wybierz nr koloru, którą chcesz wyswietlic (1-13): ");
                    int kl = scan.nextInt();
                    wyswietlanieKoloru(kl);
                    break;
                case 6:
                    usunDuplikaty();
                    System.out.println("Duplikaty usuniete");
                    break;
            }
        }
    }

    public void tworzenieStruktury() {
        ark = k.strukturyzator();
    }

    public void wyswietlanieStruktury() {
        System.out.println("Wszystkie elementy: ");
        for (Karta krt : ark) {
            System.out.println(krt.wartosc + " " + krt.kolor);
        }
    }

    public void liczbaElem() {
        System.out.println("Liczba elementow: ");
        System.out.println(ark.size());
    }

    public void wyswietlanieWartosci(int w) {
        System.out.println("Wszystkie elementy o wartosci " + w + ":");
        for (Karta krt : ark) {
            if (krt.wartosc == w) System.out.println(krt.wartosc + " " + krt.kolor);
        }
    }

    public void wyswietlanieKoloru(int kl) {
        System.out.println("Wszystkie elementy o kolorze " + kl + ":");
        for (Karta krt : ark) {
            if (krt.kolor == kl) System.out.println(krt.wartosc + " " + krt.kolor);
        }
    }

    public void usunDuplikaty() {
        //testy:
        //ark.add(0, new Karta(1, 0));
        //ark.add(0, new Karta(1, 0));
        //ark.add(0, new Karta(1, 0));
        //
        int l = ark.size();
        Karta ostatnia = ark.get(0);
        for (int i = 1; i < l; i++) {
            l = ark.size();
            if (i>=l)break;
            Karta temp = ark.get(i);
            if (ostatnia.wartosc == temp.wartosc && ostatnia.kolor == temp.kolor) {
                ark.remove(i);
                i--;
            }else{
                ostatnia=temp;
            }
        }
    }
}
