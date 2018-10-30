
package my;

import java.util.List;
import javax.mail.Message;

public class myMessage {
    public String sender;
    public String receiver;
    public String subject;
    public String sentDate;
    public int sentDateInt;
    public int size;
    public String content;
    public Message message;
    public List<String> filenames;
    
    public myMessage(String sender, String receiver, String subject, String sentDate, int sentDateInt, int size, String content, List<String> filenames, Message message) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.sentDate = sentDate;
        this.sentDateInt = sentDateInt;
        this.size = size;
        this.content = content;
        this.filenames = filenames;
        this.message = message;
    }
}
