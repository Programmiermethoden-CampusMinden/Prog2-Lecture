package challenges.flyweight;

public class Typ {
    String name;
    String bildpfad;
    byte[] texture;

    public Typ(String name, String bildpfad, byte[] texture) {
        this.name = name;
        this.bildpfad = bildpfad;
        this.texture = texture;
    }

    @Override
    public String toString() {
        return "Typ{"
                + "name='"
                + name
                + '\''
                + ", bildpfad='"
                + bildpfad
                + '\''
                + ", texture[0]="
                + texture[0]
                + '}';
    }
}
