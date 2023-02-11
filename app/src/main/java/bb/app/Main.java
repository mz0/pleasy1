package bb.app;

import bb.core.PluginManager;

import javax.swing.*;
import java.awt.FlowLayout;
import java.lang.reflect.InvocationTargetException;

public class Main {
    private static void createAndShowGUI() {
        JFrame frm0 = new JFrame("HelloWorldSwing");
        frm0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JDialog dlg1 = new JDialog(frm0, "the owls are not what they seem", true);
        dlg1.setLayout(new FlowLayout());
        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(e -> onClick());
        dlg1.add(new JLabel("click there >"));
        dlg1.add(btnOK);
        dlg1.setSize(310, 155);
        dlg1.setVisible(true);
     // frm0.pack(); // TODO check if needed
     // frm0.setVisible(true);
    }

    private static void onClick() {
        System.out.println("Compatible IDs: " + getIDs(PluginManager.getInstance()));
        PluginManager.getInstance().getProtocolHandlerNames().entrySet()
            .forEach(kv -> System.out.printf("ProtocolId %s - Handler %s%n", kv.getKey(), kv.getValue()));
    }

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        PluginManager.init();
        javax.swing.SwingUtilities.invokeAndWait(Main::createAndShowGUI);
        System.exit(0);
    }

    private static String getIDs(PluginManager pm) {
        return String.join(", ", pm.getCompatibleIDs());
    }
}
