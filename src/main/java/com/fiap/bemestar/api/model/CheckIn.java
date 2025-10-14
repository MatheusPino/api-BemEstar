package com.fiap.bemestar.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "checkins")
public class CheckIn {
    @Id
    private String id;
    private String userId;
    private String mood;
    private String notes;
    private int motivacao;
    private int foco;
    private int apoio;
    private Instant createdAt;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public int getMotivacao() { return motivacao; }
    public void setMotivacao(int motivacao) { this.motivacao = motivacao; }
    public int getFoco() { return foco; }
    public void setFoco(int foco) { this.foco = foco; }
    public int getApoio() { return apoio; }
    public void setApoio(int apoio) { this.apoio = apoio; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
