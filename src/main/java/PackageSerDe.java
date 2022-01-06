import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.utils.ASAPSerialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PackageSerDe implements DeliveryPackage {

    private String recipient, deliveryPackage;
    private byte[] serializedPackage;


    PackageSerDe(String recipient, String deliveryPackage) throws IOException {
        this.recipient = recipient;
        this.deliveryPackage = deliveryPackage;
        this.serialize();
    }

    private void serialize() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ASAPSerialization.writeCharSequenceParameter(this.recipient, baos);
        ASAPSerialization.writeCharSequenceParameter(this.deliveryPackage, baos);
        this.serializedPackage = baos.toByteArray();
    }

    PackageSerDe(byte[] serializedMessage) {
        this.serializedPackage = serializedMessage;
        this.deserialize();
    }

    private void deserialize() throws IOException, ASAPException {
        InputStream is = new ByteArrayInputStream(this.serializedPackage);
        this.recipient = ASAPSerialization.readCharSequenceParameter(is);
        this.deliveryPackage = ASAPSerialization.readCharSequenceParameter(is);
    }


    @Override
    public String getRecipient() {
        return this.recipient;
    }

    @Override
    public String getPackage() {
        return this.deliveryPackage;
    }

    public void sendPackage(DeliveryPackage deliveryPackage) {
        System.out.println("sending package");

    }


    byte[] getSerializedPackage() { return this.serializedPackage;}
}
