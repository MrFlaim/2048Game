package ru.sbercourses.game;

import ru.sbercourses.utility.Direction;
import ru.sbercourses.utility.board.Board;

public interface Game {
    void init();

    boolean canMove();

    void move(Direction direction);

    void addItem();

    Board getGameBoard();

    boolean hasWin();

}

