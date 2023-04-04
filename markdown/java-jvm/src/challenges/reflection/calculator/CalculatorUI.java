package challenges.reflection.calculator;

import operations.IOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

public class CalculatorUI extends JFrame {

    private JTextField numberOne = new JTextField("Number 1");
    private JTextField numberTwo = new JTextField("Number 2");
    private JComboBox<String> operationSelection = new JComboBox<>();
    private Map<String, IOperation> operationMap;
    private JLabel solution = new JLabel("");

    private File directory;

    public CalculatorUI() {
        fileSelector();
        init();
    }

    private void fileSelector() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            directory = fileChooser.getSelectedFile();
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.exit(0);
        } else {
            fileSelector();
        }

    }

    private void init() {
        createFrame();
        setup();
        update();
    }

    private void createFrame() {
        setTitle("Calculator");
        setSize(480, 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setup() {
        JPanel panel = new JPanel();
        panel.add(numberOne);
        updateOperationSelection();
        panel.add(operationSelection);
        panel.add(numberTwo);
        JButton solutionButton = new JButton("=");
        solutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    solution.setText("" + calculate());
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input.");
                }
                update();
            }
        });
        panel.add(solutionButton);
        panel.add(solution);
        JButton updateButton = new JButton("reload operations");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOperationSelection();
                update();
            }
        });
        JButton loadButton = new JButton("Load from new directory");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileSelector();
                updateOperationSelection();
                update();
            }
        });
        add(BorderLayout.NORTH, panel);
        JPanel southPanel = new JPanel();
        southPanel.add(updateButton);
        southPanel.add(loadButton);
        add(BorderLayout.SOUTH, southPanel);
    }

    private int calculate() throws NumberFormatException {
        IOperation operation = operationMap.get(operationSelection.getSelectedItem());
        int a = Integer.parseInt(numberOne.getText().replaceAll("\\s", ""));
        int b = Integer.parseInt(numberTwo.getText().replaceAll("\\s", ""));
        return operation.doOperation(a, b);
    }

    private void updateOperationSelection() {
        operationMap = OperationLoader.loadOperations(directory);
        operationSelection.removeAllItems();
        for (Map.Entry<String, IOperation> operation : operationMap.entrySet()) {
            operationSelection.addItem(operation.getKey());
        }
    }

    private void update() {
        revalidate();
        repaint();
    }
}
