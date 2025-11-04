package com.github.sambhavmahajan.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Value("${spring.mail.username}")
    private String myEmail;
    @Autowired
    private MailSender mailSender;
    @GetMapping
    public String home(Model model) {
        model.addAttribute("message", null);
        return "index";
    }
    @PostMapping("/contact")
    public String contact(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("message") String message, Model model) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(myEmail);
        mailMessage.setSubject("Contact Us!");
        mailMessage.setText("Email sent by\nEmail: " + email + "\nName: " + name + "\n\nMessage: " + message);
        mailSender.send(mailMessage);
        model.addAttribute("message", "Message sent");
        return "index";
    }
}
