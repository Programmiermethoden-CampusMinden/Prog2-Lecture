package debugging;

import java.util.Collections;
import java.util.List;

public class DebugDemo {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(2, 4, 6, 8, 10);

    var sum = sumEvenNumbers(numbers);
    IO.println("Erwartete Summe: 30, berechnet: " + sum);

    var median = median(numbers);
    IO.println("Erwarteter Median: 6, berechnet: " + median);
  }

  /** Summiert alle geraden Zahlen in der Liste. */
  static int sumEvenNumbers(List<Integer> numbers) {
    var sum = 0;
    for (int i = 1; i < numbers.size(); i++) {
      var n = numbers.get(i);
      int x = 9;
      if (n % 2 == 0) sum += n;
    }
    return sum;
  }

  /** Berechnet den Median der Liste (vereinfachte Variante für ungerade Anzahl). */
  static int median(List<Integer> numbers) {
    Collections.sort(numbers);

    var middle = numbers.size() / 2;
    return numbers.get(middle);
  }
}
