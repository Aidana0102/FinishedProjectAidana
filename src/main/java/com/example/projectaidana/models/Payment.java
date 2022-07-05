package com.example.projectaidana.models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotEmpty(message="Name should not be empty")
    String payersName;

    @NotEmpty(message="THe field  should not be empty")
    @Size(min = 16,max = 16,message = "Account should be 16 characters")
    Long payersAccount;

    @NotEmpty(message="The should not be empty")
    @Size(min = 14,max = 14,message = "BIK should be 16 characters")
    Long payersBIK;

    @NotEmpty(message="THe field should not be empty")
    String  dateOfExecution;


    @NotEmpty(message="The field should not be empty")
   String paymentDate;

    @NotEmpty(message="Name should not be empty")
    String  beneficiarysName;


    @NotEmpty(message="The field should not be empty")
    @Size(min = 16,max = 16,message = "Account should be 16 characters")
    Long beneficiarysAccount;



    @Size(min = 6,max = 6,message = "INN should be 16 characters")
    Long INN;


    @Size(min = 14,max = 14,message = "BIK should be 16 characters")
    Long  beneficiarysBIK;


    @NotEmpty(message="The field should not be empty")
    Long  amount ;
    private GKPO GKPO;
    @NotEmpty(message="The field should not be empty")
    String purposeOfPayment;
}
