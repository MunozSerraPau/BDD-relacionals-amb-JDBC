package Model;

public class  Estadistiques_jugadors {

    // VARIABLES
    private int jugadorId;
    private int equipId;
    private int partitId;
    private float minutsJugats;
    private float punts;
    private int tirsAnotats;
    private int tirsTirats;
    private int tirsTriplesAnotats;
    private int tirsTriplesTirats;
    private int tirsLliuresAnotats;
    private int tirsLliuresTirats;
    private int rebotsOfensius;
    private int rebotsDefensius;
    private float assistencies;
    private float robades;
    private float bloqueigs;


    // CONSTRUCTOR 1
    public Estadistiques_jugadors (int jugadorId, int equipId, int partitId, float minutsJugats, int punts, int tirsAnotats, int tirsTirats, int tirsTriplesAnotats, int tirsTriplesTirats, int tirsLliuresAnotats, int tirsLliuresTirats, int rebotsOfensius, int rebotsDefensius, int assistencies, int robades, int bloqueigs) {
        this.jugadorId = jugadorId;
        this.equipId = equipId;
        this.partitId = partitId;
        this.minutsJugats = minutsJugats;
        this.punts = punts;
        this.tirsAnotats = tirsAnotats;
        this.tirsTirats = tirsTirats;
        this.tirsTriplesAnotats = tirsTriplesAnotats;
        this.tirsTriplesTirats = tirsTriplesTirats;
        this.tirsLliuresAnotats = tirsLliuresAnotats;
        this.tirsLliuresTirats = tirsLliuresTirats;
        this.rebotsOfensius = rebotsOfensius;
        this.rebotsDefensius = rebotsDefensius;
        this.assistencies = assistencies;
        this.robades = robades;
        this.bloqueigs = bloqueigs;
    }

    // CONSTRUCTOR 2
    public Estadistiques_jugadors(float punts, float assistencies, float robades, float bloqueigs) {
        this.punts = punts;
        this.assistencies = assistencies;
        this.robades = robades;
        this.bloqueigs = bloqueigs;
    }

    // GETTERS
    public int getJugadorId() { return jugadorId; }
    public int getEquipId() { return equipId; }
    public int getPartitId() { return partitId; }
    public float getMinutsJugats() { return minutsJugats; }
    public float getPunts() { return punts; }
    public int getTirsAnotats() { return tirsAnotats; }
    public int getTirsTirats() { return tirsTirats; }
    public int getTirsTriplesAnotats() { return tirsTriplesAnotats; }
    public int getTirsTriplesTirats() { return tirsTriplesTirats; }
    public int getTirsLliuresAnotats() { return tirsLliuresAnotats; }
    public int getTirsLliuresTirats() { return tirsLliuresTirats; }
    public int getRebotsOfensius() { return rebotsOfensius; }
    public int getRebotsDefensius() { return rebotsDefensius; }
    public float getAssistencies() { return assistencies; }
    public float getRobades() { return robades; }
    public float getBloqueigs() { return bloqueigs; }


    // SETTERS
    public void setJugadorId(int jugadorId) { this.jugadorId = jugadorId; }
    public void setEquipId(int equipId) { this.equipId = equipId; }
    public void setPartitId(int partitId) { this.partitId = partitId; }
    public void setMinutsJugats(float minutsJugats) { this.minutsJugats = minutsJugats; }
    public void setPunts(float punts) { this.punts = punts; }
    public void setTirsAnotats(int tirsAnotats) { this.tirsAnotats = tirsAnotats; }
    public void setTirsTirats(int tirsTirats) { this.tirsTirats = tirsTirats; }
    public void setTirsTriplesAnotats(int tirsTriplesAnotats) { this.tirsTriplesAnotats = tirsTriplesAnotats; }
    public void setTirsTriplesTirats(int tirsTriplesTirats) { this.tirsTriplesTirats = tirsTriplesTirats; }
    public void setTirsLliuresAnotats(int tirsLliuresAnotats) { this.tirsLliuresAnotats = tirsLliuresAnotats; }
    public void setTirsLliuresTirats(int tirsLliuresTirats) { this.tirsLliuresTirats = tirsLliuresTirats; }
    public void setRebotsOfensius(int rebotsOfensius) { this.rebotsOfensius = rebotsOfensius; }
    public void setRebotsDefensius(int rebotsDefensius) { this.rebotsDefensius = rebotsDefensius; }
    public void setAssistencies(float assistencies) { this.assistencies = assistencies; }
    public void setRobades(float robades) { this.robades = robades; }
    public void setBloqueigs(float bloqueigs) { this.bloqueigs = bloqueigs; }
}
