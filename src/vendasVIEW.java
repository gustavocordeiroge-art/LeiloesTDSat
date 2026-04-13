/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        listarVendidos();
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        listaVendas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Nome", "Valor", "Status" }
        ));
        jScrollPane1.setViewportView(listaVendas);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 18));
        jLabel1.setText("Produtos Vendidos");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new listagemVIEW().setVisible(true);
    }

    private void listarVendidos() {
        try {
            ProdutosDAO produtosdao = new ProdutosDAO();
            DefaultTableModel model = (DefaultTableModel) listaVendas.getModel();
            model.setNumRows(0);
            ArrayList<ProdutosDTO> vendidos = produtosdao.listarProdutosVendidos();
            for (int i = 0; i < vendidos.size(); i++) {
                model.addRow(new Object[]{
                    vendidos.get(i).getId(),
                    vendidos.get(i).getNome(),
                    vendidos.get(i).getValor(),
                    vendidos.get(i).getStatus()
                });
            }
        } catch (Exception e) {
        }
    }

    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaVendas;
}
