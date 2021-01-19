package me.atticuszambrana.discord.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Multi {

    public static final ExecutorService POOL = Executors.newCachedThreadPool();

    public static void runAsync(Runnable runnable) {
        POOL.execute(runnable);
    }

}
