package Model;

public class Jugadres {
    // VARIABLES
    private int jugadorId;
    private String nom;
    private String cognom;
    private String dataNaixement;
    private float alcada;
    private float pes;
    private String dorsal;
    private String posicio;
    private int equipId;


    // CONSTRUCTOR 1
    public Jugadres(int jugadorId, String nom, String cognom, String dataNaixement, float alcada, float pes, String dorsal, String posicio, int equipId) {
        this.jugadorId = jugadorId;
        this.nom = nom;
        this.cognom = cognom;
        this.dataNaixement = dataNaixement;
        this.alcada = alcada;
        this.pes = pes;
        this.dorsal = dorsal;
        this.posicio = posicio;
        this.equipId = equipId;
    }

    // CONSTRUCTOR 2
    public Jugadres(int jugadorId, String nom, int equipId) {
        this.jugadorId = jugadorId;
        this.nom = nom;
        this.equipId = equipId;
    }

    // CONSTRUCTOR 1
    public Jugadres(String nom) {
        this.nom = nom;
    }

    // GETTERS
    public int getJugadorId() { return jugadorId; }
    public String getNom() { return nom; }
    public String getCognom() { return cognom; }
    public String getDataNaixement() { return dataNaixement; }
    public float getAlcada() { return alcada; }
    public float getPes() { return pes; }
    public String getDorsal() { return dorsal; }
    public String getPosicio() { return posicio; }
    public int getEquipId() { return equipId; }


    // SETTER
    public void setJugadorId(int jugadorId) { this.jugadorId = jugadorId; }
    public void setNom(String nom) { this.nom = nom; }
    public void setCognom(String cognom) { this.cognom = cognom; }
    public void setDataNaixement(String dataNaixement) { this.dataNaixement = dataNaixement; }
    public void setAlcada(float alcada) { this.alcada = alcada; }
    public void setPes(float pes) { this.pes = pes; }
    public void setDorsal(String dorsal) { this.dorsal = dorsal; }
    public void setPosicio(String posicio) { this.posicio = posicio; }
    public void setEquipId(int equipId) { this.equipId = equipId; }
}

