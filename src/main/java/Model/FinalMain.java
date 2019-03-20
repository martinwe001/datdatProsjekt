package Model;

import java.sql.SQLException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinalMain {



    public static void main(String[] args) {

        boolean run = true;
        boolean a = true;





        while (run) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Legge til [1] eller hente ut [2] data? Quit [3] ");
            String s1 = scanner.nextLine();
                if (s1.equals("1")) {
                    System.out.println("Hva vil du gjøre? Legge til Øvelse [1], Apparat [2], " +
                            "Treningsøkt [3], Øvelsesgruppe [4], Favorittøkt [5] ? ");
                    String s2 = scanner.nextLine();
                    if (s2.equals("1")) {
                        System.out.println("Er det fast [1] eller fri øvelse [2] ?");
                        String s100 = scanner.nextLine();
                        if (s100.equals("1")){
                            System.out.println("Hvor mange kilo og hvor mange set?");
                            String s101 = scanner.nextLine();
                            String s102 = scanner.nextLine();

                        }
                        else if (s100.equals("2")){

                        }
                        else{

                        }




                        System.out.println("Navn på øvelse og nr på øvelsesgruppen: ");
                        String s3 = scanner.nextLine();
                        int i1 = scanner.nextInt();
                        Øvelse øvelse = new Øvelse();
                        øvelse.setName(s3);
                        øvelse.setOvelsegruppe(i1);
                        try {
                            øvelse.create();
                            System.out.println("---Lagt inn i database---\n");
                        } catch (SQLException e) {
                            System.out.println("Det finnes ikke en slik øvelsegruppe");
                        }
                    }
                    else if (s2.equals("2")) {
                        System.out.println("Navn og beskrivelse på apparat: ");
                        String s3 = scanner.nextLine();
                        String s4 = scanner.nextLine();
                        Apparat apparat = new Apparat();
                        apparat.setName(s3);
                        apparat.setDescription(s4);
                        try {
                            apparat.create();
                            System.out.println("---Lagt inn i database---\n");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                    else if (s2.equals("3")){
                        System.out.println("Dato, tid, lengde, form, prestasjon og notat for treningsøkt: ");
                        String s3 = scanner.nextLine();
                        int i2 = scanner.nextInt();
                        int i3 = scanner.nextInt();
                        int i4 = scanner.nextInt();
                        int i5 = scanner.nextInt();
                        String s5 = scanner.nextLine();
                        String s4 = scanner.nextLine();
                        Treningsokt treningsokt = new Treningsokt();
                        ØvelseITreningsøkt øvelseITreningsøkt = new ØvelseITreningsøkt();
                        treningsokt.setDate(s3);
                        øvelseITreningsøkt.setDate(s3);
                        treningsokt.setTime(i2);
                        treningsokt.setLength(i3);
                        treningsokt.setPersonalShape(i4);
                        treningsokt.setPerformance(i5);
                        treningsokt.setNote(s4);
                        try {
                            treningsokt.create();
                            System.out.println("---Lagt inn i database---\n");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        while (a){
                            System.out.println("Hvilke øvelser vil du legge til?");
                            String s6 = scanner.nextLine();
                            if(!s6.isEmpty()){
                                øvelseITreningsøkt.setName(s6);
                                try {
                                    øvelseITreningsøkt.create();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    System.out.println("Ingen øvelse med dette navnet");
                                }
                            }
                            else{
                                a = false;
                            }
                        }
                        System.out.println("---Lagt inn i database---\n");
                    }
                    else if (s2.equals("4")){
                        System.out.println("Navn og muskelgruppe for øvelsegruppe: ");
                        String s3 = scanner.nextLine();
                        String s4 = scanner.nextLine();
                        Øvelsegruppe øvelsegruppe = new Øvelsegruppe();
                        øvelsegruppe.setName(s3);
                        øvelsegruppe.setMuskelgruppeNavn(s4);
                        try {
                            øvelsegruppe.create();
                            System.out.println("---Lagt inn i database---\n");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    else if (s2.equals("5")){
                        System.out.println("Navn, beskrivelse og nummer på treningsøkt på favorittøkt: ");
                        String s3 = scanner.nextLine();
                        String s4 = scanner.nextLine();
                        int i2 = scanner.nextInt();
                        FavorittØkt favorittØkt = new FavorittØkt();
                        favorittØkt.setName(s3);
                        favorittØkt.setDescription(s4);
                        favorittØkt.setØkt(i2);
                        try {
                            favorittØkt.create();
                            System.out.println("---Lagt inn i database---\n");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                    else{
                        return;
                    }
                }
                else if (s1.equals("2")){
                    System.out.println("Hva vil du hente ut? Treningsøkter [1], Øvelsesgruppe [2], Øvelse [3], Favorittøkt [4]");
                    String s2 = scanner.nextLine();
                    if (s2.equals("1")){
                        System.out.println("Antall treningsøkter du vil se?");
                        int i2 = scanner.nextInt();
                        Treningsokt treningsokt = new Treningsokt();
                        treningsokt.setNumber(i2);
                        try {
                            System.out.println("#TRENINGSØKT");
                            treningsokt.read(treningsokt.getQuery(),"lol");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                    else if (s2.equals("2")){
                        System.out.println("Hvilken øvelsegruppe?");
                        int s3 = scanner.nextInt();
                        Øvelsegruppe øvelsegruppe = new Øvelsegruppe();
                        øvelsegruppe.setNumber(s3);
                        try {
                            System.out.println("#Øvelsesgruppe: " + s3);
                            øvelsegruppe.read("lol","lol");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                    else if(s2.equals("3")){

                    }
                    else if (s2.equals("4")){


                    }
                    else{
                        return;
                    }
                }
                else if (s1.equals("3")){
                    run = false;
                }
                else {
                    System.out.println("Ugyldig input");
                }


        }
    }

    public String numberOfDays(String date1, String date2){
        return date1;
    }

}