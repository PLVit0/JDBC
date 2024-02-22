package pl.kurs;

public class Samochod {

    private String marka;
    private String model;
    private double cena;
    private int przebieg;

    public Samochod(String marka, String model, double cena, int przebieg) {
        this.marka = marka;
        this.model = model;
        this.cena = cena;
        this.przebieg = przebieg;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }
}
