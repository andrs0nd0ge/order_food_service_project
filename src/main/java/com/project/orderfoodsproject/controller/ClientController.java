package com.project.orderfoodsproject.controller;

import com.project.orderfoodsproject.dto.ClientDto;
import com.project.orderfoodsproject.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        List<ClientDto> clients = clientService.getAllClients();
        if (clients.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerClient(@RequestParam String username,
                                                 @RequestParam String email,
                                                 @RequestParam String password) {
        return new ResponseEntity<>(clientService.registerClient(username, email, password), HttpStatus.OK);
    }
}
