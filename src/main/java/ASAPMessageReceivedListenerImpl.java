import net.sharksystem.asap.ASAPHop;
import net.sharksystem.asap.ASAPMessageReceivedListener;
import net.sharksystem.asap.ASAPMessages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ASAPMessageReceivedListenerImpl implements ASAPMessageReceivedListener {
    private final String peerName;

    ASAPMessageReceivedListenerImpl(String peerName) {
        this.peerName = peerName;
    }

    public ASAPMessageReceivedListenerImpl() {
        this(null);
    }

    @Override
    public void asapMessagesReceived(ASAPMessages messages,
                                     String senderE2E, // E2E part
                                     List<ASAPHop> asapHop) throws IOException {

        CharSequence format = messages.getFormat();
        CharSequence uri = messages.getURI();
        if (peerName != null) {
            System.out.print(peerName);
        }

        System.out.println("asap message received (" + format + " | " + uri + "). size == " + messages.size());
        Iterator<byte[]> yourPDUIter = messages.getMessages();
        while (yourPDUIter.hasNext()) {
            MyUtils.deserializeExample(yourPDUIter.next());
        }
    }
}
