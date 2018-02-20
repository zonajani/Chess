package com.chess.engine.objects;

import com.chess.engine.Alliance;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Board;
import com.chess.engine.board.Tile;


import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zonaj on 2018.01.14..
 */

public class Knight extends Object {

    private final static int[] OBJECT_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};


    Knight(final int objectPosition, final Alliance objectAlliance) {
        super(objectPosition, objectAlliance);
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {


        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentObjectOffset : OBJECT_MOVE_COORDINATES) {

            final int objectDestinationCoordinate = this.objectPosition + currentObjectOffset;
            if (BoardUtils.isValidTileCoordinate(objectDestinationCoordinate)) {

                if (isFirstColExc(this.objectPosition, currentObjectOffset) ||
                        isSecondColExc(this.objectPosition, currentObjectOffset) ||
                        isSeventhColExc(this.objectPosition, currentObjectOffset) ||
                        isEighthColExc(this.objectPosition, currentObjectOffset)) {
                    continue;

                }
                final Tile objectDestinationTile = board.getTile(objectDestinationCoordinate);
                if (!objectDestinationTile.isTileOccupied()) {
                    legalMoves.add(new Move());

                } else {
                    final Object objectAtDestination = objectDestinationTile.getObject();
                    final Alliance objectAlliance = objectAtDestination.getObjectAlliance();

                    if (this.objectAlliance != objectAlliance) {
                        legalMoves.add(new Move());
                    }
                }
            }


        }

        return Collections.unmodifiableList(legalMoves);

    }

    private static boolean isFirstColExc(final int currentPosition, final int objectOffset) {

        return BoardUtils.FIRST_COL[currentPosition] && ((objectOffset == -17) ||
                (objectOffset == -10) || (objectOffset == 6) || (objectOffset == 15));
    }

    private static boolean isSecondColExc(final int currentPosition, final int objectOffset) {

        return BoardUtils.SECOND_COL[currentPosition] && ((objectOffset == -10) ||
                (objectOffset == 6));
    }

    private static boolean isSeventhColExc(final int currentPosition, final int objectOffset) {
        return BoardUtils.SEVENTH_COL[currentPosition] && ((objectOffset == -6) || (objectOffset == 10));
    }

    private static boolean isEighthColExc(final int currentPosition, final int objectOffset) {
        return BoardUtils.EIGHTH_COL[currentPosition] && ((objectOffset == -15) || (objectOffset == -6) ||
                (objectOffset == 10) || (objectOffset == 17));
    }

}
