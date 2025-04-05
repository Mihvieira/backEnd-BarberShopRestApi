INSERT INTO barber_service (duration, price, name, note) VALUES ("00:30:00", 50.00, 'Corte de Cabelo', 'Corte simples');

INSERT INTO barber_service (duration, price, name) VALUES ("00:20:00", 80.00, 'Corte de Barba');

INSERT INTO barber_shop (address, name) VALUES ('Rua Exemplo, 123', 'Barbearia Exemplo');

INSERT INTO working_days (barber_shop_id, closing_hour, end_break_time, opening_hour, start_break_time, working_day)
VALUES (1, '18:00:00', '14:00:00', '08:00:00', '12:00:00', 'Monday');

INSERT INTO working_days (barber_shop_id, closing_hour, end_break_time, opening_hour, start_break_time, working_day)
VALUES (1, '18:00:00', '14:00:00', '08:00:00', '12:00:00', 'Tuesday');

INSERT INTO working_days (barber_shop_id, closing_hour, end_break_time, opening_hour, start_break_time, working_day)
VALUES (1, '18:00:00', '14:00:00', '08:00:00', '12:00:00', 'Wednesday');

INSERT INTO working_days (barber_shop_id, closing_hour, end_break_time, opening_hour, start_break_time, working_day)
VALUES (1, '18:00:00', '14:00:00', '08:00:00', '12:00:00', 'Thursday');

INSERT INTO working_days (barber_shop_id, closing_hour, end_break_time, opening_hour, start_break_time, working_day)
VALUES (1, '18:00:00', '14:00:00', '08:00:00', '12:00:00', 'Friday');

INSERT INTO working_days (barber_shop_id, closing_hour, opening_hour, working_day)
VALUES (1, '12:00:00', '08:00:00', 'Saturday');

INSERT INTO client (email, name, phone) VALUES ('cliente@example.com', 'Cliente Exemplo', '123456789');

INSERT INTO client (email, name, phone) VALUES ('cliente2@example.com', 'Cliente Exemplo2', '123456780');

INSERT INTO payment (amount, client_id, payment_date, payment_method) VALUES (50.00, 1, '2025-04-05 10:00:00', 'CASH');

INSERT INTO schedule (barber_service_id, client_id, schedule_date, status) VALUES (1, 1, '2025-04-06 10:00', 'SCHEDULED');

INSERT INTO schedule (barber_service_id, client_id, schedule_date, status) VALUES (2, 1, '2025-04-06 11:00:00', 'SCHEDULED');