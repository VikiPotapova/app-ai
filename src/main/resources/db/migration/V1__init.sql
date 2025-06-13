-- Table: geo
CREATE TABLE geo (
                     id SERIAL PRIMARY KEY,
                     lat VARCHAR(255),
                     lng VARCHAR(255)
);

-- Table: address
CREATE TABLE address (
                         id SERIAL PRIMARY KEY,
                         street VARCHAR(255),
                         suite VARCHAR(255),
                         city VARCHAR(255),
                         zipcode VARCHAR(255),
                         geo_id INT REFERENCES geo(id) ON DELETE CASCADE
);

-- Table: company
CREATE TABLE company (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         catch_phrase VARCHAR(255),
                         bs VARCHAR(255)
);

-- Table: users
CREATE TABLE users (
                       id BIGINT PRIMARY KEY,
                       name VARCHAR(255),
                       username VARCHAR(255),
                       email VARCHAR(255),
                       phone VARCHAR(255),
                       website VARCHAR(255),
                       address_id INT REFERENCES address(id) ON DELETE CASCADE,
                       company_id INT REFERENCES company(id) ON DELETE CASCADE
);

-- Table: auth_user
CREATE TABLE auth_user (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255),
                           email VARCHAR(255) UNIQUE NOT NULL,
                           password_hash VARCHAR(255) NOT NULL
);
