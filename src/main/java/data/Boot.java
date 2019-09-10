package data;

import helpingPackage.Clock;
import static helpingPackage.StartingUtility.beginSession;
import org.lwjgl.opengl.Display;
import states.StateManager;

public class Boot {

    public Boot() {

        // poziv staticke metode iz starting utilitija da bi pozvali pocetne OpenGl metode
        beginSession();

        StateManager manager = new StateManager();
        
        // game loop
        while (!Display.isCloseRequested()) {
            Clock.update();
            manager.update();
            Display.update();
        }
        Display.destroy();
    }

    public static void main(String[] args) {
        new Boot();
    }
}
