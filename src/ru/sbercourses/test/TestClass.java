package ru.sbercourses.test;

import ru.sbercourses.game.Game;
import ru.sbercourses.game.Game2048;
import ru.sbercourses.game.board.Board;
import ru.sbercourses.game.board.SquareBoard;

public class TestClass {
    public static void main(String[] args) {
        Board board = new SquareBoard(4);
        Game game2048 = new Game2048(board);
        System.out.println(game2048.canMove());
    }
}
