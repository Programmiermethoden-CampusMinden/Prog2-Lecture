package dependency.challenge;

public class OnlineExchangeRateProvider {
  public double getRate(String from, String to) {
    // Hier könnte z.B. ein HTTP-Call stehen
    IO.println("Frage Online-Dienst nach Wechselkurs " + from + " -> " + to);
    return 1.1; // Dummy-Wert
  }
}
