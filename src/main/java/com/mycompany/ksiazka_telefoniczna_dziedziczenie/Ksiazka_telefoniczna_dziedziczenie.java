/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ksiazka_telefoniczna_dziedziczenie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kacper2p
 */
public class Ksiazka_telefoniczna_dziedziczenie {

    public static void main(String[] args) {
        int menuSwitch;
        String bookName = "";
        Scanner menuInput = new Scanner(System.in);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line;
            int index = 1;
            Scanner userChoice = new Scanner(System.in);
            List<String> users = new ArrayList<>();

            System.out.println("\nDostępne książki: ");

            while ((line = reader.readLine()) != null) {
                System.out.println(index + ". " + line);
                users.add(line);
                index++;
            }

            reader.close();

            System.out.println("\nWpisz numer książki do której chcesz wejść('0' - Wyjdz)");
            int selected = userChoice.nextInt();

            if (selected == 0) {
                System.exit(0);
            }

            Scanner name = new Scanner(System.in);

            if (selected > users.size()) {
                String newBook;
                System.out.println("Wpisz nazwę nowej książki telefonicznej: ");
                newBook = name.nextLine();

                try{
                    File book = new File(newBook + ".txt");
                    File id = new File(newBook + "ID.txt");
                    book.createNewFile();
                    id.createNewFile();
                }catch(IOException error){
                    error.printStackTrace();
                }

                bookName = newBook;

                try{
                    BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));

                    writer.write(bookName + "\n");

                    writer.close();
                }catch (IOException error){
                    error.printStackTrace();
                }
            } else {
                bookName = users.get(selected - 1);
            }
        }catch(IOException error){
            error.printStackTrace();
        }

        Phone phone = new Phone(bookName);

        do{
            System.out.println("\n---------------\nKsiążka - " + bookName + "\n1 - Dodaj wpis\n2 - Usuń wpis\n3 - Edytuj wpis\n4 - Pokaż wpisy\n5 - Szukaj wpis\n6 - Pokaż wszystkie nazwy\n7 - Wyjdź\n---------------");
            menuSwitch = menuInput.nextInt();
            switch(menuSwitch){
                case 1:
                    phone.addPhone();
                    break;
                case 2:
                    phone.removePhone();
                    break;
                case 3:
                    phone.editPhone();
                    break;
                case 4:
                    phone.showContacts();
                    break;
                case 5:
//                    phone.searchPhones();
                    break;
                case 6:
                    phone.showPhones();
                    break;
            }
        }while(menuSwitch != 7);
    }
}
