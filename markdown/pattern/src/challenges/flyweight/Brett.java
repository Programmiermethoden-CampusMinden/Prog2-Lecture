package challenges.flyweight;

import java.util.Arrays;

public class Brett {

    public Figur[] figuren = new Figur[32];

    public static Brett erstelleNeuesSchachBrett() {
        Brett brett = new Brett();
        for (int i = 0; i < 8; i++) {
            brett.figuren[i] =
                    Figur.erstelleFigur(
                            Figur.FigurArt.BAUER, new Position(i, 6), Figur.Seite.SCHWARZ);
        }
        for (int i = 0; i < 8; i++) {
            brett.figuren[i + 8] =
                    Figur.erstelleFigur(
                            Figur.FigurArt.BAUER, new Position(i, 1), Figur.Seite.WEISS);
        }

        brett.figuren[16] =
                Figur.erstelleFigur(Figur.FigurArt.TURM, new Position(0, 0), Figur.Seite.SCHWARZ);
        brett.figuren[17] =
                Figur.erstelleFigur(Figur.FigurArt.TURM, new Position(7, 0), Figur.Seite.SCHWARZ);
        brett.figuren[18] =
                Figur.erstelleFigur(Figur.FigurArt.TURM, new Position(0, 7), Figur.Seite.WEISS);
        brett.figuren[19] =
                Figur.erstelleFigur(Figur.FigurArt.TURM, new Position(7, 7), Figur.Seite.WEISS);

        brett.figuren[20] =
                Figur.erstelleFigur(
                        Figur.FigurArt.SPRINGER, new Position(1, 0), Figur.Seite.SCHWARZ);
        brett.figuren[21] =
                Figur.erstelleFigur(
                        Figur.FigurArt.SPRINGER, new Position(6, 0), Figur.Seite.SCHWARZ);
        brett.figuren[22] =
                Figur.erstelleFigur(Figur.FigurArt.SPRINGER, new Position(1, 7), Figur.Seite.WEISS);
        brett.figuren[23] =
                Figur.erstelleFigur(Figur.FigurArt.SPRINGER, new Position(6, 7), Figur.Seite.WEISS);

        brett.figuren[24] =
                Figur.erstelleFigur(
                        Figur.FigurArt.LAEUFER, new Position(2, 0), Figur.Seite.SCHWARZ);
        brett.figuren[25] =
                Figur.erstelleFigur(
                        Figur.FigurArt.LAEUFER, new Position(5, 0), Figur.Seite.SCHWARZ);
        brett.figuren[26] =
                Figur.erstelleFigur(Figur.FigurArt.LAEUFER, new Position(2, 7), Figur.Seite.WEISS);
        brett.figuren[27] =
                Figur.erstelleFigur(Figur.FigurArt.LAEUFER, new Position(5, 7), Figur.Seite.WEISS);

        brett.figuren[28] =
                Figur.erstelleFigur(Figur.FigurArt.DAME, new Position(5, 0), Figur.Seite.SCHWARZ);
        brett.figuren[29] =
                Figur.erstelleFigur(Figur.FigurArt.DAME, new Position(4, 7), Figur.Seite.WEISS);

        brett.figuren[30] =
                Figur.erstelleFigur(Figur.FigurArt.KOENIG, new Position(4, 0), Figur.Seite.SCHWARZ);
        brett.figuren[31] =
                Figur.erstelleFigur(Figur.FigurArt.KOENIG, new Position(5, 7), Figur.Seite.WEISS);

        return brett;
    }

    @Override
    public String toString() {
        return "Brett{" + "figuren=" + Arrays.toString(figuren) + '}';
    }
}
