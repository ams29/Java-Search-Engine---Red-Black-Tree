import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrontEnd {
    private static Scanner kb = null;
    private static DataLoader dictionary = null;
    private static WordRBT<Definition> tree = null;
    private static File fileName = null;

    public static void main(String[] args) {
        tree = new WordRBT<>();
        fileName = new File("data1.txt");
        dictionary = new DataLoader(fileName, tree);

        boolean done = false;
        kb = new Scanner(System.in);
        int userInput = 0;
        while (!done) {
            try {
                printMainMenu();
                userInput = Integer.parseInt(kb.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Add a new term and its definition.");
                        System.out.println("Please enter the term name: ");
                        String name1 = kb.nextLine();
                        System.out.println("Please enter the definition of the term: ");
                        String definition1 = kb.nextLine();
                        Definition newNode = new Definition(name1, definition1);
                        dictionary.getMap().insert(newNode);
                        break;
                    case 2:
                        System.out.println("Add terms through file input.");
                        System.out.println("Please enter file name (without .txt): ");
                        String fileName = kb.nextLine().trim();
                        fileName += ".txt";
                        File file = new File(fileName);
                        dictionary.setFile(file);
                        dictionary.setData();
                        System.out.println("File data successful Added.");
                        break;
                    case 3:
                        System.out.println("Add a new term and its definition.");
                        System.out.println("Please enter the term name: ");
                        String name3 = kb.nextLine();
                        System.out.println("Please enter the definition of the term: ");
                        String definition3 = kb.nextLine();
                        dictionary.getMap().writeToFile(name3, definition3);
                        break;
                    case 4:
                        System.out.println("Enter a key work to start search: ");
                        String name4 = kb.nextLine();
                        dictionary.getMap().searchWordHelper(name4);
                        break;
                    case 5:
                        System.out.println("In order print whole dictionary: ");
                        dictionary.getMap().inOrderAccessor();
                        break;
                    case 6:
                        System.out.println("Back order print whole dictionary: ");
                        dictionary.getMap().backWardsAccessor();
                        break;
                    case 7:
                        done = true;
                        break;
                    default:
                        System.out.println("The number " + userInput + " is not an option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter the correct format!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } // while
        System.out.println("Thanks for using the Java Dictionary.");
        kb.close();
    }

    private static void printMainMenu() {
        System.out.println("\nYou are in the Java Dictionary. Here are you choices: ");
        System.out.println("1. Add a new term and its definition.");
        System.out.println("2. Add terms through file input.");
        System.out.println("3. Add a term to local file (data1.txt).");
        System.out.println("4. Search a term.");
        System.out.println("5. In order print whole terms.");
        System.out.println("6. Back order print whole terms.");
        System.out.println("7. Exits");
    }

}
