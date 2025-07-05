package VIEW; // Pacote View

import DAO.ConexãoDAO; // Classe ConexãoDAO
import java.util.Vector; // Importação Biblioteca Utill - Vetores
import java.sql.PreparedStatement; // Importação PreparedStatement
import java.sql.SQLException; // Importação SQLException
import java.sql.ResultSet; // Importação ResultSet
import java.sql.ResultSetMetaData; //Importação ResultSetMetaData
import javax.swing.JOptionPane; // Importação Swing - JOptionPane 
import javax.swing.JFrame; // Importação Biblioteca Swing - JFrame
import javax.swing.table.DefaultTableModel; // Importação Biblioteca Swing - Tabela

public class TELA_3_RELATORIOS extends javax.swing.JFrame {

    // Metódo Construtor com Herança de JFrame
    public TELA_3_RELATORIOS() {
        initComponents();

        PAINEL1.setVisible(false); // Tabela1 inicia oculta

        PAINEL2.setVisible(false); // Tabela2 inicia oculta

        PAINEL3.setVisible(false); // Tabela3 inicia oculta

    }

    // Variáveis globais
    
    PreparedStatement pst; // Variável  do tipo PreparedStatement
    ResultSet rs; // Variável do tipo ResultSet
    ResultSetMetaData rss; // Variável  do tipo ResultSetMetaData

    // Instância Classe ConexãoDAO
    
    ConexãoDAO c = new ConexãoDAO();

    // Metódo de Comparacão entre 1 cidade e a doença escolhida 
    private void TabelaCompara1() {
        int cc; // Criação de uma variável do tipo inteiro 

        // Tratamento de exceções
        try {
            
            // Obtém o valor dos ComboBox e armazena nas variável respectiva
            
            String xCidade = txtCidade.getSelectedItem().toString();

            // Executa uma instrução SQL de seleção após conectar com o banco de dados
            // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
            
            pst = c.conectaBD().prepareStatement("select nomeDoenca,nomeCidade,numHabitantes,numInfectados,numMortes,numVacinados,dataAtualizacao,(numInfectados * 100 / numHabitantes) as percentualInfectados,quantAmostra from cidade join doenca on idDoenca = id_Doenca where nomeCidade = ?;");
            pst.setString(1, xCidade);
            rs = pst.executeQuery();  // O rs contém os dados retornados pela consulta
            rss = rs.getMetaData(); // O rss(ResultSetMetaData) obtém as informações sobre os metadados do ResultSet(rs)
            cc = rss.getColumnCount(); //  A quantidade de colunas na tabela é obtida e armazenada na variável cc.

            DefaultTableModel TB = (DefaultTableModel) TABELA1.getModel(); // Obtém o modelo da tabela criada
            TB.setRowCount(0); // Define o número de linhas da tabela como zero

            // Percorre todas as linhas disponíveis no ResultSet (rs)
            while (rs.next()) {

                Vector v = new Vector(); // Irá Armazenar os valores das colunas de uma linha da tabela

                // Inicia um laço for que percorre todas as colunas (cc) da tabela.
                // Cada valor das colunas é obtido do ResultSet (rs) usando o método getString() e adicionado ao objeto Vector v
                
                for (int a = 1; a <= cc; a++) {
                    v.add(rs.getString("nomeDoenca"));
                    v.add(rs.getString("nomeCidade"));
                    v.add(rs.getInt("numHabitantes"));
                    v.add(rs.getInt("numInfectados"));
                    v.add(rs.getInt("numMortes"));
                    v.add(rs.getInt("numVacinados"));
                    v.add(rs.getInt("quantAmostra"));
                    v.add(rs.getInt("percentualInfectados"));
                    v.add(rs.getString("dataAtualizacao"));
                }

                TB.addRow(v);// O vetor é adicionado como uma nova linha ao modelo da tabela

            }
            // Limpa Combobox
            
            txtCidade.setSelectedItem("Selecione..."); 

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TabelaCompara1 : " + erro); // Mensagem de erro
        }

    }

