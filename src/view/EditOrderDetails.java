/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ItemController;
import controller.CustomerOrderDetailController;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Item;
import model.OrderDetail;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class EditOrderDetails extends javax.swing.JDialog {

    private CustomerOrderDetailController orderDetailController;
    private ItemController itemController;
    private ArrayList<Item> itemsList;
    private String[] itemsArray;
    private String orderID, itemCode;
    private int qty;
    private double discount;
    private boolean qtyFlag, discountFlag;

    /**
     * Creates new form AddOrderDetailsForm
     */
    public EditOrderDetails(java.awt.Frame parent, boolean modal, String orderID, String itemCode, int qty, double discount) {
        super(parent, modal);
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.qty = qty;
        this.discount = discount;

        initComponents();
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        setItemInfoPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        itemInfoPanel = new javax.swing.JPanel();
        availableQtyLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        unitPriceLabel = new javax.swing.JLabel();
        addingDetailsPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        qtyText = new javax.swing.JTextField();
        discountText = new javax.swing.JTextField();
        infoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Items");
        setResizable(false);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 150, 150), 1, true));

        itemInfoPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));

        availableQtyLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        availableQtyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        availableQtyLabel.setText("0");

        jLabel2.setText("Code");

        jLabel1.setText("Unit Price");

        jLabel7.setText("Available Qty");

        codeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codeLabel.setText(" ");

        discountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        discountLabel.setText("0");

        jLabel3.setText("Discount");

        unitPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        unitPriceLabel.setText("0");

        javax.swing.GroupLayout itemInfoPanelLayout = new javax.swing.GroupLayout(itemInfoPanel);
        itemInfoPanel.setLayout(itemInfoPanelLayout);
        itemInfoPanelLayout.setHorizontalGroup(
            itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(availableQtyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(unitPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(discountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        itemInfoPanelLayout.setVerticalGroup(
            itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemInfoPanelLayout.createSequentialGroup()
                        .addGroup(itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(unitPriceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(discountLabel)))
                    .addGroup(itemInfoPanelLayout.createSequentialGroup()
                        .addGroup(itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(codeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(itemInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(availableQtyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        addingDetailsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));

        jLabel5.setText("Qty");

        jLabel8.setText("Discount");

        qtyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyTextActionPerformed(evt);
            }
        });
        qtyText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyTextKeyTyped(evt);
            }
        });

        discountText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountTextActionPerformed(evt);
            }
        });
        discountText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                discountTextKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout addingDetailsPanelLayout = new javax.swing.GroupLayout(addingDetailsPanel);
        addingDetailsPanel.setLayout(addingDetailsPanelLayout);
        addingDetailsPanelLayout.setHorizontalGroup(
            addingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(24, 24, 24)
                .addComponent(qtyText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(discountText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        addingDetailsPanelLayout.setVerticalGroup(
            addingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addingDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(discountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addingDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addingDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        infoLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        infoLabel.setText(" ");
        infoLabel.setPreferredSize(new java.awt.Dimension(300, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qtyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyTextActionPerformed
        updateButton.requestFocus();
    }//GEN-LAST:event_qtyTextActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        OrderDetail orderDetail = setOrderDetail();
        if (!qtyFlag) {
            displayMessage("Enter a valid quantity");
            qtyText.requestFocus();
        } else if (!discountFlag) {
            displayMessage("Enter a valid discount value");
            discountText.requestFocus();
        } else {
            boolean updated = false;
            orderDetailController = new CustomerOrderDetailController();

            try {
                updated = orderDetailController.updateOrderDetail(orderDetail);
            } catch (SQLException ex) {
                Logger.getLogger(EditOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (updated) {
                setItem(itemCode, orderDetail.getQty());
                dispose();
            } else {
                displayMessage("Item was not updated");
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void qtyTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyTextKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_qtyTextKeyTyped

    private void discountTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountTextKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_PERIOD))) {
            evt.consume();
        }
    }//GEN-LAST:event_discountTextKeyTyped

    private void discountTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountTextActionPerformed
        updateButton.requestFocus();
    }//GEN-LAST:event_discountTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditOrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditOrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditOrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditOrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addingDetailsPanel;
    private javax.swing.JLabel availableQtyLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JTextField discountText;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel itemInfoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField qtyText;
    private javax.swing.JLabel unitPriceLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void setItemInfoPanel() {
        Item item = null;
        itemController = new ItemController();

        try {
            itemsList = itemController.searchItem(itemCode, "code");
            item = itemsList.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(EditOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        codeLabel.setText(itemCode);
        availableQtyLabel.setText(item.getQtyOnHand() + "");
        unitPriceLabel.setText(item.getUnitPrice() + "");
        discountLabel.setText(item.getDiscount() + "");

        qtyText.setText(qty + "");
        discountText.setText(discount + "");
    }

    private void displayMessage(String message) {
        final String msg = message;

        new Thread() {
            public void run() {
                infoLabel.setText("");
                try {
                    sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
                }

                infoLabel.setText(msg);
                try {
                    sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
                }
                infoLabel.setText("");
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
                }

                infoLabel.setText(msg);

                try {
                    sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CustomerOrder.class.getName()).log(Level.SEVERE, null, ex);
                }

                infoLabel.setText("");
            }
        }.start();
    }

    private OrderDetail setOrderDetail() {
        OrderDetail od;
        int qty = 0;
        double discount;

        if (!qtyText.getText().equals("")) {
            qty = Integer.parseInt(qtyText.getText());
            if (qty > 0 & qty < Integer.parseInt(availableQtyLabel.getText())) {
                qtyFlag = true;
            }
        }
        if (!discountText.getText().equals("")) {
            discount = Double.parseDouble(discountText.getText());
            if (discount < 99) {
                discountFlag = true;
            } else {
                discountFlag = false;
            }
        } else {
            discountFlag = true;
            discount = 0;
        }

        od = new OrderDetail(orderID, itemCode, qty, Double.parseDouble(unitPriceLabel.getText()), discount);

        return od;
    }

    private void setItem(String itemCode, int newQty) {
        Item oldItem = null, newItem = null;
        itemController = new ItemController();

        try {
            itemsList = itemController.searchItem(itemCode, "code");
            oldItem = itemsList.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(AddOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        int qtyVal = 0;
        if (qty > newQty) {
            qtyVal = oldItem.getQtyOnHand() + (qty - newQty);
        } else {
            qtyVal = oldItem.getQtyOnHand() - (newQty - qty);
        }
        newItem = new Item(itemCode, oldItem.getDescription(), oldItem.getUnitPrice(), oldItem.getDiscount(), qtyVal, oldItem.getAddedDate(), oldItem.getNotes());

        try {
            itemController.updateItem(newItem);
        } catch (SQLException ex) {
            Logger.getLogger(AddOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
