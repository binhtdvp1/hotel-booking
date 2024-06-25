CREATE TABLE IF NOT EXISTS users (
	user_id serial primary key,
	email varchar(100) not null unique,
	password varchar(200) not null,
	full_name varchar(200),
	phone_number varchar(20),
	ref_role_id numeric(10),
	active_flag smallint,
	created_by varchar(50),
	created_date timestamp without time zone,
	updated_by varchar(50),
	updated_date timestamp without time zone
);

CREATE TABLE IF NOT EXISTS roles (
	role_id serial primary key,
	role_name varchar(100) not null,
	role_code varchar(50) not null unique,
	active_flag smallint,
	created_by varchar(50),
	created_date timestamp without time zone,
	updated_by varchar(50),
	updated_date timestamp without time zone
);

CREATE TABLE IF NOT EXISTS hotel (
	hotel_id serial primary key,
	hotel_name varchar(100) not null,
	hotel_code varchar(20) not null unique,
	hotel_address varchar(200) not null,	
	rating smallint,
	active_flag smallint,
	created_by varchar(50),
	created_date timestamp without time zone,
	updated_by varchar(50),
	updated_date timestamp without time zone
);

CREATE TABLE IF NOT EXISTS booking (
	booking_id serial primary key,
	ref_user_id numeric(20) not null,
	ref_hotel_id numeric(20) not null,
	ref_room_type_id numeric(20) not null,
	from_date timestamp without time zone,
	to_date timestamp without time zone,
	status varchar(50),
	active_flag smallint,
	created_by varchar(50),
	created_date timestamp without time zone,
	updated_by varchar(50),
	updated_date timestamp without time zone
);

CREATE TABLE IF NOT EXISTS user_rating (
	user_rating_id serial primary key,
	ref_booking_id numeric(20) not null,
	rate smallint,
	active_flag smallint,
	created_by varchar(50),
	created_date timestamp without time zone,
	updated_by varchar(50),
	updated_date timestamp without time zone
);

CREATE TABLE IF NOT EXISTS room_type (
	room_type_id serial primary key,
	room_type_code varchar(20) not null,
	room_type_name varchar(50) not null,
	ref_hotel_code varchar(20) not null,
	price numeric(20),
	active_flag smallint,
	quantity smallint,
	created_by varchar(50),
	created_date timestamp without time zone,
	updated_by varchar(50),
	updated_date timestamp without time zone
);

alter table room_type add unique (room_type_code,ref_hotel_code);

insert into roles(role_name,role_code,created_by,created_date,updated_by,updated_date,active_flag)
values ('Admin', 'ADMIN', 'system', current_date, 'system', current_date,1);

insert into roles(role_name,role_code,created_by,created_date,updated_by,updated_date,active_flag)
values ('User', 'USER', 'system', current_date, 'system', current_date,1);