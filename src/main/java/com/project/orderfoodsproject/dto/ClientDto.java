package com.project.orderfoodsproject.dto;

import com.project.orderfoodsproject.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String username;
    private String email;
    public static ClientDto from(Client client) {
        return builder()
                .id(client.getId())
                .username(client.getUsername())
                .email(client.getEmail())
                .build();
    }
}
