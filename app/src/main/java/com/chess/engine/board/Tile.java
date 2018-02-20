package com.chess.engine.board;
import com.chess.engine.objects.Object;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zonaj on 2018.01.14..
 */

public abstract class Tile {

    protected final int tileCoordinate;

    private static final Map<Integer, emptyTile> EMPTY_TILES = createAllPossibleEmptyTile();

    private static Map<Integer,emptyTile> createAllPossibleEmptyTile() {

        final Map<Integer, emptyTile> emptyTileMap = new HashMap<>();

        for (int i = 0; i <64; i++){
            emptyTileMap.put(i, new emptyTile(i));
        }
        return Collections.unmodifiableMap(emptyTileMap);

    }

    public static Tile createTile(final int tileCoordinate, final Object object){
        return object != null ? new occupiedTile(tileCoordinate, object) : EMPTY_TILES.get(tileCoordinate);
    }

    private Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Object getObject();

    public static final class emptyTile extends Tile {

        private emptyTile(final int coordinate){
            super(coordinate);

        }
        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override
        public Object getObject(){
            return null;
        }
    }

    public static final class occupiedTile extends Tile {

        private final Object objectOnTile;
        private occupiedTile(int tileCoordinate, Object objectOnTile){
            super(tileCoordinate);
            this.objectOnTile = objectOnTile;
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }

        @Override
        public Object getObject(){
            return this.objectOnTile;
        }
    }
}
