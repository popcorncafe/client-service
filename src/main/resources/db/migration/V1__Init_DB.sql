CREATE TABLE client
(
    id            bigint PRIMARY KEY,
    firstname     varchar(20) NULL,
    surname       varchar(20) NULL,
    username      varchar(20) NULL,
    phone_number  varchar(20) NULL UNIQUE,
    register_date timestamptz DEFAULT current_timestamp
);