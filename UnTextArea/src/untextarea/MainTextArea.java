package untextarea;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

/**
 *
 * @author Gerardo.Castro.Mtz
 */
public class MainTextArea {

    private static final String rutaIcono = "./Pastero_MMXXIII.png";

    public static void main(String[] args) {
        MetodosLoadSave mls = new MetodosLoadSave();
        FramePrincipal frm = new FramePrincipal();
        JTextArea jta = frm.getTextArea();

        if (args.length > 0) {
            //JOptionPane.showConfirmDialog(null, args[0], "Para Abrir", 0, 0, ii);
            System.out.println(args);
            jta.setText(mls.leerArchivo(args[0]));
        }
        
        // TextAreaModelo tam=new TextAreaModelo();
        dragNDrop dd = new dragNDrop(jta);

        dd.toString();

        ImageIcon ii = new ImageIcon(rutaIcono);
        frm.setIconImage(ii.getImage());

        // Hacer que la ventana esté siempre en primer plano
        frm.setAlwaysOnTop(true);
        frm.setVisible(true);

    }

}
