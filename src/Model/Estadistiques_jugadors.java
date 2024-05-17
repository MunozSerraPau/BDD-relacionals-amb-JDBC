package Model;

public class Estadistiques_jugadors {

    // VARIABLES
    private int jugadorId;
    private int equipId;
    private int partitId;
    private double minutsJugats;
    private int punts;
    private int tirsAnotats;
    private int tirsTirats;
    private int tirsTriplesAnotats;
    private int tirsTriplesTirats;
    private int tirsLliuresAnotats;
    private int tirsLliuresTirats;
    private int rebotsOfensius;
    private int rebotsDefensius;
    private int assistencies;
    private int robades;
    private int bloqueigs;


    // CONSTRUCTOR
    public Estadistiques_jugadors (int jugadorId, int equipId, int partitId, double minutsJugats, int punts, int tirsAnotats, int tirsTirats, int tirsTriplesAnotats, int tirsTriplesTirats, int tirsLliuresAnotats, int tirsLliuresTirats, int rebotsOfensius, int rebotsDefensius, int assistencies, int robades, int bloqueigs) {
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


    // GETTERS
    public int getJugadorId() { return jugadorId; }
    public int getEquipId() { return equipId; }
    public int getPartitId() { return partitId; }
    public double getMinutsJugats() { return minutsJugats; }
    public int getPunts() { return punts; }
    public int getTirsAnotats() { return tirsAnotats; }
    public int getTirsTirats() { return tirsTirats; }
    public int getTirsTriplesAnotats() { return tirsTriplesAnotats; }
    public int getTirsTriplesTirats() { return tirsTriplesTirats; }
    public int getTirsLliuresAnotats() { return tirsLliuresAnotats; }
    public int getTirsLliuresTirats() { return tirsLliuresTirats; }
    public int getRebotsOfensius() { return rebotsOfensius; }
    public int getRebotsDefensius() { return rebotsDefensius; }
    public int getAssistencies() { return assistencies; }
    public int getRobades() { return robades; }
    public int getBloqueigs() { return bloqueigs; }


    // SETTERS
    public void setJugadorId(int jugadorId) { this.jugadorId = jugadorId; }
    public void setEquipId(int equipId) { this.equipId = equipId; }
    public void setPartitId(int partitId) { this.partitId = partitId; }
    public void setMinutsJugats(double minutsJugats) { this.minutsJugats = minutsJugats; }
    public void setPunts(int punts) { this.punts = punts; }
    public void setTirsAnotats(int tirsAnotats) { this.tirsAnotats = tirsAnotats; }
    public void setTirsTirats(int tirsTirats) { this.tirsTirats = tirsTirats; }
    public void setTirsTriplesAnotats(int tirsTriplesAnotats) { this.tirsTriplesAnotats = tirsTriplesAnotats; }
    public void setTirsTriplesTirats(int tirsTriplesTirats) { this.tirsTriplesTirats = tirsTriplesTirats; }
    public void setTirsLliuresAnotats(int tirsLliuresAnotats) { this.tirsLliuresAnotats = tirsLliuresAnotats; }
    public void setTirsLliuresTirats(int tirsLliuresTirats) { this.tirsLliuresTirats = tirsLliuresTirats; }
    public void setRebotsOfensius(int rebotsOfensius) { this.rebotsOfensius = rebotsOfensius; }
    public void setRebotsDefensius(int rebotsDefensius) { this.rebotsDefensius = rebotsDefensius; }
    public void setAssistencies(int assistencies) { this.assistencies = assistencies; }
    public void setRobades(int robades) { this.robades = robades; }
    public void setBloqueigs(int bloqueigs) { this.bloqueigs = bloqueigs; }
}
