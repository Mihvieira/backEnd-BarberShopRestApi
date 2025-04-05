create table barber_service (
    duration time not null,
    price decimal(38, 2) not null,
    id bigint not null AUTO_INCREMENT,
    name varchar(255) not null,
    note varchar(255),
    primary key (id)
);
create table barber_shop (
    id bigint not null AUTO_INCREMENT,
    address varchar(255),
    name varchar(255),
    primary key (id)
);
create table client (
    id bigint not null AUTO_INCREMENT,
    email varchar(255),
    name varchar(255) not null,
    phone varchar(255) not null,
    primary key (id)
);
create table payment (
    amount decimal(38, 2) not null,
    client_id bigint not null,
    payment_date datetime not null,
    id bigint not null AUTO_INCREMENT,
    payment_method enum ('CASH', 'CREDIT_CARD', 'DEBIT_CARD', 'PIX') not null,
    primary key (id)
);
create table schedule (
    barber_service_id bigint not null,
    client_id bigint,
    schedule_date datetime not null,
    id bigint not null AUTO_INCREMENT,
    status enum ('CANCELED', 'COMPLETED', 'SCHEDULED'),
    primary key (id)
);
create table working_days (
    barber_shop_id bigint,
    id bigint not null AUTO_INCREMENT,
    closing_hour time not null,
    end_break_time time,
    opening_hour time not null,
    start_break_time time,
    working_day enum (
        'Friday',
        'Monday',
        'Saturday',
        'Sunday',
        'Thursday',
        'Tuesday',
        'Wednesday'
    ) not null,
    primary key (id)
);
alter table barber_service
add constraint UKiwmk910rx006ymyp4ukrcasix unique (name);
alter table client
add constraint UKbfgjs3fem0hmjhvih80158x29 unique (email);
alter table client
add constraint UKqe9dtj732yl9u3oqhhsee4lps unique (phone);
alter table working_days
add constraint UKf63xgd5fl18j7e59d4n2lo91i unique (working_day);
alter table payment
add constraint FK3fpanu7q9tijfio491vu0fd0r foreign key (client_id) references client (id);
alter table schedule
add constraint FKpx31d1y7t9dknv3x9oo4kgs3l foreign key (barber_service_id) references barber_service (id);
alter table schedule
add constraint FKffi483m655f7wqdwp0d4uthf0 foreign key (client_id) references client (id);
alter table working_days
add constraint FKcu64rih1bwvqykwp3nti3fj6q foreign key (barber_shop_id) references barber_shop (id);