package com.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProbabilityTest {
    Probability probabilityToGetHeadDuringCoinToss = new Probability(0.5);
    Probability probabilityToGetTailsDuringCoinToss = new Probability(0.5);

    @Test
    public void returnTrueForEqualProbabilityValues(){
        assertTrue(probabilityToGetHeadDuringCoinToss.equals(probabilityToGetTailsDuringCoinToss));
    }

    @Test
    public void returnProbabilityValueOfTwoEventsOccuringTogether(){
        Probability probabilityOfTwoEventsOccuringTogether = new Probability(0.25);
        assertEquals(probabilityOfTwoEventsOccuringTogether,probabilityToGetHeadDuringCoinToss.theProbabilityOfTwoEventsOccurringTogether(probabilityToGetTailsDuringCoinToss));
    }

    @Test
    public void throwsExceptionForTheProbabilityOfTwoEventsOccurringTogether(){
        Probability probabilityAsNull = null;
        NullPointerException exception = assertThrows(NullPointerException.class,()->probabilityToGetTailsDuringCoinToss.theProbabilityOfTwoEventsOccurringTogether(probabilityAsNull));
        assertEquals("Null Value Found for Probability",exception.getMessage());
    }

    @Test
    public void returnProbabilityValueOfEventNotOccuring(){
        Probability probabilityOfEventNotOccuring = new Probability(0.5);
        assertEquals(probabilityOfEventNotOccuring, probabilityToGetHeadDuringCoinToss.theProbabilityOfEventNotOccurring());
    }
    @Test
    public void returnExceptionForNullValuesIntheProbabilityOfEitherTwoEventsOccurring(){
        Probability probabilityAsNull= null;
        assertThrows(NullPointerException.class,()-> probabilityToGetHeadDuringCoinToss.theProbabilityOfEitherTwoEventsOccurring(probabilityAsNull));
    }
    @Test
    public void returnTheProbabilityValueOfEitherTwoEventsOccurring(){
        Probability probabilityOfEitherTwoEventsOccurring = new Probability(0.75);
        assertEquals(probabilityOfEitherTwoEventsOccurring, probabilityToGetHeadDuringCoinToss.theProbabilityOfEitherTwoEventsOccurring(probabilityToGetTailsDuringCoinToss));
    }

}
