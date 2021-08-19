create table comments
(
    id      integer not null
        constraint comments_pkey
            primary key,
    text    varchar(255),
    post_id integer
        constraint comments_posts_id_fk
            references posts
            on delete cascade
);

alter table comments
    owner to postgres;

INSERT INTO public.comments (id, text, post_id) VALUES (1, '1 comment 1', 1);
INSERT INTO public.comments (id, text, post_id) VALUES (2, '1 comment 2', 1);
INSERT INTO public.comments (id, text, post_id) VALUES (3, '2 comment 1', 2);
INSERT INTO public.comments (id, text, post_id) VALUES (4, '2 comment 2', 2);
INSERT INTO public.comments (id, text, post_id) VALUES (5, '2 comment 3', 2);
INSERT INTO public.comments (id, text, post_id) VALUES (6, '3 comment 1', 3);