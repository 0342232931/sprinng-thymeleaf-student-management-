package vn.ths.BTCuoiKhoa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "logger")
public class Logger {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    private long timestamp = System.currentTimeMillis();

    public Logger(String content) {
        this.content = content;
    }

    public Logger() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Logger{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
