import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        //Creating the inventory Array list below
        Inventory inventory = new Inventory();
        
        //Create memberlist below
        MemberList memberList = new MemberList();
        
        //Creating members
        Member member1 = new Member("Caleb Filip", true, "Credit Card", 
                        43.63, false);
        memberList.addMember(member1);
        
        Member member2 = new Member("Summer Vang", false, "Debit Card", 
                        120.53, false);
        memberList.addMember(member2);
        
        
        //Add products to the inventory
        Book book1 = new Book("Things Fall Apart", "Chinua Achebe",
                                19.99, 14);
        inventory.addBook(book1);
        
        Book book2 = new Book("The Hobbit", "J. R. R. Tolkien",
                27.99, 19);
        inventory.addBook(book2);
        
        DVD dvd1 = new DVD("Lord of the Rings", "Peter Jackson",
                            34.99, 5);
        inventory.addDVD(dvd1);
        
        DVD dvd2 = new DVD("Inception", "Christopher Nolan",
                            9.99, 5);
        inventory.addDVD(dvd2);
        
        CD cd1 = new CD("An Evening With Silk Sonic", "Silk Sonic", 
                        19.99, 18);
        inventory.addCD(cd1);
        CD cd2 = new CD("Giant Steps", "John Coltrane", 
                        7.99, 3);
        inventory.addCD(cd2);
        
        
        while (true) {
            System.out.println("\nBookstore Menu:");
            System.out.println("1. Make a purchase");
            System.out.println("2. Add a new member");
            System.out.println("3. Pay monthly due");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            //user makes coice
            switch (choice) {
                case 1:
                    makePurchase(scanner, inventory, memberList);
                    break;
                case 2:
                    addNewMember(scanner, memberList);
                    break;
                case 3:
                    payMonthlyDue(scanner, memberList);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    private static void makePurchase(Scanner scanner, Inventory inventory, MemberList memberList) {
        ArrayList<Book> books = inventory.getBooks();
        ArrayList<DVD> dvds = inventory.getDVDs();
        ArrayList<CD> cds = inventory.getCDs();
        ArrayList<Member> members = memberList.getMembers();
        //user makes choice again
        System.out.println("\nSelect the item category:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.print("Enter your choice: ");
        
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        if (categoryChoice < 1 || categoryChoice > 3) {
            System.out.println("Invalid category choice.");
            return;
        }
        
        System.out.println("\nAvailable Items:");
        
        //display items based on the selected category
        if (categoryChoice == 1) {
            System.out.println("Books:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i).getTitle());
            }
        } else if (categoryChoice == 2) {
            System.out.println("DVDs:");
            for (int i = 0; i < dvds.size(); i++) {
                System.out.println((i + 1) + ". " + dvds.get(i).getTitle());
            }
        } else if (categoryChoice == 3) {
            System.out.println("CDs:");
            for (int i = 0; i < cds.size(); i++) {
                System.out.println((i + 1) + ". " + cds.get(i).getTitle());
            }
        }
        
        System.out.println("\nMembers:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i + 1) + ". " + members.get(i).getName());
        }
        
        // Get user input
        System.out.print("\nEnter the number of the item you want to buy: ");
        int itemIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        System.out.print("Enter the number of the member making the purchase: ");
        int memberIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (categoryChoice == 1 && itemIndex >= 0 && itemIndex < books.size() ||
            categoryChoice == 2 && itemIndex >= 0 && itemIndex < dvds.size() ||
            categoryChoice == 3 && itemIndex >= 0 && itemIndex < cds.size()) {
            
            double purchasePrice = 0.0;
            
            if (categoryChoice == 1) {
                Book selectedBook = books.get(itemIndex);
            } else if (categoryChoice == 2){
                DVD selectedDVD = dvds.get(itemIndex);
            } else if (categoryChoice == 3){
                CD selectedCD = cds.get(itemIndex);
         
            }
                System.out.println("Purchase successful!");

        }
    }
    
    
    private static void addNewMember(Scanner scanner, MemberList memberList) {
        System.out.print("\nEnter the name of the new member: ");
        String name = scanner.nextLine();

        System.out.print("Is the new member premium? (true/false): ");
        boolean isPremium = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Enter the payment method for the new member: ");
        String payMethod = scanner.nextLine();

        //System.out.print("Enter the initial total spent for the new member: ");
        //double totalSpent = scanner.nextDouble();
        //scanner.nextLine(); 

        // Create and add the new member
        Member newMember = new Member(name, isPremium, payMethod, 0, false);
        memberList.addMember(newMember);
        System.out.println("New member added successfully!");
    }

    private static void payMonthlyDue(Scanner scanner, MemberList memberList) {
        //Display members
        ArrayList<Member> members = memberList.getMembers();

        System.out.println("\nMembers:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i + 1) + ". " + members.get(i).getName());
        }

        //user input for member selection
        System.out.print("\nEnter the number of the member to pay the monthly due: ");
        int memberIndex = scanner.nextInt() - 1;
        scanner.nextLine();

      //change variable monthlyPaid
        if (memberIndex >= 0 && memberIndex < members.size()) {
            Member selectedMember = members.get(memberIndex);
            selectedMember.setMonthlyPaid(true);
            System.out.println("Monthly due paid successfully!");
        } else {
            System.out.println("Invalid member selection.");
        }
    }
}

        
        
        
       
