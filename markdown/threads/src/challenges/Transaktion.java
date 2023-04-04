package challenges;

/**
 * Eine Transaktion bearbeitet eine Rechnung
 *
 * @param von Konto von dem aus die Rechnung bezahlt werden soll
 * @param rechnung Die zu bezahlende Rechnung
 */
public record Transaktion(Konto von, Rechnung rechnung) {}
