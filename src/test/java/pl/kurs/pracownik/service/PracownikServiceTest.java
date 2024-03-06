package pl.kurs.pracownik.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.kurs.pracownik.model.Pracownik;
import pl.kurs.pracownik.model.Stanowisko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class PracownikServiceTest {

    @Mock
    private ConnectionService connectionService;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;
    @InjectMocks
    private PracownikService pracownikService;

    @Before
    public void init() throws SQLException {
        MockitoAnnotations.openMocks(this);
        when(connectionService.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    public void testZatrudnieniePracownika() throws SQLException {
        Pracownik pracownik = new Pracownik("Jan", "Kowalski", Stanowisko.JUNIOR_DEV, 5000, true);
        pracownikService.zatrudnieniePracownika(pracownik);
        Mockito.verify(preparedStatement,times(1)).executeUpdate();
    }

    @Test
    public void testZwolnieniePracownika() throws SQLException {
        Pracownik pracownik = new Pracownik("Jan", "Kowalski", Stanowisko.JUNIOR_DEV, 5000, true);
        pracownikService.zwolnieniePracownika(pracownik);
        Mockito.verify(preparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testPonowneZatrudnieniePracownika() throws SQLException {
        Pracownik pracownik = new Pracownik("Jan", "Kowalski", Stanowisko.JUNIOR_DEV, 5000, true);
        pracownikService.ponowneZatrudnieniePracownika(pracownik);
        verify(preparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testPodwyzka() throws SQLException {
        Pracownik pracownik = new Pracownik("Jan", "Kowalski", Stanowisko.JUNIOR_DEV, 5000, true);
        pracownikService.podwyzka(pracownik, 1000);
        verify(preparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testZnajdzPracownika() throws SQLException {
        String imieLubNazwisko = "Jan";
        pracownikService.znajdzPracownika(imieLubNazwisko);
        verify(preparedStatement, times(1)).executeQuery();
    }

    @Test
    public void testAwans() throws SQLException {
        Pracownik pracownik = new Pracownik("Jan", "Kowalski", Stanowisko.JUNIOR_DEV, 5000, true);
        pracownikService.awans(pracownik, Stanowisko.MID_DEV);
        verify(preparedStatement, times(1)).executeUpdate();
    }
}