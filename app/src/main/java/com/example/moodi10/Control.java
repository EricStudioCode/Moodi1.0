package com.example.moodi10;

import com.google.firebase.auth.*;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.*;

public class Control {
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;

    public Control() {
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
    }

    public void insertSample(Sample sample) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            System.out.println("Not logged in");
        } else {
            String uid = currentUser.getUid();

            DocumentReference docRef = db.collection("samples").document("newSample");

            Map<String,Object> sampleData = new HashMap<>();
            sampleData.put("uid", uid);
            sampleData.put("data", sample.getData());

            docRef.set(sampleData);
        }
    }
}
