package ru.vsu.samsonova.gui;

import javax.swing.*;

public class FrameMain extends JFrame
{
    public FrameMain()
    {
        setTitle("task 3");
        setSize(665, 320);
        add(new MainPanel());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
