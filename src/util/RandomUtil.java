package src.util;

import java.util.Random;

public final class RandomUtil {
    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getNext(int lowerBound, int UpperBound) {
        return RANDOM.nextInt(lowerBound, UpperBound + 1);
    }

    public static int getNext(int bound){
        return RANDOM.nextInt(bound);
    }
}
