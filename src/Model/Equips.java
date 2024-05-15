package Model;

public class Equips {
    // VARIABLES
    private int equip_id;
    private String nom;
    private String acronim;
    private String ciutat;
    private String divisio;
    private int guanyades;
    private int perdudes;


    // CONSTRUCTOR
    public Equips(int equip_id, String nom, String acronim, String ciutat, String divisio, int guanyades, int perdudes) {
        this.equip_id = equip_id;
        this.ciutat = ciutat;
        this.nom = nom;
        this.acronim = acronim;
        this.divisio = divisio;
        this.guanyades = guanyades;
        this.perdudes = perdudes;
    }


    // GETTERS
    public int getEquip_id() { return equip_id; }
    public String getNom() { return nom; }
    public String getAcronim() { return acronim; }
    public String getCiutat() { return ciutat; }
    public String getDivisio() { return divisio; }
    public int getGuanyades() { return guanyades; }
    public int getPerdudes() { return perdudes; }


    // SETTERS
    public void setEquip_id(int equip_id) { this.equip_id = equip_id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setAcronim(String acronim) { this.acronim = acronim; }
    public void setCiutat(String ciutat) { this.ciutat = ciutat; }
    public void setDivisio(String divisio) { this.divisio = divisio; }
    public void setGuanyades(int guanyades) { this.guanyades = guanyades; }
    public void setPerdudes(int perdudes) { this.perdudes = perdudes; }


}
