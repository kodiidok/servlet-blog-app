-- Insert mock user data
INSERT INTO users (username, password, fullname, email, created_at)
VALUES
    ('user1', 'pwd1', 'John Doe', 'john@example.com', NOW()),
    ('user2', 'pwd2', 'Jane Smith', 'jane@example.com', NOW()),
    ('user3', 'pwd3', 'Alice Johnson', 'alice@example.com', NOW());
