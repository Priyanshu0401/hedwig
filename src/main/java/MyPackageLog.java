
public class MyPackageLog {
    private DeliveryPackage deliveryPackage;
    private String takerSignature;
    private String giverSignature;
    private long time = System.currentTimeMillis();

    public DeliveryPackage getMyPackage() {
        return deliveryPackage;
    }

    public void setMyPackage(DeliveryPackage deliveryPackage) {
        this.deliveryPackage = deliveryPackage;
    }

    public String getTakerSignature() {
        return takerSignature;
    }

    public void setTakerSignature(String takerSignature) {
        this.takerSignature = takerSignature;
    }

    public String getGiverSignature() {
        return giverSignature;
    }

    public void setGiverSignature(String giverSignature) {
        this.giverSignature = giverSignature;
    }

    @Override
    public String toString() {
        return "MyPackageLog{" +
                "myPackage=" + deliveryPackage +
                ", takerSignature='" + takerSignature + '\'' +
                ", giverSignature='" + giverSignature + '\'' +
                ", time=" + time +
                '}';
    }
}
