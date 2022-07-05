package com.example.projectaidana.controllers;

import com.example.projectaidana.dao.PaymentService;
import com.example.projectaidana.models.GKPO;
import com.example.projectaidana.models.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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
        public String create (@ModelAttribute("payment")  @Valid Payment payment, BindingResult bindingResult){
            if(bindingResult.hasErrors())
                return "/payments/mn";
            paymentService.save(payment);
                return "redirect:/payments/mn";
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
