/* a starter using https://www.vogella.com/tutorials/SWT/article.html */
package bb.app;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class App {
    public static void main(String[] args) {
        String btnText = "Click here";
        char dq = '"';
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
                System.out.println(dq + btnText + dq + " pressed");
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
}
