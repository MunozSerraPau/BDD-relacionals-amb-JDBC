package Model;

public class Partits {
    // VARIABLES
    private int partitId;
    private int equipId;
    private String  dataPartit;
    private String matx;
    private char resultat;


    // CONSTRUCTOR
    public Partits(int partitId, int equipId, String dataPartit, String matx, char resultat) {
        this.partitId = partitId;
        this.equipId = equipId;
        this.dataPartit = dataPartit;
        this.matx = matx;
        this.resultat = resultat;
    }

    // CONSTRUCTOR 2


    public Partits(int equipId, String dataPartit) {
        this.equipId = equipId;
        this.dataPartit = dataPartit;
    }

    // GETTERS
    public int getPartitId() { return partitId; }
    public int getEquipId() { return equipId; }
    public String getDataPartit() { return dataPartit; }
    public String getMatx() { return matx; }
    public char getResultat() { return resultat; }

    // SETTERS
    public void setPartitId(int partitId) { this.partitId = partitId; }
    public void setEquipId(int equipId) { this.equipId = equipId; }
    public void setDataPartit(String dataPartit) { this.dataPartit = dataPartit; }
    public void setMatx(String matx) { this.matx = matx; }
    public void setResultat(char resultat) { this.resultat = resultat; }
}
