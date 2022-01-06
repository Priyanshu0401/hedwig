import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.ASAPPeer;

import java.io.IOException;

public class Hedwig implements AsapStarterAPI{

    private ASAPPeer peer;

    @Override
    public void sendPackage(DeliveryPackage deliveryPackage) throws ASAPException, IOException {
        // need to send a message
        // 1st: serialize it:
        PackageSerDe serializer = new PackageSerDe(
                deliveryPackage.getRecipient(),
                deliveryPackage.getPackage());

        byte[] serializedMessage = serializer.getSerializedPackage();

        // define a uri if you like
        String uri = "HarryPotter://hedwigA";
        // 2nd: send it with ASAP peer
        this.peer.sendASAPMessage(APP_FORMAT, uri, serializedMessage);

    }
}
