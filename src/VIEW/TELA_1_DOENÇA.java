package VIEW; // Pacote View

import DAO.ConexãoDAO; // Importação da Classe ConexãoDAO
import java.sql.Connection;
import java.util.Vector; // Importação da Biblioteca Utill - Vetor
import java.sql.PreparedStatement; // Importação PreparedStatement 
import java.sql.SQLException; // Importação SQLException
import java.sql.ResultSet; // Importação ResultSet
import java.sql.ResultSetMetaData; // Importação ResultSetMetaData
import javax.swing.JOptionPane; // Importação Biblioteca Swing - JOptionPane
import javax.swing.JFrame; // Importação Biblioteca Swing - JFrame
import javax.swing.table.DefaultTableModel; // Importação Biblioteca Swing - Tabela

// Classe com Herança de JFRAME
public class TELA_1_DOENÇA extends javax.swing.JFrame {

// Metódo Construtor
    public TELA_1_DOENÇA() {
        initComponents();
        CarregaId(); // Metódo de Atualizar ID conforme banco de dados 
        TabelaAtualiza(); // Metódo de Atualizar tabela conforme banco de dados
        txtId.setVisible(false);
    }

    // Variáveis globais
    PreparedStatement pst; // Variável  do tipo PreparedStatement
    ResultSet rs; // Variável do tipo ResultSet
    ResultSetMetaData rss; // Variável  do tipo ResultSetMetaData

    // Instância Classe ConexãoDAO
    ConexãoDAO c = new ConexãoDAO();

    // Metódo sem retorno para Atualizar ID conforme Preenchimento dos Dados
    private void CarregaId() {

        // Tratamento de exceções
        try {
            pst = c.conectaBD().prepareStatement("select idDoenca from doenca"); // Consulta SQL parametrizada para o banco de dados após conexão com o banco de dados
            rs = pst.executeQuery(); // O rs contém os dados retornados pela consulta.

            while (rs.next()) { // Altera sobre cada linha do ResultSet usando um laço while
                txtId.addItem(rs.getString(1)); // Preenche o componente com os IDs das doenças obtidos do banco de dados

            }

        } catch (SQLException erro) { // Captura qualquer exceção do tipo SQLException
            JOptionPane.showMessageDialog(null, "Carrega ID : Erro!" + erro); // Mensagem de erro
        }

    }

    // Metódo sem retorno para Atualizar Tabela conforme Preenchimento dos Dados
    private void TabelaAtualiza() {
        int cc;// Criação de uma variável do tipo inteiro 

        // Tratamento de exceções
        try {

            // Obtêm os dados que o usuário digitou e atribui as variáveis respectivas 
            String xDoença = txtDoenca.getText();
            String xSintomas = txtSintomas.getText();
            String xCausa = txtCausa.getText();
            String xPrevencao = txtPrevencao.getText();
            String xTratamento = txtTratamento.getText();
            String xDiagnostico = txtDiagnostico.getText();
            String xData = txtData.getSelectedText();

            pst = c.conectaBD().prepareStatement("select * from doenca"); // Prepara uma consulta SQL para selecionar todos os registros da tabela após conectar com o banco de dados
            rs = pst.executeQuery(); // O rs contém os dados retornados pela consulta.
            rss = rs.getMetaData(); // O rss(ResultSetMetaData) obtém as informações sobre os metadados do ResultSet(rs)
            cc = rss.getColumnCount(); //  A quantidade de colunas na tabela é obtida e armazenada na variável cc.

            DefaultTableModel TB = (DefaultTableModel) jTabela.getModel(); // Obtém o modelo da tabela criada
            TB.setRowCount(0); // Define o número de linhas da tabela como zero

            // Percorre todas as linhas disponíveis no ResultSet (rs)
            while (rs.next()) {

                Vector v = new Vector(); // Irá Armazenar os valores das colunas de uma linha da tabela.

                // Inicia um laço for que percorre todas as colunas (cc) da tabela.
                // Cada valor das colunas é obtido do ResultSet (rs) usando o método getString() e adicionado ao objeto Vector v.
                for (int a = 1; a <= cc; a++) {
                    v.add(rs.getString("idDoenca"));
                    v.add(rs.getString("nomeDoenca"));
                    v.add(rs.getString("sintomaDoenca"));
                    v.add(rs.getString("causaDoenca"));
                    v.add(rs.getString("prevencaoDoenca"));
                    v.add(rs.getString("tratamentoDoenca"));
                    v.add(rs.getString("diagnosticoDoenca"));
                    v.add(rs.getString("anoDoenca"));
                }

                TB.addRow(v); // O vetor é adicionado como uma nova linha ao modelo da tabela

            }

            // Limpa campos
            txtDoenca.setText("");
            txtSintomas.setText("");
            txtCausa.setText("");
            txtPrevencao.setText("");
            txtTratamento.setText("");
            txtDiagnostico.setText("");
            txtData.setText("");
            txtDoenca.requestFocus(); //  Foco de entrada

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TabelaAtualiza : " + erro); // Mensagem de erro
        }

    }

