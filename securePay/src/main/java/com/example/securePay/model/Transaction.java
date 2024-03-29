package com.example.securePay.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	private String transactionType;
	@CreatedDate
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;
	@Min(value = 1)

	private Double amount;
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;

}
