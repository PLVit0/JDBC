package pl.kurs;

import org.apache.commons.dbcp2.BasicDataSource;

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
//        String selectQuery = "select idklienta, imie, nazwisko from klienci where idklienta > 3";

//        ResultSet resultSet = statement.executeQuery(selectQuery);

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


        // Stwórz klase samochod marka model cena przebieg.  // DONE
        // Stwórz kilka samochodow i zapisz je do bazy danych, // DONE

        Connection connectionCar = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_car",
                "root",
                "root"
        );
        Statement statementCar = connectionCar.createStatement();

        String insertQuery1 = "insert into cars values(null,'BMW','X6 M60i', 540000.0, 45000)," +
                "(null,'BMW','X7 M60i', 600000.0, 23000)" +
                ",(null,'BMW','X5 xDrive50e', 560000.0, 11000)" +
                ",(null,'BMW','520d xDrive', 250000.0, 4000)" +
                ",(null,'BMW','X4 xDrive30i', 360000.0, 18000)" +
                ",(null,'BMW','M3 M xDrive Competition Touring', 660000.0, 1000)" +
                ",(null,'BMW','X2 M35i', 360000.0, 29000)" +
                ",(null,'BMW','X3 M Competition', 460000.0, 53000);";

//        String insertQueryMB = "insert into cars values(null,'Mercedes','GLE 63s AMG', 540000.0, 32000)," +
//                "(null,'Mercedes','AMG GT', 9600000.0, 18000)" +
//                ",(null,'Volvo','XC60 D5', 260000.0, 45000);";
//        int insertRowsAffected1 = statementCar.executeUpdate(insertQueryMB);
//
//        System.out.println("Dodalismy: " + insertRowsAffected1 + " pozycji");


        // nastepnie usun jedno auto a potem inne zmien marke

//       String insertQuery2 = "delete from cars where model = 'X6 M60i'";
//        int deleteRowsAffected = statementCar.executeUpdate(insertQuery2);

//        String insertQuery2 = "delete from cars where marka = 'Volvo'";
//        int deleteRowsAffected = statementCar.executeUpdate(insertQuery2);
//        System.out.println("Usuniecie " + deleteRowsAffected);

        // odczytaj wszystkie auta
        //
//        String selectQueryCar = "select marka, model, cena from cars";
//
//        ResultSet resultSetCar = statementCar.executeQuery(selectQueryCar);
//        System.out.println(resultSetCar);

//        while (resultSet.next()) {
//            int id = resultSet.getInt("idklienta");
//            String name = resultSet.getString("imie");
//            String surname = resultSet.getString("nazwisko");
//
//            System.out.println(id + " " + name + " " + surname);
//        }

        // Stwórz tabele user która ma login haslo i bardzo tajne dane, dodaj kilka rekordow

        //SQL injection (w3schools)

//        String createTable = "create table user(id int not null auto_increment primary key,haslo char(20),bardzo_tajne_dane char(20))";

//        String insertQuery = "insert into user values(null, 'pass', 'tajnypass'),(null, 'qwert', 'tajnedane'),(null, '12pass', 'empty')";
//        statementCar.executeUpdate(insertQuery);

//        String selectQuery = "select * from user where haslo = 'qwert' or 1=1";
//        ResultSet resultSet = statementCar.executeQuery(selectQuery);
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString(3));
//        }


//        statementCar.executeUpdate(createTable);

//        String query = "select * from klienci where idklienta > ? and nazwisko = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1, 2);
//        preparedStatement.setString(2, "Nowak");
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//
//        }

        //        Praca domowa_1:
//        Napisz program do zarządzania pracownikami:
//        Pracownik (imię, nazwisko, stanowisko(enum(stażysta, junior dev, mid dev, senior dev, lead dev )), pensja, zwolniony(boolean))
//        Napisz serwis, który będzie posiadał metody:
//        - zatrudniająca pracownika,
//                -zwalniającą pracownika (soft delete),
//                - podyższającą pensję
//                -awansującą pracownika;
//        - wyszukującą pracownika po imieniu i nazwisku (jeżeli podamy samo imię lub samo nazwisko to ten SELECT też ma działać w tej metodzie).
//                Oczywiście wszelkie zmiany muszą zachodzić w bazie danych.

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/ksiegarnia");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        Connection connection1 = null;
        Statement statement1 = null;
        ResultSet resultSet = null;

        try {
            connection1 = dataSource.getConnection();
            statement1 = connection1.createStatement();
            resultSet = statement1.executeQuery("select * from klienci");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if (statement1 != null) {
                    statement1.close();
                }
                if (connection1 != null) {
                    statement1.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}