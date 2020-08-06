package com.amit.ms.currencyexchangeservice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")
    private String to;
    @Column(name="conversion_multiple")
    private BigDecimal conversionMultiple;
    private int port;
}
