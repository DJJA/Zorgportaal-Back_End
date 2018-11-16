package domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class HealthRatingSetInvalidRatingTest {
    @Parameterized.Parameters(name = "{index}: rating = {0}")
    public static Iterable<Integer> data() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            numbers.add(0 - i);
        }
        for (int i=0; i<10; i++) {
            numbers.add(11 + i);
        }
        return numbers;
    }

    private int input;

    public HealthRatingSetInvalidRatingTest(int input) {
        this.input = input;
    }

    @Test(expected = IllegalArgumentException.class)
    public void setRating() {
        HealthRating rating = new HealthRating();

        rating.setRating(input);
    }
}
