package battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock implementation of the {@link BattleshipModel} interface for testing purposes.
 * This class simulates a simplified Battleship game with predefined ship positions
 * and tracks player guesses. It is used primarily for unit testing the controller.
 */
public class MockBattleshipModel implements BattleshipModel {
  private final int[] shipGrid; // Predefined ship positions
  private final List<Integer> guesses; // Tracks player guesses
  private boolean isGameStarted = false; // Indicates whether the game has started
  private int guessCount = 0; // Tracks the number of guesses made by the player

  /**
   * Constructs a mock Battleship model with predefined ship positions.
   *
   * @param shipGrid an array representing the positions of ships on the grid
   */
  public MockBattleshipModel(int[] shipGrid) {
    this.shipGrid = shipGrid;
    this.guesses = new ArrayList<>();
  }

  /**
   * Starts the game by setting the game start flag to true.
   */
  @Override
  public void startGame() {
    isGameStarted = true;
  }

  /**
   * Processes a player's guess and checks if it hits a ship.
   *
   * @param row the row index of the guess
   * @param col the column index of the guess
   * @return true if the guess hits a ship, false otherwise
   */
  @Override
  public boolean makeGuess(int row, int col) {
    int guess = row * 10 + col; // Convert row/col to a single number
    guesses.add(guess); // Add to the list of guesses
    guessCount++;
    for (int ship : shipGrid) {
      if (ship == guess) {
        return true; // Hit
      }
    }
    return false; // Miss
  }

  /**
   * Determines if the game is over based on the number of guesses made.
   *
   * @return true if the maximum number of guesses is reached, false otherwise
   */
  @Override
  public boolean isGameOver() {
    return guessCount >= 5; // Game ends after 5 guesses
  }

  /**
   * Checks if all ships have been sunk.
   *
   * @return true if all ships have been hit, false otherwise
   */
  @Override
  public boolean areAllShipsSunk() {
    for (int ship : shipGrid) {
      if (!guesses.contains(ship)) {
        return false; // At least one ship is not hit
      }
    }
    return true; // All ships are hit
  }

  /**
   * Gets the number of guesses made by the player.
   *
   * @return the number of guesses made
   */
  @Override
  public int getGuessCount() {
    return guessCount;
  }

  /**
   * Gets the maximum number of guesses allowed.
   *
   * @return the maximum number of guesses
   */
  @Override
  public int getMaxGuesses() {
    return 5; // Max guesses allowed
  }

  /**
   * Gets the cell grid representing the game state.
   * <p>
   * This method is not used in the mock implementation and always returns an empty grid.
   *
   * @return a 2D array of {@link CellState} representing the cell grid
   */
  @Override
  public CellState[][] getCellGrid() {
    return new CellState[0][0]; // Not used for this test
  }

  /**
   * Gets the ship grid representing the positions of ships.
   * <p>
   * This method is not used in the mock implementation and always returns an empty grid.
   *
   * @return a 2D array of {@link ShipType} representing the ship grid
   */
  @Override
  public ShipType[][] getShipGrid() {
    return new ShipType[0][0]; // Not used for this test
  }
}
