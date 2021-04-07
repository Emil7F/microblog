insert into user(id, created, email, name, surname)
values (1, '2021-04-01 10:00:00.0', 'bobfisher@mail.com', 'Bobby','Fisher' ),
       (2, '2021-04-01 10:00:00.0', 'aalechin@mail.com', 'Aleksandr','Alechin' ),
       (3, '2021-04-01 10:00:00.0', 'mtal@mail.com', 'Michaił','Tal' );


insert into post(id, content, created, status, updated, owner_id)
values (1, 'Content 1', '2021-04-01 11:00:00.0', 'ORIGINAL', '2021-04-01 11:00:00.0', 1),
       (2, 'Content 2', '2021-04-01 11:00:00.0', 'ORIGINAL', '2021-04-01 11:00:00.0', 2),
       (3, 'Content 3', '2021-04-01 11:00:00.0', 'ORIGINAL', '2021-04-01 11:00:00.0', 1),
       (4, 'Content 4', '2021-04-01 11:00:00.0', 'ORIGINAL', '2021-04-01 11:00:00.0', 2),
       (5, 'Content 5', '2021-04-01 11:00:00.0', 'ORIGINAL', '2021-04-01 11:00:00.0', 3);
