package battleship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the {@link BattleshipConsoleController} class.
 * This class tests various scenarios including normal gameplay,
 * invalid inputs, and game-winning scenarios.
 */
public class BattleshipConsoleControllerTest {
  private MockBattleshipView view;

  /**
   * Sets up the mock view object before each test case.
   */
  @Before
  public void setUp() {
    view = new MockBattleshipView();
  }

  /**
   * Tests the scenario where the game ends without winning, ensuring the game processes guesses
   * correctly, terminates after a specified number of attempts, and displays appropriate messages.
   *
   */
  @Test
  public void testPlayGameWithoutWin() {
    // Arrange
    int[] shipGrid = {3, 12, 10, 14, 15}; // Ships are located at these positions
    String inputSequence = """
        A3
        A5
        A4
        B8
        A9
        """;
    StringReader input = new StringReader(inputSequence);
    BattleshipConsoleController controller = new BattleshipConsoleController(input, view);

    MockBattleshipModel model = new MockBattleshipModel(shipGrid);

    // Act
    controller.playGame(model);

    // Assert
    assertFalse(model.areAllShipsSunk()); // Verify game ends without sinking all ships
    assertEquals("Game over! You lost.", view.messages.get(view.messages.size() - 2));
    // Verify game-over message

    // Verify all messages in sequence
    assertEquals("Welcome to Battleship!", view.messages.get(0));
    assertEquals("Max guesses allowed: 5", view.messages.get(1));

    assertEquals("Enter your guess:", view.messages.get(2));
    assertEquals("Guess count: 1", view.messages.get(3));
    assertEquals("You hit a ship!", view.messages.get(4)); // A3 hit (0 * 10 + 3 is equal to 3)
    assertEquals("Displaying the current grid.", view.messages.get(5));

    assertEquals("Enter your guess:", view.messages.get(6));
    assertEquals("Guess count: 2", view.messages.get(7));
    assertEquals("You missed!", view.messages.get(8)); // A5 miss (0 * 10 + 5 is not equal to 12)
    assertEquals("Displaying the current grid.", view.messages.get(9));

    assertEquals("Enter your guess:", view.messages.get(10));
    assertEquals("Guess count: 3", view.messages.get(11));
    assertEquals("You missed!", view.messages.get(12)); // A4 miss(0 * 10 + 4 is not equal to 10)
    assertEquals("Displaying the current grid.", view.messages.get(13));

    assertEquals("Enter your guess:", view.messages.get(14));
    assertEquals("Guess count: 4", view.messages.get(15));
    assertEquals("You missed!", view.messages.get(16)); // B8 miss (1 * 10 + 8 is not equal to 14)
    assertEquals("Displaying the current grid.", view.messages.get(17));

    assertEquals("Enter your guess:", view.messages.get(18));
    assertEquals("Guess count: 5", view.messages.get(19));
    assertEquals("You missed!", view.messages.get(20)); // A5 miss (0 * 10 + 5 is not equal to 15)
    assertEquals("Displaying the current grid.", view.messages.get(21));
  }

  /**
   * Tests the scenario where all user inputs are invalid,
   * ensuring that the game correctly validates
   * input and displays error messages without affecting the game state or guess count.
   *
   */
  @Test
  public void testPlayGameWithAllInvalidInputs() {
    // Arrange
    int[] shipGrid = {3, 12, 10, 14, 15}; // Ships are located at these positions (irrelevant here)
    String inputSequence = """
                Z11
                A!
                !5
                M5
                A?
                
                B0
                B6
                B7
                B8
                B9
                """;
    StringReader input = new StringReader(inputSequence);
    BattleshipConsoleController controller = new BattleshipConsoleController(input, view);

    MockBattleshipModel model = new MockBattleshipModel(shipGrid);

    // Act
    controller.playGame(model);

    // Assert
    assertFalse(model.areAllShipsSunk()); // No ships sunk since all inputs were invalid

    // Verify error messages in sequence
    assertEquals("Welcome to Battleship!", view.messages.get(0));
    assertEquals("Max guesses allowed: 5", view.messages.get(1));

    // First invalid input (Z11)
    assertEquals("Enter your guess:", view.messages.get(2));
    assertEquals("Error: User guess must be exactly 2 characters (e.g., A5).",
        view.messages.get(3));

    // Second invalid input (A!)
    assertEquals("Enter your guess:", view.messages.get(4));
    assertEquals("Error: Column must be a digit between 0 and 9.", view.messages.get(5));

    // Third invalid input (!5)
    assertEquals("Enter your guess:", view.messages.get(6));
    assertEquals("Error: Row must be a letter between A and J.", view.messages.get(7));

    // Forth invalid input (M5)
    assertEquals("Enter your guess:", view.messages.get(8));
    assertEquals("Error: Row must be a letter between A and J.", view.messages.get(9));

    // Fifth invalid input (A?)
    assertEquals("Enter your guess:", view.messages.get(10));
    assertEquals("Error: Column must be a digit between 0 and 9.", view.messages.get(11));

  }

  /**
   * Tests the scenario where the game ends with a win, ensuring that all ships are sunk,
   * the game processes guesses correctly, and appropriate messages are displayed.
   *
   */
  @Test
  public void testPlayGameWithWin() {
    // Arrange
    int[] shipGrid = {3, 5, 4, 18, 9}; // Ships are located at these positions
    String inputSequence = """
        A3
        A5
        A4
        B8
        A9
        """;
    StringReader input = new StringReader(inputSequence);
    BattleshipConsoleController controller = new BattleshipConsoleController(input, view);

    MockBattleshipModel model = new MockBattleshipModel(shipGrid);

    // Act
    controller.playGame(model);

    // Assert
    assertTrue(model.areAllShipsSunk()); // Verify game ends with sinking all ships
    assertEquals("Game over! You won!", view.messages.get(view.messages.size() - 2));
    // Verify game-over message

    // Verify all messages in sequence
    assertEquals("Welcome to Battleship!", view.messages.get(0));
    assertEquals("Max guesses allowed: 5", view.messages.get(1));

    assertEquals("Enter your guess:", view.messages.get(2));
    assertEquals("Guess count: 1", view.messages.get(3));
    assertEquals("You hit a ship!", view.messages.get(4)); // A3 hit
    assertEquals("Displaying the current grid.", view.messages.get(5));

    assertEquals("Enter your guess:", view.messages.get(6));
    assertEquals("Guess count: 2", view.messages.get(7));
    assertEquals("You hit a ship!", view.messages.get(8)); // A5 hit
    assertEquals("Displaying the current grid.", view.messages.get(9));

    assertEquals("Enter your guess:", view.messages.get(10));
    assertEquals("Guess count: 3", view.messages.get(11));
    assertEquals("You hit a ship!", view.messages.get(12)); // A4 hit
    assertEquals("Displaying the current grid.", view.messages.get(13));

    assertEquals("Enter your guess:", view.messages.get(14));
    assertEquals("Guess count: 4", view.messages.get(15));
    assertEquals("You hit a ship!", view.messages.get(16)); // B8 hit
    assertEquals("Displaying the current grid.", view.messages.get(17));

    assertEquals("Enter your guess:", view.messages.get(18));
    assertEquals("Guess count: 5", view.messages.get(19));
    assertEquals("You hit a ship!", view.messages.get(20)); // A5 hit
    assertEquals("Displaying the current grid.", view.messages.get(21));
  }

}






