package challenges;

class Auftrag {
    private WarenTyp warenTyp;
    private int anzahl;

    public Auftrag(WarenTyp warenTyp, int anzahl) {
        if(warenTyp == null){
            throw new IllegalArgumentException("Warentyp darf nicht null sein.");
        }
        if(anzahl <= 0){
            throw new IllegalArgumentException("Die Menge muss größer als 0 sein.");
        }
        this.warenTyp = warenTyp;
        this.anzahl = anzahl;
    }

    public WarenTyp getWarenTyp() {
        return warenTyp;
    }

    public int getAnzahl() {
        return anzahl;
    }
}
