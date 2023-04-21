INSERT INTO public.book_author (id, first_name, middle_name, last_name) VALUES (DEFAULT, 'Eno', null, 'Raud');
INSERT INTO public.book_author (id, first_name, middle_name, last_name) VALUES (DEFAULT, 'Oskar', null, 'Luts';)

INSERT INTO public.book_status (id, description) VALUES (DEFAULT, 'kohal');
INSERT INTO public.book_status (id, description) VALUES (DEFAULT, 'välja laenutatud');
INSERT INTO public.book_status (id, description) VALUES (DEFAULT, 'broneeritud');

INSERT INTO public."user" (id, first_name, middle_name, last_name, personal_code) VALUES (DEFAULT, 'Mari', null, 'Maasikas', 12345678);
INSERT INTO public."user" (id, first_name, middle_name, last_name, personal_code) VALUES (DEFAULT, 'Kati', null, 'Karu', 12348678);
INSERT INTO public."user" (id, first_name, middle_name, last_name, personal_code) VALUES (DEFAULT, 'Martin', null, 'Tamm', 45874225;)

INSERT INTO public.category (id, name, code) VALUES (DEFAULT, 'lastekirjandus', 'LAS');
INSERT INTO public.category (id, name, code) VALUES (DEFAULT, 'ulmekirjandus', 'ULM');
INSERT INTO public.category (id, name, code) VALUES (DEFAULT, 'luule', 'LUU');
INSERT INTO public.category (id, name, code) VALUES (DEFAULT, 'eesti kirjandus', 'EES');

INSERT INTO public.book (id, title, year_published, un_code, category_id, book_author_id, book_status_id) VALUES (DEFAULT, 'Sipsik', 1962, '1234567', 1, 1, 1);
INSERT INTO public.book (id, title, year_published, un_code, category_id, book_author_id, book_status_id) VALUES (DEFAULT, 'Roosetvaba mõõk', 1957, '1288567', 1, 1, 1);
INSERT INTO public.book (id, title, year_published, un_code, category_id, book_author_id, book_status_id) VALUES (DEFAULT, 'Naksitrallid. Esimene raamat', 1972, '1944567', 1, 1, 1);
INSERT INTO public.book (id, title, year_published, un_code, category_id, book_author_id, book_status_id) VALUES (DEFAULT, 'Naksitrallid. Teine raamat', 1975, '8734567', 1, 1, 1);
