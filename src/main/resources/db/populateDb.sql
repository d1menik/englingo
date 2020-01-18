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

INSERT INTO englingo.questions(id, correct_answer, lecture_id, title)
VALUES (1, 0, 2, 'pes'),
       (2, 1, 2, 'kočka'),
       (3, 2, 2, 'pták'),
       (4, 3, 2, 'lev'),
       (5, 4, 2, 'králík')
ON DUPLICATE KEY UPDATE correct_answer = VALUES(correct_answer),
                        lecture_id     = VALUES(lecture_id),
                        title          = VALUES(title);

INSERT INTO englingo.question_choices(question_id, choices)
VALUES (1, 'dog'),
       (1, 'cat'),
       (1, 'bird'),
       (1, 'lion'),
       (1, 'rabbit'),
       (2, 'dog'),
       (2, 'cat'),
       (2, 'bird'),
       (2, 'lion'),
       (2, 'rabbit'),
       (3, 'dog'),
       (3, 'cat'),
       (3, 'bird'),
       (3, 'lion'),
       (3, 'rabbit'),
       (4, 'dog'),
       (4, 'cat'),
       (4, 'bird'),
       (4, 'lion'),
       (4, 'rabbit'),
       (5, 'dog'),
       (5, 'cat'),
       (5, 'bird'),
       (5, 'lion'),
       (5, 'rabbit')
ON DUPLICATE KEY UPDATE question_id = VALUES(question_id),
                        choices     = VALUES(choices);