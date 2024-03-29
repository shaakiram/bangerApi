package com.banger.bangerapi.Controller;

import com.banger.bangerapi.Models.Contact;
import com.banger.bangerapi.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/contact")
@RestController
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/addContact")
    public ResponseEntity<?> addContact(@RequestBody Contact contact){
        return  contactService.addContact(contact);
    }
    @GetMapping("/getAllContacts")
    private ResponseEntity<?> getAllContacts() throws Exception{
        return ResponseEntity.ok(contactService.getAllContacts());
    }
    @GetMapping("/deleteContact/{id}")
    public  ResponseEntity<?> deleteNotification(@PathVariable int id){
        return  contactService.deleteNotification(id);
    }
}
