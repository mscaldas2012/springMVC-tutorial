package com.msc.springmvc.web.controller;

import com.msc.springmvc.web.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.logging.Logger;


/**
 * This code was written by Marcelo Caldas.
 * e-Mail: mscaldas@gmail.com
 * <p/>
 * Project: springmvc-web
 * <p/>
 * Date: 11/12/13
 * <p/>
\ */
@Controller
@SessionAttributes({"contactList"})
public class ContactCotroller {
    private static final Logger logger = Logger.getLogger(ContactCotroller.class.getName());

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")Contact contact, HttpSession session) {
        System.out.println("First Name:" + contact.getFirstname() +"Last Name:" + contact.getLastname());
        HashMap<String, Contact> contactList = (HashMap<String, Contact>) session.getAttribute("contactList");
        contactList.put(contact.getEmail(), contact);
        return "redirect:contacts";
    }

    @RequestMapping("/contacts")
    public String showContacts(ModelMap map){ // Map<String, Object> map) {
        map.put("contact", new Contact());
        if (map.get("contactList") == null) {
            map.put("contactList", new HashMap<String, Contact>());
        }

        return "contact";
        //return new ModelAndView("contact", "command", new Contact());
    }

    @RequestMapping("/delete/{contactEmail}")
    public String deleteContact(@PathVariable("contactEmail") String email, HttpSession session) {
        HashMap<String, Contact> contactList = (HashMap<String, Contact>) session.getAttribute("contactList");
        System.out.println("email = " + email);
        contactList.remove(email);
        return "redirect:/contacts";
    }
}
