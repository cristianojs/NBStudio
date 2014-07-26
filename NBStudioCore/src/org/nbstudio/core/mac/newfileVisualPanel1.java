/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.nbstudio.cachefilesystem.CacheFileObject;
import org.nbstudio.core.CacheProject;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.openide.WizardDescriptor;

public final class newfileVisualPanel1 extends JPanel {

    private CacheProject project;
    private final newfileWizardPanel1 panel;

    /**
     * Creates new form newfileVisualPanel1
     */
    public newfileVisualPanel1(newfileWizardPanel1 panel) {
        initComponents();
        this.panel = panel;

        tRoutineName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                routineNameChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                routineNameChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                routineNameChanged();
            }
        });
    }

    @Override
    public String getName() {
        return "Routine Name";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tRoutineName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tRoutineDesc = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        lRoutineNameError = new javax.swing.JLabel();

        tRoutineName.setText(org.openide.util.NbBundle.getMessage(newfileVisualPanel1.class, "newfileVisualPanel1.tRoutineName.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(newfileVisualPanel1.class, "newfileVisualPanel1.jLabel1.text")); // NOI18N

        tRoutineDesc.setColumns(20);
        tRoutineDesc.setRows(5);
        jScrollPane1.setViewportView(tRoutineDesc);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(newfileVisualPanel1.class, "newfileVisualPanel1.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lRoutineNameError, org.openide.util.NbBundle.getMessage(newfileVisualPanel1.class, "newfileVisualPanel1.lRoutineNameError.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lRoutineNameError)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tRoutineName))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tRoutineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lRoutineNameError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lRoutineNameError;
    private javax.swing.JTextArea tRoutineDesc;
    private javax.swing.JTextField tRoutineName;
    // End of variables declaration//GEN-END:variables

    private void routineNameChanged() {
        panel.fireChangeEvent();
    }

    void read(WizardDescriptor settings) {
        project = (CacheProject) Templates.getProject(settings);
        CacheFileObject dir = (CacheFileObject) project.getProjectDirectory();
    }

    public boolean validateDialog() {
        clearMessage();
        String rtnName = getRoutineName();
        if (!rtnName.isEmpty()) {
//            try {
//                FileSystem fs = project.getProjectDirectory().getFileSystem();
//                Database db = project.getConnection().getAssociatedConnection();
//                if (RoutineMgr.Exists(db, rtnName + ".mac")) {
//                    setMessage("Please enter the valid name");
//                    return false;
//                }
//                return true;
//            } catch (CacheException ex) {
//            }
            return true;
        }
        setMessage("Please enter the valid name");
        return false;
    }
    
    private void setMessage(String message)
    {
        lRoutineNameError.setForeground(Color.red);
        lRoutineNameError.setText(message);
    }
    
    private void clearMessage()
    {
        lRoutineNameError.setText("");
    }

    public String getRoutineName() {
        return tRoutineName.getText();
    }

    public String getRoutineDesc() {
        return tRoutineDesc.getText();
    }
}