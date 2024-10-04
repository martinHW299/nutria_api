package com.nutria.nutria_api.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.nutria.nutria_api.dao.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private Firestore firestore;

    public String createUser(User user) {
        try {
            ApiFuture<DocumentReference> users = firestore.collection("users").add(user);
            log.info(user.toString());
            return "Document saved: " + users.get().getId();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
