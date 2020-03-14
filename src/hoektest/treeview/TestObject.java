package hoektest.treeview;

public class TestObject {
    private String navn;
    private String gruppe;
    private double beloeb;


    public TestObject(String navn, String gruppe, double beloeb) {
        this.navn = navn;
        this.gruppe = gruppe;
        this.beloeb = beloeb;
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getGruppe() {
        return gruppe;
    }

    public void setGruppe(String gruppe) {
        this.gruppe = gruppe;
    }

    public double getBeloeb() {
        return beloeb;
    }

    public void setBeloeb(double beloeb) {
        this.beloeb = beloeb;
    }
}
