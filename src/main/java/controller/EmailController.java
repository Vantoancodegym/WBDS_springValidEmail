package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/check")
public class EmailController {
    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping("")
    public ModelAndView showFormCheck(){
        ModelAndView modelAndView=new ModelAndView("home");
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView check(@RequestParam String email){
        ModelAndView modelAndView=new ModelAndView("home");
       boolean check= email.matches(EMAIL_REGEX);
       String result="";
       if (check){
           result="valid";}
       else {
           result="invalid";}

       modelAndView.addObject("result",result);
       return modelAndView;

    }
}
