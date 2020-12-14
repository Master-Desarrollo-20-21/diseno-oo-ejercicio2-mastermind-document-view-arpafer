package mastermind_documentview.views.console;

import mastermind_documentview.utils.GestorIO;

public class RenderDevice {

    private static RenderDevice renderDevice;
    private GestorIO console;

    public RenderDevice() {

    }

    public static RenderDevice getInstance() {
        if (renderDevice == null) {
            renderDevice = new RenderDevice();
            renderDevice.console = new GestorIO();
        }
        return renderDevice;
    }

    public void write(String message) {
        this.console.out(message);
    }

    public void writeln(String message) {
        this.console.out(message + "\n");
    }

    public String read() {
        return this.console.inString();
    }

    public String readRespond(String message) {
        this.console.out(message);
        return this.console.inString();
    }
}
