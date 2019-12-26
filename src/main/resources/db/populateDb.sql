INSERT INTO englingo.lectures(id, picture_url, title)
VALUES (1, '/image/food.png', 'Jídlo'),
       (2, '/image/animals.png', 'Zvířata'),
       (3, '/image/holiday.png', 'Prázdniny'),
       (4, '/image/sports.png', 'Sporty')
ON DUPLICATE KEY UPDATE picture_url = VALUES(picture_url),
                        title       = VALUES(title);

INSERT INTO englingo.roles(id, role_type)
VALUES (1, 'ADMIN'),
       (2, 'USER')
ON DUPLICATE KEY UPDATE role_type = VALUES(role_type);

INSERT INTO englingo.users(id, active, created, email, first_name, last_name, password, username, role_id)
VALUES (1, TRUE, '2019/12/10', 'tomas.fuk@email.com', 'Tomas', 'Fuk', 'heslo', 'tom', 2),
       (2, TRUE, '2018/10/28', 'honza.novak@email.com', 'Honza', 'Novak', 'heslo', 'jenik', 2),
       (3, TRUE, '2018/4/12', 'honza.admin@email.com', 'Honza', 'Admin', 'heslo', 'admin', 1)
ON DUPLICATE KEY UPDATE active     = VALUES(active),
                        created    = VALUES(created),
                        email      = VALUES(email),
                        first_name = VALUES(first_name),
                        last_name  = VALUES(last_name),
                        password   = VALUES(password),
                        username   = VALUES(username),
                        role_id    = VALUES(role_id);
