/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
class Person {
    Scanner value = new Scanner(System.in);

    void addPerson(){
        String name, surname, country, city;
        System.out.println("Podaj imie: ");
        name = value.nextLine();

        System.out.println("Podaj nazwisko: ");
        surname = value.nextLine();

        System.out.println("Podaj państwo: ");
        country = value.nextLine();

        System.out.println("Podaj miejscowość: ");
        city = value.nextLine();

        Scanner intValue = new Scanner(System.in);

        System.out.println("\tIle numerów telefonów chcesz dodac: ");
        int phoneNumbersCount = intValue.nextInt();

        String numbers = "";

        for(int i=0; i<phoneNumbersCount; i++){
            System.out.println("\t\tWpisz " + (i+1) + " numer telefonu: ");
            numbers += value.nextLine() + ",";
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("peoples.txt", true));
            writer.write(getId() + "," + name + "," + surname + "," + country + "," + city + "," + numbers + "\n");
            writer.close();
            setId(getId());
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    void removePerson(int toRemove){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("peoples.txt"));
            List<String> data = new ArrayList<>();
            String line;

            while((line = reader.readLine()) != null){
                data.add(line);
            }

            data.remove(toRemove - 1);

            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("peoples.txt"));
                for(String ln : data){
                writer.write(ln + "\n");
                }

                writer.close();
            }catch(IOException error){
                error.printStackTrace();
            }

            reader.close();
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    void editAll(int choose, int toEdit ){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("peoples.txt"));

            List<List<String>> data = new ArrayList<>();
            String line;

            while((line = reader.readLine()) != null){
                String[] splitData = line.split("[,;]");
                List<String> contact = new ArrayList<>();
                for(String ln : splitData){
                    contact.add(ln);
                }
                data.add(contact);
            }

            switch(choose){
                case 1:
                    System.out.println("\tPodaj nowe imie (" + data.get(toEdit).get(1) + ")");
                    data.get(toEdit).set(1, value.nextLine());
                    System.out.println("\tPodaj nowe nazwisko (" + data.get(toEdit).get(2) + ")");
                    data.get(toEdit).set(2, value.nextLine());
                    System.out.println("\tPodaj nowy państwo (" + data.get(toEdit).get(3) + ")");
                    data.get(toEdit).set(3, value.nextLine());
                    System.out.println("\tPodaj nową miejscowość (" + data.get(toEdit).get(4) + ")");
                    data.get(toEdit).set(4, value.nextLine());

                    break;
                case 2:
                    System.out.println("\t\t\t1. Dodaj numer\n\t\t\t2. Usuń numer");
                    choose = value.nextInt();

                    switch(choose){
                        case 1:
                            System.out.println("\t\t\t\tPodaj nowy numer telefonu");
                            data.get(toEdit).add(value.nextLine());
                            break;
                        case 2:
                            List<String> dataToEdit = new ArrayList<>();
                            List<String> numbers = new ArrayList<>();

                            for(String ln : data.get(toEdit)){
                                numbers.add(ln);
                            }

                            for(int i = 0; i<5; i++){
                                dataToEdit.add(numbers.get(0));
                                numbers.remove(0);
                            }

                            System.out.println("\t\t\t\t\tWpisz indeks numeru telefonu, który chcesz usunąć: ");
                            for(int i = 1; i <= numbers.size(); i++){
                                System.out.println("\t\t\t\t\t" + i + " => " + numbers.get(i-1));
                            }

                            int toDelete = value.nextInt();
                            numbers.remove(toDelete - 1);

                            for(String number : numbers){
                                dataToEdit.add(number);
                            }

                            data.set(toEdit, dataToEdit);
                            break;
                        default: break;
                    }
                    break;
                case 3:
                    Scanner newValue = new Scanner(System.in);

                    System.out.println("\t\t\t1 - Imie\n\t\t\t2 - Nazwisko\n\t\t\t3 - Państwo\n\t\t\t4 - Miejscowość");

                    switch(value.nextInt()){
                        case 1:
                            System.out.println("\t\t\t\tPodaj nowe imie (" + data.get(toEdit).get(1) + "):");
                            data.get(toEdit).set(1, newValue.nextLine());
                            break;
                        case 2:
                            System.out.println("\t\t\t\tPodaj nowe nazwisko (" + data.get(toEdit).get(2) + "):");
                            data.get(toEdit).set(2, newValue.nextLine());
                            break;
                        case 3:
                            System.out.println("\t\t\t\tPodaj nowe państwo (" + data.get(toEdit).get(3) + "):");
                            data.get(toEdit).set(3, newValue.nextLine());
                            break;
                        case 4:
                            System.out.println("\t\t\t\tPodaj nową miejscowość (" + data.get(toEdit).get(4) + "):");
                            data.get(toEdit).set(4, newValue.nextLine());
                            break;
                    }
                    break;
                default: break;
            }
            saveDataToFile(data);

            reader.close();
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    void showPerson(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("peoples.txt"));
            String line;
            int lineNumber = 1;

            while((line = reader.readLine()) != null){
                String[] data = line.split("[,;]");
                System.out.println(lineNumber + ". " + data[1] + " " + data[2]);
                lineNumber++;
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    void showAll(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("peoples.txt"));
            String line;

            while((line = reader.readLine()) != null){
                List<String> data = new ArrayList<>();
                for(String n : line.split("[,;]")){
                    data.add(n);
                }
                System.out.println("---------------");
                System.out.println(data.get(1) + " " + data.get(2) + "\n" + data.get(3)+ " " + data.get(4));

                for(int i = 0; i<5; i++){
                    data.remove(0);
                }

                String numbers = "";

                for(String number : data){
                    numbers += number + " ";
                }

                System.out.println(numbers);
            }

            reader.close();
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    //Metody poboczne

    void saveDataToFile(List<List<String>> data){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("peoples.txt"));
            for(List<String> ln : data){
                for(String contactData : ln){
                    writer.write(contactData + ",");
                }
                writer.write("\n");
            }
            writer.close();
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    void setId(int current){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("id.txt"));
            writer.write(Integer.toString(current + 1));
            writer.close();
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    int getId(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("id.txt"));
            String line;

            if((line = reader.readLine()) != null){
                return Integer.parseInt(line);
            }else {
                return 0;
            }
        }catch(IOException error){
            error.printStackTrace();
            return 0;
        }
    }
}
