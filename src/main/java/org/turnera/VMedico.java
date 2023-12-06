package org.turnera;

import javax.swing.*;

public class VMedico extends JFrame{
    private JLabel titulo;
    private JTextField textField1;
    private JTextField textField2;
    private JButton agregarButton;
    private JPanel panelMedico;

    public VMedico(){
        setContentPane(panelMedico);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,200);
    }
}
