package pl.kurs;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {


        // connection string

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ksiegarnia",
                "root",
                "root"
        );

        // tworzymy statement po to zeby utworzyc resultseta
        Statement statement = connection.createStatement();

        //SELECT
        String selectQuery = "select idklienta, imie, nazwisko from klienci where idklienta > 3";

        ResultSet resultSet = statement.executeQuery(selectQuery);

//        while (resultSet.next()) {
//            int id = resultSet.getInt("idklienta");
//            String name = resultSet.getString("imie");
//            String surname = resultSet.getString("nazwisko");
//
//            System.out.println(id + " " + name + " " + surname);
//        }

        //INSERT

//        String insertQuery = "insert into klienci values(null, 'Jan', 'Nowak');";
//        int insertRowsAffected = statement.executeUpdate(insertQuery);
//
//        System.out.println("Dodalismy: " + insertRowsAffected + " pozycji");

        //DELETE

//        String insertQuery = "delete from klienci where idklienta = 1";
//        int deleteRowsAffected = statement.executeUpdate(insertQuery);
//
//        System.out.println("Usuniecie " + deleteRowsAffected);

        //PRACA DOMOWA


        // Stwórz klase samochod marka model cena przebieg. Stwórz kilka samochodow i zapisz je do bazy danych,
        // nastepnie usun jedno auto a potem inne zmien marke
        // odczytaj wszystkie auta


        // Stwórz tabele user która ma login haslo i bardzo tajne dane, dodaj kilka rekordow

        //SQL injection (w3schools)












    }
}