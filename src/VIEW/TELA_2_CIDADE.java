package VIEW; // Pacote View

import DAO.ConexãoDAO; // Classe ConexãoDAO
import javax.swing.JOptionPane; // Importação Biblioteca Swing - JOptionPane 
import java.util.Vector; // Importação da Biblioteca Utill - Vetor
import java.sql.PreparedStatement; // Importação Preparação
import java.sql.ResultSetMetaData; // Importação ResultSetMetaData
import java.sql.SQLException; //  Importação SQLException
import java.sql.ResultSet; // // Importação ResultSet
import javax.swing.JFrame;  // Importação Biblioteca Swing - JFrame
import javax.swing.table.DefaultTableModel;  // Importação Biblioteca Swing - Tabela

// Classe com Herança de JFRAME
public class TELA_2_CIDADE extends javax.swing.JFrame {

    // Método Construtor
    public TELA_2_CIDADE() {
        initComponents();
        TabelaAtualiza(); // Metódo de Atualizar tabela conforme banco de dados
        
    }
    // Variáveis globais

    PreparedStatement pst; // Variável  do tipo PreparedStatement
    ResultSet rs; // Variável do tipo ResultSet
    ResultSetMetaData rss; // Variável  do tipo ResultSetMetaData

    // Instância Classe ConexãoDAO
    ConexãoDAO c = new ConexãoDAO();

  

    // Metódo sem retorno para Atualizar Tabela conforme Preenchimento dos Dados
    private void TabelaAtualiza() {
        int cc; // Criação de uma variável do tipo inteiro 

        // Tratamento de exceções
        try {

            // Obtêm os dados que o usuário digitou e atribui as variáveis respectivas
            
            String xCidade = txtCidade.getSelectedItem().toString();
            String xHabitantes = txtHabitantes.getText();
            String xInfectados = txtInfectados.getText();
            String xMortes = txtMortes.getText();
            String xVacinados = txtVacinados.getText();
            String xAno = txtAno.getText();
            String xColetas = txtColetas.getText();

            pst = c.conectaBD().prepareStatement("select * from cidade"); // Prepara uma consulta SQL para selecionar todos os registros da tabela após conectar com o banco de dados
            rs = pst.executeQuery(); // O rs contém os dados retornados pela consulta.
            rss = rs.getMetaData(); // O rss(ResultSetMetaData) obtém as informações sobre os metadados do ResultSet(rs)
            cc = rss.getColumnCount(); //  A quantidade de colunas na tabela é obtida e armazenada na variável cc.

            DefaultTableModel TB = (DefaultTableModel) jTabela.getModel(); // Obtém o modelo da tabela criada
            TB.setRowCount(0); // Define o número de linhas da tabela como zero

            // Percorre todas as linhas disponíveis no ResultSet (rs)
            while (rs.next()) {

                Vector v = new Vector(); // Irá Armazenar os valores das colunas de uma linha da tabela

                // Inicia um laço for que percorre todas as colunas (cc) da tabela.
                // Cada valor das colunas é obtido do ResultSet (rs) usando o método getString() e adicionado ao objeto Vector v
                for (int a = 1; a <= cc; a++) {
                    v.add(rs.getString("idCidade"));
                    v.add(rs.getString("nomeCidade"));
                    v.add(rs.getString("numHabitantes"));
                    v.add(rs.getString("numInfectados"));
                    v.add(rs.getString("numMortes"));
                    v.add(rs.getString("numVacinados"));
                    v.add(rs.getString("dataAtualizacao"));
                    v.add(rs.getString("quantAmostra"));

                }

                TB.addRow(v); // O vetor é adicionado como uma nova linha ao modelo da tabela

            }
            // Limpa campos 

            txtHabitantes.setText("");
            txtInfectados.setText("");
            txtMortes.setText("");
            txtVacinados.setText("");
            txtAno.setText("");
            txtColetas.setText("");
            txtCidade.setSelectedItem("Selecione..."); // Limpa Combobox

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TabelaAtualiza : " + erro); // Mensagem de erro
        }

    }

