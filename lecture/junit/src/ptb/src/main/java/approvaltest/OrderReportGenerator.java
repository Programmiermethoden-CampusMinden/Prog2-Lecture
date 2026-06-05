package approvaltest;

import java.util.List;

public class OrderReportGenerator {
    public static String generateReport(List<Order> orders) {
        var sb = new StringBuilder();
        sb.append("=== ORDER REPORT ===\n");
        orders.forEach(
                o -> {
                    sb.append("Order: ").append(o.id()).append("\n");
                    sb.append("Customer: ").append(o.customer()).append("\n");
                    sb.append("Items:\n");
                    o.items().forEach(item -> sb.append(" - ").append(item).append("\n"));
                    sb.append("\n");
                });
        sb.append("Total orders: ").append(orders.size()).append("\n");
        return sb.toString();
    }
}
