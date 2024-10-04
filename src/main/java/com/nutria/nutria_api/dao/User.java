package com.nutria.nutria_api.dao;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.ServerTimestamp;
import lombok.Data;

@Data
public class User {

    @DocumentId
    private String user_id;
    private String user_name;
    private String user_email;

    @ServerTimestamp
    private Timestamp createdAt;
}
