import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

class TeamManagement implements PlayerOperation {

    // Encapsulation: storing player list privately
    private ArrayList<Player> teamPlayers;


    // Constructor: initialize ArrayList
    public TeamManagement() {

        teamPlayers = new ArrayList<>();
        // Creating an empty ArrayList to store Player objects
    }


    // Checks whether player data is valid
    private void validatePlayerData(int id, int age, int jerseyNumber, int goals)
            throws InvalidPlayerException {

        String errorMessage = "";

        // Checks player ID
        if (id <= 0) {
            errorMessage += "Player ID must be greater than 0!\n";
        }

        // Checks age
        if (age <= 0) {
            errorMessage += "Player age must be greater than 0!\n";
        }

        // Checks jersey number
        if (jerseyNumber <= 0) {
            errorMessage += "Jersey number must be greater than 0!\n";
        }

        // Checks goals
        if (goals < 0) {
            errorMessage += "Goals cannot be negative!\n";
        }

        // Throws custom exception if any invalid data is found
        if (!errorMessage.isEmpty()) {
            throw new InvalidPlayerException(errorMessage);
        }
    }


    @Override
    public void addPlayer() {

        Scanner sc = new Scanner(System.in);
        // Scanner object for taking user input

        try {

            System.out.print("Enter Player ID: ");
            int id = sc.nextInt();

            sc.nextLine();
            // Clears the leftover Enter key after nextInt()


            System.out.print("Enter Player Name: ");
            String name = sc.nextLine();


            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            sc.nextLine();
            // Clears the leftover Enter key


            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();


            System.out.print("Enter Position: ");
            String position = sc.nextLine();


            System.out.print("Enter Jersey Number: ");
            int jerseyNumber = sc.nextInt();


            System.out.print("Enter Goals: ");
            int goals = sc.nextInt();


            // Checking whether entered player data is valid
            validatePlayerData(id, age, jerseyNumber, goals);


            // Checking if Player ID or Phone Number already exists
            for (Player existingPlayer : teamPlayers) {

                // Player ID must be unique
                if (existingPlayer.getPlayerId() == id) {

                    System.out.println(
                            "Player ID already exists! Try something unique!"
                    );

                    return;
                }


                // Phone number must be unique
                if (existingPlayer.getPhone().equals(phone)) {

                    System.out.println(
                            "Phone number already exists! Try again!"
                    );

                    return;
                }
            }


            // Creating a Player object using valid user input
            Player p = new Player(
                    id,
                    name,
                    age,
                    phone,
                    position,
                    jerseyNumber,
                    goals
            );


            // Adding the Player object to the team list
            teamPlayers.add(p);


            System.out.println("Player added successfully!");
        }


        // Handles wrong data type input
        catch (InputMismatchException e) {

            System.out.println(
                    "Invalid input! Please enter a number where required."
            );
        }


        // Handles custom player validation errors
        catch (InvalidPlayerException e) {

            System.out.println(e.getMessage());
        }
    }


    @Override
    public void searchPlayer(int id) {

        // Checking each Player object in the list
        for (Player p : teamPlayers) {

            if (p.getPlayerId() == id) {

                p.displayInfo();
                return;
            }
        }

        System.out.println("Player not found!");
    }


    @Override
    public void searchPlayer(String name) {

        // Checking each Player object in the list
        for (Player p : teamPlayers) {

            if (p.getName().equalsIgnoreCase(name)) {

                p.displayInfo();
                return;
            }
        }

        System.out.println("Player not found!");
    }


    @Override
    public void deletePlayer(int id) {

        // Checking each Player object in the list
        for (int i = 0; i < teamPlayers.size(); i++) {

            Player p = teamPlayers.get(i);

            if (p.getPlayerId() == id) {

                teamPlayers.remove(i);

                System.out.println("Player deleted successfully!");
                return;
            }
        }

        System.out.println("Player not found!");
    }


    @Override
    public void displayPlayers() {

        // Checking if the player list is empty
        if (teamPlayers.isEmpty()) {

            System.out.println("No players found!");
            return;
        }


        // Displaying all players in the team
        for (Player p : teamPlayers) {

            p.displayInfo();
            System.out.println("--------------------");
        }
    }
}