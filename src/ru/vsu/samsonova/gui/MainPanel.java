package ru.vsu.samsonova.gui;

import ru.vsu.samsonova.SimpleLinkedListStack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel
{
    private JLabel stackOfObjectsLabel = new JLabel("Enter an object for push to stack:");
    private JTextField stackOfObjectsTextField = new JTextField();
    private JLabel doubleStackLabel = new JLabel("Double stack:");
    private JTextField doubleStackTextField = new JTextField();
    private JButton doubleButton = new JButton("Double");
    private JButton clearButton = new JButton("Clear");
    private JButton pushButton = new JButton("Push");

    private final Font font = new Font("SanSerif", Font.PLAIN, 14);
    private final Color backgroundColor = new Color(132, 236, 203);

    private SimpleLinkedListStack<String> stack = new SimpleLinkedListStack<>();


    public MainPanel()
    {
        setLayout(null);
        setFont(font);
        setBackground(backgroundColor);

        stackOfObjectsLabel.setBounds(40, 40, 190, 30);
        add(stackOfObjectsLabel);
        stackOfObjectsTextField.setBounds(230, 40, 395, 30);
        add(stackOfObjectsTextField);


        doubleButton.setBounds(255, 120, 150, 40);
        doubleButton.addActionListener(doubleButtonListener);
        add(doubleButton);

        clearButton.setBounds(445, 120, 150, 40);
        clearButton.addActionListener(clearButtonListener);
        add(clearButton);

        pushButton.setBounds(65, 120, 150, 40);
        pushButton.addActionListener(pushButtonListener);
        add(pushButton);

        doubleStackLabel.setBounds(40, 210, 160, 30);
        add(doubleStackLabel);
        doubleStackTextField.setBounds(230, 210, 395, 30);
        doubleStackTextField.setEditable(false);
        add(doubleStackTextField);
    }

    ActionListener doubleButtonListener = e -> {
        try {
            stack.doubler();
            while(!stack.isEmpty())
            {
                doubleStackTextField.setText(doubleStackTextField.getText() + stack.pop() + " ");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    };

    ActionListener clearButtonListener = e ->
    {
        stackOfObjectsTextField.setText(null);
        doubleStackTextField.setText(null);
    };

    ActionListener pushButtonListener = e -> {
        stack.push(stackOfObjectsTextField.getText());
        stackOfObjectsTextField.setText(null);
    };
}

