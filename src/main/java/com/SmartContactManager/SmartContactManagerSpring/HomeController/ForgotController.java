package com.SmartContactManager.SmartContactManagerSpring.HomeController;

import com.SmartContactManager.SmartContactManagerSpring.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class ForgotController {
//
    @Autowired
    private EmailService emailService;
    Random random=new Random(1000);
// email id form open handler
@RequestMapping("/forgot")
    public String openString(){


        return "forgot_email_form";
    }
// Sending otp handler
    @PostMapping ("/send-otp")
    public String sendOTP(@RequestParam("email") String email , HttpSession session){


        System.out.println(email);
        // generating otp 4 digit

int otp=random.nextInt(9999999);

        System.out.println(otp);
// write code for send otp to email

        String subject="OTP from SCM";
        String message="<h1>OTP= " +otp+"</h1>";
        String to =email;
Boolean flag= this.emailService.sendEmail(subject,message,to);


       if(flag == true){
           return "verify_otp";
       }
       else {

        session.setAttribute("message","check your email id");

           return  "forgot_email_form";
       }
       }


}
