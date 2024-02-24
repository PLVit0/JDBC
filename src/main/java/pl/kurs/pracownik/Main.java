package pl.kurs.pracownik;

import pl.kurs.pracownik.model.Pracownik;
import pl.kurs.pracownik.model.Stanowisko;
import pl.kurs.pracownik.service.ConnectionService;
import pl.kurs.pracownik.service.PracownikService;


public class Main {
    public static void main(String[] args) {


        ConnectionService connectionService = new ConnectionService();
        connectionService.createPracownikTable();

        PracownikService pracownikService = new PracownikService();

        Pracownik pracownik = new Pracownik("Janusz", "Nowak", Stanowisko.JUNIOR_DEV, 9000, true);
        Pracownik pracownik1 = new Pracownik("Sebastian", "Kowalski", Stanowisko.STAŻYSTA, 5000, false);
        Pracownik pracownik2 = new Pracownik("Robert", "Nowak", Stanowisko.STAŻYSTA, 5000, true);

//        pracownikService.zatrudnieniePracownika(pracownik);
//        pracownikService.zatrudnieniePracownika(pracownik1);
//        pracownikService.zatrudnieniePracownika(pracownik2);


//        pracownikService.zwolnieniePracownika(pracownik2);
//        pracownikService.ponowneZatrudnieniePracownika(pracownik2);
//
//        pracownikService.podwyzka(pracownik2, 20000);
//        pracownikService.awans(pracownik, Stanowisko.SENIOR_DEV);
//
//        pracownikService.podwyzka(pracownik, 9000);



//        pracownikService.ponowneZatrudnieniePracownika(pracownik1);

        pracownikService.znajdzPracownika("Kowalski");

        pracownikService.zwolnieniePracownika(pracownik2);

    }


}
