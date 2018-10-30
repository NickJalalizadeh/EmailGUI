package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

public class IMAPClient {
    
    public final int folderSize = 7;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public List<List<myMessage>> msgInfo = new ArrayList<List<myMessage>>();
    public Folder[] folders = new Folder[folderSize];
    private Session session;
    private Store store;
    private String username;
    
   IMAPClient(String host, String user, String password) 
   {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        username = user;
        
        try {
            session = Session.getInstance(props, null);
            store = session.getStore();
            store.connect(host, user, password);

        } catch (Exception mex) {
            mex.printStackTrace();
        }
   }
   
   public void getFolder(String folderName, int index) throws MessagingException, IOException {
        Message[] messageArray;
        Message message;
        Multipart mp;
        MimeBodyPart bp, bp0;
        String sender = "", receiver, subject, sentDate, content = "", contentType;
        List<myMessage> tempMsg = new ArrayList<>();
        int sentDateInt, size;
        
        folders[index] = store.getFolder(folderName);
        folders[index].open(Folder.READ_WRITE);
        messageArray = folders[index].getMessages();
        
        for (int i = 0; i < messageArray.length && i < 50; i++) {
            List<String> filenames = new ArrayList<>();
            message = messageArray[i];
            
            // store details of each message
            if (message.getFrom().length > 0)
                sender = message.getFrom()[0].toString();
            try {
                receiver = message.getAllRecipients()[0].toString();
            } catch (NullPointerException e) {
                receiver = username;
            }
            subject = message.getSubject();
            if (subject == null || "".equals(subject)) 
                subject = "(no subject)";
            sentDate = message.getSentDate().toString();
            sentDateInt = (int) (message.getSentDate().getTime() / 1000);
            size = message.getSize();
            
            //Get Message content
            //filenames.clear();
            contentType =  message.getContentType();
            if (contentType.contains("multipart")) {
                mp = (Multipart) message.getContent();
                for (int j = 1; j < mp.getCount(); j++) {
                    bp = (MimeBodyPart) mp.getBodyPart(j);
                    if (bp.ATTACHMENT.equalsIgnoreCase(bp.getDisposition())) {
                        // this part is attachment
                        filenames.add(bp.getFileName());
                    }
                }
                bp0 = (MimeBodyPart) mp.getBodyPart(0);
                content = bp0.getContent().toString();
            }
            else
                content = message.getContent().toString();
            
            tempMsg.add(new myMessage(sender, receiver, subject, sentDate, sentDateInt, size, content, filenames, message));
        }
        msgInfo.add(tempMsg);
   }

   public void deleteMessage(Message message) throws MessagingException {
        message.setFlag(Flags.Flag.DELETED, true);
        
        //If not in trash, copy to trash
        if (!"[Gmail]/Trash".equals(message.getFolder().getFullName())) {
            List<Message> tempList = new ArrayList<>();
            tempList.add(message);
            Message[] tempMessageArray = tempList.toArray(new Message[tempList.size()]);
            message.getFolder().copyMessages(tempMessageArray, folders[folderSize - 1]);
        }
        message.getFolder().close(true);
   }
   
   public void recoverMessage(Message message) throws MessagingException {
        message.setFlag(Flags.Flag.DELETED, true);

        List<Message> tempList = new ArrayList<>();
        tempList.add(message);
        Message[] tempMessageArray = tempList.toArray(new Message[tempList.size()]);
        message.getFolder().copyMessages(tempMessageArray, folders[0]);
        
        message.getFolder().close(true);
   }
   
   public void sendToSpam(Message message) throws MessagingException {
        List<Message> tempList = new ArrayList<>();
        tempList.add(message);
        Message[] tempMessageArray = tempList.toArray(new Message[tempList.size()]);
        message.getFolder().copyMessages(tempMessageArray, folders[folderSize - 2]);
   }
   
   public static void main() {

   }

}	