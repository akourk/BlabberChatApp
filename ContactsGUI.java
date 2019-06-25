/**
 * CLASS:       CS410 Software Engineering
 * ASSIGNMENT:  Development Phase 1
 * TEAM:        Brandae Grein, Michael Thomas, Alex Kourkoumelis, Matthew Clark, Jordi Monterrubio
**/

// Package Main.
package BlabberVMichaels;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

public class ContactsGUI extends javax.swing.JFrame
{
    private LogIn login = new LogIn();
    public Color BlabberBackground = new Color(12, 130, 186);
    private String username;
    private ArrayList<JPanel> allContactPanels;
    private int arrayIndex;
    private final Border border = BorderFactory.createStrokeBorder(new BasicStroke(5.0f));

    // Chat App
    private JFrame frm = new JFrame("Blabber Conversation");
    private JPanel pnl = new JPanel();
    private JTextArea chatTxt = new JTextArea(20,3);
    private JTextField msgTxt = new JTextField("Input Text Here", 20);
    private String chatLog = "Conversations History Will Not Be Stored \n\n";

    private void setAllNames()
    {
        usernameContact1.setText("Contact 1");
        usernameContact2.setText("Contact 2");
        usernameContact3.setText("Contact 3");
        usernameContact4.setText("Contact 4");
        usernameContact5.setText("Contact 5");
        usernameContact6.setText("Contact 6");


    }
    
    public ContactsGUI(Color color)
    {
        if(color != BlabberBackground){
            BlabberBackground = color;
        }
        initComponents();
        setAllNames();
        getContentPane().setBackground( BlabberBackground );
        contactPanel.setBorder(border);
        contactPanel.setBackground(Color.WHITE);
        contactPanel1.setBorder(border);
        contactPanel1.setBackground(Color.WHITE);
        contactPanel2.setBorder(border);
        contactPanel2.setBackground(Color.WHITE);
        contactPanel3.setBorder(border);
        contactPanel3.setBackground(Color.WHITE);
        contactPanel4.setBorder(border);
        contactPanel4.setBackground(Color.WHITE);
        contactPanel5.setBorder(border);
        contactPanel5.setBackground(Color.WHITE);
    }
    
    public void getUsername(String _username)
    {
        username = _username;
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setText("Welcome to Blabberland, " + username + "!");
    }
    
    public void createArrayList()
    {
        allContactPanels = new ArrayList<JPanel>();
        allContactPanels.add(contactPanel);
        allContactPanels.add(contactPanel1);
        allContactPanels.add(contactPanel2);
        allContactPanels.add(contactPanel3);
        allContactPanels.add(contactPanel4);
        allContactPanels.add(contactPanel5);
        arrayIndex = 6;
    }
    
    public void addContact(String username)
    {
        allContactPanels.add(contactPanel);
        arrayIndex++;
        for (Component jc : allContactPanels.get(arrayIndex).getComponents())
        {
            if ( jc instanceof JLabel )
            {
                ((JLabel) jc).setText(username);
            }
        }
        allContactPanels.get(arrayIndex).setBorder(border);
    }

    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        jFrame1 = new javax.swing.JFrame();
        jMenuItem1 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        welcomeText = new javax.swing.JLabel();
        startConversationButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        contactPanel = new javax.swing.JPanel();
        usernameContact1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        contactPanel1 = new javax.swing.JPanel();
        usernameContact2 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        contactPanel2 = new javax.swing.JPanel();
        usernameContact3 = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        contactPanel3 = new javax.swing.JPanel();
        usernameContact4 = new javax.swing.JLabel();
        jToggleButton4 = new javax.swing.JToggleButton();
        jCheckBox4 = new javax.swing.JCheckBox();
        contactPanel4 = new javax.swing.JPanel();
        usernameContact5 = new javax.swing.JLabel();
        jToggleButton5 = new javax.swing.JToggleButton();
        jCheckBox5 = new javax.swing.JCheckBox();
        contactPanel5 = new javax.swing.JPanel();
        usernameContact6 = new javax.swing.JLabel();
        jToggleButton6 = new javax.swing.JToggleButton();
        jCheckBox6 = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blabber Contacts");
        setBackground(new java.awt.Color(255, 255, 255));

