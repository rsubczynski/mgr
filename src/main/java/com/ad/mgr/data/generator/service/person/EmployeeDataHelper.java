package com.ad.mgr.data.generator.service.person;

import java.util.List;
import java.util.Random;

public class EmployeeDataHelper {

    public static List<String> getPositions() {
        return List.of("Biuro", "Lakiernia", "Sklep", "Magazyn");
    }

    public static List<String> getMenNames() {
        return List.of("Bogdan", "Bogusław", "Bolesław", "Bronisław", "Czesław", "Jarosław", "Kazimierz",
                "Miłosz", "Mirosław", "Radosław", "Sławomir", "Stanisław", "Wojciech", "Zbigniew", "Damian", "Filip",
                "Grzegorz", "Sebastian", "Stefan", "Zenon", "Adrian", "Patryk", "Paweł", "Wiktor", "Adam", "Daniel",
                "Jakub", "Jan", "Artur");
    }

    public static List<String> getMenSurnames() {
        return List.of("Nowak",
                "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Kamiński", "Lewandowski", "Zieliński", "Dąbrowski",
                "Szymański", "Woźniak", "Kozłowski", "Jankowski", "Mazur", "Kwiatkowski", "Wojciechowski", "Krawczyk",
                "Kaczmarek", "Piotrowski", "Grabowski", "Zając", "Pawłowski", "Michalski", "Król", "Nowakowski", "Wróbel",
                "Wieczorek", "Jabłoński", "Dudek", "Adamczyk", "Majewski", "Nowicki", "Olszewski", "Stępień", "Malinowski",
                "Jaworski", "Pawlak", "Górski", "Sikora", "Witkowski", "Walczak", "Rutkowski", "Baran", "Michalak", "Szewczyk",
                "Ostrowski", "Tomaszewski", "Duda", "Zalewski", "Pietrzak", "Wróblewski", "Jasiński", "Marciniak",
                "Zawadzki", "Sadowski", "Bąk", "Jakubowski", "Wilk", "Chmielewski", "Włodarczyk", "Borkowski", "Sokołowski",
                "Szczepański", "Sawicki", "Lis", "Kucharski", "Mazurek", "Kubiak", "Wysocki", "Kalinowski", "Maciejewski",
                "Czarnecki", "Kołodziej", "Kaźmierczak", "Urbański", "Sobczak", "Konieczny", "Głowacki", "Krupa", "Wasilewski",
                "Zakrzewski", "Krajewski", "Adamski", "Sikorski", "Mróz", "Laskowski", "Gajewski", "Ziółkowski", "Szulc",
                "Makowski", "Baranowski", "Szymczak", "Kaczmarczyk", "Przybylski", "Czerwiński", "Brzeziński", "Błaszczyk",
                "Andrzejewski", "Kozak", "Borowski", "Cieślak", "Kania", "Chojnacki", "Górecki", "Janik", "Szczepaniak");
    }

    public static List<String> getWomenNames() {
        return List.of(
                "Anna", "Katarzyna", "Maria", "Małgorzata", "Agnieszka", "Barbara", "Ewa", "Magdalena", "Elżbieta",
                "Krystyna", "Joanna", "Aleksandra", "Monika", "Zofia", "Teresa", "Danuta", "Natalia", "Julia", "Karolina",
                "Marta", "Beata", "Dorota", "Halina", "Alicja", "Jadwiga", "Jolanta", "Janina", "Iwona", "Grażyna",
                "Paulina", "Irena", "Justyna", "Zuzanna", "Bożena", "Wiktoria", "Hanna", "Renata", "Urszula", "Agata",
                "Sylwia", "Helena", "Maja", "Patrycja", "Izabela", "Emilia", "Aneta", "Oliwia", "Weronika", "Ewelina",
                "Martyna", "Klaudia", "Gabriela", "Marzena", "Marianna", "Lena", "Dominika", "Stanisława", "Kinga",
                "Amelia", "Edyta", "Kamila", "Wiesława", "Wanda", "Alina", "Lidia", "Mariola", "Lucyna", "Nikola",
                "Milena", "Daria", "Wioletta", "Mirosława", "Angelika", "Laura", "Antonina", "Kazimiera", "Bogumiła",
                "Genowefa", "Olga", "Sandra", "Ilona", "Michalina", "Henryka", "Nadia", "Józefa", "Marlena", "Sabina",
                "Bogusława", "Stefania", "Kornelia", "Łucja", "Anita", "Regina", "Iga", "Czesława", "Liliana", "Władysława"
        );
    }

    public static List<String> getWomenSurnames() {
        return List.of("Nowak",
                "Nowak", "Kowalska", "Wiśniewska", "Wójcik", "Kowalczyk", "Kamińska", "Lewandowska", "Zielińska", "Szymańska",
                "Dąbrowska", "Woźniak", "Kozłowska", "Jankowska", "Mazur", "Kwiatkowska", "Wojciechowska", "Krawczyk", "Kaczmarek",
                "Piotrowska", "Grabowska", "Pawłowska", "Michalska", "Król", "Zając", "Wieczorek",
                "Jabłońska", "Wróbel", "Nowakowska", "Majewska", "Olszewska", "Adamczyk", "Jaworska", "Malinowska", "Stępień",
                "Dudek", "Górska", "Nowicka", "Witkowska", "Pawlak", "Sikora", "Walczak", "Rutkowska", "Michalak", "Szewczyk",
                "Ostrowska", "Baran", "Tomaszewska", "Zalewska", "Pietrzak", "Wróblewska", "Jasińska", "Marciniak", "Jakubowska",
                "Sadowska", "Zawadzka", "Duda", "Włodarczyk", "Bąk", "Chmielewska", "Borkowska", "Wilk", "Sokołowska", "Szczepańska",
                "Sawicka", "Lis", "Kucharska", "Maciejewska", "Kalinowska", "Mazurek", "Wysocka", "Kubiak", "Kołodziej", "Czarnecka",
                "Kaźmierczak", "Urbańska", "Sobczak", "Głowacka", "Krajewska", "Krupa", "Sikorska", "Zakrzewska", "Wasilewska",
                "Piekarska", "Osińska", "Kubicka", "Komorowska", "Skrzypczak", "Grochowska", "Zaremba", "Siwek", "Burzyńska",
                "Skrzypek", "Czyżewska", "Wrońska", "Zygmunt", "Szafrańska", "Dubiel", "Stachura", "Wojtas", "Jackowska",
                "Prokop", "Malicka", "Gwóźdź", "Sochacka", "Bożek", "Jurkowska", "Świerczyńska");
    }

    public static String generateRandomString(List<String> stringList) {
        return stringList.get(new Random().nextInt(stringList.size()));
    }

    public static boolean generateRandomBoolean(){
        return Math.random() < 0.5;
    }

}
