import java.util.Arrays;

public class CharacterSelection {
  public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
    if (moves == null || moves.length == 0) {
      return new String[] {};
    }

    int row = fighters.length;
    int column = fighters[0].length;

    int start_row = position[0];
    int start_column = position[1];

    String[] setps = new String[moves.length];
    for (int i = 0; i < moves.length; i++) {

      if (moves[i].equals("left")) {
        start_column -= 1;
      } else if (moves[i].equals("up")) {
        start_row -= 1;
      } else if (moves[i].equals("right")) {
        start_column += 1;
      } else if (moves[i].equals("down")) {
        start_row += 1;
      }

      start_column = start_column < 0 ? column - 1 : start_column;
      start_row = Integer.max(start_row, 0);

      start_column = start_column > column - 1 ? 0 : start_column;
      start_row = Integer.min(start_row, row - 1);

      setps[i] = fighters[start_row][start_column];

    }

    return setps;
  }

  public static void main(String[] args) {

    String[][] fighters = new String[][] { new String[] { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
        new String[] { "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" }, };

    String[] moves = new String[] { "up", "left", "right", "left", "left" };

    String[] steps = streetFighterSelection(fighters, new int[] { 0, 0 }, moves);
    System.out.println(Arrays.toString(steps));

  }
}