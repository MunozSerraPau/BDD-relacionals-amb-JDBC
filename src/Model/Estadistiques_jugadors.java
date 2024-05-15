package Model;

public class Estadistiques_jugadors {

    // VARIABLES
    private int jugadorId;
    private int equipoId;
    private int partidoId;
    private float minutosJugados;
    private int puntos;
    private int tirosAnotados;
    private int tirosTirados;
    private int tirosTriplesAnotados;
    private int tirosTriplesTirados;
    private int tirosLibresAnotados;
    private int tirosLibresTirados;
    private int rebotesOfensivos;
    private int rebotesDefensivos;
    private int asistencias;
    private int robos;
    private int bloqueos;


    // CONSTRUCTOR

    public Estadistiques_jugadors(int jugadorId, int equipoId, int partidoId, float minutosJugados, int puntos, int tirosAnotados, int tirosTirados, int tirosTriplesAnotados, int tirosTriplesTirados, int tirosLibresAnotados, int tirosLibresTirados, int rebotesOfensivos, int rebotesDefensivos, int asistencias, int robos, int bloqueos) {
        this.jugadorId = jugadorId;
        this.equipoId = equipoId;
        this.partidoId = partidoId;
        this.minutosJugados = minutosJugados;
        this.puntos = puntos;
        this.tirosAnotados = tirosAnotados;
        this.tirosTirados = tirosTirados;
        this.tirosTriplesAnotados = tirosTriplesAnotados;
        this.tirosTriplesTirados = tirosTriplesTirados;
        this.tirosLibresAnotados = tirosLibresAnotados;
        this.tirosLibresTirados = tirosLibresTirados;
        this.rebotesOfensivos = rebotesOfensivos;
        this.rebotesDefensivos = rebotesDefensivos;
        this.asistencias = asistencias;
        this.robos = robos;
        this.bloqueos = bloqueos;
    }


    // GETTERS
    public int getJugadorId() { return jugadorId; }
    public int getEquipoId() { return equipoId; }
    public int getPartidoId() { return partidoId; }
    public float getMinutosJugados() { return minutosJugados; }
    public int getPuntos() { return puntos; }
    public int getTirosAnotados() { return tirosAnotados; }
    public int getTirosTirados() { return tirosTirados; }
    public int getTirosTriplesAnotados() { return tirosTriplesAnotados; }
    public int getTirosTriplesTirados() { return tirosTriplesTirados; }
    public int getTirosLibresAnotados() { return tirosLibresAnotados; }
    public int getTirosLibresTirados() { return tirosLibresTirados; }
    public int getRebotesOfensivos() { return rebotesOfensivos; }
    public int getRebotesDefensivos() { return rebotesDefensivos; }
    public int getAsistencias() { return asistencias; }
    public int getRobos() { return robos; }
    public int getBloqueos() { return bloqueos; }


    // SETTERS
    public void setJugadorId(int jugadorId) { this.jugadorId = jugadorId; }
    public void setEquipoId(int equipoId) { this.equipoId = equipoId; }
    public void setPartidoId(int partidoId) { this.partidoId = partidoId; }
    public void setMinutosJugados(float minutosJugados) { this.minutosJugados = minutosJugados; }
    public void setPuntos(int puntos) { this.puntos = puntos; }
    public void setTirosAnotados(int tirosAnotados) { this.tirosAnotados = tirosAnotados; }
    public void setTirosTirados(int tirosTirados) { this.tirosTirados = tirosTirados; }
    public void setTirosTriplesAnotados(int tirosTriplesAnotados) { this.tirosTriplesAnotados = tirosTriplesAnotados; }
    public void setTirosTriplesTirados(int tirosTriplesTirados) { this.tirosTriplesTirados = tirosTriplesTirados; }
    public void setTirosLibresAnotados(int tirosLibresAnotados) { this.tirosLibresAnotados = tirosLibresAnotados; }
    public void setTirosLibresTirados(int tirosLibresTirados) { this.tirosLibresTirados = tirosLibresTirados; }
    public void setRebotesOfensivos(int rebotesOfensivos) { this.rebotesOfensivos = rebotesOfensivos; }
    public void setRebotesDefensivos(int rebotesDefensivos) { this.rebotesDefensivos = rebotesDefensivos; }
    public void setAsistencias(int asistencias) { this.asistencias = asistencias; }
    public void setRobos(int robos) { this.robos = robos; }
    public void setBloqueos(int bloqueos) { this.bloqueos = bloqueos; }
}
