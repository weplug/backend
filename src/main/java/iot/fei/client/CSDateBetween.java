package iot.fei.client;

import java.time.LocalDateTime;

public class CSDateBetween {
    LocalDateTime from;
    LocalDateTime to;

    public CSDateBetween() {
    }

    public CSDateBetween(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }
}
