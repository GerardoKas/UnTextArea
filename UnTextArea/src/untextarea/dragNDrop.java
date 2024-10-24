
package untextarea;

import javax.swing.*;
import java.awt.datatransfer.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.*;
import java.util.List;

public class dragNDrop extends JFrame {

    private JTextArea textArea;

    public dragNDrop(JTextArea objText) {
        textArea=objText;
        
        textArea.setDragEnabled(true); // Habilita el arrastrar y soltar
        textArea.setDropTarget(new DropTarget(textArea, DnDConstants.ACTION_COPY, new DropTargetListener() {
            
            @Override
            public void dragEnter(DropTargetDragEvent dtde) {
            }

            @Override
            public void dragOver(DropTargetDragEvent dtde) {
            }

            @Override
            public void drop(DropTargetDropEvent dtde) {
                try {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    // Obtiene los datos del portapapeles
                    Transferable tr = dtde.getTransferable();
                    if (tr.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                        // Si es texto
                        String text = (String) tr.getTransferData(DataFlavor.stringFlavor);
                        textArea.append(text);
                    } else if (tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        // Si es un archivo
                        List<File> files = (List<File>) tr.getTransferData(DataFlavor.javaFileListFlavor);
                        for (File file : files) {
                            textArea.append(file.getAbsolutePath() + "\n");
                            // Aquí puedes procesar el archivo como desees
                        }
                    } else {
                        // Otros formatos (imágenes, etc.)
                        JOptionPane.showMessageDialog(null,"Ese formato no esta soportado");
                        //textArea.append("Formato no soportado.\n");
                    }
                    
                    dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    
                } catch (Exception e) {
                    System.out.println("ERROR EN "+e.getMessage());
                    System.out.println(e.toString());
                    //e.printStackTrace();
                }
            }

            // ... otros métodos de DropTargetListener
            @Override
            public void dropActionChanged(DropTargetDragEvent dtde) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void dragExit(DropTargetEvent dte) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }));

    }

}