    // Metódo de Comparacões entre 2 cidades e a doença escolhida 
    private void TabelaCompara2() {

        int cc; // Criação de uma variável do tipo inteiro 

        // Tratamento de exceções
        try {

            // Obtém o valor dos ComboBox e armazena nas variáveis respectivas
            
            String xCidade1 = txtCidade1.getSelectedItem().toString();
            String xCidade2 = txtCidade2.getSelectedItem().toString();

            // Executa uma instrução SQL de seleção após conectar com o banco de dados
            // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
            
            pst = c.conectaBD().prepareStatement("select nomeDoenca,nomeCidade,numHabitantes,numInfectados,numMortes,numVacinados,dataAtualizacao,(numInfectados * 100 / numHabitantes) as percentualInfectados,quantAmostra from cidade join doenca on idDoenca = id_Doenca where nomeCidade = ? or nomeCidade = ?;");
            pst.setString(1, xCidade1);
            pst.setString(2, xCidade2);
            rs = pst.executeQuery();// O rs contém os dados retornados pela consulta.
            rss = rs.getMetaData();// O rss(ResultSetMetaData) obtém as informações sobre os metadados do ResultSet(rs)
            cc = rss.getColumnCount(); //  A quantidade de colunas na tabela é obtida e armazenada na variável cc.

            DefaultTableModel TB = (DefaultTableModel) TABELA2.getModel(); // Obtém o modelo da tabela criada
            TB.setRowCount(0); // Define o número de linhas da tabela como zero

            // Percorre todas as linhas disponíveis no ResultSet (rs)
            while (rs.next()) {

                Vector v = new Vector(); // Irá Armazenar os valores das colunas de uma linha da tabela

                // Inicia um laço for que percorre todas as colunas (cc) da tabela.
                // Cada valor das colunas é obtido do ResultSet (rs) usando o método getString() e adicionado ao objeto Vector v    
                
                for (int a = 1; a <= cc; a++) {
                    v.add(rs.getString("nomeDoenca"));
                    v.add(rs.getString("nomeCidade"));
                    v.add(rs.getInt("numHabitantes"));
                    v.add(rs.getInt("numInfectados"));
                    v.add(rs.getInt("numMortes"));
                    v.add(rs.getInt("numVacinados"));
                    v.add(rs.getInt("quantAmostra"));
                    v.add(rs.getInt("percentualInfectados"));
                    v.add(rs.getString("dataAtualizacao"));
                }

                TB.addRow(v); // O vetor é adicionado como uma nova linha ao modelo da tabela

            }

            // Limpa Combobox 
            
            txtCidade1.setSelectedItem("Selecione...");
            txtCidade2.setSelectedItem("Selecione..."); 

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TabelaCompara2 : " + erro); // Mensagem de erro
        }

    }

