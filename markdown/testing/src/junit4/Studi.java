package junit4;

public class Studi {
    private String name = "";
    private int credits = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name darf nicht NULL sein");
        }

        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void addToCredits(int credits) {
        if (credits < 0) {
            throw new IllegalArgumentException("Negative Credits nicht erlaubt");
        }
        if (this.credits + credits > 210) {
            throw new IllegalArgumentException("Mehr als 210 Credits nicht erlaubt");
        }

        this.credits += credits;
    }
}
