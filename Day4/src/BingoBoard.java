import org.jetbrains.annotations.NotNull;

public class BingoBoard {

    private static final Integer BOARDSIZE = 5;

    private static final Integer VALUE_FOR_ZERO = 500;

    private Integer[] board = new Integer[BOARDSIZE*BOARDSIZE];

    private Integer currentLine = 0;

    private Boolean winner = false;

    public BingoBoard() {}

    //Add the rows to our board
    public void addRow(@NotNull String row) {
        String[] rowArray = row.trim().split("[ ]+");
        Integer xPos = 0;
        for(String number : rowArray) {
            board[currentLine * BOARDSIZE + xPos] = Integer.parseInt(number);
            xPos++;
        }
        currentLine++;
    }

    //Find out if our board has bingo'd
    public Boolean addNumber(@NotNull Integer number) {
        if(winner) return false;

        Integer position = 0;
        for(Integer b : board) {
            if(b.equals(number)) {
                if(number > 0) {
                    board[position] = -number;
                } else {
                    board[position] = -VALUE_FOR_ZERO;
                }
                break;
            }
            position++;
        }

        if(position > ((BOARDSIZE * BOARDSIZE) - 1)) return false;

        Integer column = position % BOARDSIZE;
        Integer row = Math.floorDiv(position, BOARDSIZE);

        Integer count = 0;
        for (int i = 0; i < BOARDSIZE; i++) {
            count += board[row * BOARDSIZE + i] < 0 ? 1 : 0;
        }

        if(count.equals(BOARDSIZE)) {
            winner = true;
            return true;
        }

        count = 0;
        for (int i = 0; i < BOARDSIZE; i++) {
            count += board[i * BOARDSIZE + column] < 0 ? 1 : 0;
        }

        if(count.equals(BOARDSIZE)) {
            winner = true;
            return true;
        }
        return false;
    }

    //Get the result for our flag
    public Integer calculateMarkedWords(@NotNull Integer drawnNumber) {
        Integer result = 0;
        for (int i = 0; i < (BOARDSIZE * BOARDSIZE); i++) {
            if(board[i] >= 0) {
                result += board[i];
            }
        }
        return result * drawnNumber;
    }
}
