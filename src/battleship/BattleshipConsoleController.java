package battleship;

import java.io.IOException;
import java.util.Scanner;

/**
 * Console-based controller for the Battleship game. This class handles user input,
 * updates the view based on the state of the model, and facilitates the flow of the game.
 */
public class BattleshipConsoleController implements BattleshipController {
  private final Readable input; // Input source for user commands
  private final BattleshipView view; // View interface for displaying game output

  /**
   * Constructs a new {@code BattleshipConsoleController}.
   *
   * @param input the input source for user commands (e.g., {@link StringReader} or {@link Scanner})
   * @param view  the view interface used to display game messages and grid states
   */
  public BattleshipConsoleController(Readable input, BattleshipView view) {
    this.input = input;
    this.view = view;
  }

  /**
   * Starts and manages the flow of the Battleship game. This method reads user input,
   * updates the game model, and uses the view to display the game's state and messages.
   *
   * @param model the {@link BattleshipModel} representing the game's state
   * @throws RuntimeException if an I/O error occurs or input ends unexpectedly
   */
  @Override
  public void playGame(BattleshipModel model) {
    model.startGame();
    int guessCount = model.getGuessCount();
    int maxCount = model.getMaxGuesses();

    try {
      view.displayWelcomeMessage();
      view.displayMaxGuesses(maxCount);
    } catch (IOException e) {
      throw new RuntimeException("Failed to display the welcome message.", e);
    }

    try (Scanner scanner = new Scanner(input)) {
      while (!model.isGameOver()) {
        try {
          view.displayPromptMessage();
          if (!scanner.hasNextLine()) {
            throw new IllegalArgumentException("Input ended unexpectedly.");
          }
          String userGuess = scanner.nextLine().trim();
          int[] answer = parseGuess(userGuess);

          boolean isHit = model.makeGuess(answer[0], answer[1]);
          guessCount++;

          view.displayGuessCount(guessCount);
          if (isHit) {
            view.displayHitMessage();
          } else {
            view.displayMissMessage();
          }
          view.displayCellGrid(model.getCellGrid());

          if (model.isGameOver()) {
            view.displayGameOver(model.areAllShipsSunk());
            view.displayShipGrid(model.getShipGrid());
          }

        } catch (IllegalArgumentException e) {
          try {
            view.displayErrorMessage(e.getMessage());
          } catch (IOException ioException) {
            throw new RuntimeException("Failed to display an error message.", ioException);
          }
        }
      }
    } catch (IOException e) {
      throw new RuntimeException("An error occurred while updating the view.", e);
    }
  }

  /**
   * Parses a user's guess and converts it into a row and column index.
   *
   * @param userGuess the string input by the user, e.g., "A5"
   * @return an array of integers where the first element is the row and the second is the column.
   * @throws IllegalArgumentException if the input format is invalid or out of bounds
   */
  private int[] parseGuess(String userGuess) {
    userGuess = userGuess.toUpperCase();

    if (userGuess.length() != 2) {
      throw new IllegalArgumentException("User guess must be exactly 2 characters (e.g., A5).");
    }
    if (userGuess.charAt(0) < 'A' || userGuess.charAt(0) > 'J') {
      throw new IllegalArgumentException("Row must be a letter between A and J.");
    }
    if (userGuess.charAt(1) < '0' || userGuess.charAt(1) > '9') {
      throw new IllegalArgumentException("Column must be a digit between 0 and 9.");
    }

    int row = userGuess.charAt(0) - 'A';
    int col = userGuess.charAt(1) - '0';

    return new int[]{row, col};
  }
}
