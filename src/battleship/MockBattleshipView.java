package battleship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mock implementation of the {@link BattleshipView} interface for testing purposes.
 * This class captures messages displayed by the view during a Battleship game, allowing
 * verification of the output in test cases.
 */
public class MockBattleshipView implements BattleshipView {
  public final List<String> messages = new ArrayList<>();
  // Stores all messages displayed by the view

  /**
   * Displays the welcome message for the Battleship game.
   *
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayWelcomeMessage() throws IOException {
    messages.add("Welcome to Battleship!");
  }

  /**
   * Displays a prompt message asking the player to enter their guess.
   *
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayPromptMessage() throws IOException {
    messages.add("Enter your guess:");
  }

  /**
   * Displays the current state of the cell grid.
   * <p>
   * This implementation logs a placeholder message for testing purposes.
   *
   * @param cellGrid a 2D array of {@link CellState} representing the cell grid
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayCellGrid(CellState[][] cellGrid) throws IOException {
    messages.add("Displaying the current grid.");
  }

  /**
   * Displays the final ship grid, showing the positions of all ships.
   * <p>
   * This implementation logs a placeholder message for testing purposes.
   *
   * @param shipGrid a 2D array of {@link ShipType} representing the ship grid
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayShipGrid(ShipType[][] shipGrid) throws IOException {
    messages.add("Displaying the final ship grid.");
  }

  /**
   * Displays the current number of guesses made by the player.
   *
   * @param currentGuesses the number of guesses made so far
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayGuessCount(int currentGuesses) throws IOException {
    messages.add("Guess count: " + currentGuesses);
  }

  /**
   * Displays the maximum number of guesses allowed in the game.
   *
   * @param maxGuesses the maximum number of guesses
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayMaxGuesses(int maxGuesses) throws IOException {
    messages.add("Max guesses allowed: " + maxGuesses);
  }

  /**
   * Displays an error message.
   *
   * @param message the error message to be displayed
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayErrorMessage(String message) throws IOException {
    messages.add("Error: " + message);
  }

  /**
   * Displays the game-over message based on whether the player won or lost.
   *
   * @param win true if the player won, false otherwise
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayGameOver(boolean win) throws IOException {
    messages.add(win ? "Game over! You won!" : "Game over! You lost.");
  }

  /**
   * Displays a message indicating the player hit a ship.
   *
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayHitMessage() throws IOException {
    messages.add("You hit a ship!");
  }

  /**
   * Displays a message indicating the player missed.
   *
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void displayMissMessage() throws IOException {
    messages.add("You missed!");
  }
}
