package challenges.regexp;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public final class LexerUI {
    private final JTextArea inputArea = new JTextArea();
    private final JTextPane outputPane = new JTextPane();

    public LexerUI() {
        outputPane.setEditable(false);

        JFrame frame = new JFrame("LexerUI");
        JPanel labelPanel = new JPanel(new GridLayout(1, 2));
        labelPanel.add(new JLabel("Input:"));
        labelPanel.add(new JLabel("Output:"));
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.add(new JScrollPane(inputArea));
        mainPanel.add(new JScrollPane(outputPane));
        frame.add(labelPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        inputArea
                .getDocument()
                .addDocumentListener(
                        new DocumentListener() {
                            @Override
                            public void insertUpdate(DocumentEvent e) {
                                convert();
                            }

                            @Override
                            public void removeUpdate(DocumentEvent e) {
                                convert();
                            }

                            @Override
                            public void changedUpdate(DocumentEvent e) {
                                convert();
                            }
                        });

        String inputText = """
                package controller;

                import com.badlogic.gdx.Game;
                import com.badlogic.gdx.graphics.g2d.SpriteBatch;

                /* ApplicationListener that delegates to the MainGameController. Just some setup. */
                public class LibgdxSetup extends Game {
                    private final MainController mc;

                    /**
                     * The batch is necessary to draw ALL the stuff. Every object that uses draw need to know the
                     * batch.
                     */
                    private SpriteBatch batch;
                    // This batch is used to //draw the HUD /*elements*/ on it.\040
                    private SpriteBatch hudBatch;

                    /**
                     * "ApplicationListener" that delegates to the "MainGameController". Just some setup.
                     */
                    public LibgdxSetup(MainController mc) {
                        this.mc = mc;
                    }

                    @Over-ride 'someText'
                    public void create() {
                        // new ...
                        char ch = new Character('a');
                        return null;
                    }
                }
                """;
        inputArea.setText(inputText);

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void convert() {
        final String inputText = inputArea.getText();

        Lexer lexer = new Lexer();
        List<MyMatchResult> tokens = lexer.tokenize(inputText);

        // Sort the list so that other surrounding elements are placed last.
        for (int i = 0; i < tokens.size(); i++) {
            for (int j = i + 1; j < tokens.size(); j++) {
                if (isSurrounded(tokens.get(i), tokens.get(j))) {
                    Collections.swap(tokens, i, j);
                }
            }
        }

        outputPane.setText(inputText);
        Highlighter hl = outputPane.getHighlighter();
        try {
            for (MyMatchResult match : tokens) {
                hl.addHighlight(
                        match.start(),
                        match.end(),
                        new DefaultHighlighter.DefaultHighlightPainter(match.token.color));
            }
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isSurrounded(MyMatchResult inner, MyMatchResult outer) {
        return inner != outer && outer.start() <= inner.start() && outer.end() >= inner.end();
    }
}