        welcomeText.setFont(new java.awt.Font("Abadi MT Condensed Extra Bold", 1, 22));
        welcomeText.setForeground(new java.awt.Color(255, 255, 255));
        welcomeText.setText("jLabel1");

        startConversationButton.setFont(new java.awt.Font("Abadi MT Condensed Extra Bold", 1, 14));
        startConversationButton.setText("Start Conversation");
        startConversationButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startConversationButtonActionPerformed(evt);
            }
        });

        // Contact Panel
        contactPanel.setPreferredSize(new java.awt.Dimension(265, 105));
        usernameContact1.setFont(new java.awt.Font("Abadi MT Condensed Extra Bold", 0, 18));
        usernameContact1.setText("jLabel1");
        jToggleButton1.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jToggleButton1.setText("Block user?");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener()
        {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
            jToggleButton3ActionPerformed(evt);
        }
        });
        jCheckBox1.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        jCheckBox1.setText("Add to Conversation");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton3ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout contactPanelLayout = new javax.swing.GroupLayout(contactPanel);
        contactPanel.setLayout(contactPanelLayout);
        contactPanelLayout.setHorizontalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(usernameContact1))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        contactPanelLayout.setVerticalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(usernameContact1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addGap(18, 18, 18))
        );

        // Contact Panel 1
        contactPanel1.setPreferredSize(new java.awt.Dimension(265, 105));
        usernameContact2.setFont(new java.awt.Font("Abadi MT Condensed Extra Bold", 0, 18));
        usernameContact2.setText("jLabel1");
        jToggleButton2.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jToggleButton2.setText("Block user?");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jCheckBox2.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        jCheckBox2.setText("Add to Conversation");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox3ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout contactPanel1Layout = new javax.swing.GroupLayout(contactPanel1);
        contactPanel1.setLayout(contactPanel1Layout);
        contactPanel1Layout.setHorizontalGroup(
            contactPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(contactPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2)
                    .addComponent(usernameContact2))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        contactPanel1Layout.setVerticalGroup(
            contactPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(usernameContact2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2)
                .addGap(18, 18, 18))
        );

        // Contact Panel 2
        contactPanel2.setPreferredSize(new java.awt.Dimension(265, 105));
        usernameContact3.setFont(new java.awt.Font("Abadi MT Condensed Extra Bold", 0, 18));
        usernameContact3.setText("jLabel1");
        jToggleButton3.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jToggleButton3.setText("Block user?");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jCheckBox3.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        jCheckBox3.setText("Add to Conversation");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox3ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout contactPanel2Layout = new javax.swing.GroupLayout(contactPanel2);
        contactPanel2.setLayout(contactPanel2Layout);
        contactPanel2Layout.setHorizontalGroup(
            contactPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(contactPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox3)
                    .addComponent(usernameContact3))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        contactPanel2Layout.setVerticalGroup(
            contactPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(usernameContact3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3)
                .addGap(18, 18, 18))
        );

        // Contact Pane1 3
        contactPanel3.setPreferredSize(new java.awt.Dimension(265, 105));
        usernameContact4.setFont(new java.awt.Font("Abadi MT Condensed Extra Bold", 0, 18));
        usernameContact4.setText("jLabel1");
        jToggleButton4.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jToggleButton4.setText("Block user?");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jCheckBox4.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        jCheckBox4.setText("Add to Conversation");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox3ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout contactPanel3Layout = new javax.swing.GroupLayout(contactPanel3);
        contactPanel3.setLayout(contactPanel3Layout);
        contactPanel3Layout.setHorizontalGroup(
            contactPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(contactPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4)
                    .addComponent(usernameContact4))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        contactPanel3Layout.setVerticalGroup(
            contactPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(usernameContact4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton4)
                .addGap(18, 18, 18))
        );

        // Contact Pane1 4
        contactPanel4.setPreferredSize(new java.awt.Dimension(265, 105));
        usernameContact5.setFont(new java.awt.Font("Abadi MT Condensed Extra Bold", 0, 18));
        usernameContact5.setText("jLabel1");
        jToggleButton5.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jToggleButton5.setText("Block user?");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jCheckBox5.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        jCheckBox5.setText("Add to Conversation");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox3ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout contactPanel4Layout = new javax.swing.GroupLayout(contactPanel4);
        contactPanel4.setLayout(contactPanel4Layout);
        contactPanel4Layout.setHorizontalGroup(
            contactPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(contactPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox5)
                    .addComponent(usernameContact5))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        contactPanel4Layout.setVerticalGroup(
            contactPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(usernameContact5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton5)
                .addGap(18, 18, 18))
        );

        // Contact Pane1 5
        contactPanel5.setPreferredSize(new java.awt.Dimension(265, 105));
        usernameContact6.setFont(new java.awt.Font("Abadi MT Condensed Extra Bold", 0, 18));
        usernameContact6.setText("jLabel1");
        jToggleButton6.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jToggleButton6.setText("Block user?");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jCheckBox6.setFont(new java.awt.Font("Lucida Grande", 0, 12));
        jCheckBox6.setText("Add to Conversation");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox3ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout contactPanel5Layout = new javax.swing.GroupLayout(contactPanel5);
        contactPanel5.setLayout(contactPanel5Layout);
        contactPanel5Layout.setHorizontalGroup(
            contactPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contactPanel5Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(contactPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBox6)
                        .addComponent(usernameContact6))
                    .addContainerGap(110, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactPanel5Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35))
        );
        contactPanel5Layout.setVerticalGroup(
            contactPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(usernameContact6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton6)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(0, Short.MAX_VALUE))
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(0, Short.MAX_VALUE))
        );

        scrollPane.setViewportView(jPanel1);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        // Layout Horizontal
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startConversationButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        // Layout Vertical
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(welcomeText)
                .addGap(0, 0, 0)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startConversationButton)
                .addGap(0, 0, 0))
        );
        pack();
    }

    // Start conversation button clicked and socket connection created.
    // Passing username and socket to MessagesGUI.
    private void startConversationButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
