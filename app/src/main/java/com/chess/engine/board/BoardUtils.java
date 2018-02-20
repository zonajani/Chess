package com.chess.engine.board;

/**
 * Created by zonaj on 2018.01.14..
 */

public class BoardUtils {

    public static final boolean[] FIRST_COL = null;
    public static final boolean[] SECOND_COL = null;
    public static final boolean[] SEVENTH_COL = null;
    public static final boolean[] EIGHTH_COL = null;

    private BoardUtils(){
        throw new RuntimeException("");
    }

    public static boolean isValidTileCoordinate(int coordinate) {
        return coordinate >=0 && coordinate < 64;
    }
}
