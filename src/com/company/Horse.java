package com.company;

import java.util.Arrays;

public class Horse {
    public static boolean move(Field grid){
        grid.checkFreeSlots();
        if(!(grid.moves.isEmpty())){
            String prevMove = "("+grid.currentHorse[0]+";"+grid.currentHorse[1]+")-";
            int RandMove = (int) (Math.random() * grid.moves.size());
            grid.fieldGrid[grid.currentHorse[0]][grid.currentHorse[1]] = '_';
            grid.currentHorse = Arrays.stream(grid.moves.get(RandMove)).mapToInt(Integer::intValue).toArray();
            grid.fieldGrid[grid.currentHorse[0]][grid.currentHorse[1]] = 'F';
            String thisMove = "("+grid.currentHorse[0]+";"+grid.currentHorse[1]+")";
            grid.moveSequence.add(prevMove+thisMove);
            return true;
        }else{
            return false;
        }
    }
}
