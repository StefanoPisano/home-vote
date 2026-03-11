CREATE TABLE votes
(
    id          UUID PRIMARY KEY,
    request_id  UUID        NOT NULL REFERENCES requests (id) ON DELETE CASCADE,
    user_id     UUID        NOT NULL,
    vote_choice VARCHAR(10) NOT NULL,
    created_at  TIMESTAMP   NOT NULL DEFAULT now(),
    UNIQUE (request_id, user_id)
);