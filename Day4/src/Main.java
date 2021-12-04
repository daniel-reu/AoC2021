import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/in.txt"));

        ArrayList<String> list = new ArrayList<String>();

        String line;

        while((line = br.readLine()) != null) {
            list.add(line);
        }

        List<BingoBoard> boards = new ArrayList<BingoBoard>();
        List<Integer> winningNumbers = new ArrayList<Integer>();

        BingoBoard currentBoard = null;
        Integer lineNumber = 0;

        //Get the winning numbers and add the boards to our board list
        for(String s : list) {
            if(lineNumber == 0) {
                winningNumbers = getWinningNumbers(s);
                lineNumber++;
                continue;
            }
            if(s.isBlank()) {
                if(currentBoard != null) {
                    boards.add(currentBoard);

                }
                currentBoard = new BingoBoard();
                continue;
            }
            if(currentBoard != null) {
                boards.add(currentBoard);
            }
            currentBoard.addRow(s);
        }

        BingoBoard winner = null;
        Integer winnerNumber = 0;
        Integer numberOfWinningBoards = 0;



        //Find the winner
        loop:
        for(Integer number : winningNumbers) {
            for(BingoBoard board : boards) {
                if(board.addNumber(number)) {
                    winner = board;
                    winnerNumber = number;
                    numberOfWinningBoards++;
                        if(numberOfWinningBoards == boards.size()) break loop;
//                    System.out.println(board.calculateMarkedWords(number));
//                    return;
                }
            }
        }


        if(winner != null) {
            System.out.println(winner.calculateMarkedWords(winnerNumber));
        }
    }

    public static List<Integer> getWinningNumbers(@NotNull String string) {
        return List.of(string.split(",")).stream().map(Integer::valueOf).collect(Collectors.toList());
    }


}
