package frontend;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aplicacao app = new Aplicacao();
        
        Homepage home = new Homepage(app);
        
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            Homepage gui = new Homepage(app);

            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.pack();
            gui.setVisible(true);
        }
    });
    }
    
}
