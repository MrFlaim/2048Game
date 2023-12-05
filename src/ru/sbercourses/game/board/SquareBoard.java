package ru.sbercourses.game.board;

import ru.sbercourses.game.Key;

import java.util.ArrayList;
import java.util.List;

public class SquareBoard extends Board {
    private int size;

    public SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    @Override
    public void fillBoard(List<Integer> list) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board.put(new Key(i, j), list.get(i * size + j));
            }
        }
    }

    @Override
    public List<Key> availableSpace() {
        List<Key> nullKeyList = new ArrayList<>();
        for (Key key : board.keySet()) {
            if (board.get(key) == null) {
                nullKeyList.add(key);
            }
        }
        return nullKeyList;
    }

    @Override
    public void addItem(Key key, Integer value) {
        board.put(key, value);
    }

    @Override
    public Key getKey(int i, int j) {
        for (Key key : board.keySet()) {
            if (key.equals(new Key(i, j))) {
                return key;
            }
        }
        return null;
    }

    @Override
    public Integer getValue(Key key) {
        return board.get(key);
    }

    @Override
    public List<Key> getColumn(int j) {
        List<Key> columnKeys = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            columnKeys.add(new Key(i, j));
        }
        return columnKeys;
    }

    @Override
    public List<Key> getRow(int i) {
        List<Key> rowKeys = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            rowKeys.add(new Key(i, j));
        }
        return rowKeys;
    }

    @Override
    public boolean hasValue(Integer value) {
        return board.containsValue(value);
    }

    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> values = new ArrayList<>();
        for (Key key : keys) {
            values.add(board.get(key));
        }
        return values;
    }
}
