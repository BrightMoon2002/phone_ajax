package com.codegym.controller.smartPhone;

import com.codegym.model.SmartPhone;
import com.codegym.service.smartPhone.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/smartphones")
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @GetMapping("/list")
    public ModelAndView showAll() {
        ModelAndView model = new ModelAndView("/smartphone/list");
        model.addObject("smartphoneList", smartPhoneService.findAll());
        return model;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<SmartPhone>> getAll() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SmartPhone> createNewPhone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone> showEditPhone(@PathVariable Long id) {
        SmartPhone smartPhone = smartPhoneService.findById(id).get();
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deletePhone(@PathVariable Long id) {
        smartPhoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<SmartPhone> updatePhone(@RequestBody SmartPhone smartPhone) {
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }
}
