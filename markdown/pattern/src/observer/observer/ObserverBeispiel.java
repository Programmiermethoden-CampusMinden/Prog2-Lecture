package observer;

public class ObserverBeispiel {
    public static void main(String[] args) {
        Observer[] people = {new Lecturer("Frau Holle"),
                new Student("Heinz"),
                new Student("Karla"),
                new Tutor("Kolja"),
                new Student("Wuppie")};

        LSF lsf = new LSF();
        for (Observer p : people) {
            lsf.register(p);
        }

        lsf.notifyObservers();
    }
}
