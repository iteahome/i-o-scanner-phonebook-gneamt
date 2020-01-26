package ro.iteahome.phonebook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputScanner = new Scanner(System.in);  //scanner pentru input
        System.out.println("Introduceti numele contactului: ");

        String contact = inputScanner.nextLine();  //contact = user input

        Scanner textFileScanner = null;  //scanner pentru fisier

        try {
            textFileScanner = new Scanner(new BufferedReader((new FileReader("phonebook.txt"))));
            while (textFileScanner.hasNextLine()){
                String readLine = textFileScanner.nextLine();
                if (readLine.contains(contact)){
                    System.out.println("Numarul de telefon al lui " + contact + " este " + readLine.substring(readLine.length()-10));
                }

            }
        } finally {
            if (textFileScanner != null)
                textFileScanner.close();
        }
    }
}
