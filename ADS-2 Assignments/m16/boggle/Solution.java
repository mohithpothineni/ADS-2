
/**
 * Class for solution.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
    }

    /**
     * Main method.
     *
     * @param      args  The command line arguments.
     */
    public static void main(final String[] args) {
        String caseType = StdIn.readLine();
        switch (caseType) {
        case "Score":
            String dictionaryName = StdIn.readLine();
            In in = new In("/Files/" + dictionaryName);
            String[] dictionary = in.readAllStrings();
            BoggleSolver solver = new BoggleSolver(dictionary);

            String boardName = StdIn.readLine();
            BoggleBoard board = new BoggleBoard("/Files/" + boardName);
            int score = 0;
            for (String word : solver.getAllValidWords(board)) {
                score += solver.scoreOf(word);
            }
            StdOut.println("Score = " + score);
            break;

        default:
            try {
                dictionaryName = StdIn.readLine();
                in = new In("/Files/" + dictionaryName);
                dictionary = in.readAllStrings();
                solver = new BoggleSolver(dictionary);
                board = null;
                score = 0;
                for (String word : solver.getAllValidWords(board)) {
                    score += solver.scoreOf(word);
                }
                StdOut.println("Score = " + score);
            } catch (Exception ex) {
                System.out.println("board is null");
            }
            break;
        }
    }
}
