package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long portfolioId;

    @OneToOne
    @JoinColumn(name="clientId", nullable=false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    public Portfolio() {
    }

    public Portfolio(long portfolioId, Client client, List<Security> securities) {
        this.portfolioId = portfolioId;
        this.client = client;
        this.securities = securities;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
