package approvaltest;

import java.util.List;

public record Order(String id, String customer, List<String> items) {}
