/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ksiazka_telefoniczna_dziedziczenie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phone extends Person{
    public Phone(String bookName){
        super(bookName);
    }

    void addPhone(){
        super.addPerson();
    }

    void removePhone(){
        super.showPerson();
        Scanner input = new Scanner(System.in);
        System.out.println("Wpisz numer użytkownika, którego chcesz usunąć: ");
        int indexToRemove = input.nextInt();
        super.removePerson(indexToRemove);
    }

    void editPhone(){
        int choose = 0, toEdit = 0;
        Scanner input = new Scanner(System.in);
        Scanner value = new Scanner(System.in);
        System.out.println("\n\t1 - Edytować wszystkie dane\n\t2 - Edytować numery telefonów\n\t3 - Edytować jedno pole");
        choose = input.nextInt();
        showPhones();
        System.out.println("\t\tPodaj numer użytkownika, którego chcesz edytować: ");
        toEdit = input.nextInt()-1;
        super.editAll(choose, toEdit);

//                String newValue;
//                switch(choose){
//                    case 1:
//                        System.out.println("                Podaj nowe imie (" + super.name.get(toEdit) + "):");
//                        newValue = value.nextLine();
//                        super.editField(toEdit, super.name, newValue);
//                        break;
//                    case 2:
//                        System.out.println("                Podaj nowe nazwisko (" + super.surname.get(toEdit) + "):");
//                        newValue = value.nextLine();
//                        super.editField(toEdit, super.surname, newValue);
//                        break;
//                    case 3:
//                        System.out.println("                Podaj nowe państwo (" + super.country.get(toEdit));
//                        newValue = value.nextLine();
//                        super.editField(toEdit, super.country, newValue);
//                        break;
//                    case 4:
//                        System.out.println("                Podaj nową miejscowość (" + super.city.get(toEdit) + "):");
//                        newValue = value.nextLine();
//                        super.editField(toEdit, super.city, newValue);
//                        break;
//                }
//                break;
//        }
    }
    
    void showContacts(){
        System.out.println("---------------");
        super.showPerson();
        System.out.println("---------------");
    }

    void checkPhrase(List<String>parameter){
        Scanner inputPhrase = new Scanner(System.in);
        System.out.println("\t\tWpisz szukaną frazę: ");
        String phrase = inputPhrase.nextLine().toLowerCase();
        int phrasesCounter=0;
        List<Integer> phones = new ArrayList<>();
//        for(int i=0; i<parameter.size(); i++){
//            for(int j=0; j<phoneID.size(); j++){
//                if(i==phoneID.get(j)){
//                    phones.add(j);
//                }
//            }
////            if(!(phones.isEmpty())){
////                if(parameter.get(i).toLowerCase().contains(phrase)) {
////                    System.out.println("-------------------------\nNumer użytkownika: " + (super.ID.get(i) + 1) + "\nNazwa: " + super.name.get(i) + " " + super.surname.get(i) + "\nKraj: " + super.country.get(i) + "\nMiejscowość: " + super.city.get(i) + "\nNumery telefonów: ");
////                    phrasesCounter++;
////                    for(int k=0; k<phones.size(); k++){
////                        System.out.println(numbers.get(phones.get(k)));
////                    }
////                }
////            }
//            phones.clear();
//        }if(phrasesCounter<1){
//            System.out.println("Nikt taki nie istnieje w twoim telefonie");
//        }else{
//            System.out.println("-------------------------");
//        }
    }

//    void searchPhones(){
//        Scanner searchData = new Scanner(System.in);
//        System.out.println("    Po czym chcesz wyszukać: \n    1 - po imieniu\n    2 - po nazwisku\n    3 - po kraju\n    4 - po miejscowości\n    5 - po numerze telefonu\n");
//        int choose = searchData.nextInt();
//        switch(choose){
//            case 1:
//                checkPhrase(super.name);
//                break;
//            case 2:
//                checkPhrase(super.surname);
//                break;
//            case 3:
//                checkPhrase(super.country);
//                break;
//            case 4:
//                checkPhrase(super.city);
//                break;
//            case 5:
//                checkPhrase(numbers);
//                break;
//        }
//    }

    void showPhones(){
        super.showAll();
        System.out.println("---------------");
    }
}
