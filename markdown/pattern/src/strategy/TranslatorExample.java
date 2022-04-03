package strategy;

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

class TranslatorExample {
    private final ITranslator translator;

    TranslatorExample(ITranslator t) {
        translator = t;
    }

    public String getMessage() {
        return translator.translate("hello world");
    }

    // Test des Uebersetzers
    public static void main(String[] args) {
        TranslatorExample j = new TranslatorExample(new DE());
        j.getMessage(); // Ausgabe in deutscher Sprache

        TranslatorExample k = new TranslatorExample(new ES());
        k.getMessage(); // Ausgabe in spanischer Sprache
    }
}
