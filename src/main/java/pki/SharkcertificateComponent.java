package pki;

import net.sharksystem.ASAPFormats;
import net.sharksystem.SharkComponent;
import net.sharksystem.SharkException;
import net.sharksystem.SharkStatusException;
import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.ASAPPeer;
import net.sharksystem.asap.ASAPSecurityException;
import net.sharksystem.asap.ASAPStorage;
import net.sharksystem.asap.crypto.ASAPKeyStore;
import net.sharksystem.asap.crypto.InMemoASAPKeyStore;
import net.sharksystem.asap.persons.ASAPCertificateStore;
import net.sharksystem.asap.persons.FullAsapPKIStorage;
import net.sharksystem.asap.persons.PersonValues;
import net.sharksystem.asap.pki.ASAPAbstractCertificateStore;
import net.sharksystem.asap.pki.ASAPCertificate;
import net.sharksystem.asap.pki.ASAPCertificateStorage;
import net.sharksystem.pki.CredentialMessage;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.*;
import java.util.Collection;
import java.util.List;

@ASAPFormats(formats = {ASAPCertificateStore.CREDENTIAL_APP_NAME, ASAPCertificateStorage.PKI_APP_NAME})
public class SharkCertificateComponent implements SharkComponent, ASAPKeyStore, ASAPCertificateStore {
    private FullAsapPKIStorage asapPKIStorage = null;

    @Override
    public void onStart(ASAPPeer asapPeer) throws SharkException {
        try {
            ASAPStorage asapStorage = asapPeer.getASAPStorage(asapPeer.getPeerID());
            ASAPCertificateStorage asapAliceCertificateStorage =
                    new ASAPAbstractCertificateStore(asapStorage, asapPeer.getPeerID(), asapPeer.getPeerID());
            InMemoASAPKeyStore inMemoASAPKeyStore = new InMemoASAPKeyStore(asapPeer.getPeerID());
            this.asapPKIStorage = new FullAsapPKIStorage(asapAliceCertificateStorage, inMemoASAPKeyStore);
        } catch (IOException | ASAPException e) {
            throw new SharkException(e);
        }
    }

    private void checkStatus() throws SharkStatusException {
        if(this.asapPKIStorage == null) {
            throw new SharkStatusException("ASAP peer not started component not yet initialized");
        }
    }

    // just an example of a interface implementation
    @Override
    public PublicKey getPublicKey(CharSequence charSequence) throws ASAPSecurityException {
        this.checkStatus(); // it would produce an exception if called before the Shark Peer was started
        return this.asapPKIStorage.getPublicKey(charSequence); // delegate call
    }

    @Override
    public boolean isOwner(CharSequence charSequence) {
        return false;
    }

    @Override
    public CharSequence getOwner() {
        return null;
    }

    @Override
    public void generateKeyPair() throws ASAPSecurityException {

    }

    @Override
    public CharSequence getOwnerID() {
        return null;
    }

    @Override
    public CharSequence getOwnerName() {
        return null;
    }

    @Override
    public PrivateKey getPrivateKey() throws ASAPSecurityException {
        return null;
    }

    @Override
    public PublicKey getPublicKey() throws ASAPSecurityException {
        return null;
    }

    @Override
    public long getKeysCreationTime() throws ASAPSecurityException {
        return 0;
    }

    @Override
    public ASAPCertificate addAndSignPerson(CharSequence charSequence, CharSequence charSequence1, PublicKey publicKey, long l) throws ASAPSecurityException, IOException {
        return null;
    }

    @Override
    public void setSigningFailureRate(CharSequence charSequence, int i) throws ASAPSecurityException {

    }

    @Override
    public int getSigningFailureRate(CharSequence charSequence) {
        return 0;
    }

    @Override
    public PersonValues getPersonValuesByPosition(int i) throws ASAPSecurityException {
        return null;
    }

    @Override
    public PersonValues getPersonValuesByID(CharSequence charSequence) throws ASAPSecurityException {
        return null;
    }

    @Override
    public int getNumberOfPersons() {
        return 0;
    }

    @Override
    public int getIdentityAssurance(CharSequence charSequence) throws ASAPSecurityException {
        return 0;
    }

    @Override
    public List<CharSequence> getIdentityAssurancesCertificationPath(CharSequence charSequence) throws ASAPSecurityException {
        return null;
    }

    @Override
    public Collection<ASAPCertificate> getCertificatesBySubject(CharSequence charSequence) throws ASAPSecurityException {
        return null;
    }

    @Override
    public Collection<ASAPCertificate> getCertificatesByIssuer(CharSequence charSequence) throws ASAPSecurityException {
        return null;
    }

    @Override
    public ASAPCertificate getCertificateByIssuerAndSubject(CharSequence charSequence, CharSequence charSequence1) throws ASAPSecurityException {
        return null;
    }

    @Override
    public void addCertificate(ASAPCertificate asapCertificate) throws IOException, ASAPSecurityException {

    }

    @Override
    public boolean verifyCertificate(ASAPCertificate asapCertificate) throws ASAPSecurityException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        return false;
    }

    @Override
    public CredentialMessage createCredentialMessage() throws ASAPSecurityException {
        return null;
    }

    @Override
    public boolean incorporateReceivedCertificates() {
        return false;
    }

    @Override
    public void store(OutputStream outputStream) throws IOException {

    }

    @Override
    public void load(InputStream inputStream) throws IOException {

    }

    @Override
    public String getAsymmetricEncryptionAlgorithm() {
        return null;
    }

    @Override
    public String getAsymmetricSigningAlgorithm() {
        return null;
    }

    @Override
    public SecretKey generateSymmetricKey() throws ASAPSecurityException {
        return null;
    }

    @Override
    public String getSymmetricEncryptionAlgorithm() {
        return null;
    }

    @Override
    public String getSymmetricKeyType() {
        return null;
    }

    @Override
    public int getSymmetricKeyLen() {
        return 0;
    }
}
