package challenges;

/**
 * Eine Rechnung kann als Zahlungsforderung an Kunden gesendet werden
 *
 * @param betrag Summe die gezahlt werden muss
 * @param empfaenger Konto auf dem die Summe gesendet werden muss
 */
public record Rechnung(double betrag, Konto empfaenger) {}