//            MessagesGUI newMessage = new MessagesGUI(username, socket);
//            newMessage.setVisible(true);
//            setVisible(false);
        try
        {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Client connected...");

            // Implement GUI
            pnl.setLayout(new BorderLayout());
            pnl.add(new JScrollPane(chatTxt), BorderLayout.CENTER);
            pnl.add(msgTxt, BorderLayout.SOUTH);
            frm.add(pnl);

            msgTxt.addKeyListener(new KeyListener()
            {
                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyReleased(KeyEvent e)
                {
                    if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    {
                        String message = msgTxt.getText();
                        PrintWriter outStream;
                        try
                        {
                            outStream = new PrintWriter(socket.getOutputStream());
                            outStream.println(username + ": " + message);
                            outStream.flush();
                        }
                        catch(IOException e1)
                        {
                            e1.printStackTrace();
                        }
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {}
            });

            frm.setPreferredSize(new Dimension(400, 400));
            frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frm.setVisible(true);
            frm.pack();

            ContactsGUIThread messagesGUIThread = new ContactsGUIThread(this, socket);
            messagesGUIThread.start();
        }catch(IOException e){e.printStackTrace();}
    }

    public void updateView(String message)
    {
        chatLog += message + "\n";
        chatTxt.setText(chatLog);
    }

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt)
    {
        // TODO add your handling code here:
    }

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt)
    {
            // TODO add your handling code here:
    }

//    public static void main(String args[])
//    {
//        try
//        {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
//            {
//                if ("Nimbus".equals(info.getName()))
//                {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MessagesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MessagesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MessagesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MessagesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        java.awt.EventQueue.invokeLater(new Runnable()
//        {
//            public void run()
//            {
//                new MessagesGUI().setVisible(true);
//            }
//        });
//    }

    private javax.swing.JPanel contactPanel;
    private javax.swing.JPanel contactPanel1;
    private javax.swing.JPanel contactPanel2;
    private javax.swing.JPanel contactPanel3;
    private javax.swing.JPanel contactPanel4;
    private javax.swing.JPanel contactPanel5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton startConversationButton;
    private javax.swing.JLabel usernameContact1;
    private javax.swing.JLabel usernameContact2;
    private javax.swing.JLabel usernameContact3;
    private javax.swing.JLabel usernameContact4;
    private javax.swing.JLabel usernameContact5;
    private javax.swing.JLabel usernameContact6;
    private javax.swing.JLabel welcomeText;
}
