/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.vendas.swing;

import br.org.catolicasc.vendas.model.IProduto;
import br.org.catolicasc.vendas.model.Produto;
import br.org.catolicasc.vendas.model.UnidadePeso;
import br.org.catolicasc.vendas.service.ProdutoService;
import br.org.catolicasc.vendas.util.KeyValue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author fkannenberg
 */
public class ProdutoForm extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form ProdutoForm
     */
    public ProdutoForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnDesfazer = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnExportarExcel = new javax.swing.JButton();
        btnExportarPdf = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnAjuda = new javax.swing.JButton();
        pnlFormulario = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPeso = new javax.swing.JLabel();
        txtPeso = new javax.swing.JFormattedTextField();
        lblQuantidadeDisponivel = new javax.swing.JLabel();
        txtQuantidadeDisponivel = new javax.swing.JFormattedTextField();
        lblUnidadePeso = new javax.swing.JLabel();
        cmbUnidade = new javax.swing.JComboBox<String>();
        mnuArquivo = new javax.swing.JMenuBar();
        mniArquivo = new javax.swing.JMenu();
        mniNovo = new javax.swing.JMenuItem();
        mniSalvar = new javax.swing.JMenuItem();
        mniDesfazer = new javax.swing.JMenuItem();
        mniExcluir = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniSair = new javax.swing.JMenuItem();
        mniEditar = new javax.swing.JMenu();
        mniLocalizar = new javax.swing.JMenuItem();
        mniAjuda = new javax.swing.JMenu();
        mniSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de produto");
        setPreferredSize(new java.awt.Dimension(600, 450));
        setResizable(false);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(this);
        jToolBar1.add(btnNovo);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/disk.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("");
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(this);
        jToolBar1.add(btnSalvar);

        btnDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross.png"))); // NOI18N
        btnDesfazer.setText("Desfazer");
        btnDesfazer.setFocusable(false);
        btnDesfazer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesfazer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDesfazer.addActionListener(this);
        jToolBar1.add(btnDesfazer);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(this);
        jToolBar1.add(btnExcluir);
        jToolBar1.add(jSeparator1);

        btnExportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/page_white_excel.png"))); // NOI18N
        btnExportarExcel.setText("Excel");
        btnExportarExcel.setFocusable(false);
        btnExportarExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExportarExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnExportarExcel);

        btnExportarPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/page_white_acrobat.png"))); // NOI18N
        btnExportarPdf.setText("Relatório");
        btnExportarPdf.setFocusable(false);
        btnExportarPdf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExportarPdf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnExportarPdf);
        jToolBar1.add(jSeparator2);

        btnAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/help.png"))); // NOI18N
        btnAjuda.setText("Ajuda");
        btnAjuda.setFocusable(false);
        btnAjuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAjuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAjuda.addActionListener(this);
        jToolBar1.add(btnAjuda);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        java.awt.GridBagLayout pnlFormularioLayout = new java.awt.GridBagLayout();
        pnlFormularioLayout.columnWidths = new int[] {0, 5, 0, 5, 0};
        pnlFormularioLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        pnlFormulario.setLayout(pnlFormularioLayout);

        lblCodigo.setText("Codigo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(lblCodigo, gridBagConstraints);

        txtCodigo.setEnabled(false);
        txtCodigo.setPreferredSize(new java.awt.Dimension(70, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(txtCodigo, gridBagConstraints);

        lblNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(lblNome, gridBagConstraints);

        txtNome.setPreferredSize(new java.awt.Dimension(200, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(txtNome, gridBagConstraints);

        lblPeso.setText("Peso (kg):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(lblPeso, gridBagConstraints);

        txtPeso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(NumberFormat.getInstance())));
        txtPeso.setPreferredSize(new java.awt.Dimension(70, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(txtPeso, gridBagConstraints);

        lblQuantidadeDisponivel.setText("Quantidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(lblQuantidadeDisponivel, gridBagConstraints);

        txtQuantidadeDisponivel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(NumberFormat.getInstance())));
        txtQuantidadeDisponivel.setPreferredSize(new java.awt.Dimension(100, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(txtQuantidadeDisponivel, gridBagConstraints);

        lblUnidadePeso.setText("Unidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(lblUnidadePeso, gridBagConstraints);

        cmbUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUnidade.setPreferredSize(new java.awt.Dimension(64, 27));
        final DefaultComboBoxModel comboModel = ComboHelper.createModel(UnidadePeso.values());
        cmbUnidade.setModel(comboModel);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlFormulario.add(cmbUnidade, gridBagConstraints);

        getContentPane().add(pnlFormulario, java.awt.BorderLayout.CENTER);

        mniArquivo.setText("Arquivo");

        mniNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniNovo.setText("Novo");
        mniNovo.addActionListener(this);
        mniArquivo.add(mniNovo);

        mniSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniSalvar.setText("Salvar");
        mniSalvar.addActionListener(this);
        mniArquivo.add(mniSalvar);

        mniDesfazer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniDesfazer.setText("Desfazer");
        mniDesfazer.addActionListener(this);
        mniArquivo.add(mniDesfazer);

        mniExcluir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniExcluir.setText("Excluir");
        mniExcluir.addActionListener(this);
        mniArquivo.add(mniExcluir);
        mniArquivo.add(jSeparator3);

        mniSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniSair.setText("Sair");
        mniSair.addActionListener(this);
        mniArquivo.add(mniSair);

        mnuArquivo.add(mniArquivo);

        mniEditar.setText("Editar");

        mniLocalizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniLocalizar.setText("Localizar");
        mniLocalizar.addActionListener(this);
        mniEditar.add(mniLocalizar);

        mnuArquivo.add(mniEditar);

        mniAjuda.setText("Ajuda");
        mniSobre.addActionListener(this);

        mniSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniSobre.setText("Sobre");
        mniAjuda.add(mniSobre);

        mnuArquivo.add(mniAjuda);

        setJMenuBar(mnuArquivo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoForm form = new ProdutoForm();
                form.pack();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjuda;
    private javax.swing.JButton btnDesfazer;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.JButton btnExportarPdf;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbUnidade;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblQuantidadeDisponivel;
    private javax.swing.JLabel lblUnidadePeso;
    private javax.swing.JMenu mniAjuda;
    private javax.swing.JMenu mniArquivo;
    private javax.swing.JMenuItem mniDesfazer;
    private javax.swing.JMenu mniEditar;
    private javax.swing.JMenuItem mniExcluir;
    private javax.swing.JMenuItem mniLocalizar;
    private javax.swing.JMenuItem mniNovo;
    private javax.swing.JMenuItem mniSair;
    private javax.swing.JMenuItem mniSalvar;
    private javax.swing.JMenuItem mniSobre;
    private javax.swing.JMenuBar mnuArquivo;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPeso;
    private javax.swing.JFormattedTextField txtQuantidadeDisponivel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        switch (comando.toLowerCase()) {
            case "novo": {
                novo();
                break;
            }
            case "salvar": {
                salva();
                break;
            }
            case "excluir": {
                exclui();
                break;
            }
            case "desfazer": {
                cancela();
                break;
            }
            case "ajuda":
            case "sobre": {
                ajuda();
                break;
            }
            case "localizar": {
                localiza();
                break;
            }
            case "sair": {
                sai();
                break;
            }
            default:
                break;

        }
    }

    private void novo() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Criar um novo registro?", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            limpa();
        }
    }

    private void salva() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Salvar o registro?", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            IProduto produto = null;
            try {
                produto = getProduto();

                if (produto.getId() == 0) {
                    ProdutoService.getInstance().create(produto);
                } else {
                    ProdutoService.getInstance().update(produto);
                }

                txtCodigo.setText(produto.getId() + "");
                btnExcluir.setEnabled(true);
            } catch (Exception ex) {
                btnExcluir.setEnabled(false);
                showError("Erro ao salvar Produto.", ex);
            }
        }
    }

    private void cancela() {
        if (isCreate()) {
            limpa();
        } else {
            carrega();
        }
    }

    private void carrega() {
        try {
            int id = 0;

            if (!txtCodigo.getText().isEmpty()) {
                id = Integer.valueOf(txtCodigo.getText());
            }

            IProduto produto = ProdutoService.getInstance().findById(id);
            
            carrega(produto);

        } catch (Exception ex) {
            showError("Erro ao carregar Produto.", ex);
        }
    }

    private void limpa() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtPeso.setText("0");
        txtQuantidadeDisponivel.setText("0");
        cmbUnidade.setSelectedIndex(0);
        txtNome.requestFocus();
    }

    private void carrega(IProduto produto) {
        if (produto != null) {

            final NumberFormat numberFormatter = NumberFormat.getNumberInstance();

            txtCodigo.setText(produto.getId() + "");
            txtNome.setText(produto.getNome());
            txtQuantidadeDisponivel.setText(numberFormatter.format(produto.getQtdeDisponivel()));
            txtPeso.setText(numberFormatter.format(produto.getPeso()));
            cmbUnidade.setSelectedItem(new KeyValue(produto.getUnidadePeso().ordinal(), null));
            btnExcluir.setEnabled(true);
        }
    }

    private void exclui() {
        if (isCreate()) {
            showError("Nenhum produto selecionado.", null);
        } else {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {

                try {
                    int id = Integer.valueOf(txtCodigo.getText());
                    ProdutoService.getInstance().delete(getProduto());
                    limpa();
                } catch (Exception ex) {
                    btnExcluir.setEnabled(false);
                    showError("Erro ao excluir Produto.", ex);
                }
            }
        }
    }

    private void sai() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja sair da aplicação?", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION) {
            dispose();
        }

    }

    private void ajuda() {
        JOptionPane.showMessageDialog(null, "Sistema de Vendas.\nVersão: 0.1.0", "Ajuda!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void localiza() {
        final NumberFormat format = NumberFormat.getInstance();
        final NumberFormatter formatter = new NumberFormatter(format);

        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setCommitsOnValidEdit(true);

        JFormattedTextField field = new JFormattedTextField(formatter);

        Object[] fields = {"Código:", field};

        int resposta = JOptionPane.showConfirmDialog(null,
                fields,
                "Localizar",
                JOptionPane.OK_CANCEL_OPTION);

        if (resposta == JOptionPane.OK_OPTION) {
            String fieldValue = field.getText();
            if (fieldValue != null && !fieldValue.isEmpty()) {
                try {
                    int id = Integer.valueOf(fieldValue);
                    IProduto produto = ProdutoService.getInstance().findById(id);
                    if (produto == null) {
                        throw new IllegalArgumentException("Produto não encontrado.");
                    }
                    carrega(produto);
                } catch (Exception ex) {
                    showError("Erro na pesquisa de produto.", ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nenhum parâmetro foi informado.", "Informação", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private boolean isCreate() {
        return txtCodigo.getText().isEmpty();
    }

    private IProduto getProduto() {
        IProduto produto = null;

        try {
            int id = 0;

            if (!txtCodigo.getText().isEmpty()) {
                id = Integer.valueOf(txtCodigo.getText());
            }

            String nome = txtNome.getText();
            double peso = NumberFormat.getInstance().parse(txtPeso.getText()).doubleValue();
            double quantidade = NumberFormat.getInstance().parse(txtQuantidadeDisponivel.getText()).doubleValue();

            KeyValue unidadeItem = (KeyValue) cmbUnidade.getSelectedItem();
            UnidadePeso unidadePeso = UnidadePeso.valueOf(unidadeItem.getDescription());

            produto = new Produto(id, nome, peso, quantidade, unidadePeso);

        } catch (Exception ex) {
            showError("Erro ao criar Produto.", ex);
        }
        return produto;
    }

    private static void showError(String mensagem, Exception ex) {

        if (ex != null) {
            mensagem += "Error: " + ex.getMessage();
        }

        JOptionPane.showMessageDialog(null, mensagem, "Erro!", JOptionPane.ERROR_MESSAGE);
    }

}