    // Interface Gráfica
    @SuppressWarnings("unchecked")//Parte gráfica 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCidade = new javax.swing.JLabel();
        lblAtualizacao = new javax.swing.JLabel();
        lblHabitantes = new javax.swing.JLabel();
        lblColetas = new javax.swing.JLabel();
        lblInfectados = new javax.swing.JLabel();
        lblVacinados = new javax.swing.JLabel();
        lblMortes = new javax.swing.JLabel();
        lblCidad = new javax.swing.JLabel();
        txtAno = new javax.swing.JFormattedTextField();
        txtHabitantes = new javax.swing.JTextField();
        txtColetas = new javax.swing.JTextField();
        txtVacinados = new javax.swing.JTextField();
        txtMortes = new javax.swing.JTextField();
        txtCidade = new javax.swing.JComboBox<>();
        btnINSERIR = new javax.swing.JButton();
        btnALTERAR = new javax.swing.JButton();
        btnLIMPAR = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        btnSAIR = new javax.swing.JButton();
        btnCOMPARACOES = new javax.swing.JButton();
        btnDOENCA = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        PAINEL_BARRA_VERDE_INFERIOR = new javax.swing.JPanel();
        PAINEL_BARRA_PRETA_INFERIOR = new javax.swing.JPanel();
        lblSuporte = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUNIP = new javax.swing.JButton();
        txtInfectados = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCidade.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblCidade.setForeground(new java.awt.Color(102, 102, 102));
        lblCidade.setText("CIDADE");

        lblAtualizacao.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblAtualizacao.setForeground(new java.awt.Color(102, 102, 102));
        lblAtualizacao.setText("ATUALIZAÇÃO");

        lblHabitantes.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblHabitantes.setForeground(new java.awt.Color(102, 102, 102));
        lblHabitantes.setText("HABITANTES");

        lblColetas.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblColetas.setForeground(new java.awt.Color(102, 102, 102));
        lblColetas.setText("COLETAS");

        lblInfectados.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblInfectados.setForeground(new java.awt.Color(102, 102, 102));
        lblInfectados.setText("INFECTADOS");

        lblVacinados.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblVacinados.setForeground(new java.awt.Color(102, 102, 102));
        lblVacinados.setText("VACINADOS");

        lblMortes.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblMortes.setForeground(new java.awt.Color(102, 102, 102));
        lblMortes.setText("MORTES");

        lblCidad.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        lblCidad.setForeground(new java.awt.Color(147, 170, 97));
        lblCidad.setText("Cidades");
        lblCidad.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblCidad.setPreferredSize(new java.awt.Dimension(86, 28));

