import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Meryem
 */
public class Man extends javax.swing.JFrame implements DataTransfer{

   DefaultTableModel defaultTableModel;
    public Man() {
        initComponents();
        defaultTableModel=(DefaultTableModel) tblMan.getModel();
        
        try{
            ArrayList<Product> products=getProduct();
            for(Product product:products){
            Object[] row={
            product.getId(),product.getGender(),product.getCategory(),product.getProduct_name(),product.getSize(),product.getShoe_size(),product.getPrice()};   
            
            defaultTableModel.addRow(row);
            }
                    }catch(SQLException exception){
                    exception.printStackTrace();
        }
        
    }

  public ArrayList<Product> getProduct() throws SQLException{
      Connection connection=null;
      Statement statement=null;
      DatabaseHelper databaseHelper=new DatabaseHelper();
      ResultSet resultset;
      ArrayList<Product> products=null;
      
      try{
      connection= databaseHelper.getConnection();
      statement= connection.createStatement();
      String sql="Select*from products where Gender='Man'";
      resultset=statement.executeQuery(sql);
      products=new ArrayList<Product>();
      
             while(resultset.next()){
                 products.add(new Product(
                 resultset.getInt("Id"),
                 resultset.getString("Gender"),
                 resultset.getString("Category"),
                 resultset.getString("Product_name"),
                 resultset.getString("Size"),
                 resultset.getInt("Shoe_size"),
                 resultset.getInt("Price")
                 ));
                 
             }
              }catch(SQLException exception){
                  databaseHelper.showErrorMessage(exception);
              }
      return products;
  }
    @Override
    public List<Object[]> getData() {
        int[] selectedRows = tblMan.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tblMan.getModel();
        List<Object[]> selectedData = new ArrayList<>();

        for (int rowIndex : selectedRows) {
            Object[] rowData = new Object[defaultTableModel.getColumnCount()];
            for (int columnIndex = 0; columnIndex < defaultTableModel.getColumnCount(); columnIndex++) {
                rowData[columnIndex] = defaultTableModel.getValueAt(rowIndex, columnIndex);
            }
            selectedData.add(rowData);
        }
        return selectedData;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSelectproduct = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMan = new javax.swing.JTable();
        btnBackM = new javax.swing.JButton();
        btnNextM = new javax.swing.JButton();
        btnAddtoCartM = new javax.swing.JButton();
        lblManProduct = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSelectproduct.setText("PLEASE SELECT A PRODUCT");
        getContentPane().add(lblSelectproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, 40));

        tblMan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Gender", "Category", "Product_name", "Size", "Shoe_size", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMan);
        if (tblMan.getColumnModel().getColumnCount() > 0) {
            tblMan.getColumnModel().getColumn(0).setResizable(false);
            tblMan.getColumnModel().getColumn(1).setResizable(false);
            tblMan.getColumnModel().getColumn(2).setResizable(false);
            tblMan.getColumnModel().getColumn(3).setResizable(false);
            tblMan.getColumnModel().getColumn(4).setResizable(false);
            tblMan.getColumnModel().getColumn(5).setResizable(false);
            tblMan.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 420, 150));

        btnBackM.setText("BACK");
        btnBackM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackMActionPerformed(evt);
            }
        });
        getContentPane().add(btnBackM, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 303, 90, 40));

        btnNextM.setText("NEXT");
        btnNextM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextMActionPerformed(evt);
            }
        });
        getContentPane().add(btnNextM, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 303, 100, 40));

        btnAddtoCartM.setText("ADD TO CART ");
        btnAddtoCartM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtoCartMActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddtoCartM, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 163, -1, 40));

        lblManProduct.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblManProduct.setText("MAN'S PRODUCTS");
        getContentPane().add(lblManProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 180, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/9907-2_S_-600x600.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackMActionPerformed
       Gender gender = new Gender();
       gender.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnBackMActionPerformed

    private void btnNextMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextMActionPerformed
       ShoppingCart shoppingCart = new ShoppingCart();
       shoppingCart.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnNextMActionPerformed

    private void btnAddtoCartMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtoCartMActionPerformed
List<Object[]> data = getData();
 ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.sendData(data);
        shoppingCart.setVisible(true);
    }//GEN-LAST:event_btnAddtoCartMActionPerformed

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
            java.util.logging.Logger.getLogger(Man.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Man.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Man.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Man.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Man().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddtoCartM;
    private javax.swing.JButton btnBackM;
    private javax.swing.JButton btnNextM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblManProduct;
    private javax.swing.JLabel lblSelectproduct;
    private javax.swing.JTable tblMan;
    // End of variables declaration//GEN-END:variables


    @Override
    public void sendData(List<Object[]> data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

   
}
