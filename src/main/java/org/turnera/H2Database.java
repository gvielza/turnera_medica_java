package org.turnera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Database {
    public static void createTables() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./data/turnos", "sa", "")) {
            Statement stmt = connection.createStatement();

            // Crear tablas
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Medico (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(255), costoConsulta DOUBLE)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Paciente (id INT PRIMARY KEY, nombre VARCHAR(255))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Turno (id INT PRIMARY KEY, fechaHora VARCHAR(255), esSobreturno BOOLEAN, pacienteId INT, medicoId INT, " +
                    "FOREIGN KEY (pacienteId) REFERENCES Paciente(id), FOREIGN KEY (medicoId) REFERENCES Medico(id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
