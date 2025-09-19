/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import bean.Lfs_jogos;
import dao.Lfs_jogosDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class JDlgJogos extends javax.swing.JDialog {

    /**
     * Creates new form JDlgUsuario
     */
    boolean incluir = false;
    boolean pesquisar = false;
    private MaskFormatter mascaraDataLancamento, mascaraDataAdicionado;

    public JDlgJogos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        habilitar(false);
        setTitle("Cadastro Jogos");

        try {
            mascaraDataLancamento = new MaskFormatter("##/##/####");
            mascaraDataAdicionado = new MaskFormatter("##/##/####");

            jFmtLfs_data_lancamento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataLancamento));
            jFmtLfs_data_adicionado.setFormatterFactory(new DefaultFormatterFactory(mascaraDataAdicionado));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void habilitar(boolean status) {
        jTxtIdlfs_Jogos.setEnabled(status);
        jTxtLfs_nome_jogo.setEnabled(status);
        jCboLfs_classificacao_indicativa.setEnabled(status);
        jCboLfs_genero.setEnabled(status);
        jTxtLfs_preco.setEnabled(status);
        jTxtLfs_descricao.setEnabled(status);
        jFmtLfs_data_lancamento.setEnabled(status);
        jTxtLfs_estoque.setEnabled(status);
        jCboLfs_idioma.setEnabled(status);
        jFmtLfs_data_adicionado.setEnabled(status);
        jTxtLfs_desenvolvedora.setEnabled(status);
        jTxtLfs_avaliacao_media.setEnabled(status);
        jTxtLfs_modo_de_jogo.setEnabled(status);
        jCboLfs_plataforma.setEnabled(status);
        jChbLfs_status_disponibilidade.setEnabled(status);

        jBtnIncluir.setEnabled(!status);
        jBtnAlterar.setEnabled(!status);
        jBtnExcluir.setEnabled(!status);
        jBtnPesquisar.setEnabled(!status);

        jBtnConfirmar.setEnabled(status);
        jBtnCancelar.setEnabled(status);
    }

    public void limpar() {
        jTxtIdlfs_Jogos.setText("");
        jTxtLfs_nome_jogo.setText("");
        jCboLfs_classificacao_indicativa.setSelectedIndex(-1);
        jCboLfs_genero.setSelectedIndex(-1);
        jTxtLfs_preco.setText("");
        jTxtLfs_descricao.setText("");
        jFmtLfs_data_lancamento.setText("");
        jTxtLfs_estoque.setText("");
        jCboLfs_idioma.setSelectedIndex(-1);
        jFmtLfs_data_adicionado.setText("");
        jTxtLfs_desenvolvedora.setText("");
        jTxtLfs_avaliacao_media.setText("");
        jTxtLfs_modo_de_jogo.setText("");
        jCboLfs_plataforma.setSelectedIndex(-1);
        jChbLfs_status_disponibilidade.setSelected(false);
    }

    public Lfs_jogos viewBean() {
        Lfs_jogos jogo = new Lfs_jogos();
        int cod = Integer.parseInt(jTxtIdlfs_Jogos.getText());
        jogo.setLfs_id_jogo(cod);
        jogo.setLfs_nome_jogo(jTxtLfs_nome_jogo.getText());
        jogo.setLfs_classificacao_indicativa(jCboLfs_classificacao_indicativa.getSelectedItem().toString());
        jogo.setLfs_genero(jCboLfs_genero.getSelectedItem().toString());
        jogo.setLfs_preco(Double.parseDouble(jTxtLfs_preco.getText()));
        jogo.setLfs_descricao(jTxtLfs_descricao.getText());

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            jogo.setLfs_data_lancamento(formato.parse(jFmtLfs_data_lancamento.getText()));
            jogo.setLfs_data_adicionado(formato.parse(jFmtLfs_data_adicionado.getText()));
        } catch (ParseException ex) {
            System.out.println("Erro na conversão da data.");
        }

        jogo.setLfs_estoque(Integer.parseInt(jTxtLfs_estoque.getText()));
        jogo.setLfs_idioma(jCboLfs_idioma.getSelectedItem().toString());
        jogo.setLfs_desenvolvedora(jTxtLfs_desenvolvedora.getText());
        jogo.setLfs_avaliacao_media(Double.parseDouble(jTxtLfs_avaliacao_media.getText()));
        jogo.setLfs_modo_de_jogo(jTxtLfs_modo_de_jogo.getText());
        jogo.setLfs_plataforma(jCboLfs_plataforma.getSelectedItem().toString());
        jogo.setLfs_status_disponibilidade(jChbLfs_status_disponibilidade.isSelected() ? "S" : "N");
        return jogo;

    }

    public void beanView(Lfs_jogos jogo) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataLancamento = formato.format(jogo.getLfs_data_lancamento());
        String dataAdicionado = formato.format(jogo.getLfs_data_adicionado());
                
        jTxtIdlfs_Jogos.setText(String.valueOf(jogo.getLfs_id_jogo()));
        jTxtLfs_nome_jogo.setText(jogo.getLfs_nome_jogo());
        jCboLfs_classificacao_indicativa.setSelectedItem(jogo.getLfs_classificacao_indicativa());
        jCboLfs_genero.setSelectedItem(jogo.getLfs_genero());
        jTxtLfs_preco.setText(String.valueOf(jogo.getLfs_preco()));
        jTxtLfs_descricao.setText(jogo.getLfs_descricao());
        jFmtLfs_data_lancamento.setText(dataLancamento);
        jTxtLfs_estoque.setText(String.valueOf(jogo.getLfs_estoque()));
        jCboLfs_idioma.setSelectedItem(jogo.getLfs_idioma());
        jFmtLfs_data_adicionado.setText(dataAdicionado);
        jTxtLfs_desenvolvedora.setText(jogo.getLfs_desenvolvedora());
        jTxtLfs_avaliacao_media.setText(String.valueOf(jogo.getLfs_avaliacao_media()));
        jTxtLfs_modo_de_jogo.setText(jogo.getLfs_modo_de_jogo());
        jCboLfs_plataforma.setSelectedItem(jogo.getLfs_plataforma());
        jChbLfs_status_disponibilidade.setSelected(jogo.getLfs_status_disponibilidade().equals("S"));
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
        jTxtIdlfs_Jogos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtLfs_nome_jogo = new javax.swing.JTextField();
        jCboLfs_classificacao_indicativa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCboLfs_genero = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtLfs_preco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtLfs_descricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jFmtLfs_data_lancamento = new javax.swing.JFormattedTextField();
        jTxtLfs_estoque = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCboLfs_idioma = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jFmtLfs_data_adicionado = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxtLfs_desenvolvedora = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTxtLfs_avaliacao_media = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTxtLfs_modo_de_jogo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jCboLfs_plataforma = new javax.swing.JComboBox<>();
        jChbLfs_status_disponibilidade = new javax.swing.JCheckBox();
        jBtnIncluir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        jTxtIdlfs_Jogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdlfs_JogosActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome do Jogo");

        jCboLfs_classificacao_indicativa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "18", "12", "8" }));
        jCboLfs_classificacao_indicativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboLfs_classificacao_indicativaActionPerformed(evt);
            }
        });

        jLabel3.setText("Classificacao Idade");

        jCboLfs_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aventura", "RPG", "Terror", "Sobrevivencia" }));

        jLabel4.setText("Genero");

        jLabel5.setText("Preco");

        jLabel6.setText("Descricao");

        jLabel7.setText("Data Lancamento");

        jLabel8.setText("Estoque");

        jLabel9.setText("Idioma");

        jCboLfs_idioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingles", "Portugues", "Espanhol" }));

        jLabel10.setText("Data Adicionado");

        jLabel11.setText("Desenvolvedora");

        jLabel12.setText("Avaliacao Media");

        jLabel13.setText("Modo de Jogo");

        jLabel14.setText("Plataforma");

        jCboLfs_plataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "PS4", "PS3", "PS2", "Xbox" }));

        jChbLfs_status_disponibilidade.setText("Disponibilidade");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir.setText("incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnConfirmar.setText("confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excluir.png"))); // NOI18N
        jBtnExcluir.setText("excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCboLfs_plataforma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTxtLfs_preco, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtIdlfs_Jogos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addComponent(jLabel5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFmtLfs_data_adicionado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(209, 209, 209))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTxtLfs_nome_jogo)
                                            .addGap(18, 18, 18)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(236, 236, 236)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCboLfs_classificacao_indicativa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jCboLfs_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTxtLfs_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jCboLfs_idioma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addGap(36, 36, 36)
                                                        .addComponent(jLabel9)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jTxtLfs_modo_de_jogo)))))
                            .addComponent(jChbLfs_status_disponibilidade)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTxtLfs_desenvolvedora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addComponent(jTxtLfs_descricao, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtLfs_data_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTxtLfs_avaliacao_media, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jBtnIncluir)
                        .addGap(30, 30, 30)
                        .addComponent(jBtnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnPesquisar)))
                .addContainerGap(40, Short.MAX_VALUE))
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
                    .addComponent(jTxtIdlfs_Jogos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLfs_nome_jogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboLfs_classificacao_indicativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboLfs_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtLfs_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLfs_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtLfs_data_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLfs_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboLfs_idioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtLfs_data_adicionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLfs_desenvolvedora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLfs_avaliacao_media, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLfs_modo_de_jogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboLfs_plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbLfs_status_disponibilidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnPesquisar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnIncluir))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtIdlfs_JogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIdlfs_JogosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIdlfs_JogosActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        incluir = true;
        habilitar(true);
        limpar();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        if (pesquisar == true) {
            incluir = false;
            habilitar(true);
            jTxtIdlfs_Jogos.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Necessário pesquisar antes");
        }
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if (pesquisar == true) {
            int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir?");
            if (resp == JOptionPane.YES_OPTION) {
                Lfs_jogos jogo = viewBean();
                Lfs_jogosDao jogosDao = new Lfs_jogosDao();
                jogosDao.delete(jogo);
            }
            limpar();
            habilitar(false);
        } else {
            JOptionPane.showMessageDialog(null, "Necessário pesquisar antes");
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        Lfs_jogos jogo = viewBean();
        Lfs_jogosDao jogosDao = new Lfs_jogosDao();

        if (incluir == true) {
            jogosDao.insert(jogo);
        } else {
            jogosDao.update(jogo);
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
        Lfs_jogosDao jogosDao = new Lfs_jogosDao();
        Lfs_jogos jogo = (Lfs_jogos) jogosDao.list(codigo);
        if (jogo == null) {
            JOptionPane.showMessageDialog(null, "Código não encontrado");
        } else {
            beanView(jogo);
        }*/
        JDlgJogosPesquisar jDlgJogosPesquisar = new JDlgJogosPesquisar(null, true);
        jDlgJogosPesquisar.setTelaPai(this);
        jDlgJogosPesquisar.setVisible(true);
        pesquisar = true;
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jCboLfs_classificacao_indicativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboLfs_classificacao_indicativaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboLfs_classificacao_indicativaActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgJogos dialog = new JDlgJogos(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jCboLfs_classificacao_indicativa;
    private javax.swing.JComboBox<String> jCboLfs_genero;
    private javax.swing.JComboBox<String> jCboLfs_idioma;
    private javax.swing.JComboBox<String> jCboLfs_plataforma;
    private javax.swing.JCheckBox jChbLfs_status_disponibilidade;
    private javax.swing.JFormattedTextField jFmtLfs_data_adicionado;
    private javax.swing.JFormattedTextField jFmtLfs_data_lancamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtIdlfs_Jogos;
    private javax.swing.JTextField jTxtLfs_avaliacao_media;
    private javax.swing.JTextField jTxtLfs_descricao;
    private javax.swing.JTextField jTxtLfs_desenvolvedora;
    private javax.swing.JTextField jTxtLfs_estoque;
    private javax.swing.JTextField jTxtLfs_modo_de_jogo;
    private javax.swing.JTextField jTxtLfs_nome_jogo;
    private javax.swing.JTextField jTxtLfs_preco;
    // End of variables declaration//GEN-END:variables
}
