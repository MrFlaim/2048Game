package ru.sbercourses.game;

import java.util.ArrayList;
import java.util.List;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        var filtredList = move(list);
        return mergeEqual(filtredList);
    }

    private List<Integer> move(List<Integer> list) {
        List<Integer> filtredList = new ArrayList<>();
        for (Integer integer : list) {
            if (integer != null) {
                filtredList.add(integer);
            }
        }
        for (int i = filtredList.size(); i < list.size(); i++) {
            filtredList.add(null);
        }
        return filtredList;
    }

    private List<Integer> mergeEqual(List<Integer> filtredList) {
        for (int i = 0; i < filtredList.size() - 1; i++) {
            if ((filtredList.get(i) != null) && filtredList.get(i).equals(filtredList.get(i + 1))) {
                filtredList.set(i, filtredList.get(i + 1) * 2);
                filtredList.remove(i + 1);
                filtredList.add(null);
            }
        }
        return filtredList;
    }
}
