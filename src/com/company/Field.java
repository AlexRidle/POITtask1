package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Field {

    public int[] firstHorse = new int[]{0,0};
    public void setFirstHorse(int x, int y){firstHorse[x] = y;}
    public int[] getFirstHorse(){return firstHorse;}
    public int getFirstHorse(int x){return firstHorse[x];}

    public int[] currentHorse = new int[]{0,0};
    public void setCurrentHorse(int x, int y){currentHorse[x] = y;}
    public int[] getCurrentHorse(){return currentHorse;}
    public int getCurrentHorse(int x){return currentHorse[x];}

    public int[] testHorse = new int[]{0,0};
    public void setTestHorse(int x, int y){testHorse[x] = y;}
    public int[] getTestHorse(){return testHorse;}
    public int getTestHorse(int x){return testHorse[x];}

    public char[][] fieldGrid = generate();
    public ArrayList<Integer[]> moves = new ArrayList<>();
    public ArrayList<String> moveSequence = new ArrayList<>();

    private char[][] generate(){
        char[][] grid = new char[8][8];
        for(int i = 0; i<8;i++){
            for(int j = 0;j<8;j++){
                grid[i][j] = 'X';
            }
        }
        return grid;
    }

    public void showField(){
        System.out.println("");
        for(int i=0; i<8; i++){
            for(int j=0;j<8;j++){
                System.out.print(this.fieldGrid[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void checkFreeSlots(){
        this.moves.clear();
        boolean DownRight = checkSlot(2,1); checkAndAdd(DownRight);
        boolean DownLeft = checkSlot(2,-1); checkAndAdd(DownLeft);
        boolean LeftDown = checkSlot(1,-2); checkAndAdd(LeftDown);
        boolean LeftUp = checkSlot(-1,-2);  checkAndAdd(LeftUp);
        boolean UpLeft = checkSlot(-2,-1);  checkAndAdd(UpLeft);
        boolean UpRight = checkSlot(-2,1);  checkAndAdd(UpRight);
        boolean RightUp = checkSlot(-1,2);  checkAndAdd(RightUp);
        boolean RightDown = checkSlot(1,2); checkAndAdd(RightDown);
    }

    public void checkAndAdd(boolean move){
        if(move){
            Integer[] goodMove = Arrays.stream(testHorse).boxed().toArray(Integer[]::new);
            this.moves.add(goodMove);
        }
    }

    public void placeHorse(){
        int RandI = (int) (Math.random() * 8); this.currentHorse[0] = RandI; this.firstHorse[0] = RandI;
        int RandJ = (int) (Math.random() * 8); this.currentHorse[1] = RandJ; this.firstHorse[1] = RandJ;
        this.fieldGrid[RandI][RandJ] = 'O';
    }

    public boolean checkSlot(int i, int j){
        System.arraycopy(this.currentHorse, 0, this.testHorse, 0, 2);
        testHorse[0] += i;
        testHorse[1] += j;
        if((testHorse[0]<8 && testHorse[1]<8) && (testHorse[0]>=0 && testHorse[1]>=0)){
            if(this.fieldGrid[testHorse[0]][testHorse[1]] != '_'){
                //this.fieldGrid[testHorse[0]][testHorse[1]] = '!';
                return true;
            }
        }
        return false;
    }
}
