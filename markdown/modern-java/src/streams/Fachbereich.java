package streams;

import java.util.List;

/** Ein Fachbereich */
public record Fachbereich(String name, List<Studiengang> studiengaenge) {}
