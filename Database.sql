CREATE TABLE public.usuario (
	codigo int4 NOT NULL,
	login varchar NOT NULL,
	senha varchar NOT NULL,
	sexo bpchar(1) NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (codigo)
);
