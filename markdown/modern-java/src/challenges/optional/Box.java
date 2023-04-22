package challenges.optional;

/**
 * @param xSize Breite des Kartons
 * @param ySize Länge des Kartons
 * @param zSize Höhe des Kartons
 * @param material Material des Karton
 */
public record Box(float xSize, float ySize, float zSize, Material material) {
}
