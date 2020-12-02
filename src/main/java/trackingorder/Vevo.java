package trackingorder;

public class Vevo {
    private String lackim;
    private String telefonszam;
    private String nev;
    private String emailCim;

    public Vevo(String lackim, String telefonszam, String nev, String emailCim) {
        this.lackim = lackim;
        this.telefonszam = telefonszam;
        this.nev = nev;
        this.emailCim = emailCim;
    }

    public String getLackim() {
        return lackim;
    }

    public void setLackim(String lackim) {
        this.lackim = lackim;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEmailCim() {
        return emailCim;
    }

    public void setEmailCim(String emailCim) {
        this.emailCim = emailCim;
    }

}
