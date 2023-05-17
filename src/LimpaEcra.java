package src;

import java.io.IOException;

public class LimpaEcra {
    private String osName = System.getProperty("os.name");

    public void clear_screen() throws IOException, InterruptedException {
        if (osName.contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else if (osName.contains("Linux"))
            new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
    }
}
