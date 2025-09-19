/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import bean.Lfs_cliente;
import dao.Lfs_clienteDao;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class JDlgCliente extends javax.swing.JDialog {

    /**
     * Creates new form JDlgUsuario
     */
    boolean incluir = false;
    boolean pesquisar = false;
    private MaskFormatter mascaraCpf, mascaraDataNasc, mascaraDataUltimoLogin, mascaraDataCadastro, mascaraTelefone, mascaraRG;

    public JDlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        habilitar(false);
        setTitle("Cadastro Cliente");

        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraDataNasc = new MaskFormatter("##/##/####");
            mascaraDataUltimoLogin = new MaskFormatter("##/##/####");
            mascaraDataCadastro = new MaskFormatter("##/##/####");
            mascaraTelefone = new MaskFormatter("(##) #####-####");
            mascaraRG = new MaskFormatter("#.###.###");

            jFmtLfs_cpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
            jFmtLfs_dataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNasc));
            jFmtLfs_dataUltimoLogin.setFormatterFactory(new DefaultFormatterFactory(mascaraDataUltimoLogin));
            jFmtLfs_dataCadastro.setFormatterFactory(new DefaultFormatterFactory(mascaraDataCadastro));
            jFmtLfs_telefone.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
            jFmtLfs_RG.setFormatterFactory(new DefaultFormatterFactory(mascaraRG));
        } catch (ParseException ex) {
            System.getLogger(JDlgCliente.class.getName()).log(Level.ERROR, (String) null, ex);
        }
    }

    private void habilitar(boolean status) {
        jTxtIdlfs_Cliente.setEnabled(status);
        jTxtLfs_Nome_completo.setEnabled(status);
        jCboLfs_genero.setEnabled(status);
        jFmtLfs_cpf.setEnabled(status);
        jFmtLfs_dataNascimento.setEnabled(status);
        jPwdLfs_senha.setEnabled(status);
        jFmtLfs_RG.setEnabled(status);
        jTxtLfs_Cep.setEnabled(status);
        jTxtLfs_email.setEnabled(status);
        jFmtLfs_telefone.setEnabled(status);
        jCboLfs_forma_pagamento.setEnabled(status);
        jFmtLfs_dataUltimoLogin.setEnabled(status);
        jTxtLfs_preferencias.setEnabled(status);
        jTxtLfs_observacoes.setEnabled(status);
        jFmtLfs_dataCadastro.setEnabled(status);

        jBtnIncluir.setEnabled(!status);
        jBtnAlterar.setEnabled(!status);
        jBtnExcluir.setEnabled(!status);
        jBtnPesquisar.setEnabled(!status);

        jBtnConfirmar.setEnabled(status);
        jBtnCancelar.setEnabled(status);
    }

    public void limpar() {
        jTxtIdlfs_Cliente.setText("");
        jTxtLfs_Nome_completo.setText("");
        jCboLfs_genero.setSelectedIndex(-1);
        jFmtLfs_cpf.setText("");
        jFmtLfs_dataNascimento.setText("");
        jPwdLfs_senha.setText("");
        jFmtLfs_RG.setText("");
        jTxtLfs_Cep.setText("");
        jTxtLfs_email.setText("");
        jFmtLfs_telefone.setText("");
        jCboLfs_forma_pagamento.setSelectedIndex(-1);
        jFmtLfs_dataUltimoLogin.setText("");
        jTxtLfs_preferencias.setText("");
        jTxtLfs_observacoes.setText("");
        jFmtLfs_dataCadastro.setText("");
    }

    public Lfs_cliente viewBean() {

        Lfs_cliente cliente = new Lfs_cliente();
        int cod = Integer.parseInt(jTxtIdlfs_Cliente.getText());
        cliente.setIdlfs_Cliente(cod);
        cliente.setLfs_Nome_completo(jTxtLfs_Nome_completo.getText());
        cliente.setLfs_genero(jCboLfs_genero.getSelectedItem().toString());
        cliente.setLfs_cpf(jFmtLfs_cpf.getText());

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            cliente.setLfs_dataNascimento(formato.parse(jFmtLfs_dataNascimento.getText()));
            cliente.setLfs_dataUltimoLogin(formato.parse(jFmtLfs_dataUltimoLogin.getText()));
            cliente.setLfs_dataCadastro(formato.parse(jFmtLfs_dataCadastro.getText()));
        } catch (ParseException ex) {
            System.out.println("Erro na conversão da data.");
        }

        cliente.setLfs_senha(jPwdLfs_senha.getText());
        cliente.setLfs_RG(jFmtLfs_RG.getText());
        cliente.setLfs_Cep(jTxtLfs_Cep.getText());
        cliente.setLfs_email(jTxtLfs_email.getText());
        cliente.setLfs_telefone(jFmtLfs_telefone.getText());
        cliente.setLfs_forma_pagamento(jCboLfs_forma_pagamento.getSelectedItem().toString());
        cliente.setLfs_preferencias(jTxtLfs_preferencias.getText());
        cliente.setLfs_observacoes(jTxtLfs_observacoes.getText());

        return cliente;
    }

    public void beanView(Lfs_cliente cliente) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        jTxtIdlfs_Cliente.setText(String.valueOf(cliente.getIdlfs_Cliente()));
        jTxtLfs_Nome_completo.setText(cliente.getLfs_Nome_completo());
        jCboLfs_genero.setSelectedItem(cliente.getLfs_genero());
        jFmtLfs_cpf.setText(cliente.getLfs_cpf());

        String dataNasc = formato.format(cliente.getLfs_dataNascimento());
        jFmtLfs_dataNascimento.setText(dataNasc);

        jPwdLfs_senha.setText(cliente.getLfs_senha());
        jFmtLfs_RG.setText(cliente.getLfs_RG());
        jTxtLfs_Cep.setText(cliente.getLfs_Cep());
        jTxtLfs_email.setText(cliente.getLfs_email());
        jFmtLfs_telefone.setText(cliente.getLfs_telefone());
        jCboLfs_forma_pagamento.setSelectedItem(cliente.getLfs_forma_pagamento());
        
        String dataUltimoLogin = formato.format(cliente.getLfs_dataNascimento());
        jFmtLfs_dataUltimoLogin.setText(dataUltimoLogin);
        
        jTxtLfs_preferencias.setText(cliente.getLfs_preferencias());
        jTxtLfs_observacoes.setText(cliente.getLfs_observacoes());
        
        String dataCadastro = formato.format(cliente.getLfs_dataNascimento());
        jFmtLfs_dataCadastro.setText(dataCadastro);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtIdlfs_Cliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtLfs_Nome_completo = new javax.swing.JTextField();
        jCboLfs_genero = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFmtLfs_cpf = new javax.swing.JFormattedTextField();
        jFmtLfs_dataNascimento = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPwdLfs_senha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jFmtLfs_RG = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtLfs_Cep = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtLfs_email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jFmtLfs_telefone = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jCboLfs_forma_pagamento = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jFmtLfs_dataUltimoLogin = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jTxtLfs_preferencias = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTxtLfs_observacoes = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jFmtLfs_dataCadastro = new javax.swing.JFormattedTextField();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        jTxtIdlfs_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdlfs_ClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome Completo");

        jCboLfs_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Nao dizer" }));

        jLabel3.setText("Genero");

        jLabel4.setText("CPF");

        jLabel5.setText("Data de Nascimento");

        jLabel6.setText("Senha");

        jLabel7.setText("RG");

        jLabel8.setText("Cep");

        jLabel9.setText("Email");

        jLabel10.setText("Telefone");

        jLabel11.setText("Forma Pagamento");

        jCboLfs_forma_pagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartao", "Dinheiro", "Pix", "Cheque" }));

        jLabel12.setText("Data Ultimo Login");

        jLabel13.setText("Preferencias");

        jLabel14.setText("Observacoes");

        jTxtLfs_observacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtLfs_observacoesActionPerformed(evt);
            }
        });

        jLabel15.setText("Data Cadastro");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir.setText("incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excluir.png"))); // NOI18N
        jBtnExcluir.setText("excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnConfirmar.setText("confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnPesquisar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jTxtIdlfs_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(209, 209, 209))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTxtLfs_Nome_completo)
                                        .addGap(18, 18, 18))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jFmtLfs_dataNascimento, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jPwdLfs_senha)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jTxtLfs_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13)
                                            .addComponent(jTxtLfs_preferencias, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jFmtLfs_telefone)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel10)
                                            .addComponent(jTxtLfs_observacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCboLfs_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jFmtLfs_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11)
                                    .addComponent(jCboLfs_forma_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jFmtLfs_dataUltimoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTxtLfs_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFmtLfs_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel15)
                            .addComponent(jFmtLfs_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtIdlfs_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLfs_Nome_completo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboLfs_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtLfs_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtLfs_dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPwdLfs_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtLfs_RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLfs_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtLfs_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtLfs_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboLfs_forma_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtLfs_dataUltimoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtLfs_preferencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLfs_observacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtLfs_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtIdlfs_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIdlfs_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIdlfs_ClienteActionPerformed

    private void jTxtLfs_observacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtLfs_observacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtLfs_observacoesActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        incluir = true;
        habilitar(true);
        limpar();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        if (pesquisar == true) {
            incluir = false;
            habilitar(true);
            jTxtIdlfs_Cliente.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Necessário pesquisar antes");
        }
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if (pesquisar == true) {
            int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir?");
            if (resp == JOptionPane.YES_OPTION) {
                Lfs_cliente cliente = viewBean();
                Lfs_clienteDao clienteDao = new Lfs_clienteDao();
                clienteDao.delete(cliente);
            }
            limpar();
            habilitar(false);
        } else {
            JOptionPane.showMessageDialog(null, "Necessário pesquisar antes");
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        Lfs_cliente cliente = viewBean();
        Lfs_clienteDao clienteDao = new Lfs_clienteDao();

        if (incluir == true) {
            clienteDao.insert(cliente);
        } else {
            clienteDao.update(cliente);
        }

        pesquisar = false;
        incluir = false;

        habilitar(false);
        limpar();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        incluir = false;
        pesquisar = false;
        habilitar(false);
        limpar();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        /*String id = JOptionPane.showInputDialog(null, "Entre com o código");
        int codigo = Integer.parseInt(id);
        Lfs_clienteDao clienteDao = new Lfs_clienteDao();
        Lfs_cliente cliente = (Lfs_cliente) clienteDao.list(codigo);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Código não encontrado");
        } else {
            beanView(cliente);
        }*/

        JDlgClientePesquisar jDlgClientePesquisar = new JDlgClientePesquisar(null, true);
        jDlgClientePesquisar.setTelaPai(this);
        jDlgClientePesquisar.setVisible(true);

        pesquisar = true;
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCliente dialog = new JDlgCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboLfs_forma_pagamento;
    private javax.swing.JComboBox<String> jCboLfs_genero;
    private javax.swing.JFormattedTextField jFmtLfs_RG;
    private javax.swing.JFormattedTextField jFmtLfs_cpf;
    private javax.swing.JFormattedTextField jFmtLfs_dataCadastro;
    private javax.swing.JFormattedTextField jFmtLfs_dataNascimento;
    private javax.swing.JFormattedTextField jFmtLfs_dataUltimoLogin;
    private javax.swing.JFormattedTextField jFmtLfs_telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPwdLfs_senha;
    private javax.swing.JTextField jTxtIdlfs_Cliente;
    private javax.swing.JTextField jTxtLfs_Cep;
    private javax.swing.JTextField jTxtLfs_Nome_completo;
    private javax.swing.JTextField jTxtLfs_email;
    private javax.swing.JTextField jTxtLfs_observacoes;
    private javax.swing.JTextField jTxtLfs_preferencias;
    // End of variables declaration//GEN-END:variables
}