    // Interface Gráfica
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        lblDoenca0 = new javax.swing.JLabel();
        lblDoenca1 = new javax.swing.JLabel();
        lblAtualizacao = new javax.swing.JLabel();
        lblCausa = new javax.swing.JLabel();
        lblSintomas = new javax.swing.JLabel();
        lblPrevencao = new javax.swing.JLabel();
        lblTratamento = new javax.swing.JLabel();
        lblDiagnostico = new javax.swing.JLabel();
        txtDoenca = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        txtCausa = new javax.swing.JTextField();
        txtSintomas = new javax.swing.JTextField();
        txtPrevencao = new javax.swing.JTextField();
        txtTratamento = new javax.swing.JTextField();
        txtDiagnostico = new javax.swing.JTextField();
        txtId = new javax.swing.JComboBox<>();
        btnCidade = new javax.swing.JButton();
        btnINSERIR = new javax.swing.JButton();
        btnALTERAR = new javax.swing.JButton();
        btnLIMPAR = new javax.swing.JButton();
        btnCOMPARACOES = new javax.swing.JButton();
        btnSAIR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        PAINEL_BARRA_VERDE_INFERIOR = new javax.swing.JPanel();
        PAINEL_BARRA_PRETA_INFERIOR = new javax.swing.JPanel();
        lblSuporte = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        lblUNIP = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(10, 10));
        setSize(new java.awt.Dimension(10, 10));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblDoenca0.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        lblDoenca0.setForeground(new java.awt.Color(147, 170, 97));
        lblDoenca0.setText("Doença");

        lblDoenca1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblDoenca1.setForeground(new java.awt.Color(102, 102, 102));
        lblDoenca1.setText("DOENÇA");

        lblAtualizacao.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblAtualizacao.setForeground(new java.awt.Color(102, 102, 102));
        lblAtualizacao.setText("ATUALIZAÇÃO");

        lblCausa.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblCausa.setForeground(new java.awt.Color(102, 102, 102));
        lblCausa.setText("CAUSA");

        lblSintomas.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblSintomas.setForeground(new java.awt.Color(102, 102, 102));
        lblSintomas.setText("SINTOMAS");

        lblPrevencao.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblPrevencao.setForeground(new java.awt.Color(102, 102, 102));
        lblPrevencao.setText("PREVENCÃO");

        lblTratamento.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblTratamento.setForeground(new java.awt.Color(102, 102, 102));
        lblTratamento.setText("TRATAMENTO");

        lblDiagnostico.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblDiagnostico.setForeground(new java.awt.Color(102, 102, 102));
        lblDiagnostico.setText("DIAGNÓSTICO");

        txtDoenca.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtDoenca.setForeground(new java.awt.Color(0, 0, 0));
        txtDoenca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 170, 97), 2, true));
        txtDoenca.setCaretColor(new java.awt.Color(149, 170, 97));
        txtDoenca.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtDoenca.setSelectionColor(new java.awt.Color(147, 170, 97));
        txtDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoencaActionPerformed(evt);
            }
        });

        txtData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 170, 97), 2, true));
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtData.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtData.setSelectionColor(new java.awt.Color(149, 170, 97));

        txtCausa.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtCausa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(147, 170, 97), 2, true));
        txtCausa.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtCausa.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtSintomas.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtSintomas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 170, 97), 2, true));
        txtSintomas.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtSintomas.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtPrevencao.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtPrevencao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 170, 97), 2, true));
        txtPrevencao.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtPrevencao.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtTratamento.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtTratamento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 170, 97), 2, true));
        txtTratamento.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtTratamento.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtDiagnostico.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtDiagnostico.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 170, 97), 2, true));
        txtDiagnostico.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtDiagnostico.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtId.setEnabled(false);
        txtId.setFocusable(false);

        btnCidade.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        btnCidade.setForeground(new java.awt.Color(0, 0, 0));
        btnCidade.setText("Cidades");
        btnCidade.setBorder(null);
        btnCidade.setContentAreaFilled(false);
        btnCidade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCidade.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCidade.setPreferredSize(new java.awt.Dimension(86, 28));
        btnCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCidadeActionPerformed(evt);
            }
        });

        btnINSERIR.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnINSERIR.setForeground(new java.awt.Color(60, 63, 65));
        btnINSERIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/ADD_92.png"))); // NOI18N
        btnINSERIR.setBorder(null);
        btnINSERIR.setContentAreaFilled(false);
        btnINSERIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINSERIRActionPerformed(evt);
            }
        });

        btnALTERAR.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnALTERAR.setForeground(new java.awt.Color(60, 63, 65));
        btnALTERAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/EDIT_92.png"))); // NOI18N
        btnALTERAR.setBorder(null);
        btnALTERAR.setContentAreaFilled(false);
        btnALTERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERARActionPerformed(evt);
            }
        });

        btnLIMPAR.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnLIMPAR.setForeground(new java.awt.Color(60, 63, 65));
        btnLIMPAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/LIMPAR_92.png"))); // NOI18N
        btnLIMPAR.setBorder(null);
        btnLIMPAR.setContentAreaFilled(false);
        btnLIMPAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIMPARActionPerformed(evt);
            }
        });

        btnCOMPARACOES.setBackground(new java.awt.Color(255, 255, 255));
        btnCOMPARACOES.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        btnCOMPARACOES.setForeground(new java.awt.Color(0, 0, 0));
        btnCOMPARACOES.setText("Relatórios");
        btnCOMPARACOES.setBorder(null);
        btnCOMPARACOES.setContentAreaFilled(false);
        btnCOMPARACOES.setPreferredSize(new java.awt.Dimension(157, 26));
        btnCOMPARACOES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOMPARACOESActionPerformed(evt);
            }
        });

        btnSAIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/SAIR_92.png"))); // NOI18N
        btnSAIR.setBorder(null);
        btnSAIR.setContentAreaFilled(false);
        btnSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAIRActionPerformed(evt);
            }
        });

        jTabela.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTabela.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DOENÇA", "SINTOMA", "CAUSA", "PREVENÇÃO", "TRATAMENTO", "DIAGNÓSTICO", "ANO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTabela.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabela.setGridColor(new java.awt.Color(0, 0, 0));
        jTabela.setMaximumSize(new java.awt.Dimension(1000, 30));
        jTabela.setMinimumSize(new java.awt.Dimension(500, 30));
        jTabela.setPreferredSize(new java.awt.Dimension(800, 100));
        jTabela.setRowHeight(60);
        jTabela.setRowMargin(10);
        jTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabela);
        if (jTabela.getColumnModel().getColumnCount() > 0) {
            jTabela.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTabela.getColumnModel().getColumn(0).setMaxWidth(20);
            jTabela.getColumnModel().getColumn(1).setMinWidth(2);
            jTabela.getColumnModel().getColumn(1).setPreferredWidth(2);
            jTabela.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTabela.getColumnModel().getColumn(2).setMaxWidth(100);
            jTabela.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTabela.getColumnModel().getColumn(5).setMaxWidth(100);
            jTabela.getColumnModel().getColumn(7).setPreferredWidth(120);
            jTabela.getColumnModel().getColumn(7).setMaxWidth(120);
        }

        PAINEL_BARRA_VERDE_INFERIOR.setBackground(new java.awt.Color(149, 170, 97));
        PAINEL_BARRA_VERDE_INFERIOR.setForeground(new java.awt.Color(0, 0, 0));
        PAINEL_BARRA_VERDE_INFERIOR.setPreferredSize(new java.awt.Dimension(1150, 94));

        PAINEL_BARRA_PRETA_INFERIOR.setBackground(new java.awt.Color(0, 0, 0));
        PAINEL_BARRA_PRETA_INFERIOR.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        PAINEL_BARRA_PRETA_INFERIOR.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout PAINEL_BARRA_PRETA_INFERIORLayout = new javax.swing.GroupLayout(PAINEL_BARRA_PRETA_INFERIOR);
        PAINEL_BARRA_PRETA_INFERIOR.setLayout(PAINEL_BARRA_PRETA_INFERIORLayout);
        PAINEL_BARRA_PRETA_INFERIORLayout.setHorizontalGroup(
            PAINEL_BARRA_PRETA_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PAINEL_BARRA_PRETA_INFERIORLayout.setVerticalGroup(
            PAINEL_BARRA_PRETA_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        lblSuporte.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblSuporte.setForeground(new java.awt.Color(246, 248, 238));
        lblSuporte.setText("SUPORTE");

        lblEmail.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(246, 248, 238));
        lblEmail.setText("jonathansantos4978@gmail.com");

        lblSemestre.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblSemestre.setForeground(new java.awt.Color(246, 248, 238));
        lblSemestre.setText("3º SEMESTRE");

        lblUNIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/UNIP.png"))); // NOI18N
        lblUNIP.setBorder(null);
        lblUNIP.setBorderPainted(false);
        lblUNIP.setContentAreaFilled(false);

        javax.swing.GroupLayout PAINEL_BARRA_VERDE_INFERIORLayout = new javax.swing.GroupLayout(PAINEL_BARRA_VERDE_INFERIOR);
        PAINEL_BARRA_VERDE_INFERIOR.setLayout(PAINEL_BARRA_VERDE_INFERIORLayout);
        PAINEL_BARRA_VERDE_INFERIORLayout.setHorizontalGroup(
            PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PAINEL_BARRA_PRETA_INFERIOR, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
            .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(lblSuporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSemestre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        PAINEL_BARRA_VERDE_INFERIORLayout.setVerticalGroup(
            PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                .addComponent(PAINEL_BARRA_PRETA_INFERIOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                                .addComponent(lblSuporte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEmail))
                            .addComponent(lblUNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblSemestre)))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(txtCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(txtSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(txtPrevencao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(lblDoenca1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(lblAtualizacao))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(632, 632, 632)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDoenca0, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(btnCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(btnCOMPARACOES, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(lblCausa)
                        .addGap(165, 165, 165)
                        .addComponent(lblSintomas)
                        .addGap(110, 110, 110)
                        .addComponent(lblPrevencao)))
                .addContainerGap(275, Short.MAX_VALUE))
            .addComponent(PAINEL_BARRA_VERDE_INFERIOR, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSAIR))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnINSERIR, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(btnALTERAR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(btnLIMPAR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(111, 111, 111)
                                    .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(lblTratamento)
                                    .addGap(151, 151, 151)
                                    .addComponent(lblDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(350, 350, 350))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSAIR)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCOMPARACOES, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDoenca0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDoenca1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAtualizacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCausa)
                    .addComponent(lblSintomas)
                    .addComponent(lblPrevencao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(txtSintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
                        .addComponent(txtCausa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
                    .addComponent(txtPrevencao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTratamento)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDiagnostico)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTratamento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnINSERIR)
                    .addComponent(btnALTERAR)
                    .addComponent(btnLIMPAR))
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(PAINEL_BARRA_VERDE_INFERIOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Eventos
    // Evento de clique do mouse na tabela e Carrega Campos
    private void jTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMouseClicked
        DefaultTableModel TB = (DefaultTableModel) jTabela.getModel(); // Acesso e manipulação dos dados da tabela

        int selectedIndex = jTabela.getSelectedRow(); // Obtém o índice da linha selecionada na tabela jTabela e armazena o valor na variável selectedIndex

        //Obtêm os valores das células da linha selecionada na tabela e atribui a cada componente respectivo
        txtDoenca.setText(TB.getValueAt(selectedIndex, 1).toString());
        txtSintomas.setText(TB.getValueAt(selectedIndex, 2).toString());
        txtCausa.setText(TB.getValueAt(selectedIndex, 3).toString());
        txtPrevencao.setText(TB.getValueAt(selectedIndex, 4).toString());
        txtTratamento.setText(TB.getValueAt(selectedIndex, 5).toString());
        txtDiagnostico.setText(TB.getValueAt(selectedIndex, 6).toString());
        txtData.setText(TB.getValueAt(selectedIndex, 7).toString());


    }//GEN-LAST:event_jTabelaMouseClicked

    // Evento ao clicar no btnCIDADE 
    private void btnCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCidadeActionPerformed
        TELA_2_CIDADE c = new TELA_2_CIDADE(); // Instância da classe TELA_2_CIDADE
        this.dispose(); // Fecha janela atual 
        c.setVisible(true); // Exibe a TELA_2_CIDADE
    }//GEN-LAST:event_btnCidadeActionPerformed

    // Evento ao clicar no btnLIMPAR 
    private void btnLIMPARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIMPARActionPerformed
        txtDoenca.setText("");
        txtSintomas.setText("");
        txtDiagnostico.setText("");
        txtPrevencao.setText("");
        txtTratamento.setText("");
        txtDiagnostico.setText("");
        txtData.setText("");
        txtCausa.setText("");

    }//GEN-LAST:event_btnLIMPARActionPerformed

    // Evento ao clicar no btnALTERAR 
    private void btnALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARActionPerformed

        // Tratamento de exceções
        try {

            // Obtém os valores dos campos de texto e armazena nas variáveis respectivas
            String xDoença = txtDoenca.getText();
            String xSintomas = txtSintomas.getText();
            String xCausa = txtCausa.getText();
            String xPrevencao = txtPrevencao.getText();
            String xTratamento = txtTratamento.getText();
            String xDiagnostico = txtDiagnostico.getText();
            String xData = txtData.getText();
            String xId = txtId.getSelectedItem().toString();

            int Resultado = JOptionPane.showConfirmDialog(null, "Você realmente deseja alterar o registro?", "ATENÇÃO", JOptionPane.YES_NO_OPTION); // Mensagem de confirmação

            if (Resultado == JOptionPane.YES_OPTION) {

                // Executa uma instrução SQL de atualização após conectar com o banco de dados
                // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
                pst = c.conectaBD().prepareStatement("update doenca set  nomeDoenca = ? ,sintomaDoenca = ? ,causaDoenca = ? ,prevencaoDoenca = ?,tratamentoDoenca = ? ,diagnosticoDoenca = ? ,anoDoenca = ? where idDoenca = ?");
                pst.setString(1, xDoença); //
                pst.setString(2, xSintomas);
                pst.setString(3, xCausa);
                pst.setString(4, xPrevencao);
                pst.setString(5, xTratamento);
                pst.setString(6, xDiagnostico);
                pst.setString(7, xData);
                pst.setString(8, xId);

            }

            // Executa a instrução SQL de atualização
            // Armazena o número de linhas afetadas na variável k
            int k = pst.executeUpdate();

            if (k == 1) {

                // Código a ser executado se a atualização for bem-sucedida
                JOptionPane.showMessageDialog(this, "Alterar: SUCESSO!");

                // Limpa os campos de texto
                txtDoenca.setText("");
                txtSintomas.setText("");
                txtDiagnostico.setText("");
                txtPrevencao.setText("");
                txtTratamento.setText("");
                txtDiagnostico.setText("");
                txtData.setText("");
                txtDoenca.requestFocus();  //  Foco de entrada
                CarregaId(); // Atualiza ID (interface)
                TabelaAtualiza(); // Atualiza Tabela (interface)

            } else {
                JOptionPane.showMessageDialog(this, "Alterar: FALHA! "); // Mensagem de erro 1
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Alterar : " + erro); // Mensagem de erro 
        }
    }//GEN-LAST:event_btnALTERARActionPerformed

    // Evento ao clicar no btnINSERIR 
    private void btnINSERIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINSERIRActionPerformed

        // Tratamento de exceções
        try {

            // Obtém os valores dos campos de texto e armazena nas variáveis respectivas
            String xDoença = txtDoenca.getText();
            String xSintomas = txtSintomas.getText();
            String xCausa = txtCausa.getText();
            String xPrevencao = txtPrevencao.getText();
            String xTratamento = txtTratamento.getText();
            String xDiagnostico = txtDiagnostico.getText();
            String xData = txtData.getText();

            // Executa uma instrução SQL de Inserção após conectar com o banco de dados
            // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
            pst = c.conectaBD().prepareStatement("insert into doenca(nomeDoenca,sintomaDoenca,causaDoenca,prevencaoDoenca,tratamentoDoenca,diagnosticoDoenca,anoDoenca) values (?,?,?,?,?,?,?)");
            pst.setString(1, xDoença);
            pst.setString(2, xSintomas);
            pst.setString(3, xCausa);
            pst.setString(4, xPrevencao);
            pst.setString(5, xTratamento);
            pst.setString(6, xDiagnostico);
            pst.setString(7, xData);

            // Executa a instrução SQL de atualização
            // Armazena o número de linhas afetadas na variável k
            int k = pst.executeUpdate();

            if (k == 1) {

                // Código a ser executado se a atualização for bem-sucedida
                JOptionPane.showMessageDialog(this, "Inserir: SUCESSO!");

                // Limpa os campos de texto
                txtDoenca.setText("");
                txtSintomas.setText("");
                txtDiagnostico.setText("");
                txtPrevencao.setText("");
                txtTratamento.setText("");
                txtDiagnostico.setText("");
                txtData.setText("");
                txtDoenca.requestFocus(); //  Foco de entrada
                CarregaId(); // Atualiza ID (interface)
                TabelaAtualiza(); // Atualiza Tabela (interface)

            } else {
                JOptionPane.showMessageDialog(this, "Inserir: FALHA! "); // Mensagem de erro 1
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Inserir : " + erro); // Mensagem de erro 2
        }
    }//GEN-LAST:event_btnINSERIRActionPerformed

    // Evento ao clicar no btnCOMPARACOES
    private void btnCOMPARACOESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOMPARACOESActionPerformed
        TELA_3_RELATORIOS r = new TELA_3_RELATORIOS();// Instância da classe TELA_3_RELATORIOS
        this.dispose();// Fecha janela atual 
        r.setVisible(true);// Exibe a TELA_3_RELATORIOS
    }//GEN-LAST:event_btnCOMPARACOESActionPerformed

    // Evento de quando a tela se inicia
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    // Evento ao clicar no btnSAIR e Fecha janela caso o usuário escolha "SIM"
    private void btnSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAIRActionPerformed
        JFrame frame = new JFrame("SAIR");
        if (JOptionPane.showConfirmDialog(frame, "Deseja sair ?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSAIRActionPerformed

    private void txtDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoencaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoencaActionPerformed

    // Metódo Principal
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TELA_1_DOENÇA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TELA_1_DOENÇA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TELA_1_DOENÇA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TELA_1_DOENÇA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TELA_1_DOENÇA().setVisible(true);
            }
        });
    }

    // Variáveis da Interface Gráfica
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PAINEL_BARRA_PRETA_INFERIOR;
    private javax.swing.JPanel PAINEL_BARRA_VERDE_INFERIOR;
    private javax.swing.JButton btnALTERAR;
    private javax.swing.JButton btnCOMPARACOES;
    private javax.swing.JButton btnCidade;
    private javax.swing.JButton btnINSERIR;
    private javax.swing.JButton btnLIMPAR;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    private javax.swing.JLabel lblAtualizacao;
    private javax.swing.JLabel lblCausa;
    private javax.swing.JLabel lblDiagnostico;
    private javax.swing.JLabel lblDoenca0;
    private javax.swing.JLabel lblDoenca1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPrevencao;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblSintomas;
    private javax.swing.JLabel lblSuporte;
    private javax.swing.JLabel lblTratamento;
    private javax.swing.JButton lblUNIP;
    private javax.swing.JTextField txtCausa;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtDoenca;
    private javax.swing.JComboBox<String> txtId;
    private javax.swing.JTextField txtPrevencao;
    private javax.swing.JTextField txtSintomas;
    private javax.swing.JTextField txtTratamento;
    // End of variables declaration//GEN-END:variables
}
