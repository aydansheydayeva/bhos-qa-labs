package com.example7.demo7.firebase;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.stereotype.Service;

@Service
public class FirebaseInitialization {

    @PostConstruct
    public void initialize() throws IOException {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ByteArrayInputStream(System.getenv("FIREBASE_CREDENTIALS").getBytes())))
                    .setDatabaseUrl("https://demo7-7e443.firebaseio.com")
                    .build();

                    if (FirebaseApp.getApps().isEmpty()) {
                        FirebaseApp.initializeApp(options, "demo7");
                    } else {
                        FirebaseApp.getApps().get(0);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/*
@Service
public class FirebaseInitialization {

    @PostConstruct
    public void initialization() throws IOException{

        FileInputStream serviceAccount =
        new FileInputStream("./serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();

        FirebaseApp.initializeApp(options);

    }
    
}*/