package org.turnera;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VInicio extends JFrame{
    private JButton agregarmedicoButton;
    private JPanel panelinicio;


    private JButton agregarTurnoButton;
    private JButton listarMedicosButton;
    private JLabel turneraMédicaLabel;

    public VInicio() {

        setContentPane(panelinicio);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,200);
        agregarmedicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelinicio.setVisible(false);
                new VMedico().setVisible(true);
            }
        });
        agregarTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelinicio.setVisible(false);
                new VTurno().setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        new VInicio().setVisible(true);
    }
}
