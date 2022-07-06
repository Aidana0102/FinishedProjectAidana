package com.example.projectaidana.controllers.dao;
import com.example.projectaidana.models.Payment;
import com.example.projectaidana.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment save(Payment payment){
       return paymentRepository.save(payment);
    }

    public List<Payment>findAll(){
        return paymentRepository.findAll();
    }

  public File findById(Long id) throws IOException {
        Payment payment=paymentRepository.findById(id).get();
      File file = new File("Payment.txt");
      file.createNewFile();
      FileWriter writer = new FileWriter(file);
      writer.write("\"1CClientBankExchange\n" +
              "ВерсияФормата=1.01\n" +
              "Кодировка=Windows\"\n" +
              "\"СекцияДокумент=Платежное поручение\n" +
              "Номер="+payment.getId()+"\n" +
                   "Дата="+payment.getPaymentDate()+   "\n"+
                 //   "Сумма="+payment.getAmount()+ "\n"+
              "ПлательщикСчет="+payment.getPayersAccount()+"\n"+
              "Плательщик1="+payment.getPayersName()+"\n"+
          //           "ПолучательСчет="+payment.getBeneficiarysAccount()+"\n"+
           //   "Получатель1="+payment.getBeneficiarysName()+"\n"+
           //   "ПолучательБИК="+payment.getBeneficiarysBIK()+"\n"+
           //   "ПолучательИНН="+payment.getINN()+"\n"+
              "СрокПлатежа="+payment.getDateOfExecution()+"\n"+
        //     "НазначениеПлатежа="+payment.getPurposeOfPayment()+"\n"+
         //     "ГКПО="+payment.getGKPO()+"\n"+
                      "КонецДокумента' "+  "\n");
      writer.flush();
      writer.close();
      return  file;
      }



}
