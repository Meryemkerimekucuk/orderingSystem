
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 interface DataTransfer{
    List<Object[]> getData();
    void sendData(List<Object[]> data);
}
public class Woman extends javax.swing.JFrame implements DataTransfer {

    DefaultTableModel model;
    public Woman(){
        initComponents();
        model=(DefaultTableModel)tblWoman.getModel();
   
        
 try{
       
      
        ArrayList<Product>products =getProduct();
        for(Product product:products){
        Object[] row={
        product.getId(),product.getGender(),product.getCategory(),product.getProduct_name(),product.getSize(),product.getShoe_size(),product.getPrice()};
         model.addRow(row);
}
        }catch(SQLException ex){
            System.out.println(ex);
        }      
}

     public ArrayList<Product> getProduct() throws SQLException{
         Connection connection=null;
         Statement statement = null;
         DatabaseHelper databaseHelper=new DatabaseHelper();
         ResultSet resultSet;
         ArrayList<Product> products=null;
         try{
            connection=databaseHelper.getConnection();
            statement=connection.createStatement();
            String sql="Select*From products where Gender='Woman' ";
            resultSet=statement.executeQuery(sql);
            products=new ArrayList<Product>();
          
            
            while(resultSet.next()){
                products.add(new Product(
                resultSet.getInt("Id"),
                resultSet.getString("Gender"),
                resultSet.getString("Category"),
                resultSet.getString("Product_name"),
                resultSet.getString("Size"),
                resultSet.getInt("Shoe_size"),
                resultSet.getInt("Price")));
                
            }
            
         }catch(SQLException exception){
             databaseHelper.showErrorMessage(exception);
         }
         finally{
         try{
             if(statement!=null){
                 if(connection!=null){
                     statement.close();
                     connection.close();
                 }
             }
         }catch(SQLException exception){
             
         }
     }
         return products;
     }
     
     @Override
    public List<Object[]> getData() {
        int[] selectedRows = tblWoman.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) tblWoman.getModel();
        List<Object[]> selectedData = new ArrayList<>();

        for (int rowIndex : selectedRows) {
            Object[] rowData = new Object[model.getColumnCount()];
            for (int columnIndex = 0; columnIndex < model.getColumnCount(); columnIndex++) {
                rowData[columnIndex] = model.getValueAt(rowIndex, columnIndex);
            }
            selectedData.add(rowData);
        }
        return selectedData;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSelectProduct = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWoman = new javax.swing.JTable();
        btnBackW = new javax.swing.JButton();
        btnNextW = new javax.swing.JButton();
        btnAddW = new javax.swing.JButton();
        lblWomenProducts = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSelectProduct.setText("PLEASE SELECT A PRODUCT");
        getContentPane().add(lblSelectProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 240, 40));

        tblWoman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblWoman);
        if (tblWoman.getColumnModel().getColumnCount() > 0) {
            tblWoman.getColumnModel().getColumn(0).setResizable(false);
            tblWoman.getColumnModel().getColumn(1).setResizable(false);
            tblWoman.getColumnModel().getColumn(2).setResizable(false);
            tblWoman.getColumnModel().getColumn(3).setResizable(false);
            tblWoman.getColumnModel().getColumn(4).setResizable(false);
            tblWoman.getColumnModel().getColumn(5).setResizable(false);
            tblWoman.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 420, 170));

        btnBackW.setText("BACK");
        btnBackW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackWActionPerformed(evt);
            }
        });
        getContentPane().add(btnBackW, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 383, 90, 40));

        btnNextW.setText("NEXT");
        btnNextW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextWActionPerformed(evt);
            }
        });
        getContentPane().add(btnNextW, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 90, 40));

        btnAddW.setText("ADD TO CART");
        btnAddW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddW, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 203, 130, 40));

        lblWomenProducts.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblWomenProducts.setText("WOMAN'S PRODUCTS");
        getContentPane().add(lblWomenProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 280, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/9907-2_S_-600x600.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 600, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackWActionPerformed
        Gender gender=new Gender();
        gender.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackWActionPerformed

    private void btnNextWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextWActionPerformed
        
        ShoppingCart shoppingCart = new ShoppingCart();

       shoppingCart.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnNextWActionPerformed

    private void btnAddWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWActionPerformed

   List<Object[]> data = getData();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.sendData(data);
        shoppingCart.setVisible(true);
    }//GEN-LAST:event_btnAddWActionPerformed

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
            java.util.logging.Logger.getLogger(Woman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Woman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Woman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Woman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Woman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddW;
    private javax.swing.JButton btnBackW;
    private javax.swing.JButton btnNextW;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSelectProduct;
    private javax.swing.JLabel lblWomenProducts;
    private javax.swing.JTable tblWoman;
    // End of variables declaration//GEN-END:variables

    @Override
    public void sendData(List<Object[]> data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

}
