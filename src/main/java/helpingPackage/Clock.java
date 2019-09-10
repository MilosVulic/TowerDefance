package helpingPackage;

import org.lwjgl.Sys;

public class Clock {

    public static boolean paused = false;
    public static long lastFrame, totalTime;
    public static float delta = 0, multiplier = 1;
    
    // metoda koja vraca broj tikova u milisekundama
    public static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    // vracanje delta time
    public static float getDelta() {
        long time = getTime();
        int del = (int) (time - lastFrame);
        lastFrame = getTime();
        if (del * 0.001f > 0.05f) {
            return 0.05f;
        }
        return del * 0.001f;
    }

    public static float delta() {
        if (paused) {
            return 0;
        } else {
            return delta * multiplier;
        }
    }

    public static long getTotalTime() {
        return totalTime;
    }

    public static float getMultiplier() {
        return multiplier;
    }

    public static void update() {
        delta = getDelta();
        totalTime += delta;
    }

    // metoda za debugovanje nista posebno
    public static void changeMultiplier(double value) {
        if (multiplier + value < -1 || multiplier + value > 7) {
        } else {
            multiplier += value;
        }
    }

    // game state metoda 
    public static void pause() {
        paused = !paused;
    }
}
