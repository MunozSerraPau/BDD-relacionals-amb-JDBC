package Model;

public class Partits {
    // VARIABLES
    private String id;
    private Integer equipId;
    private Integer temporadaId;
    private String dataPartit;
    private String matx;
    private String resultat;
    private Integer punts;
    private Integer tirsAnotats;
    private Integer tirsIntentats;
    private Integer triplesAnotats;
    private Integer triplesIntentats;
    private Integer rebotsOfensius;
    private Integer rebotsDefensius;
    private Integer rebots;
    private Integer assistencies;
    private Integer robades;
    private Integer bloqueigs;


    // CONSTRUCTOR
    public Partits(String id, Integer equipId, Integer temporadaId, String dataPartit, String matx, String resultat, Integer punts, Integer tirsAnotats, Integer tirsIntentats, Integer triplesAnotats, Integer triplesIntentats, Integer rebotsOfensius, Integer rebotsDefensius, Integer rebots, Integer assistencies, Integer robades, Integer bloqueigs) {
        this.id = id;
        this.equipId = equipId;
        this.temporadaId = temporadaId;
        this.dataPartit = dataPartit;
        this.matx = matx;
        this.resultat = resultat;
        this.punts = punts;
        this.tirsAnotats = tirsAnotats;
        this.tirsIntentats = tirsIntentats;
        this.triplesAnotats = triplesAnotats;
        this.triplesIntentats = triplesIntentats;
        this.rebotsOfensius = rebotsOfensius;
        this.rebotsDefensius = rebotsDefensius;
        this.rebots = rebots;
        this.assistencies = assistencies;
        this.robades = robades;
        this.bloqueigs = bloqueigs;
    }


    //GETTERS
    public String getId() { return id; }
    public Integer getEquipId() { return equipId; }
    public Integer getTemporadaId() { return temporadaId; }
    public String getDataPartit() { return dataPartit; }
    public String getMatx() { return matx; }
    public String getResultat() { return resultat; }
    public Integer getPunts() { return punts; }
    public Integer getTirsAnotats() { return tirsAnotats; }
    public Integer getTirsIntentats() { return tirsIntentats; }
    public Integer getTriplesAnotats() { return triplesAnotats; }
    public Integer getTriplesIntentats() { return triplesIntentats; }
    public Integer getRebotsOfensius() { return rebotsOfensius; }
    public Integer getRebotsDefensius() { return rebotsDefensius; }
    public Integer getRebots() { return rebots; }
    public Integer getAssistencies() { return assistencies; }
    public Integer getRobades() { return robades; }
    public Integer getBloqueigs() { return bloqueigs; }


    // SETTER
    public void setId(String id) { this.id = id; }
    public void setEquipId(Integer equipId) { this.equipId = equipId; }
    public void setTemporadaId(Integer temporadaId) { this.temporadaId = temporadaId; }
    public void setDataPartit(String dataPartit) { this.dataPartit = dataPartit; }
    public void setMatx(String matx) { this.matx = matx; }
    public void setResultat(String resultat) { this.resultat = resultat; }
    public void setPunts(Integer punts) { this.punts = punts; }
    public void setTirsAnotats(Integer tirsAnotats) { this.tirsAnotats = tirsAnotats; }
    public void setTirsIntentats(Integer tirsIntentats) { this.tirsIntentats = tirsIntentats; }
    public void setTriplesAnotats(Integer triplesAnotats) { this.triplesAnotats = triplesAnotats; }
    public void setTriplesIntentats(Integer triplesIntentats) { this.triplesIntentats = triplesIntentats; }
    public void setRebotsOfensius(Integer rebotsOfensius) { this.rebotsOfensius = rebotsOfensius; }
    public void setRebotsDefensius(Integer rebotsDefensius) { this.rebotsDefensius = rebotsDefensius; }
    public void setRebots(Integer rebots) { this.rebots = rebots; }
    public void setAssistencies(Integer assistencies) { this.assistencies = assistencies; }
    public void setRobades(Integer robades) { this.robades = robades; }
    public void setBloqueigs(Integer bloqueigs) { this.bloqueigs = bloqueigs; }
}
