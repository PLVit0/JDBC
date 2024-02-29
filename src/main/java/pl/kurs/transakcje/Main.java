package pl.kurs.transakcje;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

//  Zasady ACID (anagram) to zbiór zasad które opisują transakcję:
//•	Atomowość – wykonanie wszystkich kroków wchodzących w skład transakcji decyduje o jej sukcesie;
//•	Spójność – stan bazy danych zawsze przedstawia stan przed lub po transakcji;
//•	Izolacja – transakcja jest odizolowana od innych transakcji, działa niezależnie od pozostałych;
//•	Trwałość – w przypadku awarii systemu bazodanowego, transakcja albo wykonana jest w całości albo wcale;

    public static void main(String[] args) throws SQLException {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/ksiegarnia");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        Connection connection = dataSource.getConnection();

        try {
            // Transkacja DELETE
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement("delete from klienci where nazwisko = ?");
                preparedStatement.setString(1, "Nowak");
                int deleteRows = preparedStatement.executeUpdate();
                System.out.println("Delete rows: " + deleteRows);
            } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }
            //transakcja INSERT
            PreparedStatement preparedStatement1 = null;

            try {
                preparedStatement1 = connection.prepareStatement("insert into klienci values(null, ? , ?)");
                preparedStatement1.setString(1, "Adam");
                preparedStatement1.setString(2, "Malysz");
                int insertRows = preparedStatement1.executeUpdate();
                System.out.println("Inserted rows: " + insertRows);

            } finally {
                if (preparedStatement1 != null) {
                    preparedStatement.close();
                }
            }

            connection.commit();


        } catch (SQLException e) {
            System.out.println("ROLBAC KURLA");
            connection.rollback();
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        // Stwórz tabele Pociag ktora ma nazwe, dlugosc, to czy jest wars oraz laczna liczba miejsc.
        // Za pomoca transakcji dodaj jaksi pociag i usun stary, ale jesli usuniceie sie nie powiedzie
        // to chcemy cofnac inserta, no bo ile mozna miec pociagow w pkp? O_O

        // Przetestuj działanie rollbacka na trzech operacjach np robimy inserta, deleta i updejta, jak sie sypnie updejt
        // to chcemy cofnac wszystkie zmiany, na dowolnej tabeli



    }

}
