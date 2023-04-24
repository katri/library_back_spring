DROP SCHEMA public CASCADE;
CREATE SCHEMA public
    GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-04-20 12:35:59.769

-- tables
-- Table: book
CREATE TABLE book (
                      id serial  NOT NULL,
                      title text  NOT NULL,
                      year_published int  NOT NULL,
                      un_code bigint  NOT NULL,
                      category_id serial  NOT NULL,
                      book_author_id serial  NOT NULL,
                      book_status_id serial  NOT NULL,
                      CONSTRAINT id PRIMARY KEY (id)
);

-- Table: book_author
CREATE TABLE book_author (
                             id serial  NOT NULL,
                             first_name text  NOT NULL,
                             middle_name text  NULL,
                             last_name text  NOT NULL,
                             CONSTRAINT book_author_pk PRIMARY KEY (id)
);

-- Table: book_status
CREATE TABLE book_status (
                             id serial  NOT NULL,
                             description text  NOT NULL,
                             CONSTRAINT book_status_pk PRIMARY KEY (id)
);

-- Table: books_to_users
CREATE TABLE books_to_users (
                                id serial  NOT NULL,
                                start_date date  NOT NULL,
                                end_date date  NOT NULL,
                                comment text  NULL,
                                book_id serial  NOT NULL,
                                user_id serial  NOT NULL,
                                is_active boolean NOT NULL,
                                CONSTRAINT books_to_users_pk PRIMARY KEY (id)
);

-- Table: category
CREATE TABLE category (
                          id serial  NOT NULL,
                          name text  NOT NULL,
                          code text  NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        first_name text  NOT NULL,
                        middle_name text  NULL,
                        last_name text  NOT NULL,
                        personal_code bigint  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: book_book_author (table: book)
ALTER TABLE book ADD CONSTRAINT book_book_author
    FOREIGN KEY (book_author_id)
        REFERENCES book_author (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: book_book_status (table: book)
ALTER TABLE book ADD CONSTRAINT book_book_status
    FOREIGN KEY (book_status_id)
        REFERENCES book_status (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: book_category (table: book)
ALTER TABLE book ADD CONSTRAINT book_category
    FOREIGN KEY (category_id)
        REFERENCES category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: books_to_users_book (table: books_to_users)
ALTER TABLE books_to_users ADD CONSTRAINT books_to_users_book
    FOREIGN KEY (book_id)
        REFERENCES book (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: books_to_users_user (table: books_to_users)
ALTER TABLE books_to_users ADD CONSTRAINT books_to_users_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

