public interface AsapStarterAPI {
    String APP_FORMAT = “application/x-hedwigTransport”;
    void sendPackage(DeliveryPackage deliveryPackage) throws Exception;

    /**
     *
    void checkWeightFeasibleOrNot(Long weight);
    void createStoreAndExchangeCertificates();
    void callHedwig(); //      in IoT
    void attachPackageOnHedwig();  // in IoT
    void flyHedwig();
    void hoverHedwig(); // when any BT other than sender in range of hedwig it will blink.
    void checkReceiverIdentityAndDeliver(); // in IoT
     *
     *
     */
}
