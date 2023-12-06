package org.turnera;

import java.sql.*;

public class TurnoManager {
    private static final String URL = "jdbc:h2:./data/turnos";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    // ... Otros métodos de la clase

    public void registrarMedico(String nombre, double costoConsulta) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Medico (nombre, costoConsulta) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nombre);
                statement.setDouble(2, costoConsulta);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrarPaciente(String nombre) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Paciente (nombre) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nombre);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean tomarTurno(String fechaHora, boolean esSobreturno, int paciente, int medico) {

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String query = "INSERT INTO Turno (fechaHora, esSobreturno, pacienteId, medicoId) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, fechaHora);
                    statement.setBoolean(2, esSobreturno);
                    statement.setInt(3, paciente);
                    statement.setInt(4, medico);
                    statement.executeUpdate();
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false;
    }
    private boolean verificarDisponibilidad(String fechaHora, Medico medico) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT COUNT(*) FROM Turno WHERE medicoId = ? AND fechaHora = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, medico.getId());
                statement.setTimestamp(2, Timestamp.valueOf(fechaHora));
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count == 0; // Si count es 0, el médico está disponible en ese momento
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // En caso de error, consideramos que el médico no está disponible
    }


}
