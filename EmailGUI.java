
package my;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class EmailGUI extends javax.swing.JFrame {

    private DefaultListModel messageListModel = new DefaultListModel();
    private SpinnerNumberModel spinModel = new SpinnerNumberModel(1, 1, 5, 1);
    public static IMAPClient client = new IMAPClient("imap.gmail.com", "nick.jalalizadeh@gmail.com", "Jalalizadeh3");
    private String[] folders = {"INBOX", "[Gmail]/Starred", "[Gmail]/Sent Mail", "[Gmail]/Drafts", "[Gmail]/Important", "[Gmail]/Spam", "[Gmail]/Trash"};
    private String[] badFilenames = {".exe", ".pdf", ".hta", ".jar", ".bat", ".inf"};
    private String[] spamWords = {"for cheap", "buy direct", "clearance", "meet singles", "money making", "$$$", "we hate spam", "this isn't spam"};
    private Boolean folderChanging;
    private List<myMessage> msgs = new ArrayList<>();
    
    private static JFrame frame = null;
            
    public EmailGUI() throws MessagingException, IOException {
        initComponents();
        
        //initClient();
        client.getFolder(folders[0], 0);
        //client.getFolder(folders[5], 5);
    }
    
    private void initClient() throws MessagingException, IOException {
        for (int i = 0; i < folders.length; i++)
            client.getFolder(folders[i], i);
        folderList.setSelectedIndex(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        folderList = new javax.swing.JList<>();
        refreshButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageList = new javax.swing.JList<>();
        pageSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        sortBox = new javax.swing.JComboBox<>();
        ascendButton = new javax.swing.JRadioButton();
        descendButton = new javax.swing.JRadioButton();
        SortLabel = new javax.swing.JLabel();
        PerPageLabel = new javax.swing.JLabel();
        perPageBox = new javax.swing.JComboBox<>();
        searchTypeBox = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        SearchByLabel = new javax.swing.JLabel();
        SearchLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        FromLabel = new javax.swing.JLabel();
        fromField = new javax.swing.JLabel();
        toField = new javax.swing.JLabel();
        ToLabel = new javax.swing.JLabel();
        subjectField = new javax.swing.JLabel();
        SubjectLabel = new javax.swing.JLabel();
        dateField = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        recoverButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        attachmentField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        folderList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Inbox", "Starred", "Sent Mail", "Drafts", "Important", "Spam", "Trash" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        folderList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                folderListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(folderList);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(53, 53, 53))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        messageList.setToolTipText("");
        messageList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                messageListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(messageList);

        pageSpinner.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        pageSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1, 1));
        pageSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pageSpinnerStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Page:");

        sortBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "From", "To", "Size", "Subject" }));
        sortBox.setRequestFocusEnabled(false);
        sortBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortBoxActionPerformed(evt);
            }
        });

        buttonGroup2.add(ascendButton);
        ascendButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ascendButton.setText("Ascending");
        ascendButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ascendButtonItemStateChanged(evt);
            }
        });

        buttonGroup2.add(descendButton);
        descendButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descendButton.setSelected(true);
        descendButton.setText("Descending");
        descendButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                descendButtonItemStateChanged(evt);
            }
        });

        SortLabel.setText("Sort:");

        PerPageLabel.setText("Per Page:");

        perPageBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "20", "50" }));
        perPageBox.setSelectedIndex(2);
        perPageBox.setRequestFocusEnabled(false);
        perPageBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perPageBoxActionPerformed(evt);
            }
        });

        searchTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Address", "File Name" }));
        searchTypeBox.setRequestFocusEnabled(false);

        searchButton.setText("Go");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        SearchByLabel.setText("Search By:");

        SearchLabel.setText("Search:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SortLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PerPageLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchByLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ascendButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(descendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(perPageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))
                    .addComponent(searchTypeBox, 0, 255, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchByLabel)
                    .addComponent(searchTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(SearchLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SortLabel)
                    .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ascendButton)
                    .addComponent(descendButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PerPageLabel)
                    .addComponent(perPageBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setToolTipText("");

        FromLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        FromLabel.setForeground(new java.awt.Color(51, 51, 255));
        FromLabel.setText("From");

        fromField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fromField.setToolTipText("");

        toField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        toField.setToolTipText("");

        ToLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ToLabel.setForeground(new java.awt.Color(51, 51, 255));
        ToLabel.setText("To");

        subjectField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        subjectField.setToolTipText("");

        SubjectLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubjectLabel.setForeground(new java.awt.Color(51, 51, 255));
        SubjectLabel.setText("Subject");

        dateField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dateField.setToolTipText("");

        DateLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DateLabel.setForeground(new java.awt.Color(51, 51, 255));
        DateLabel.setText("Date");

        messageArea.setEditable(false);
        messageArea.setColumns(20);
        messageArea.setRows(5);
        jScrollPane3.setViewportView(messageArea);

        recoverButton.setText("Recover");
        recoverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recoverButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("Attachments");

        attachmentField.setEditable(false);
        attachmentField.setColumns(20);
        attachmentField.setRows(5);
        jScrollPane5.setViewportView(attachmentField);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ToLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FromLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(SubjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                            .addComponent(fromField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subjectField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(recoverButton)
                        .addGap(15, 15, 15)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dateField, fromField, subjectField, toField});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fromField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FromLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ToLabel)
                    .addComponent(toField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubjectLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subjectField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(recoverButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateField, fromField, subjectField, toField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateList() {
        folderChanging = true;
        int perPage = Integer.parseInt((String)perPageBox.getSelectedItem());
        int page = (int)pageSpinner.getValue() - 1;
        int max = msgs.size() / perPage + (int)((msgs.size() % perPage == 0)? 0 : 1);
        
        messageList.clearSelection();
        messageListModel.clear();
        for (int i = page * perPage; i < (page * perPage + perPage) && i < msgs.size(); i++) {
            messageListModel.addElement(msgs.get(i).subject);
        }
        spinModel.setMaximum(max);
        spinModel.setValue(1);
        pageSpinner.setModel(spinModel);
        messageList.setModel(messageListModel);
        folderChanging = false;
    }
    
    private void sortMessages() {
        switch((String)sortBox.getSelectedItem()) {
            case "Date":
                Collections.sort(msgs, (myMessage o1, myMessage o2) -> 
                    Integer.toString(o1.sentDateInt).compareTo(Integer.toString(o2.sentDateInt))); break;
            case "From":
                Collections.sort(msgs, (myMessage o1, myMessage o2) ->
                    o1.sender.toLowerCase().compareTo(o2.sender.toLowerCase())); break;
            case "To":
                Collections.sort(msgs, (myMessage o1, myMessage o2) ->
                    o1.receiver.toLowerCase().compareTo(o2.receiver.toLowerCase())); break;
            case "Size":
                Collections.sort(msgs, (myMessage o1, myMessage o2) -> 
                    Integer.toString(o1.size).compareTo(Integer.toString(o2.size))); break;
            case "Subject":
                Collections.sort(msgs, (myMessage o1, myMessage o2) ->
                    o1.subject.toLowerCase().compareTo(o2.subject.toLowerCase())); break;
        }
        if (descendButton.isSelected())
            Collections.reverse(msgs);
}
    
    private void folderListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_folderListValueChanged
        if (evt.getValueIsAdjusting() == false) {
            //clear msgs as well as reduces size to 0
            msgs.subList(0, msgs.size()).clear();
            //Important to copy the lists such the the elements are separate
            //Do not copy the objects themselves
            for (myMessage message : client.msgInfo.get(folderList.getSelectedIndex())) {
                msgs.add(message);
            }
            sortMessages();
            updateList();
        }
    }//GEN-LAST:event_folderListValueChanged

    private void messageListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_messageListValueChanged
        if (evt.getValueIsAdjusting() == false) {
            if (folderChanging == false) {
                String attachText = "";
                int perPage = Integer.parseInt((String)perPageBox.getSelectedItem());
                int page = (int)pageSpinner.getValue() - 1;
                int messageIndex = messageList.getSelectedIndex() + page * perPage;

                fromField.setText(msgs.get(messageIndex).sender);
                toField.setText(msgs.get(messageIndex).receiver);
                subjectField.setText(msgs.get(messageIndex).subject);
                dateField.setText(msgs.get(messageIndex).sentDate);
                messageArea.setText(msgs.get(messageIndex).content);
                if (!msgs.get(messageIndex).filenames.isEmpty())
                    for (String file : msgs.get(messageIndex).filenames) 
                        attachText += file + '\n';
                attachmentField.setText(attachText);
                
                /*Malware Detection*/
                //Check if any string from badFilenames is contained in attachText
                if (Arrays.stream(badFilenames).parallel().anyMatch(attachText::contains)) {
                    JOptionPane.showMessageDialog(frame, "Warning: The following message may contain files that can be harmful to your computer.", 
                        "Malware Detector", JOptionPane.WARNING_MESSAGE);
                }
                //Check if any string from spam words is contained in either subject or content of message
                if (Arrays.stream(spamWords).parallel().anyMatch(msgs.get(messageIndex).subject.toLowerCase()::contains) || 
                        Arrays.stream(spamWords).parallel().anyMatch(msgs.get(messageIndex).content.toLowerCase()::contains)) {
                    JOptionPane.showMessageDialog(frame, "Warning: The following message has been flagged as spam.", "Spam Detector", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        client.sendToSpam(msgs.get(messageIndex).message);
                    } catch (MessagingException ex) {
                        Logger.getLogger(EmailGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_messageListValueChanged

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int perPage = Integer.parseInt((String)perPageBox.getSelectedItem());
        int page = (int)pageSpinner.getValue() - 1;
        int messageIndex = messageList.getSelectedIndex() + page * perPage;
        
        try {
            client.deleteMessage(msgs.get(messageIndex).message);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void recoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recoverButtonActionPerformed
        if ("[Gmail]/Trash".equals(client.folders[folderList.getSelectedIndex()].getFullName())) {
            int perPage = Integer.parseInt((String)perPageBox.getSelectedItem());
            int page = (int)pageSpinner.getValue() - 1;
            int messageIndex = messageList.getSelectedIndex() + page * perPage;
        
            try {
                client.recoverMessage(msgs.get(messageIndex).message);
            } catch (MessagingException ex) {
                Logger.getLogger(EmailGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_recoverButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        int folderIndex = folderList.getSelectedIndex();
        try {
            client.getFolder(folders[folderIndex], folderIndex);
            updateList();
        } catch (MessagingException | IOException ex) {
            Logger.getLogger(EmailGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshButtonActionPerformed
    
    private void perPageBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perPageBoxActionPerformed
        updateList();
    }//GEN-LAST:event_perPageBoxActionPerformed

    private void pageSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pageSpinnerStateChanged
        //UPDATE LIST WITHOUT CHANGING SPIN VALUE
        folderChanging = true;
        int perPage = Integer.parseInt((String)perPageBox.getSelectedItem());
        int page = (int)pageSpinner.getValue() - 1;
        int max = msgs.size() / perPage + (int)((msgs.size() % perPage == 0)? 0 : 1);
        
        messageList.clearSelection();
        messageListModel.clear();
        for (int i = page * perPage; i < (page * perPage + perPage) && i < msgs.size(); i++) {
            messageListModel.addElement(msgs.get(i).subject);
        }
        spinModel.setMaximum(max);
        pageSpinner.setModel(spinModel);
        messageList.setModel(messageListModel);
        folderChanging = false;
    }//GEN-LAST:event_pageSpinnerStateChanged

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String name, address, filename;
        String search = searchField.getText().toLowerCase();
        
        msgs.clear();
        switch ((String)searchTypeBox.getSelectedItem()) {
            case "Name:":
                for (List<myMessage> list : client.msgInfo) {
                    for (myMessage message : list) {
                        if (message.sender.contains("<"))
                            name = message.sender.substring(0, message.sender.indexOf('<'));
                        else if (!message.sender.contains("@"))
                            name = message.sender;
                        else continue;

                        if (name.toLowerCase().contains(search))
                            msgs.add(message);
                    }
                }
                break;
            case "Address:":
                for (List<myMessage> list : client.msgInfo) {
                    for (myMessage message : list) {
                        if (message.sender.contains("@"))
                            if (message.sender.contains("<"))
                                address = message.sender.substring(message.sender.indexOf('<') + 1, message.sender.indexOf('>'));
                            else
                                address = message.sender;
                        else continue;
                        
                        if (address.toLowerCase().contains(search))
                            msgs.add(message);
                    }
                }
            case "File Name:":
                for (List<myMessage> list : client.msgInfo) {
                    for (myMessage message : list) {
                        if (!message.filenames.isEmpty())
                            for (String file : message.filenames)
                                if (file.toLowerCase().contains(search)) {
                                    msgs.add(message);
                                    break;
                                }
                    }
                }
        }
        sortMessages();
        updateList();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void descendButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_descendButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Collections.reverse(msgs);
            updateList();
        }
    }//GEN-LAST:event_descendButtonItemStateChanged

    private void sortBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortBoxActionPerformed
        msgs = client.msgInfo.get(folderList.getSelectedIndex());
        sortMessages();
        updateList();
    }//GEN-LAST:event_sortBoxActionPerformed

    private void ascendButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ascendButtonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Collections.reverse(msgs);
            updateList();
        }
    }//GEN-LAST:event_ascendButtonItemStateChanged

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
            java.util.logging.Logger.getLogger(EmailGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmailGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmailGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmailGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new EmailGUI();
                } catch (MessagingException | IOException ex) {
                    Logger.getLogger(EmailGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel FromLabel;
    private javax.swing.JLabel PerPageLabel;
    private javax.swing.JLabel SearchByLabel;
    private javax.swing.JLabel SearchLabel;
    private javax.swing.JLabel SortLabel;
    private javax.swing.JLabel SubjectLabel;
    private javax.swing.JLabel ToLabel;
    private javax.swing.JRadioButton ascendButton;
    private javax.swing.JTextArea attachmentField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel dateField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JRadioButton descendButton;
    private javax.swing.JList<String> folderList;
    private javax.swing.JLabel fromField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea messageArea;
    private javax.swing.JList<String> messageList;
    private javax.swing.JSpinner pageSpinner;
    private javax.swing.JComboBox<String> perPageBox;
    private javax.swing.JButton recoverButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchTypeBox;
    private javax.swing.JComboBox<String> sortBox;
    private javax.swing.JLabel subjectField;
    private javax.swing.JLabel toField;
    // End of variables declaration//GEN-END:variables
}
