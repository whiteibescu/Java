CREATE TABLE user
(
    id bigint auto_increment NOT NULL,
    name varchar(255) NOT NULL,
    level integer,
    primary key(id)
);

CREATE TABLE message
(
    id bigint auto_increment NOT NULL,
    message varchar(1500) NOT NULL,
    fromId bigint NOT NULL,
    `from` varchar(255) NOT NULL,
    toId bigint NOT NULL,
    `to` varchar(255) NOT NULL,
    primary key(id)
);

INSERT INTO user (`name`, `level`) VALUES ('John', 1);
INSERT INTO user (`name`, `level`) VALUES ('Dave', 4);
INSERT INTO user (`name`, `level`) VALUES ('Jacob', 3);

INSERT INTO message (`message`, `fromId`, `from`, `toId`, `to`) VALUES ('Hi', 1, 'Paul', 2, 'Dave');
INSERT INTO message (`message`, `fromId`, `from`, `toId`, `to`) VALUES ('Good Morning', 3, 'Jacob', 2, 'Dave');
INSERT INTO message (`message`, `fromId`, `from`, `toId`, `to`) VALUES ('Bye Bye', 2, 'Dave', 3, 'Jacob');
INSERT INTO message (`message`, `fromId`, `from`, `toId`, `to`) VALUES ('Hi', 3, 'Jacob', 1, 'Paul');