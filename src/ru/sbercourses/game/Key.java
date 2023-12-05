package ru.sbercourses.game;

import java.util.Objects;

public class Key {
    private int row;
    private int column;

    public Key(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return row == key.row && column == key.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
