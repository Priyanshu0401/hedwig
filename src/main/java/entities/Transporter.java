package entities;

import java.util.LinkedList;

public class Transporter {

    private LinkedList<String> logs = new LinkedList<>();

    public void addLog(String log) {
        this.logs.addLast(log);
    }

    public LinkedList<String> getLogs() {
        return logs;
    }

    public void receivePackage(){

    }
    public void dropPackage(){

    }
}
