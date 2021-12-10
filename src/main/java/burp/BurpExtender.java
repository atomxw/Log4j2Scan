package burp;

import burp.scanner.Log4j2Scanner;

import java.awt.*;
import java.io.PrintWriter;

public class BurpExtender implements IBurpExtender, ITab {

    public IExtensionHelpers helpers;
    public IBurpExtenderCallbacks callbacks;
    public PrintWriter stdout;
    public PrintWriter stderr;
    public String version = "0.1";

    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        this.stderr = new PrintWriter(callbacks.getStderr(), true);
        callbacks.registerScannerCheck(new Log4j2Scanner(this));
        callbacks.setExtensionName("Log4j2Scan v" + version);

        stdout.println("Log4j2Scan loaded successfully!\r\n");
    }

    @Override
    public String getTabCaption() {
        return null;
    }

    @Override
    public Component getUiComponent() {
        return null;
    }
}
