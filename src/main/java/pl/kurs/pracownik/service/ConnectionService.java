package pl.kurs.pracownik.service;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionService {


    private BasicDataSource dataSource;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public ConnectionService() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/pracownicy");
        dataSource.setUsername("root");
        dataSource.setPassword("rootroot");
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void fetchDataFromPracownicyTable() {
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM pracownicy");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createPracownikTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS pracownik (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "imie VARCHAR(25), " +
                "nazwisko VARCHAR(25), " +
                "stanowisko VARCHAR(25), " +
                "pensja DECIMAL(10, 2), " +
                "pracuje BOOLEAN" +
                ")";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Tabela 'pracownik' została utworzona.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
