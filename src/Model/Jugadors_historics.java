package Model;

public class Jugadors_historics {
    // variables
    private int jugadorId;
    private String nom;
    private String cognom;
    private String dorsal;
    private String posicio;
    private float minutsTotals;
    private int puntsTotals;
    private int totalTirsAnotats;
    private int totalTirsTirats;
    private int totalTriplesAnotats;
    private int totalTriplesTirats;
    private int totalLliuresAnotats;


    // CONSTRUCTOR
    public Jugadors_historics(int jugadorId, String cognom, String nom, String dorsal, String posicio, float minutsTotals, int puntsTotals, int totalTirsAnotats, int totalTirsTirats, int totalTriplesAnotats, int totalTriplesTirats, int totalLliuresAnotats) {
        this.jugadorId = jugadorId;
        this.cognom = cognom;
        this.nom = nom;
        this.dorsal = dorsal;
        this.posicio = posicio;
        this.minutsTotals = minutsTotals;
        this.puntsTotals = puntsTotals;
        this.totalTirsAnotats = totalTirsAnotats;
        this.totalTirsTirats = totalTirsTirats;
        this.totalTriplesAnotats = totalTriplesAnotats;
        this.totalTriplesTirats = totalTriplesTirats;
        this.totalLliuresAnotats = totalLliuresAnotats;
    }


    // GETTERS
    public int getJugadorId() { return jugadorId; }
    public String getNom() { return nom; }
    public String getCognom() { return cognom; }
    public String getDorsal() { return dorsal; }
    public String getPosicio() { return posicio; }
    public float getMinutsTotals() { return minutsTotals; }
    public int getPuntsTotals() { return puntsTotals; }
    public int getTotalTirsAnotats() { return totalTirsAnotats; }
    public int getTotalTirsTirats() { return totalTirsTirats; }
    public int getTotalTriplesAnotats() { return totalTriplesAnotats; }
    public int getTotalTriplesTirats() { return totalTriplesTirats; }
    public int getTotalLliuresAnotats() { return totalLliuresAnotats; }


    // SETTERS
    public void setJugadorId(int jugadorId) { this.jugadorId = jugadorId; }
    public void setNom(String nom) { this.nom = nom; }
    public void setCognom(String cognom) { this.cognom = cognom; }
    public void setDorsal(String dorsal) { this.dorsal = dorsal; }
    public void setPosicio(String posicio) { this.posicio = posicio; }
    public void setMinutsTotals(float minutsTotals) { this.minutsTotals = minutsTotals; }
    public void setPuntsTotals(int puntsTotals) { this.puntsTotals = puntsTotals; }
    public void setTotalTirsAnotats(int totalTirsAnotats) { this.totalTirsAnotats = totalTirsAnotats; }
    public void setTotalTirsTirats(int totalTirsTirats) { this.totalTirsTirats = totalTirsTirats; }
    public void setTotalTriplesAnotats(int totalTriplesAnotats) { this.totalTriplesAnotats = totalTriplesAnotats; }
    public void setTotalTriplesTirats(int totalTriplesTirats) { this.totalTriplesTirats = totalTriplesTirats; }
    public void setTotalLliuresAnotats(int totalLliuresAnotats) { this.totalLliuresAnotats = totalLliuresAnotats; }
}
