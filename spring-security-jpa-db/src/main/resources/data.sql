create table user.users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
);

create table user.authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO users(username,password,enabled)
VALUES ('JOHN','{noop}test123',1),
('MARY','{noop}test123',1),
('SUSAN','{noop}test123',1);

INSERT INTO authorities(username,authority)
VALUES
('JOHN','EMPLOYEE'),
('MARY','EMPLOYEE'),
('MARY','MANAGER'),
('SUSAN','EMPLOYEE'),
('SUSAN','ADMIN');
