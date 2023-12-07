package org.turnera;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMedico extends JFrame{
    private JLabel titulo;
    private JTextField textField1;
    private JTextField textField2;
    private JButton agregarButton;
    private JPanel panelMedico;
    private JLabel id;
    private JTextField dni_medico;

    public VMedico(){
        setContentPane(panelMedico);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,200);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                H2Database base_datos= new H2Database();
                base_datos.createTables();
                TurnoManager manejar_bd=new TurnoManager();
                int dni= Integer.parseInt(dni_medico.getText());
                String nombre_medico=textField1.getText();
                Double precio=Double.parseDouble(textField2.getText());

                if (manejar_bd.registrarMedico(dni,nombre_medico, precio)) {
                    JOptionPane.showMessageDialog(null, "Médico registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar al médico.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                setVisible(false);
                new VInicio().setVisible(true);

            }
        });
    }
}
