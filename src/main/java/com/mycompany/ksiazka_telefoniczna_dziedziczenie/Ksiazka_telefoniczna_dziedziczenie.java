/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ksiazka_telefoniczna_dziedziczenie;

import java.util.Scanner;

/**
 *
 * @author kacper2p
 */
public class Ksiazka_telefoniczna_dziedziczenie {

    public static void main(String[] args) {
        int menuSwitch;
        Phone phone = new Phone();
        Scanner menuInput = new Scanner(System.in);
        do{
            System.out.println("\n---------------\n1 - Dodaj wpis\n2 - Usuń wpis\n3 - Edytuj wpis\n4 - Pokaż wpisy\n5 - Szukaj wpis\n6 - Pokaż wszystkie nazwy\n7 - Wyjdź\n---------------");
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
