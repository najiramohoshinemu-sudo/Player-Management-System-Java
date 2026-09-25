import java.util.Scanner; // Imports Scanner for taking user input

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Scanner object for user input

        PlayerOperation team = new TeamManagement();
        // Interface reference type with TeamManagement object


        while (true) { // Keeps showing the menu until user chooses Exit

            System.out.println("\n===== PLAYER MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Player");
            System.out.println("2. Search Player by ID");
            System.out.println("3. Search Player by Name");
            System.out.println("4. Delete Player");
            System.out.println("5. Display All Players");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt(); // Stores user's menu choice


            switch (choice) { // Performs action based on user's choice

                case 1:
                    team.addPlayer(); // Calls addPlayer() method
                    break; // Ends case 1


                case 2:
                    System.out.print("Enter Player ID: ");
                    int searchId = sc.nextInt(); // Takes ID to search

                    team.searchPlayer(searchId);
                    // Calls searchPlayer(int id)

                    break;


                case 3:
                    sc.nextLine();
                    // Clears the leftover Enter key after nextInt()

                    System.out.print("Enter Player Name: ");
                    String searchName = sc.nextLine();
                    // Takes player name to search

                    team.searchPlayer(searchName);
                    // Calls searchPlayer(String name)

                    break;


                case 4:
                    System.out.print("Enter Player ID: ");
                    int deleteId = sc.nextInt(); // Takes ID to delete

                    team.deletePlayer(deleteId);
                    // Calls deletePlayer(int id)

                    break;


                case 5:
                    team.displayPlayers();
                    // Displays all players

                    break;


                case 6:
                    System.out.println("Exiting program...");

                    return;
                    // Ends the main() method and exits the program


                default:
                    System.out.println("Invalid choice!");
                    // Runs if user enters a choice other than 1-6
            }
        }
    }
}