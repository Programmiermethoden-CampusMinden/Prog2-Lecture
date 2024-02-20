package challenges.flyweight;

import java.util.Arrays;

public class Figur {
    public static final int TEXTURE_GROESSE = 4096;
    Position position;
    Seite seite;
    Typ typ;

    public Figur(Position position, Seite seite, Typ typ) {
        this.position = position;
        this.seite = seite;
        this.typ = typ;
    }

    public static Figur erstelleFigur(FigurArt figurArt, Position position, Seite seite) {
        Figur figur = null;
        switch (figurArt) {
            case BAUER:
                figur =
                        new Figur(
                                position,
                                seite,
                                new Typ("Bauer", "./irgendwo/bauerbild.png", loadBauerTexture()));
                break;
            case TURM:
                figur =
                        new Figur(
                                position,
                                seite,
                                new Typ("Turm", "./irgendwo/turmbild.png", loadTurmTexture()));
                break;
            case SPRINGER:
                figur =
                        new Figur(
                                position,
                                seite,
                                new Typ(
                                        "Springer",
                                        "./irgendwo/springerbild.png",
                                        loadSpringerTexture()));
                break;
            case LAEUFER:
                figur =
                        new Figur(
                                position,
                                seite,
                                new Typ(
                                        "Laeufer",
                                        "./irgendwo/laeuferbild.png",
                                        loadLaeuferTexture()));
                break;
            case DAME:
                figur =
                        new Figur(
                                position,
                                seite,
                                new Typ("Dame", "./irgendwo/damebild.png", loadDameTexture()));
                break;
            case KOENIG:
                figur =
                        new Figur(
                                position,
                                seite,
                                new Typ(
                                        "Koenig",
                                        "./irgendwo/koenigbild.png",
                                        loadKoenigTexture()));
                break;
        }
        return figur;
    }

    private static byte[] loadBauerTexture() {
        byte[] texture = new byte[TEXTURE_GROESSE];
        Arrays.fill(texture, (byte) 1);
        return texture;
    }

    private static byte[] loadTurmTexture() {
        byte[] texture = new byte[TEXTURE_GROESSE];
        Arrays.fill(texture, (byte) 2);
        return texture;
    }

    private static byte[] loadSpringerTexture() {
        byte[] texture = new byte[TEXTURE_GROESSE];
        Arrays.fill(texture, (byte) 3);
        return texture;
    }

    private static byte[] loadLaeuferTexture() {
        byte[] texture = new byte[TEXTURE_GROESSE];
        Arrays.fill(texture, (byte) 4);
        return texture;
    }

    private static byte[] loadDameTexture() {
        byte[] texture = new byte[TEXTURE_GROESSE];
        Arrays.fill(texture, (byte) 5);
        return texture;
    }

    private static byte[] loadKoenigTexture() {
        byte[] texture = new byte[TEXTURE_GROESSE];
        Arrays.fill(texture, (byte) 6);
        return texture;
    }

    @Override
    public String toString() {
        return "Figur{" + "position=" + position + ", seite=" + seite + ", typ=" + typ + '}';
    }

    public enum Seite {
        SCHWARZ,
        WEISS
    }

    public enum FigurArt {
        BAUER,
        TURM,
        SPRINGER,
        LAEUFER,
        DAME,
        KOENIG
    }
}