        txtAno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(147, 170, 97), 2, true));
        try {
            txtAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtAno.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtAno.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtAno.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtHabitantes.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtHabitantes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 170, 97), 2, true));
        txtHabitantes.setPreferredSize(new java.awt.Dimension(15, 24));
        txtHabitantes.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtHabitantes.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtColetas.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtColetas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 170, 97), 2, true));
        txtColetas.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtColetas.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtVacinados.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtVacinados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(147, 170, 97), 2, true));
        txtVacinados.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtVacinados.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtMortes.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtMortes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 170, 97), 2, true));
        txtMortes.setMinimumSize(new java.awt.Dimension(15, 24));
        txtMortes.setPreferredSize(new java.awt.Dimension(15, 24));
        txtMortes.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtMortes.setSelectionColor(new java.awt.Color(147, 170, 97));

        txtCidade.setBackground(new java.awt.Color(102, 102, 102));
        txtCidade.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtCidade.setForeground(new java.awt.Color(255, 255, 255));
        txtCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "São Bernardo do Campo", "São Caetano", "Santo André", "Mauá", "Diadema" }));
        txtCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCidade.setRequestFocusEnabled(false);

        btnINSERIR.setBackground(new java.awt.Color(153, 153, 153));
        btnINSERIR.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnINSERIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/ADD_92.png"))); // NOI18N
        btnINSERIR.setBorder(null);
        btnINSERIR.setContentAreaFilled(false);
        btnINSERIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINSERIRActionPerformed(evt);
            }
        });

        btnALTERAR.setBackground(new java.awt.Color(153, 153, 153));
        btnALTERAR.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnALTERAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/EDIT_92.png"))); // NOI18N
        btnALTERAR.setBorder(null);
        btnALTERAR.setContentAreaFilled(false);
        btnALTERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERARActionPerformed(evt);
            }
        });

        btnLIMPAR.setBackground(new java.awt.Color(153, 153, 153));
        btnLIMPAR.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnLIMPAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/LIMPAR_92.png"))); // NOI18N
        btnLIMPAR.setBorder(null);
        btnLIMPAR.setContentAreaFilled(false);
        btnLIMPAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIMPARActionPerformed(evt);
            }
        });

        btnDELETE.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnDELETE.setForeground(new java.awt.Color(60, 63, 65));
        btnDELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/DELETE_92.png"))); // NOI18N
        btnDELETE.setBorder(null);
        btnDELETE.setContentAreaFilled(false);
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });

        btnSAIR.setBackground(new java.awt.Color(153, 153, 153));
        btnSAIR.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnSAIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/SAIR_92.png"))); // NOI18N
        btnSAIR.setBorder(null);
        btnSAIR.setContentAreaFilled(false);
        btnSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAIRActionPerformed(evt);
            }
        });

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

        btnDOENCA.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        btnDOENCA.setForeground(new java.awt.Color(0, 0, 0));
        btnDOENCA.setText("Doença");
        btnDOENCA.setBorder(null);
        btnDOENCA.setContentAreaFilled(false);
        btnDOENCA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDOENCA.setPreferredSize(new java.awt.Dimension(115, 30));
        btnDOENCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDOENCAActionPerformed(evt);
            }
        });

        jTabela.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CIDADE", "HABITANTES", "INFECTADOS", "MORTES", "VACINADOS", "DATA", "COLETAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTabela.setAlignmentX(0.0F);
        jTabela.setAlignmentY(0.0F);
        jTabela.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabela.setGridColor(new java.awt.Color(0, 0, 0));
        jTabela.setMinimumSize(new java.awt.Dimension(105, 250));
        jTabela.setPreferredSize(new java.awt.Dimension(250, 150));
        jTabela.setRowHeight(30);
        jTabela.setRowMargin(10);
        jTabela.setSelectionBackground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        jTabela.setSelectionForeground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        jTabela.setShowGrid(true);
        jTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabela);
        if (jTabela.getColumnModel().getColumnCount() > 0) {
            jTabela.getColumnModel().getColumn(0).setMinWidth(30);
            jTabela.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTabela.getColumnModel().getColumn(0).setMaxWidth(100);
            jTabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTabela.getColumnModel().getColumn(2).setPreferredWidth(20);
            jTabela.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTabela.getColumnModel().getColumn(4).setPreferredWidth(5);
            jTabela.getColumnModel().getColumn(5).setPreferredWidth(20);
            jTabela.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTabela.getColumnModel().getColumn(7).setPreferredWidth(1);
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

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 248, 238));
        jLabel1.setText("3º SEMESTRE");

        lblUNIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/UNIP.png"))); // NOI18N
        lblUNIP.setBorder(null);
        lblUNIP.setBorderPainted(false);
        lblUNIP.setContentAreaFilled(false);

        javax.swing.GroupLayout PAINEL_BARRA_VERDE_INFERIORLayout = new javax.swing.GroupLayout(PAINEL_BARRA_VERDE_INFERIOR);
        PAINEL_BARRA_VERDE_INFERIOR.setLayout(PAINEL_BARRA_VERDE_INFERIORLayout);
        PAINEL_BARRA_VERDE_INFERIORLayout.setHorizontalGroup(
            PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PAINEL_BARRA_PRETA_INFERIOR, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
            .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblEmail)
                        .addComponent(lblSuporte))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblUNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)))
        );
        PAINEL_BARRA_VERDE_INFERIORLayout.setVerticalGroup(
            PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                .addComponent(PAINEL_BARRA_PRETA_INFERIOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 92, Short.MAX_VALUE))
            .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                            .addComponent(lblSuporte)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblEmail))
                        .addComponent(lblUNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel1)))
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        txtInfectados.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtInfectados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(147, 170, 97), 2, true));
        txtInfectados.setSelectedTextColor(new java.awt.Color(147, 170, 97));
        txtInfectados.setSelectionColor(new java.awt.Color(147, 170, 97));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PAINEL_BARRA_VERDE_INFERIOR, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnDOENCA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(lblCidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(btnCOMPARACOES, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblCidade)
                        .addGap(410, 410, 410)
                        .addComponent(lblAtualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSAIR))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(lblHabitantes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblColetas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtColetas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblInfectados)
                                        .addGap(99, 99, 99))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtInfectados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(338, 338, 338)
                                        .addComponent(lblMortes))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txtVacinados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)
                                        .addComponent(txtMortes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(249, 249, 249))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblVacinados)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHabitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187))
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(554, 554, 554))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnINSERIR, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnALTERAR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnLIMPAR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnDELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(279, 279, 279))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCOMPARACOES, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDOENCA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSAIR))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCidade)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAtualizacao)
                        .addGap(23, 23, 23)))
                .addGap(3, 3, 3)
                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblColetas)
                        .addGap(18, 18, 18)
                        .addComponent(txtColetas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHabitantes)
                        .addGap(18, 18, 18)
                        .addComponent(txtHabitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfectados)
                    .addComponent(lblVacinados)
                    .addComponent(lblMortes))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMortes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVacinados, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInfectados, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnINSERIR)
                        .addComponent(btnLIMPAR, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDELETE, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnALTERAR, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(PAINEL_BARRA_VERDE_INFERIOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Eventos
    // Evento ao clicar no btnINSERIR
    private void btnINSERIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINSERIRActionPerformed

        // Tratamento de exceções
        try {

            // Obtém os valores dos campos de texto e armazena nas variáveis respectivas
            String xCidade = txtCidade.getSelectedItem().toString();
            String xHabitantes = txtHabitantes.getText();
            String xInfectados = txtInfectados.getText();
            String xMortes = txtMortes.getText();
            String xVacinados = txtVacinados.getText();
            String xAno = txtAno.getText();
            String xColetas = txtColetas.getText();

            // Executa uma instrução SQL de Inserção após conectar com o banco de dados
            // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
            pst = c.conectaBD().prepareStatement("insert into cidade(nomeCidade,numHabitantes,numInfectados,numMortes,numVacinados,dataAtualizacao,quantAmostra) values (?,?,?,?,?,?,?)");
            pst.setString(1, xCidade);
            pst.setString(2, xHabitantes);
            pst.setString(3, xInfectados);
            pst.setString(4, xMortes);
            pst.setString(5, xVacinados);
            pst.setString(6, xAno);
            pst.setString(7, xColetas);

            // Executa a instrução SQL de atualização
            // Armazena o número de linhas afetadas na variável k
            
            int k = pst.executeUpdate();

            if (k == 1) {

                // Código a ser executado se a atualização for bem-sucedida
                
                JOptionPane.showMessageDialog(this, "Inserir: SUCESSO!");

                // Limpa os campos de texto
                txtHabitantes.setText("");
                txtInfectados.setText("");
                txtMortes.setText("");
                txtVacinados.setText("");
                txtAno.setText("");
                txtColetas.setText("");
                txtCidade.setSelectedItem("Selecione..."); // Limpa Combobox
                TabelaAtualiza(); // Atualiza ID (interface)
               
                

            } else {
                JOptionPane.showMessageDialog(this, "Inserir: FALHA! "); // Mensagem de erro 1
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Inserir: " + erro); // Mensagem de erro 2
        }
    }//GEN-LAST:event_btnINSERIRActionPerformed

    // Evento ao clicar no btnALTERAR
    private void btnALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARActionPerformed

        
        DefaultTableModel TB = (DefaultTableModel)jTabela.getModel();
        int selectedindex = jTabela.getSelectedRow();
        // Tratamento de exceções
        try {
            
            int id = Integer.parseInt(TB.getValueAt(selectedindex, 0).toString()); //Obtém o valor de uma célula específica de uma tabela e na linha indicada pelo índice e na coluna 0

            // Obtém os valores dos campos de texto e armazena nas variáveis respectivas
            
            String xCidade = txtCidade.getSelectedItem().toString();
            String xHabitantes = txtHabitantes.getText();
            String xInfectados = txtInfectados.getText();
            String xMortes = txtMortes.getText();
            String xVacinados = txtVacinados.getText();
            String xAno = txtAno.getText();
            String xColetas = txtColetas.getText();
         

            int Resultado = JOptionPane.showConfirmDialog(null, "Você realmente deseja alterar o registro?", "ATENÇÃO", JOptionPane.YES_NO_OPTION); // Mensagem de confirmação

            if (Resultado == JOptionPane.YES_OPTION) {

                // Executa uma instrução SQL de atualização após conectar com o banco de dados
                // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
                
                pst = c.conectaBD().prepareStatement("update cidade set  nomeCidade = ? ,numHabitantes = ? ,numInfectados = ? ,numMortes = ?,numVacinados = ? ,dataAtualizacao = ? ,quantAmostra = ? where idCidade = ?");
                pst.setString(1, xCidade);
                pst.setString(2, xHabitantes);
                pst.setString(3, xInfectados);
                pst.setString(4, xMortes);
                pst.setString(5, xVacinados);
                pst.setString(6, xAno);
                pst.setString(7, xColetas);
                pst.setInt(8, id);

            }
            // Executa a instrução SQL de atualização
            // Armazena o número de linhas afetadas na variável k
            int k = pst.executeUpdate();

            if (k == 1) {

                // Código a ser executado se a atualização for bem-sucedida
                JOptionPane.showMessageDialog(this, "Alterar: SUCESSO!");

                // Limpa os campos de texto
                txtHabitantes.setText("");
                txtInfectados.setText("");
                txtMortes.setText("");
                txtVacinados.setText("");
                txtAno.setText("");
                txtColetas.setText("");
                txtCidade.setSelectedItem("Selecione..."); // Limpa Combobox
                TabelaAtualiza(); // Atualiza ID (interface)
               
                

            } else {
                JOptionPane.showMessageDialog(this, "Alterar: FALHA! ");// Mensagem de erro 1
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Alterar: " + erro); // Mensagem de erro 2
        }
    }//GEN-LAST:event_btnALTERARActionPerformed

    // Evento ao clicar no btnLIMPAR 
    private void btnLIMPARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIMPARActionPerformed

        txtHabitantes.setText("");
        txtInfectados.setText("");
        txtMortes.setText("");
        txtVacinados.setText("");
        txtAno.setText("");
        txtColetas.setText("");
        txtCidade.setSelectedItem("Selecione..."); // Limpa Combobox

    }//GEN-LAST:event_btnLIMPARActionPerformed

    // Evento ao clicar no btnDELETE
    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed

        DefaultTableModel TB = (DefaultTableModel) jTabela.getModel(); // Obtém o modelo da tabela criada

        int selectIndex = jTabela.getSelectedRow();// Obtém o índice da linha selecionada na tabela

        // Tratamento de exceções
        try {
            int id = Integer.parseInt(TB.getValueAt(selectIndex, 0).toString()); // Obtém o valor da primeira coluna e atribui a variável id 

            int Resultado = JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o registro?", "ATENÇÃO", JOptionPane.YES_NO_OPTION); // Mensagem de Confirmação

            if (Resultado == JOptionPane.YES_OPTION) { // Caso o usuário escolha "SIM" executará os comandos abaixo

                // Executa uma instrução SQL de deletar após conectar com o banco de dados
                // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
                pst = c.conectaBD().prepareStatement("delete from cidade where idCidade = ?");
                pst.setInt(1, id);

                // Executa a instrução SQL de atualização
                int k = pst.executeUpdate();

                if (k == 1) {

                    // Código a ser executado se a atualização for bem-sucedida
                    JOptionPane.showMessageDialog(this, "Delete: SUCESSO!");

                    // Limpa os campos de texto
                    txtHabitantes.setText("");
                    txtInfectados.setText("");
                    txtMortes.setText("");
                    txtVacinados.setText("");
                    txtAno.setText("");
                    txtColetas.setText("");
                    txtCidade.setSelectedItem("Selecione..."); // Limpa Combobox
                    
                    TabelaAtualiza(); // Atualiza Tabela (interface)
          

                } else {
                    JOptionPane.showMessageDialog(this, "Delete: FALHA! "); // Mensagem de erro 1
                }
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Delete: " + erro);// Mensagem de erro 2
        }
    }//GEN-LAST:event_btnDELETEActionPerformed

    //Evento ao clicar na tabela(registros)
    private void jTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMouseClicked
       
        DefaultTableModel TB = (DefaultTableModel) jTabela.getModel(); // Pegando modelo da tabela

        int selectedIndex = jTabela.getSelectedRow(); // Obtém o índice da linha selecionada na tabela jTabela e armazena o valor na variável selectedIndex

         // Obtêm os valores das células da linha selecionada na tabela e atribui a cada componente respectivo
         
        txtCidade.setSelectedItem(TB.getValueAt(selectedIndex, 1).toString());
        txtHabitantes.setText(TB.getValueAt(selectedIndex, 2).toString());
        txtInfectados.setText(TB.getValueAt(selectedIndex, 3).toString());
        txtMortes.setText(TB.getValueAt(selectedIndex, 4).toString());
        txtVacinados.setText(TB.getValueAt(selectedIndex, 5).toString());
        txtAno.setText(TB.getValueAt(selectedIndex, 6).toString());
        txtColetas.setText(TB.getValueAt(selectedIndex, 7).toString());


    }//GEN-LAST:event_jTabelaMouseClicked

    // Evento ao clicar no btnSAIR e Fecha janela caso o usuário escolha "SIM"
    private void btnSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAIRActionPerformed
        JFrame frame = new JFrame("SAIR");
        if (JOptionPane.showConfirmDialog(frame, "Deseja sair ?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSAIRActionPerformed

    // Evento ao clicar no btnCOMPARACOES 
    private void btnCOMPARACOESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOMPARACOESActionPerformed
        TELA_3_RELATORIOS m = new TELA_3_RELATORIOS(); // Instância da classe TELA_3_RELATORIOS
        this.dispose(); // Fecha janela atual 
        m.setVisible(true); // Exibe a TELA_3_RELATORIOS
    }//GEN-LAST:event_btnCOMPARACOESActionPerformed

    // Evento ao clicar no btnDOENCA
    private void btnDOENCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDOENCAActionPerformed
        TELA_1_DOENÇA d = new TELA_1_DOENÇA(); // Instância da classe TELA_1_DOENCA
        this.dispose(); // Fecha janela atual 
        d.setVisible(true); // Exibe a TELA_1_DOENCA
    }//GEN-LAST:event_btnDOENCAActionPerformed

    //Metódo Principal
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TELA_2_CIDADE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TELA_2_CIDADE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TELA_2_CIDADE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TELA_2_CIDADE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TELA_2_CIDADE().setVisible(true);
            }
        });
    }

    // Variáveis da Interface Gráfica
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PAINEL_BARRA_PRETA_INFERIOR;
    private javax.swing.JPanel PAINEL_BARRA_VERDE_INFERIOR;
    private javax.swing.JButton btnALTERAR;
    private javax.swing.JButton btnCOMPARACOES;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnDOENCA;
    private javax.swing.JButton btnINSERIR;
    private javax.swing.JButton btnLIMPAR;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    private javax.swing.JLabel lblAtualizacao;
    private javax.swing.JLabel lblCidad;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblColetas;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHabitantes;
    private javax.swing.JLabel lblInfectados;
    private javax.swing.JLabel lblMortes;
    private javax.swing.JLabel lblSuporte;
    private javax.swing.JButton lblUNIP;
    private javax.swing.JLabel lblVacinados;
    private javax.swing.JFormattedTextField txtAno;
    private javax.swing.JComboBox<String> txtCidade;
    private javax.swing.JTextField txtColetas;
    private javax.swing.JTextField txtHabitantes;
    private javax.swing.JTextField txtInfectados;
    private javax.swing.JTextField txtMortes;
    private javax.swing.JTextField txtVacinados;
    // End of variables declaration//GEN-END:variables
}
