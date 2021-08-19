create table posts
(
    id    integer not null
        constraint posts_pkey
            primary key,
    text  varchar(255),
    title varchar(255)
);

alter table posts
    owner to postgres;

INSERT INTO public.posts (id, text, title) VALUES (1, 'text 1', 'title 1');
INSERT INTO public.posts (id, text, title) VALUES (2, 'text 2', 'title 2');
INSERT INTO public.posts (id, text, title) VALUES (3, 'text 3', 'title 3');