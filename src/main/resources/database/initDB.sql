
CREATE TABLE public.requestt
(
    id SERIAL PRIMARY KEY NOT NULL,
    description TEXT,
    status TEXT
);
CREATE UNIQUE INDEX requestt_id_uindex ON public.requestt (id);

CREATE TABLE public.commentt
(
    id SERIAL PRIMARY KEY NOT NULL,
    commentt TEXT,
    requestt_id INT,
    CONSTRAINT requestt_commentt_id_fk FOREIGN KEY (requestt_id) REFERENCES requestt (id)
);
CREATE UNIQUE INDEX commentt_id_uindex ON public.commentt (id);