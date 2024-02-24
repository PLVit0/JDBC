package pl.kurs.pracownik.service;

import pl.kurs.pracownik.model.Pracownik;
import pl.kurs.pracownik.model.Stanowisko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PracownikService {

    ConnectionService connectionService = new ConnectionService();



    public void zatrudnieniePracownika(Pracownik pracownik) {
        String insertQuery = "insert into pracownik (imie, nazwisko, stanowisko, pensja, pracuje) values (?, ?, ?, ?, ?)";

        try (Connection connection = connectionService.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, pracownik.getImie());
            statement.setString(2, pracownik.getNazwisko());
            statement.setString(3, pracownik.getStanowisko().toString());
            statement.setDouble(4, pracownik.getPensja());
            statement.setBoolean(5, pracownik.isPracuje());
            statement.executeUpdate();
            System.out.println("Pracownik został dodany do bazy danych.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void zwolnieniePracownika(Pracownik pracownik){
        String updateQuery = "update pracownik set pracuje = 0 where imie = ? and nazwisko = ?";

        try(Connection connection = connectionService.getConnection();
            PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, pracownik.getImie());
            statement.setString(2, pracownik.getNazwisko());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ponowneZatrudnieniePracownika(Pracownik pracownik){
        String updateQuery = "update pracownik set pracuje = 1 where imie = ? and nazwisko = ?";

        try(Connection connection = connectionService.getConnection();
            PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, pracownik.getImie());
            statement.setString(2, pracownik.getNazwisko());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void podwyzka(Pracownik pracownik, double kwota){

        String selectQuery = "SELECT pensja FROM pracownik WHERE imie = ?";
        String updateQuery = "UPDATE pracownik SET pensja = ? WHERE imie = ?";

        try (Connection connection = connectionService.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

            selectStatement.setString(1, pracownik.getImie());
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                double aktualnaPensja = resultSet.getDouble("pensja");
                double nowaPensja = aktualnaPensja + kwota;

                updateStatement.setDouble(1, nowaPensja);
                updateStatement.setString(2, pracownik.getImie());
                updateStatement.executeUpdate();
            } else {
                System.out.println("Nie znaleziono pracownika o imieniu " + pracownik.getImie());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //        - wyszukującą pracownika po imieniu i nazwisku (jeżeli podamy samo imię lub samo nazwisko to ten SELECT też ma działać w tej metodzie).
    public void znajdzPracownika(String imieLubNazwisko){
        String selectQuery = "SELECT * FROM pracownicy.Pracownik WHERE imie = ? OR nazwisko = ?";

        try (Connection connection = connectionService.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setString(1, imieLubNazwisko);
            statement.setString(2, imieLubNazwisko);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String imie = resultSet.getString("imie");
                String nazwisko = resultSet.getString("nazwisko");
                String stanowisko = resultSet.getString("stanowisko");
                double pensja = resultSet.getDouble("pensja");
                boolean pracuje = resultSet.getBoolean("pracuje");

                System.out.println("ID: " + id);
                System.out.println("Imię: " + imie);
                System.out.println("Nazwisko: " + nazwisko);
                System.out.println("Stanowisko: " + stanowisko);
                System.out.println("Pensja: " + pensja);
                System.out.println("Pracuje: " + (pracuje ? "Tak" : "Nie"));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void awans(Pracownik pracownik, Stanowisko stanowisko){
        String updateQuery = "UPDATE pracownik SET stanowisko = ? WHERE imie = ?";

        try(Connection connection = connectionService.getConnection();
            PreparedStatement statement = connection.prepareStatement(updateQuery)){
            statement.setString(1, stanowisko.name());
            statement.setString(2, pracownik.getImie());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }









}
