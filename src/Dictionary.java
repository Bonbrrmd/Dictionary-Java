import java.util.ArrayList;
import java.util.Scanner;

class Record {
    String word;
    String definition;

    // para sa word saka definition
    Record(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }
}

public class Dictionary {
    private static ArrayList<Record> dictionary = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {

        //menu
        while (true) {
            System.out.println("\n------------------SELECT FROM THE CHOICES------------------");
            System.out.println("1 - Show all records");
            System.out.println("2 - Search for definition");
            System.out.println("3 - Add record");
            System.out.println("4 - Delete record");
            System.out.println("5 - Delete all records");
            System.out.println("6 - Exit");
            System.out.print("Choose: ");
            
            //user input
            String choice = scanner.nextLine();

            //switch case kapag 1 and user input show all record
            switch (choice) {
                case "1": showAllRecords(); break;
                case "2": searchRecord(); break;
                case "3": addRecord(); break;
                case "4": deleteRecord(); break;
                case "5": deleteAllRecords(); break;
                case "6": System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // methods for show all record
    private static void showAllRecords() {
        System.out.println("\n------------------ALL RECORDS------------------");
        if (dictionary.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (int i = 0; i < dictionary.size(); i++) {
                System.out.println((i + 1) + ".    " + dictionary.get(i).word);
                System.out.println("      - " + dictionary.get(i).definition);
            }
            System.out.println("< Records found: " + dictionary.size() + " >");
        }
    }

    // method for search
    private static void searchRecord() {
        System.out.println("\n------------------SEARCH RECORD------------------");
        System.out.print("Word: ");
        String searchWord = scanner.nextLine();
        boolean found = false;

        for (Record r : dictionary) {
            if (r.word.equalsIgnoreCase(searchWord)) {
                System.out.println(r.word + " - " + r.definition);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No record found!");
    }

    // method for add record
    private static void addRecord() {
        System.out.println("\n------------------ADD RECORD------------------");
        System.out.print("Word: ");
        String word = scanner.nextLine();
        System.out.print("Definition: ");
        String def = scanner.nextLine();
        
        dictionary.add(new Record(word, def));
        System.out.println("< Record has been saved successfully. >");
    }

    // method for delete specific
    private static void deleteRecord() {
        System.out.println("\n------------------Delete Record------------------");
        
         for (int i = 0; i < dictionary.size(); i++) {
                System.out.println((i + 1) + ".    " + dictionary.get(i).word);
            }
         
        System.out.print("Enter word to delete: ");
        String word = scanner.nextLine();
        System.out.print("Are you sure you want to delete all records? (y/n): ");
        
        boolean removed = dictionary.removeIf(r -> r.word.equalsIgnoreCase(word));
         String confirm1 = scanner.nextLine();
         
         if (confirm1.equalsIgnoreCase("y")) {
            dictionary.remove(word);
         System.out.println("Record deleted.");
         
         }else System.out.println("Record not found.");
    }

    //method for all records delete
    private static void deleteAllRecords() {
        System.out.print("Are you sure you want to delete all records? (y/n): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            dictionary.clear();
            System.out.println("All records deleted.");
        }
    }
}