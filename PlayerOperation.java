interface PlayerOperation {

    // Add a new player
    void addPlayer();


    // Search player information
    void searchPlayer(int id);
    void searchPlayer(String name);


    // Delete player information
    void deletePlayer(int id);


    // Display all players
    void displayPlayers();

}