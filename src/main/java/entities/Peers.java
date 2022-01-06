package entities;

import net.sharksystem.asap.ASAPPeer;

import java.util.List;

public class Peers {

    private List<ASAPPeer> peerList;

    public List<ASAPPeer> getPeerList() {
        return peerList;
    }

    public void setPeerList(List<ASAPPeer> peerList) {
        this.peerList = peerList;
    }

    public void addPeer(ASAPPeer peer) {
        if(!this.alreadyPresent(peer)) {
            this.peerList.add(peer);
        }
    }

    public boolean alreadyPresent(ASAPPeer peer) {
        return this.peerList.stream().anyMatch(asapPeer -> asapPeer.getPeerID() == peer.getPeerID());
    }
}
