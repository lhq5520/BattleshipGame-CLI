# Battleship Game

This project is a console-based implementation of the classic Battleship game. The game is played on a 10x10 grid where the player aims to guess and hit all the ships randomly placed on the grid. The player has a maximum number of guesses to find and sink all the ships.

**Example of Game Interaction:**
```
Welcome to Battleship!
Guesses Made: 0
Maximum Guesses Allowed: 10
Current Game Grid:
  0 1 2 3 4 5 6 7 8 9 
A _ _ _ _ _ _ _ _ _ _ 
B _ _ _ _ _ _ _ _ _ _ 
C _ _ _ _ _ _ _ _ _ _ 
D _ _ _ _ _ _ _ _ _ _ 
E _ _ _ _ _ _ _ _ _ _ 
F _ _ _ _ _ _ _ _ _ _ 
G _ _ _ _ _ _ _ _ _ _ 
H _ _ _ _ _ _ _ _ _ _ 
I _ _ _ _ _ _ _ _ _ _ 
J _ _ _ _ _ _ _ _ _ _ 
Enter your guess (row and column, e.g., A5): J3
It's a MISS!
Guesses Made: 1
Maximum Guesses Allowed: 10
Current Game Grid:
  0 1 2 3 4 5 6 7 8 9 
A _ _ _ _ _ _ _ _ _ _ 
B _ _ _ _ _ _ _ _ _ _ 
C _ _ _ _ _ _ _ _ _ _ 
D _ _ _ _ _ _ _ _ _ _ 
E _ _ _ _ _ _ _ _ _ _ 
F _ _ _ _ _ _ _ _ _ _ 
G _ _ _ _ _ _ _ _ _ _ 
H _ _ _ _ _ _ _ _ _ _ 
I _ _ _ _ _ _ _ _ _ _ 
J _ _ _ M _ _ _ _ _ _ 
Enter your guess (row and column, e.g., A5): C8
It's a HIT!
Guesses Made: 2
Maximum Guesses Allowed: 10
Current Game Grid:
  0 1 2 3 4 5 6 7 8 9 
A _ _ _ _ _ _ _ _ _ _ 
B _ _ _ _ _ _ _ _ _ _ 
C _ _ _ _ _ _ _ _ H _ 
D _ _ _ _ _ _ _ _ _ _ 
E _ _ _ _ _ _ _ _ _ _ 
F _ _ _ _ _ _ _ _ _ _ 
G _ _ _ _ _ _ _ _ _ _ 
H _ _ _ _ _ _ _ _ _ _ 
I _ _ _ _ _ _ _ _ _ _ 
J _ _ _ M _ _ _ _ _ _ 
Enter your guess (row and column, e.g., A5): K4
Error: Invalid guess coordinates.
Guesses Made: 2
Maximum Guesses Allowed: 10
Current Game Grid:
  0 1 2 3 4 5 6 7 8 9 
A _ _ _ _ _ _ _ _ _ _ 
B _ _ _ _ _ _ _ _ _ _ 
C _ _ _ _ _ _ _ _ H _ 
D _ _ _ _ _ _ _ _ _ _ 
E _ _ _ _ _ _ _ _ _ _ 
F _ _ _ _ _ _ _ _ _ _ 
G _ _ _ _ _ _ _ _ _ _ 
H _ _ _ _ _ _ _ _ _ _ 
I _ _ _ _ _ _ _ _ _ _ 
J _ _ _ M _ _ _ _ _ _ 
Enter your guess (row and column, e.g., A5): C8
Error: Cell has already been guessed.
Guesses Made: 2
Maximum Guesses Allowed: 10
Current Game Grid:
  0 1 2 3 4 5 6 7 8 9 
A _ _ _ _ _ _ _ _ _ _ 
B _ _ _ _ _ _ _ _ _ _ 
C _ _ _ _ _ _ _ _ H _ 
D _ _ _ _ _ _ _ _ _ _ 
E _ _ _ _ _ _ _ _ _ _ 
F _ _ _ _ _ _ _ _ _ _ 
G _ _ _ _ _ _ _ _ _ _ 
H _ _ _ _ _ _ _ _ _ _ 
I _ _ _ _ _ _ _ _ _ _ 
J _ _ _ M _ _ _ _ _ _ 
Enter your guess (row and column, e.g., A5): 
```
## Features

- Console-based user interface
- Random ship placement
- User input validation
- Display of game state and messages
- Mock implementations for testing

## Project Structure

- `src/battleship/`: Contains the main game logic and classes.
  - `BattleshipConsoleController.java`: Handles user input and game flow.
  - `BattleshipConsoleView.java`: Displays game state and messages to the user.
  - `BattleshipController.java`: Interface for the game controller.
  - `BattleshipModel.java`: Interface for the game model.
  - `BattleshipModelImpl.java`: Implementation of the game model.
  - `BattleshipView.java`: Interface for the game view.
  - `CellState.java`: Enum representing the possible states of a cell on the game grid.
  - `Main.java`: Main class to run the game.
  - `MockBattleshipModel.java`: Mock implementation of the game model for testing.
  - `MockBattleshipView.java`: Mock implementation of the game view for testing.
  - `Ship.java`: Represents a ship in the game.
  - `ShipType.java`: Enum representing different types of ships in the game.

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or any other Java IDE.
3. Run the `Main` class located in `src/battleship/Main.java`.

## How to Play

1. The game will display a welcome message and the maximum number of guesses allowed.
2. Enter your guess in the format `A5` (row and column).
3. The game will display whether your guess was a hit or miss.
4. The game will continue until all ships are sunk or the maximum number of guesses is reached.
5. The final ship positions will be displayed at the end of the game.

## Testing

Mock implementations of the model and view are provided for unit testing the controller. These can be found in `src/battleship/MockBattleshipModel.java` and `src/battleship/MockBattleshipView.java`.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
