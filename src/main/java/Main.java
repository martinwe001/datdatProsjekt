import Model.Treningsokt;
import Model.Øvelse;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Main {

    public Main(){

    }



    public static void main(String[] args){
        System.out.println("Navn på ny øvelse og øvelsesgruppeNr?");
        Scanner scanner = new Scanner(System. in);
        String input = scanner. nextLine();
        int input12 = scanner. nextInt();
        Øvelse øvelse = new Øvelse();
        øvelse.setName(input);
        øvelse.setOvelsegruppe(input12);
        try {
            øvelse.create();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(øvelse.toString());
        System.out.println("antall treningsøkter du vil se?");
        int input9 = scanner.nextInt();
        Treningsokt treningsokt = new Treningsokt();
        treningsokt.setNumber(input9);
        try {
            treningsokt.read(treningsokt.getQuery(),"lol");
            treningsokt.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Hvilken gruppe vil du ha øvelser fra?");
        int input11 = scanner.nextInt();
        øvelse.setNumber(input11);
        try {
            øvelse.read("lol","lol");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;


    }
}
