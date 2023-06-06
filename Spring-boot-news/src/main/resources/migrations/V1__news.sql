create table source
(
    id     bigserial
        primary key,
    source varchar(255)
        constraint source_constraint
            unique
);

alter table source
    owner to postgres;

create table theme
(
    id        bigserial
        primary key,
    theme     varchar(255)
        constraint theme_constraint
            unique,
    source_id bigint
        constraint source_id_constraint
            references source
);

alter table theme
    owner to postgres;

create table news
(
    id       bigserial
        primary key,
    news     varchar(255)
        constraint news_constraint
            unique,
    theme_id bigint
        constraint theme_id_constraint
            references theme
);

alter table news
    owner to postgres;

