-- Add Users
INSERT INTO users (user_id, email, first_name, last_name) VALUES (nextval('users_id_seq'), 'hidan@email.com', 'Hidan', 'Jashin');

-- Add Countries
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Romania');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'France');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Italy');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Austria');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Switzerland');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Canada');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'USA');
INSERT INTO countries (country_id, name) VALUES (nextval('countries_id_seq'), 'Andorra');

-- Add Cities
INSERT INTO cities (city_id, name, country_id) VALUES (nextval('cities_id_seq'), 'Bucharest', 1);
INSERT INTO cities (city_id, name, country_id) VALUES (nextval('cities_id_seq'), 'Constanta', 1);
INSERT INTO cities (city_id, name, country_id) VALUES (nextval('cities_id_seq'), 'Rome', 3);
INSERT INTO cities (city_id, name, country_id) VALUES (nextval('cities_id_seq'), 'Paris', 2);

-- Add Accommodations
INSERT INTO accommodations (accommodation_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('accommodations_id_seq'), 'This is a accommodation in Bucharest', 'My First Accommodation', 20, '0712345676', 45, 1, null);
INSERT INTO accommodations (accommodation_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('accommodations_id_seq'), 'This is the second accommodation in Bucharest', 'My Second Accommodation', 40, '0712345666', 40, 1, null);
INSERT INTO accommodations (accommodation_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('accommodations_id_seq'), 'This is the second accommodation in Constanta', 'My Constanta Accommodation', 40, '0712335666', 40, 2, null);
INSERT INTO accommodations (accommodation_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('accommodations_id_seq'), 'This is a accommodation in Rome', 'My Third Accommodation', 20, '0712345671', 45, 3, null);
INSERT INTO accommodations (accommodation_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('accommodations_id_seq'), 'This is the second accommodation in Rome', 'My Fourth Accommodation', 40, '0712345662', 40, 3, null);
INSERT INTO accommodations (accommodation_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('accommodations_id_seq'), 'This is a accommodation in Paris', 'My Paris Accommodation', 20, '0712335671', 45, 4, null);
INSERT INTO accommodations (accommodation_id, description, name, number_of_booked_slots, phone, total_number_of_slots, city_id, photo_id) VALUES
    (nextval('accommodations_id_seq'), 'This is the second accommodation in Paris', 'My Paris Accommodation 2', 40, '0732345662', 40, 4, null);