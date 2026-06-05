package approvaltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class OrderReportGeneratorTest {

    @Test
    void report_looks_as_expected() {
        // given
        List<Order> orders =
                List.of(
                        new Order("A-001", "Alice", List.of("Keyboard", "Mouse")),
                        new Order("B-002", "Bob", List.of("Laptop")),
                        new Order("C-003", "Charlie", List.of("Monitor", "HDMI Cable", "USB Hub")));
        String expected =
                """
                === ORDER REPORT ===
                Order: A-001
                Customer: Alice
                Items:
                 - Keyboard
                 - Mouse

                Order: B-002
                Customer: Bob
                Items:
                 - Laptop

                Order: C-003
                Customer: Charlie
                Items:
                 - Monitor
                 - HDMI Cable
                 - USB Hub

                Total orders: 3
                """;

        // when
        String report = OrderReportGenerator.generateReport(orders);

        // then
        assertEquals(expected, report);
        Approvals.verify(report);
    }
}
