package org.turnera;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class TurnoManager {
    private static final String URL = "jdbc:h2:./data/turnos";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    // ... Otros métodos de la clase

    public boolean registrarMedico(int dni, String nombre, double costoConsulta) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Medico (id,nombre, costoConsulta) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, dni);
                statement.setString(2, nombre);
                statement.setDouble(3, costoConsulta);
                int filas=statement.executeUpdate();
                if (filas>0) return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
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

    public List obtenerTodosLosMedicos() {
        java.util.List<Medico> medicos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT id, nombre, costoConsulta FROM Medico";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre");
                        double costoConsulta = resultSet.getDouble("costoConsulta");

                        Medico medico = new Medico(id,nombre,costoConsulta);
                        medico.setId(id);
                        medico.setNombre(nombre);
                        medico.setCostoConsulta(costoConsulta);

                        medicos.add(medico);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (List) medicos;
    }


}
