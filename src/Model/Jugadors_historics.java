package Model;

public class Jugadors_historics {
    // variables
    private int jugador_Id;
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
    private int totalLliuresTirars;
    private int totalRebotsOfensius;
    private int totalRebotsDefensius;
    private int totalAssistencies;
    private int totalRobades;
    private int totalBloqueigs;


    // CONSTRUCTOR
    public Jugadors_historics(int jugador_Id, String nom, String cognom, String dorsal, String posicio, float minutsTotals, int puntsTotals, int totalTirsAnotats, int totalTirsTirats, int totalTriplesAnotats, int totalTriplesTirats, int totalLliuresAnotats, int totalLliuresTirars, int totalRebotsOfensius, int totalRebotsDefensius, int totalAssistencies, int totalRobades, int totalBloqueigs) {
        this.jugador_Id = jugador_Id;
        this.nom = nom;
        this.cognom = cognom;
        this.dorsal = dorsal;
        this.posicio = posicio;
        this.minutsTotals = minutsTotals;
        this.puntsTotals = puntsTotals;
        this.totalTirsAnotats = totalTirsAnotats;
        this.totalTirsTirats = totalTirsTirats;
        this.totalTriplesAnotats = totalTriplesAnotats;
        this.totalTriplesTirats = totalTriplesTirats;
        this.totalLliuresAnotats = totalLliuresAnotats;
        this.totalLliuresTirars = totalLliuresTirars;
        this.totalRebotsOfensius = totalRebotsOfensius;
        this.totalRebotsDefensius = totalRebotsDefensius;
        this.totalAssistencies = totalAssistencies;
        this.totalRobades = totalRobades;
        this.totalBloqueigs = totalBloqueigs;

    }

    // GETTERS
    public int getJugador_Id() { return jugador_Id; }
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
    public int getTotalLliuresTirars() { return totalLliuresTirars; }
    public int getTotalRebotsOfensius() { return totalRebotsOfensius; }
    public int getTotalRebotsDefensius() { return totalRebotsDefensius; }
    public int getTotalAssistencies() { return totalAssistencies; }
    public int getTotalRobades() { return totalRobades; }
    public int getTotalBloqueigs() { return totalBloqueigs; }

    // SETTERS
    public void setJugador_Id(int jugador_Id) { this.jugador_Id = jugador_Id; }
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
    public void setTotalLliuresTirars(int totalLliuresTirars) { this.totalLliuresTirars = totalLliuresTirars; }
    public void setTotalRebotsOfensius(int totalRebotsOfensius) { this.totalRebotsOfensius = totalRebotsOfensius; }
    public void setTotalRebotsDefensius(int totalRebotsDefensius) { this.totalRebotsDefensius = totalRebotsDefensius; }
    public void setTotalAssistencies(int totalAssistencies) { this.totalAssistencies = totalAssistencies; }
    public void setTotalRobades(int totalRobades) { this.totalRobades = totalRobades; }
    public void setTotalBloqueigs(int totalBloqueigs) { this.totalBloqueigs = totalBloqueigs; }
}
