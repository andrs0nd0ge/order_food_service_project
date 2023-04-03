package com.project.orderfoodsproject.util;

import com.project.orderfoodsproject.dao.ClientDao;
import com.project.orderfoodsproject.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final ClientDao clientDao;
    @Override
    public Client loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Client> client = clientDao.getClientByEmail(email);
        if (client.isEmpty()) {
            throw new UsernameNotFoundException("Client was not found");
        }
        return client.get();
    }
}
