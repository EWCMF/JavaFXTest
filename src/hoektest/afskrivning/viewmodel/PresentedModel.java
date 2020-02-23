package hoektest.afskrivning.viewmodel;

public class PresentedModel {
    private String navn;
    private double afskrivning;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getAfskrivning() {
        return afskrivning;
    }

    public void setAfskrivning(double afskrivning) {
        this.afskrivning = afskrivning;
    }
}
