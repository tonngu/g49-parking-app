package se.lexicon.data.sequencer;

public class ReservationSequencer {
    private static Integer sequencer = 1000;
    public static Integer nextId(){
        return ++sequencer;
    }



}
