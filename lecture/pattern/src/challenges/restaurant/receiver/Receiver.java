package restaurant.receiver;

public interface Receiver {
  void prepare(String dish);

  void cancel(String dish);
}
