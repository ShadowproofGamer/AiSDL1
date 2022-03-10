import java.util.ArrayList;
import java.util.Random;

public class Kreator {
    private Random myRandom = new Random();

    public Karta generuj() {
        return new Karta(myRandom.nextInt(14), myRandom.nextInt(4));
    }

    public ArrayList<Karta> strukturyzator() {
        ArrayList<Karta> struktura = new ArrayList<>();
        //opcja default:
        Karta x = new Karta(1, 0);
        while (x.wartosc != 0) {
            int l = struktura.size();
            x = generuj();
            //debugowanie:
            //System.out.println("test:"+x.wartosc+" "+x.kolor);
            if (x.wartosc==0){
                break;
            }else if(struktura.isEmpty()) {
                struktura.add(x);
            }else if (struktura.contains(x)){
                struktura.add(struktura.indexOf(x), x);
            }else if (struktura.get(l-1).wartosc < x.wartosc){
                struktura.add(x);
            }else if (struktura.get(l-1).wartosc == x.wartosc && x.kolor>= struktura.get(l-1).kolor){
                struktura.add(x);
            }else{
                for(int i=0; i<l;i++){
                    Karta t = struktura.get(i);
                    if (t.wartosc > x.wartosc){
                        struktura.add(i, x);
                        break;
                    }else if(t.wartosc == x.wartosc && t.kolor>=x.kolor){
                        struktura.add(i, x);
                        break;
                    }
                }
            }
            //dla debugowania:
            //for (Karta krt:struktura){
            //    System.out.println(krt.wartosc+" "+ krt.kolor);
            //}

        }
        return struktura;
    }

}
