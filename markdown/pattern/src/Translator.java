interface ITranslator {
    String translate(String s);
}

class DE implements ITranslator {
    @Override
    public String translate(String s) {
        // mach was mit `s` ...
        return s;
    }
}

class ES implements ITranslator {
    @Override
    public String translate(String s) {
        // mach was mit `s` ...
        return s;
    }
}

class Translator {
    private final ITranslator translator;

    Translator(ITranslator t) {
        translator = t;
    }

    public String getMessage() {
        return translator.translate("hello world");
    }

    // Test des Uebersetzers
    public static void main(String[] args) {
        Translator j = new Translator(new DE());
        j.getMessage(); // Ausgabe in deutscher Sprache

        Translator k = new Translator(new ES());
        k.getMessage(); // Ausgabe in spanischer Sprache
    }
}
