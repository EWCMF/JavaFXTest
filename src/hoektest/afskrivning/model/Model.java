package hoektest.afskrivning.model;

public class Model {
    private int id;
    private String navn;
    private double[] beregningstal;
    private double afskrivningsvaerdi;

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double[] getBeregningstal() {
        return beregningstal;
    }

    public void setBeregningstal(double[] beregningstal) {
        this.beregningstal = beregningstal;
    }

    public double getAfskrivningsvaerdi() {
        return afskrivningsvaerdi;
    }

    public void setAfskrivningsvaerdi(double afskrivningsvaerdi) {
        this.afskrivningsvaerdi = afskrivningsvaerdi;
    }
}
