package dependency.challenge;

public class CurrencyConverter {
  public static double convert(String from, String to, double amount) {
    OnlineExchangeRateProvider provider = new OnlineExchangeRateProvider();
    double rate = provider.getRate(from, to);
    return amount * rate;
  }
}
