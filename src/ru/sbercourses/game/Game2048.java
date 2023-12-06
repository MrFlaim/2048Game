package ru.sbercourses.game;

import ru.sbercourses.game.board.Board;
import ru.sbercourses.game.utility.GameHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game2048 implements Game {
    private GameHelper helper = new GameHelper();
    private Board board;
    private Random random = new Random();

    public Game2048(Board board) {
        this.board = board;
    }

    @Override
    public void init() {
        var boardCellCount = board.getWidth() * board.getHeight();
        var fillCellCount = 2;
        List<Integer> valuesList = new ArrayList<>();
        for (int i = 0; i < boardCellCount; i++) {
            valuesList.add(null);
        }
        for (int i = 0; i < fillCellCount; i++) {
            addItem();
        }
        board.fillBoard(valuesList);
    }

    @Override
    public boolean canMove() {
        return !board.availableSpace().isEmpty();
    }

    @Override
    public void move(Direction direction) {
        switch (direction) {
            case UP:
                for (int column = 0; column < board.getWidth(); column++) {
                    List<Integer> values = board.getValues(board.getColumn(column));
                    board.fillBoard(helper.moveAndMergeEqual(values));
                }
            case DOWN:
                for (int column = board.getWidth(); column > 0; column--) {
                    List<Integer> values = board.getValues(board.getColumn(column));
                    board.fillBoard(helper.moveAndMergeEqual(values));
                }
            case LEFT:
                for (int row = 0; row < board.getHeight(); row++) {
                    List<Integer> values = board.getValues(board.getRow(row));
                    board.fillBoard(helper.moveAndMergeEqual(values));
                }
            case RIGHT:
                for (int row = board.getHeight(); row > 0; row++) {
                    List<Integer> values = board.getValues(board.getRow(row));
                    board.fillBoard(helper.moveAndMergeEqual(values));
                }
        }
    }

    @Override
    public void addItem() {
        var avalibleList = board.availableSpace();
        var randomAvalibleKey = avalibleList.get(random.nextInt(avalibleList.size()));
        if (random.nextFloat() < 0.9) {
            board.addItem(randomAvalibleKey, 2);
        } else {
            board.addItem(randomAvalibleKey, 4);
        }
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
