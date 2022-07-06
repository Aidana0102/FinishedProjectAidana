package com.example.projectaidana.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Poluchatel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="Name should not be empty")
    String  beneficiarysName;


    @NotEmpty(message="The field should not be empty")
    @Size(min = 16,max = 16,message = "Account should be 16 characters")
    Long beneficiarysAccount;


    @NotEmpty(message="The field should not be empty")
    @Size(min = 6,max = 6,message = "INN should be 16 characters")
    Long INN;

    @NotEmpty(message="The field should not be empty")
    @Size(min = 14,max = 14,message = "BIK should be 16 characters")
    Long  beneficiarysBIK;


    @NotEmpty(message="The field should not be empty")
    Long  amount ;
    private GKPO GKPO;
    @NotEmpty(message="The field should not be empty")
    String purposeOfPayment;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_name")
    private Payment payment;


}
