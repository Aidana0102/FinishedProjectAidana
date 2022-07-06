package com.example.projectaidana.controllers;

import com.example.projectaidana.controllers.dao.PaymentService;
import com.example.projectaidana.models.GKPO;
import com.example.projectaidana.models.Payment;
import com.example.projectaidana.models.Poluchatel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {


    private final PaymentService paymentService;
//    @GetMapping()
//        public  String index(Model model){
//            model.addAttribute("payments",paymentDao.index());
//            return "people/index";
//        }


//    @PostMapping("/import/excel")
//    public List<Payment> importExcel(MultipartFile multipartFile){
//
//    }




        @GetMapping("/mn")
        public String newPayment(Model model){
            model.addAttribute("payment",new Payment());
         List<GKPO> enums = Arrays.asList(GKPO.values());
            model.addAttribute("gkpo", enums);
            return "/payments/mn";
        }



        @PostMapping()
        public void create (@ModelAttribute("payment")  @Valid Payment payment , BindingResult bindingResult, HttpServletResponse response) throws IOException {
//            if(bindingResult.hasErrors())
//                return "/payments/mn";
            File file = paymentService.save(payment);
            response.setContentType("application/octet-stream");
            String headerKey="Content-Disposition";
            String headerValue="attachment; filename="+file.getName();
            response.setHeader(headerKey,headerValue);
            ServletOutputStream outputStream=response.getOutputStream();
            BufferedInputStream inputStream=new BufferedInputStream(new FileInputStream(file));
            byte[] buffer=new byte[8192];
            int byteRead=-1;
            while((byteRead=inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,byteRead);
            }
            inputStream.close();
            outputStream.close();
             //   return "redirect:/payments/mn";
        }







//
//        @GetMapping()
//     public  String payments (@ModelAttribute("payment") Payment payment, @ModelAttribute("gkpo")GKPO gkpo){
//        return"/payments/mn";
//        }
//

//    @PostMapping()
//    public ModelAndView upload(@RequestParam CommonsMultipartFile )
//
}
