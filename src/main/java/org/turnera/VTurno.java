package org.turnera;





import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class VTurno extends JFrame{
    private JPanel jpanelturno;
    private JLabel fechaturno;
    private JRadioButton sobreturnoRadioButton;
    private JTextField paciente;
    private JTextField medico;
    private JButton aceptar;
    private JTextField fecha;
    private JLabel titulo;
    private JPanel prueba;
    private JButton button1;

JDateChooser datechooser = new JDateChooser();
    JPanel panel = new JPanel();
    JDateChooser dateChooser = new JDateChooser();


    public VTurno() {
        panel.add(dateChooser);
        setContentPane(jpanelturno);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,200);



        //calendario
        //prueba.add(datechooser);




        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fechatxt=fecha.getText();
                String medicotxt=medico.getText();
                String pacientetxt=paciente.getText();
                boolean sobreturno = sobreturnoRadioButton.isSelected();
                H2Database.createTables();
                Paciente paciente_actual=new Paciente(pacientetxt);
                Medico medico_actual=new Medico(medicotxt);
                //Turno turno_actual=new Turno(fechatxt,sobreturno,paciente_actual.getId(),medico_actual.getId());
                TurnoManager turnoM_actual= new TurnoManager();
                //turnoM_actual.registrarPaciente(paciente_actual.getNombre());
                //turnoM_actual.tomarTurno(fechatxt,sobreturno,paciente_actual.getId(),medico_actual.getId());

                JOptionPane.showMessageDialog(null,"Se agregó el turno correctamente "+ pacientetxt);

            }
        });
    }


   /* public VTurno() {
        JFrame frame = new JFrame("VTurno");
        frame.setContentPane(new VTurno().jpanelturno);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/



    /*public static void main(String[] args) {
        new VTurno().setVisible(true);
    }*/
}
