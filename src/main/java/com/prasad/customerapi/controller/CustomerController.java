package com.prasad.customerapi.controller;

import com.prasad.customerapi.model.Customer;
import com.prasad.customerapi.repo.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/healthcheck")
    ResponseEntity<String> healthcheck() throws InterruptedException {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        log.info("Inside CustomerController --> healthcheck");
        String responseText = "customer-api healthcheck @ " + timeStamp + " - All OK";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(responseText.toString());
    }

    @GetMapping("/listAll")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

//    @GetMapping("/{id}")
//    public Client getClient(@PathVariable Long id) {
//        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
//    }
//
//    @PostMapping
//    public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException {
//        Client savedClient = clientRepository.save(client);
//        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client) {
//        Client currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);
//        currentClient.setName(client.getName());
//        currentClient.setEmail(client.getEmail());
//        currentClient = clientRepository.save(client);
//
//        return ResponseEntity.ok(currentClient);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteClient(@PathVariable Long id) {
//        clientRepository.deleteById(id);
//        return ResponseEntity.ok().build();
//    }

}
