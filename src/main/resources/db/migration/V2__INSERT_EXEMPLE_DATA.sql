INSERT INTO barber_service (duration, price, name, note) VALUES (30, 50.00, 'Corte de Cabelo', 'Corte simples');

INSERT INTO barber_service (duration, price, name) VALUES (20, 80.00, 'Corte de Barba');

INSERT INTO barber_shop (address, closing_hour, end_break_time, name, opening_hour, start_break_time, working_day)
VALUES ('Rua Exemplo, 123', '18:00', '14:00', 'Barbearia Exemplo', '08:00', '12:00', 'Monday');

INSERT INTO barber_shop (closing_hour, end_break_time, opening_hour, start_break_time, working_day)
VALUES ('18:00', '14:00', '08:00', '12:00', 'Tuesday');
INSERT INTO barber_shop (closing_hour, end_break_time, opening_hour, start_break_time, working_day)
VALUES ('18:00', '14:00', '08:00', '12:00', 'Wednesday');
INSERT INTO barber_shop (closing_hour, end_break_time, opening_hour, start_break_time, working_day)
VALUES ('18:00', '14:00', '08:00', '12:00', 'Thursday');
INSERT INTO barber_shop (closing_hour, end_break_time, opening_hour, start_break_time, working_day)
VALUES ('18:00', '14:00', '08:00', '12:00', 'Friday');
INSERT INTO barber_shop (closing_hour, opening_hour, working_day)
VALUES ('12:00', '08:00', 'Saturday');

INSERT INTO client (email, name, phone) VALUES ('cliente@example.com', 'Cliente Exemplo', '123456789');
INSERT INTO client (email, name, phone) VALUES ('cliente2@example.com', 'Cliente Exemplo2', '123456780');

INSERT INTO payment (amount, client_id, date, payment_method) VALUES (50.00, 1, '2023-10-01 10:00:00', 'CASH');

INSERT INTO schedule (barber_service_id, client_id, date, status) VALUES (1, 1, '2025-03-01 10:00:00', 'SCHEDULED');
INSERT INTO schedule (barber_service_id, client_id, date, status) VALUES (2, 1, '2025-03-01 11:00:00', 'SCHEDULED');