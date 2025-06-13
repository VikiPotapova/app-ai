package com.example.aidevbackendtask.seeder;

import com.example.aidevbackendtask.dto.UserDTO;
import com.example.aidevbackendtask.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserSeeder implements CommandLineRunner {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        if (!userService.getAllUsers().isEmpty()) {
            System.out.println("Users already present. Skipping seeding.");
            return;
        }

        System.out.println("Seeding users from jsonplaceholder...");

        URL url = new URL("https://jsonplaceholder.typicode.com/users");
        List<UserDTO> users = objectMapper.readValue(url, new TypeReference<>() {});

        for (UserDTO user : users) {
            userService.createUser(user);
        }

        System.out.println("✅ Seeding complete.");
    }
}