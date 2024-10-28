package src.util;

import src.model.Crystal;

public final class CrystalUtil {
    private CrystalUtil(){}

    public static Crystal getRandomCrystal(){
        int randomNumber = RandomUtil.getNext(2);
        return randomNumber == 0 ? Crystal.RED_CRYSTAL : Crystal.WHITE_CRYSTAL;
    }
}
