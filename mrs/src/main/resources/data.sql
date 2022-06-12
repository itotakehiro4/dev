-- 会議室
INSERT INTO meeting_room (room_name) VALUES ('新木場');
INSERT INTO meeting_room (room_name) VALUES ('辰巳');
INSERT INTO meeting_room (room_name) VALUES ('豊洲');
INSERT INTO meeting_room (room_name) VALUES ('月島');
INSERT INTO meeting_room (room_name) VALUES ('新富町');
INSERT INTO meeting_room (room_name) VALUES ('銀座一丁目');
INSERT INTO meeting_room (room_name) VALUES ('有楽町');

-- 会議室の予約可能日(room_idが2~6のSQLは省略)
-- room_idが1(新木場)
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 1);

INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 7);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 7);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 7);

-- ダミーユーザ
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES ('taro-yamada', '太郎', '山田', 'bb421fa35db885ce507b0ef5c3f23cb09c62eb378fae3641c165bdf4c0272949','USER');
-- 認証用ユーザ
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES ('aaaa', 'Aaa', 'Aaa', 'bb421fa35db885ce507b0ef5c3f23cb09c62eb378fae3641c165bdf4c0272949','USER');
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES ('bbbb', 'Bbb', 'Bbb', 'bb421fa35db885ce507b0ef5c3f23cb09c62eb378fae3641c165bdf4c0272949','USER');
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES ('cccc', 'Ccc', 'Ccc', 'bb421fa35db885ce507b0ef5c3f23cb09c62eb378fae3641c165bdf4c0272949','ADMIN');