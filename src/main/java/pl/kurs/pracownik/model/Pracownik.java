package pl.kurs.pracownik.model;

public class Pracownik {

    private String imie;
    private String nazwisko;
    private Stanowisko stanowisko;
    private double pensja;
    private boolean pracuje;

    public Pracownik(String imie, String nazwisko, Stanowisko stanowisko, double pensja, boolean pracuje) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.pensja = pensja;
        this.pracuje = pracuje;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public boolean isPracuje() {
        return pracuje;
    }

    public void setPracuje(boolean pracuje) {
        this.pracuje = pracuje;
    }
}
