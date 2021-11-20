package com.probability;

import java.util.Objects;

public class Probability {
    private double value;
    private final double SUM_OF_ALL_PROBABILITIES_OF_COIN_TOSS_EVENT = 1;

    public Probability(double value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return that.value == this.value;
    }

    public Probability theProbabilityOfTwoEventsOccurringTogether(Probability probability){
        if(this != null && probability != null) {
            return new Probability(this.value * probability.value);
        }
        throw new NullPointerException("Null Value Found for Probability");
    }

    public Probability theProbabilityOfEventNotOccurring(){
        if(this != null) {
            return new Probability(SUM_OF_ALL_PROBABILITIES_OF_COIN_TOSS_EVENT - this.value);
        }
        throw new NullPointerException();
    }
    public Probability theProbabilityOfEitherTwoEventsOccurring(Probability probability){
        if(this != null && probability != null) {
            Probability probabilityOfTwoEventsOccurringTogether = this.theProbabilityOfTwoEventsOccurringTogether(probability);
            return new Probability(this.value + probability.value - (probabilityOfTwoEventsOccurringTogether.value));
        }
        throw new NullPointerException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
