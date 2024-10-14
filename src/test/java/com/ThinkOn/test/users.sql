create table users (
				   username primary key,
				   firstName varchar(255),
				   lastName varchar(255),
				   email varchar(255),
				   phone varchar(30)
);

insert into users values ('myuser123', 'Jane', 'Doe', 'jane.doe@gmail.com', '514-333-3333');
insert into users values ('defaultuser5', 'John', 'Doe', 'john.doe@gmail.com', '514-111-1111');