    // Metódo de Comparacões entre um intervalo de tempo e a doença escolhida 
    private void TabelaCompara3() {
        int cc; // Criação de uma variável do tipo inteiro 

        // Tratamento de exceções
        try {

            // Obtém o valor dos campos de textos e armazena nas variáveis respectivas
            
            String xData1 = txtData1.getText();
            String xData2 = txtData2.getText();

            // Executa uma instrução SQL de seleção após conectar com o banco de dados
            // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
            
            pst = c.conectaBD().prepareStatement("select nomeDoenca,nomeCidade,numHabitantes,numInfectados,numMortes,numVacinados,dataAtualizacao,(numInfectados * 100 / numHabitantes) as percentualInfectados,quantAmostra  from cidade join doenca on idDoenca = id_Doenca where dataAtualizacao between  ? and ?;");
            pst.setString(1, xData1);
            pst.setString(2, xData2);
            rs = pst.executeQuery();// O rs contém os dados retornados pela consulta
            rss = rs.getMetaData(); // O rss(ResultSetMetaData) obtém as informações sobre os metadados do ResultSet(rs)
            cc = rss.getColumnCount();//  A quantidade de colunas na tabela é obtida e armazenada na variável cc.

            DefaultTableModel TB = (DefaultTableModel) TABELA3.getModel();// Obtém o modelo da tabela criada
            TB.setRowCount(0);// Define o número de linhas da tabela como zero

            // Percorre todas as linhas disponíveis no ResultSet (rs)
            while (rs.next()) {

                Vector v = new Vector();// Irá Armazenar os valores das colunas de uma linha da tabela

                // Inicia um laço for que percorre todas as colunas (cc) da tabela.
                // Cada valor das colunas é obtido do ResultSet (rs) usando o método getString() e adicionado ao objeto Vector v
                
                for (int a = 1; a <= cc; a++) {
                    v.add(rs.getString("nomeDoenca"));
                    v.add(rs.getString("nomeCidade"));
                    v.add(rs.getInt("numHabitantes"));
                    v.add(rs.getInt("numInfectados"));
                    v.add(rs.getInt("numMortes"));
                    v.add(rs.getInt("numVacinados"));

                    v.add(rs.getInt("quantAmostra"));
                    v.add(rs.getInt("percentualInfectados"));
                    v.add(rs.getString("dataAtualizacao"));
                }

                TB.addRow(v);// O vetor é adicionado como uma nova linha ao modelo da tabela

            }
            // Limpa campos
            txtData1.setText("");
            txtData2.setText("");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "TabelaCompara3 : " + erro); // Mensagem de erro
        }

    }

    // Interface Gráfica
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PAINEL0 = new javax.swing.JPanel();
        PAINEL1 = new javax.swing.JPanel();
        btnCONSULTA1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABELA1 = new javax.swing.JTable();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JComboBox<>();
        PAINEL2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABELA2 = new javax.swing.JTable();
        txtCidade2 = new javax.swing.JComboBox<>();
        txtCidade1 = new javax.swing.JComboBox<>();
        lblCidade1 = new javax.swing.JLabel();
        lblCidade2 = new javax.swing.JLabel();
        btnCONSULTA2 = new javax.swing.JButton();
        PAINEL3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TABELA3 = new javax.swing.JTable();
        txtData1 = new javax.swing.JFormattedTextField();
        txtData2 = new javax.swing.JFormattedTextField();
        lblData1 = new javax.swing.JLabel();
        lblData2 = new javax.swing.JLabel();
        btnCONSULTA3 = new javax.swing.JButton();
        PAINEL_BARRA_VERDE_INFERIOR = new javax.swing.JPanel();
        PAINEL_BARRA_PRETA_INFERIOR = new javax.swing.JPanel();
        lblSuporte = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        lblUNIP = new javax.swing.JButton();
        btnSELECIONE = new javax.swing.JComboBox<>();
        btnDOENCA = new javax.swing.JButton();
        btnCIDADE = new javax.swing.JButton();
        btnSAIR = new javax.swing.JButton();
        lblComparacoes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PAINEL0.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCONSULTA1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        btnCONSULTA1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/SEARCH_64.png"))); // NOI18N
        btnCONSULTA1.setBorder(null);
        btnCONSULTA1.setContentAreaFilled(false);
        btnCONSULTA1.setPreferredSize(new java.awt.Dimension(90, 40));
        btnCONSULTA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONSULTA1ActionPerformed(evt);
            }
        });

        TABELA1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        TABELA1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DOENÇA", "CIDADE", "HABITANTES", "INFECTADOS", "MORTES", "VACINADOS", "COLETAS", "% INFECTADOS", "ATUALIZAÇÃO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TABELA1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        TABELA1.setMinimumSize(new java.awt.Dimension(250, 200));
        TABELA1.setPreferredSize(new java.awt.Dimension(675, 200));
        TABELA1.setRowHeight(40);
        TABELA1.setRowMargin(10);
        jScrollPane2.setViewportView(TABELA1);

        lblCidade.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblCidade.setForeground(new java.awt.Color(102, 102, 102));
        lblCidade.setText("CIDADE");

        txtCidade.setBackground(new java.awt.Color(102, 102, 102));
        txtCidade.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtCidade.setForeground(new java.awt.Color(255, 255, 255));
        txtCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "São Bernardo do Campo", "São Caetano", "Santo André", "Mauá", "Diadema" }));
        txtCidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout PAINEL1Layout = new javax.swing.GroupLayout(PAINEL1);
        PAINEL1.setLayout(PAINEL1Layout);
        PAINEL1Layout.setHorizontalGroup(
            PAINEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAINEL1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(PAINEL1Layout.createSequentialGroup()
                .addGroup(PAINEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAINEL1Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(lblCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAINEL1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)))
                .addComponent(btnCONSULTA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PAINEL1Layout.setVerticalGroup(
            PAINEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAINEL1Layout.createSequentialGroup()
                .addGroup(PAINEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAINEL1Layout.createSequentialGroup()
                        .addComponent(lblCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PAINEL1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCONSULTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PAINEL0.add(PAINEL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 18, 1149, -1));

        TABELA2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        TABELA2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DOENÇA", "CIDADE", "HABITANTES", "INFECTADOS", "MORTES", "VACINADOS", "COLETAS", "% INFECTADOS", "ATUALIZAÇÃO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TABELA2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TABELA2.setRowHeight(40);
        TABELA2.setRowMargin(10);
        jScrollPane3.setViewportView(TABELA2);

        txtCidade2.setBackground(new java.awt.Color(102, 102, 102));
        txtCidade2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtCidade2.setForeground(new java.awt.Color(255, 255, 255));
        txtCidade2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "São Bernardo do Campo", "São Caetano", "Santo André", "Mauá", "Diadema" }));
        txtCidade2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCidade2.setPreferredSize(new java.awt.Dimension(229, 24));
        txtCidade2.setRequestFocusEnabled(false);

        txtCidade1.setBackground(new java.awt.Color(102, 102, 102));
        txtCidade1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        txtCidade1.setForeground(new java.awt.Color(255, 255, 255));
        txtCidade1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "São Bernardo do Campo", "São Caetano", "Santo André", "Mauá", "Diadema" }));
        txtCidade1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCidade1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblCidade1.setForeground(new java.awt.Color(102, 102, 102));
        lblCidade1.setText("CIDADE 1");

        lblCidade2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblCidade2.setForeground(new java.awt.Color(102, 102, 102));
        lblCidade2.setText("CIDADE 2");

        btnCONSULTA2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        btnCONSULTA2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/SEARCH_64.png"))); // NOI18N
        btnCONSULTA2.setBorder(null);
        btnCONSULTA2.setContentAreaFilled(false);
        btnCONSULTA2.setPreferredSize(new java.awt.Dimension(90, 40));
        btnCONSULTA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONSULTA2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PAINEL2Layout = new javax.swing.GroupLayout(PAINEL2);
        PAINEL2.setLayout(PAINEL2Layout);
        PAINEL2Layout.setHorizontalGroup(
            PAINEL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAINEL2Layout.createSequentialGroup()
                .addGroup(PAINEL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAINEL2Layout.createSequentialGroup()
                        .addGroup(PAINEL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PAINEL2Layout.createSequentialGroup()
                                .addGap(308, 308, 308)
                                .addComponent(lblCidade1)
                                .addGap(180, 180, 180))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAINEL2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)))
                        .addComponent(btnCONSULTA2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PAINEL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PAINEL2Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(txtCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PAINEL2Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(lblCidade2)))
                        .addGap(0, 119, Short.MAX_VALUE))
                    .addGroup(PAINEL2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        PAINEL2Layout.setVerticalGroup(
            PAINEL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAINEL2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PAINEL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAINEL2Layout.createSequentialGroup()
                        .addComponent(lblCidade1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PAINEL2Layout.createSequentialGroup()
                        .addComponent(lblCidade2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCONSULTA2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PAINEL0.add(PAINEL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 186, 1149, -1));

        TABELA3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        TABELA3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DOENÇA", "CIDADE", "HABITANTES", "INFECTADOS", "MORTES", "VACINADOS", "COLETAS", "% INFECTADOS", "ATUALIZAÇÃO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TABELA3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TABELA3.setRowHeight(40);
        TABELA3.setRowMargin(10);
        jScrollPane4.setViewportView(TABELA3);

        txtData1.setBackground(new java.awt.Color(102, 102, 102));
        txtData1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtData1.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtData1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        txtData1.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        txtData1.setSelectionColor(new java.awt.Color(102, 102, 102));

        txtData2.setBackground(new java.awt.Color(102, 102, 102));
        txtData2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtData2.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtData2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        txtData2.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        txtData2.setSelectionColor(new java.awt.Color(102, 102, 102));

        lblData1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblData1.setForeground(new java.awt.Color(102, 102, 102));
        lblData1.setText("DATA 1");

        lblData2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        lblData2.setForeground(new java.awt.Color(102, 102, 102));
        lblData2.setText("DATA 2");

        btnCONSULTA3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        btnCONSULTA3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/SEARCH_64.png"))); // NOI18N
        btnCONSULTA3.setBorder(null);
        btnCONSULTA3.setContentAreaFilled(false);
        btnCONSULTA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONSULTA3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PAINEL3Layout = new javax.swing.GroupLayout(PAINEL3);
        PAINEL3.setLayout(PAINEL3Layout);
        PAINEL3Layout.setHorizontalGroup(
            PAINEL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAINEL3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PAINEL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAINEL3Layout.createSequentialGroup()
                        .addGroup(PAINEL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PAINEL3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblData1)))
                        .addGap(110, 110, 110)
                        .addComponent(btnCONSULTA3)
                        .addGap(110, 110, 110)
                        .addGroup(PAINEL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PAINEL3Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lblData2)))
                        .addGap(229, 229, 229))))
        );
        PAINEL3Layout.setVerticalGroup(
            PAINEL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAINEL3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PAINEL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAINEL3Layout.createSequentialGroup()
                        .addGroup(PAINEL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblData1)
                            .addComponent(lblData2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PAINEL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCONSULTA3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PAINEL0.add(PAINEL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, -1, -1));

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
            .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(PAINEL_BARRA_VERDE_INFERIORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblEmail)
                        .addComponent(lblSuporte))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 521, Short.MAX_VALUE)
                    .addComponent(lblSemestre)
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
                            .addComponent(lblSemestre)))
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        btnSELECIONE.setBackground(new java.awt.Color(147, 170, 97));
        btnSELECIONE.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        btnSELECIONE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "1 Cidade", "2 Cidade", "Intervalo de Tempo", " " }));
        btnSELECIONE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(147, 170, 97), 2, true));
        btnSELECIONE.setRequestFocusEnabled(false);
        btnSELECIONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSELECIONEActionPerformed(evt);
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

        btnCIDADE.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        btnCIDADE.setForeground(new java.awt.Color(0, 0, 0));
        btnCIDADE.setText("Cidades");
        btnCIDADE.setBorder(null);
        btnCIDADE.setContentAreaFilled(false);
        btnCIDADE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCIDADE.setPreferredSize(new java.awt.Dimension(86, 28));
        btnCIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCIDADEActionPerformed(evt);
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

        lblComparacoes.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        lblComparacoes.setForeground(new java.awt.Color(147, 170, 97));
        lblComparacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComparacoes.setText("Relatórios");
        lblComparacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(PAINEL0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(btnDOENCA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSELECIONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217)))
                .addComponent(btnSAIR))
            .addComponent(PAINEL_BARRA_VERDE_INFERIOR, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDOENCA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(btnSELECIONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSAIR))
                        .addGap(26, 26, 26)
                        .addComponent(PAINEL0, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(PAINEL_BARRA_VERDE_INFERIOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Evento ao clicar no btnCONSULTA1 
    private void btnCONSULTA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONSULTA1ActionPerformed

        // Tratamento de exceções
        try {
            // Obtém o valor do ComboBox e armazena na variável respectiva
            String xCidade = txtCidade.getSelectedItem().toString();

            // Executa uma instrução SQL de seleção após conectar com o banco de dados
            // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
            pst = c.conectaBD().prepareStatement("select nomeDoenca,sintomaDoenca,nomeCidade,numHabitantes from cidade join doenca on idDoenca = id_Doenca where nomeCidade = ?;");

            pst.setString(1, xCidade);

            TabelaCompara1();// Metódo de Atualizar para Atualizar Tabela1

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Consulta 1 : " + erro); // Mensagem de erro
        }
    }//GEN-LAST:event_btnCONSULTA1ActionPerformed

    // Evento ao clicar no btnCONSULTA3 
    private void btnCONSULTA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONSULTA3ActionPerformed

        // Tratamento de exceções
        try {

            // Obtém o valor dos campos de textos e armazena nas variáveis respectivas
            
            String xData1 = txtData1.getText();
            String xData2 = txtData2.getText();

            // Executa uma instrução SQL de seleção após conectar com o banco de dados
            // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente]
            
            pst = c.conectaBD().prepareStatement("select * from cidade join doenca on idDoenca = id_Doenca where dataAtualizacao between  ? and ?;");

            pst.setString(1, xData1);
            pst.setString(2, xData2);

            TabelaCompara3();// Metódo de Atualizar para Atualizar Tabela3

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Consulta 3 : " + erro); // Mensagem de erro
        }
    }//GEN-LAST:event_btnCONSULTA3ActionPerformed

    // Evento ao clicar no btnCONSULTA2 
    private void btnCONSULTA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONSULTA2ActionPerformed

        // Tratamento de exceções
        try {

            // Obtém o valor dos ComboBox e armazena na variáveis respectivas
            
            String xCidade1 = txtCidade1.getSelectedItem().toString();
            String xCidade2 = txtCidade2.getSelectedItem().toString();

            // Executa uma instrução SQL de seleção após conectar com o banco de dados
            // Os valores dos parâmetros da instrução SQL são definidos usando o método setString() do objeto pst passando o índice do parâmetro e o valor correspondente
            
            pst = c.conectaBD().prepareStatement("select nomeDoenca,sintomaDoenca,nomeCidade,numHabitantes from cidade join doenca on idDoenca = id_Doenca where nomeCidade = ? or nomeCidade = ?;");

            pst.setString(1, xCidade1);
            pst.setString(2, xCidade2);

            TabelaCompara2();// Metódo de Atualizar para Atualizar Tabela2

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Consulta 2 : " + erro); // Mensagem de erro
        }
    }//GEN-LAST:event_btnCONSULTA2ActionPerformed

    // Evento ao clicar no btnSELECIONE(ComboBox) e Irá selecionar o Relatório escolhido pelo usuário
    private void btnSELECIONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSELECIONEActionPerformed
        if (btnSELECIONE.getSelectedItem() == "1 Cidade") {

            PAINEL1.setVisible(true);

            PAINEL2.setVisible(false);

            PAINEL3.setVisible(false);

        }
        if (btnSELECIONE.getSelectedItem() == "2 Cidade") {

            PAINEL2.setVisible(true);

            PAINEL1.setVisible(false);

            PAINEL3.setVisible(false);
        }
        if (btnSELECIONE.getSelectedItem() == "Intervalo de Tempo") {

            PAINEL3.setVisible(true);

            PAINEL1.setVisible(false);

            PAINEL2.setVisible(false);

        }
    }//GEN-LAST:event_btnSELECIONEActionPerformed

    // Evento ao clicar no btnDOENCA 
    private void btnDOENCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDOENCAActionPerformed
        TELA_1_DOENÇA d = new TELA_1_DOENÇA(); // Instância da classe TELA_1_DOENCA
        this.dispose(); // Fecha janela atual 
        d.setVisible(true); // Exibe a TELA_1_DOENCA
    }//GEN-LAST:event_btnDOENCAActionPerformed

    // Evento ao clicar no btnCIDADE 
    private void btnCIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCIDADEActionPerformed
        TELA_2_CIDADE c = new TELA_2_CIDADE(); // Instância da classe TELA_2_CIDADE
        this.dispose(); // Fecha janela atual 
        c.setVisible(true); // Exibe a TELA_2_CIDADE
    }//GEN-LAST:event_btnCIDADEActionPerformed

    // Evento ao clicar no btnSAIR e Fecha janela caso o usuário escolha "SIM"
    private void btnSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAIRActionPerformed
        JFrame frame = new JFrame("SAIR");
        if (JOptionPane.showConfirmDialog(frame, "Deseja sair ?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSAIRActionPerformed

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
            java.util.logging.Logger.getLogger(TELA_3_RELATORIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TELA_3_RELATORIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TELA_3_RELATORIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TELA_3_RELATORIOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TELA_3_RELATORIOS().setVisible(true);
            }
        });
    }

    // Variáveis da Interface Gráfica
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PAINEL0;
    private javax.swing.JPanel PAINEL1;
    private javax.swing.JPanel PAINEL2;
    private javax.swing.JPanel PAINEL3;
    private javax.swing.JPanel PAINEL_BARRA_PRETA_INFERIOR;
    private javax.swing.JPanel PAINEL_BARRA_VERDE_INFERIOR;
    private javax.swing.JTable TABELA1;
    private javax.swing.JTable TABELA2;
    private javax.swing.JTable TABELA3;
    private javax.swing.JButton btnCIDADE;
    private javax.swing.JButton btnCONSULTA1;
    private javax.swing.JButton btnCONSULTA2;
    private javax.swing.JButton btnCONSULTA3;
    private javax.swing.JButton btnDOENCA;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JComboBox<String> btnSELECIONE;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCidade1;
    private javax.swing.JLabel lblCidade2;
    private javax.swing.JLabel lblComparacoes;
    private javax.swing.JLabel lblData1;
    private javax.swing.JLabel lblData2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblSuporte;
    private javax.swing.JButton lblUNIP;
    private javax.swing.JComboBox<String> txtCidade;
    private javax.swing.JComboBox<String> txtCidade1;
    private javax.swing.JComboBox<String> txtCidade2;
    private javax.swing.JFormattedTextField txtData1;
    private javax.swing.JFormattedTextField txtData2;
    // End of variables declaration//GEN-END:variables
}
