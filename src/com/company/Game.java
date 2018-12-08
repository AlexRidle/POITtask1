package com.company;

public class Game {
    public static void start(){
        boolean play;
        int moveCount = 0;

        Field grid = new Field();
        grid.placeHorse();
        grid.showField();

        do{
            play = Horse.move(grid);
            moveCount++;
        }while(play);

        end(grid, moveCount);
    }

    public static void end(Field grid, int count){
        grid.fieldGrid[grid.firstHorse[0]][grid.firstHorse[1]] = 'S';
        grid.showField();
        System.out.println("Move count: " + count);
        System.out.println("Move sequence: " + grid.moveSequence);
    }
}
