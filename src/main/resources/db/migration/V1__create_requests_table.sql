CREATE TABLE requests (
                          id UUID PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          description TEXT,
                          type VARCHAR(20) NOT NULL,
                          status VARCHAR(20) NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          deadline TIMESTAMP,
                          ownerID UUID,
                          homeID UUID
);