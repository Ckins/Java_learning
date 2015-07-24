import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class ImageViewer
{
     public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
           {
              public void run()
              {
                 JFrame frame = new ImageViewerFrame();
                 frame.setTitle("ImageViewer");
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setVisible(true);
              }
          });
     }
}

 /*
   * A frame with a label to show an image.
*/
class ImageViewerFrame extends JFrame
{
     private JLabel label;
     private JFileChooser chooser;
     private static final int DEFAULT_WIDTH = 300;
     private static final int DEFAULT_HEIGHT = 400;
      public ImageViewerFrame()
     {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        // use a label to display the images
        label = new JLabel();
        add(label);

        // set up the file chooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

       JMenuItem openItem = new JMenuItem("Open");
       menu.add(openItem);
       openItem.addActionListener(new ActionListener()
           {
              public void actionPerformed(ActionEvent event)
              {
                 // show file chooser dialog
                 int result = chooser.showOpenDialog(null);

                 // if file selected, set it as icon of the label
                 if (result == JFileChooser.APPROVE_OPTION)
                 {
                    String name = chooser.getSelectedFile().getPath();
                    label.setIcon(new ImageIcon(name));
                 }
              }
           });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener()
           {
              public void actionPerformed(ActionEvent event)
              {
                 System.exit(0);
              }
           });
     }
}

class CalculatorPanel extends JPanel
{
     private JButton display;
     private JPanel panel;
     private double result;
     private String lastCommand;
     private boolean start;

     public CalculatorPanel()
     {
        setLayout(new BorderLayout());
        result = 0;
        lastCommand = "=";
        start = true;
        // add the display
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        // add the buttons in a 4 x 4 grid
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
     }

     /*
      * Adds a button to the center panel.
      * @param label the button label
      * @param listener the button listener
      */
     private void addButton(String label, ActionListener listener)
     {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
     }
     /*
      * This action inserts the button action string to the end of the distext.
      */
     private class InsertAction implements ActionListener
     {
        public void actionPerformed(ActionEvent event)
        {
           String input = event.getActionCommand();
           if (start)
           {
              display.setText("");
              start = false;
           }
           display.setText(display.getText() + input);
        }
     }

     /*
      * This action executes the command that the button action string denotes.
      */
     private class CommandAction implements ActionListener
     {
        public void actionPerformed(ActionEvent event)
        {
           String command = event.getActionCommand();

           if (start)
           {
              if (command.equals("-"))
              {
                display.setText(command);
                start = false;
             }
             else lastCommand = command;
          }
          else
          {
             calculate(Double.parseDouble(display.getText()));
             lastCommand = command;
             start = true;
          }
       }
    }
    /*
     * Carries out the pending calculation.
     * @param x the value to be accumulated with the prior result.
     */
    public void calculate(double x)
    {
       if (lastCommand.equals("+")) result += x;
       else if (lastCommand.equals("-")) result -= x;
       else if (lastCommand.equals("*")) result *= x;
       else if (lastCommand.equals("/")) result /= x;
       else if (lastCommand.equals("=")) result = x;
       display.setText("" + result);
    }
}
