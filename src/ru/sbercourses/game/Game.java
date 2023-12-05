package ru.sbercourses.game;

import ru.sbercourses.game.board.Board;

public interface Game {
    void init();

    boolean canMove();

    void move(Direction direction);

    void addItem();

    Board getGameBoard();

    boolean hasWin();

}

