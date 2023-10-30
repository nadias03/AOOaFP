package pl.pw.edu.mini.zpoif.task1.mafia;

import java.util.Random;

public abstract class MafiaOrganization {
    public static final int VALUE_OF_SINGLE_LEGAL_TRANSACTION = 15;
    static final Random random = new Random();

    public abstract void work();
}
