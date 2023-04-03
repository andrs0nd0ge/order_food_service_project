package com.project.orderfoodsproject.service;

import com.project.orderfoodsproject.dao.ClientDao;
import com.project.orderfoodsproject.dto.ClientDto;
import com.project.orderfoodsproject.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientDao clientDao;
    private final PasswordEncoder encoder;
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientDao.getAllClients();
        return clients.stream()
                .map(ClientDto::from)
                .collect(Collectors.toList());
    }
    public String registerClient(String username, String email, String password) {
        List<Client> clients = clientDao.getAllClients();
        String response = "";
        for (Client c : clients) {
            if (c.getEmail().equals(email)) {
                response = "Client with given email already exists";
            } else {
                password = encoder.encode(password);
                clientDao.registerClient(username, email, password);
                response = "Client was registered successfully";
            }
        }
        return response;
    }
}
