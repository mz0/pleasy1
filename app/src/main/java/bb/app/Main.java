/* a starter using https://www.vogella.com/tutorials/SWT/article.html */
package bb.app;

import bb.core.PluginManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {
    public static void main(String[] args) {
        PluginManager pm = new PluginManager();
        String btnText = "Click here";
        Display display = new Display();
        try {
          final Shell shell = new Shell(display);
          shell.setText("SWT app0");
          shell.setLayout(new FillLayout());
          Button button = new Button(shell, SWT.PUSH);
          button.setText(btnText);
          button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.out.println("Compatible IDs: " + getIDs(pm));
            }
          });
          shell.open();
          while (!shell.isDisposed())
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        } finally {
          display.dispose();
        }
    }

    private static String getIDs(PluginManager pm) {
        return String.join(", ", pm.getCompatibleIDs());
    }
}
