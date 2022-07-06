package com.example.projectaidana.controllers.dao;
import com.example.projectaidana.models.Payment;
import com.example.projectaidana.repository.PaymentRepository;
import com.example.projectaidana.repository.PoluchatelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PoluchatelRepository poluchatelRepository;

    public File save(Payment payment) throws IOException {
        poluchatelRepository.save(payment.getPoluchatel());
        Payment payment1 =  paymentRepository.save(payment);
        File file = findById(payment1);
        return file;
    }

    public List<Payment>findAll(){
        return paymentRepository.findAll();
    }

  public File findById(Payment payment) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
      File file = new File(fileName);
      file.createNewFile();
      FileWriter writer = new FileWriter(file);
      writer.write("\"1CClientBankExchange\n" +
              "ВерсияФормата=1.01\n" +
              "Кодировка=Windows\"\n" +
              "\"СекцияДокумент=Платежное поручение\n" +
              "Номер="+payment.getId()+"\n" +
                   "Дата="+payment.getPaymentDate()+   "\n"+
                    "Сумма="+payment.getPoluchatel().getAmount()+ "\n"+
              "ПлательщикСчет="+payment.getPayersAccount()+"\n"+
              "Плательщик1="+payment.getPayersName()+"\n"+
                   "ПолучательСчет="+payment.getPoluchatel().getBeneficiarysAccount()+"\n"+
              "Получатель1="+payment.getPoluchatel().getBeneficiarysName()+"\n"+
              "ПолучательБИК="+payment.getPoluchatel().getBeneficiarysBIK()+"\n"+
             "ПолучательИНН="+payment.getPoluchatel().getINN()+"\n"+
              "СрокПлатежа="+payment.getDateOfExecution()+"\n"+
             "НазначениеПлатежа="+payment.getPoluchatel().getPurposeOfPayment()+"\n"+
             "ГКПО="+payment.getPoluchatel().getGKPO()+"\n"+
                      "КонецДокумента' "+  "\n");
      writer.flush();
      writer.close();
      File fr = new File(fileName);
      return  fr;
      }



}
