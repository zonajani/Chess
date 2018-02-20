package com.chess.engine.objects;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.Collection;

/**
 * Created by zonaj on 2018.01.14..
 */

public abstract class Object {

    protected final int objectPosition;
    protected final Alliance objectAlliance;

    Object(final int objectPosition, final Alliance objectAlliance){
        this.objectPosition = objectPosition;
        this.objectAlliance = objectAlliance;

    }
    public Alliance getObjectAlliance(){
        return this.objectAlliance;
    }
    public abstract Collection<Move> calculateLegalMoves(final Board board);


}
