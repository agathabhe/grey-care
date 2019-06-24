--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.17
-- Dumped by pg_dump version 9.5.17

-- Started on 2019-06-24 17:08:38 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "greycare-spring";
--
-- TOC entry 2153 (class 1262 OID 16413)
-- Name: greycare-spring; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "greycare-spring" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';


ALTER DATABASE "greycare-spring" OWNER TO postgres;

\connect -reuse-previous=on "dbname='greycare-spring'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12397)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 182 (class 1259 OID 16422)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 181 (class 1259 OID 16414)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente (
    id integer NOT NULL,
    alergias text,
    cep text,
    cpf text,
    doador text,
    email text,
    endereco text,
    estado_civil text,
    nascimento text,
    nome text,
    telefone text,
    tipo_sanguineo text
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16424)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    cpf text,
    crm text,
    email text,
    especialidade text,
    nascimento text,
    nome text,
    senha text,
    telefone text,
    tipo text,
    username text
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 182
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 27, true);


--
-- TOC entry 2145 (class 0 OID 16414)
-- Dependencies: 181
-- Data for Name: paciente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.paciente (id, alergias, cep, cpf, doador, email, endereco, estado_civil, nascimento, nome, telefone, tipo_sanguineo) VALUES (23, 'Nada', '63700000', '12345678977', 'nao', 'stessysoysa@gmail.com', 'Rua Almirante Tamandaré, 999, ap 1', 'solteiro', '1999-11-11', 'Antonia Stefanne Sousa Alves', '88994527526', '2');
INSERT INTO public.paciente (id, alergias, cep, cpf, doador, email, endereco, estado_civil, nascimento, nome, telefone, tipo_sanguineo) VALUES (27, 'Nenhuma', '63700000', '09382938293', 'nao', 'almada@gmail.com', 'Rua B, 99', 'casado', '1994-09-09', 'Anderson Almada', '8599229911', '6');
INSERT INTO public.paciente (id, alergias, cep, cpf, doador, email, endereco, estado_civil, nascimento, nome, telefone, tipo_sanguineo) VALUES (24, 'Não sei', '63700000', '06512345621', 'nao', 'agathabmartinsr@gmail.com', 'Rua Marechal Hermes, 116, A', 'solteiro', '1999-04-26', 'Agatha Bhenares Alves Martins Rodrigues', '88994527526', '7');
INSERT INTO public.paciente (id, alergias, cep, cpf, doador, email, endereco, estado_civil, nascimento, nome, telefone, tipo_sanguineo) VALUES (25, 'Poeira', '63700000', '12345678345', 'nao', 'jonhnhtattan@gmail.com', 'Rua Fisk', 'solteiro', '1997-03-02', 'Jonhnhattan Jérome', '88998838392', '1');
INSERT INTO public.paciente (id, alergias, cep, cpf, doador, email, endereco, estado_civil, nascimento, nome, telefone, tipo_sanguineo) VALUES (26, 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined');
INSERT INTO public.paciente (id, alergias, cep, cpf, doador, email, endereco, estado_civil, nascimento, nome, telefone, tipo_sanguineo) VALUES (2, 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined', 'undefined');


--
-- TOC entry 2147 (class 0 OID 16424)
-- Dependencies: 183
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, cpf, crm, email, especialidade, nascimento, nome, senha, telefone, tipo, username) VALUES (1, 'null', '1231231', 'agathabmartinsr@gmail.com', 'asdnasd', '1999-04-26', 'AGATHA BHENARES ALVES MARTINS RODRIGUES', '123456', '88994527526', 'medico', 'agathabhe');
INSERT INTO public.users (id, cpf, crm, email, especialidade, nascimento, nome, senha, telefone, tipo, username) VALUES (14, '1', 'null', 'agathabmartinsr@gmail.com', 'null', '1999-04-26', 'AGATHA BHENARES ALVES MARTINS RODRIGUES', '1234567', '88994527526', 'secretario', 'agathabhe');
INSERT INTO public.users (id, cpf, crm, email, especialidade, nascimento, nome, senha, telefone, tipo, username) VALUES (15, '1', 'null', 'stessysousa@gmail.com', 'null', '1999-03-12', 'Antonia Stefanne Sousa Alves', '12345678', '88991212121', 'secretario', 'stessysousa');
INSERT INTO public.users (id, cpf, crm, email, especialidade, nascimento, nome, senha, telefone, tipo, username) VALUES (19, '12345678908', 'null', 'igor@mail.com', 'null', '1997-04-09', 'Igor Claudino', '1234567', '98766544', 'secretario', 'igor_');
INSERT INTO public.users (id, cpf, crm, email, especialidade, nascimento, nome, senha, telefone, tipo, username) VALUES (20, '87657865676', 'null', 'igor@mail.com', 'null', '1997-04-09', 'Igor Claudino', '123456', '98777667', 'secretario', 'igor_c');
INSERT INTO public.users (id, cpf, crm, email, especialidade, nascimento, nome, senha, telefone, tipo, username) VALUES (21, '78909876787', 'null', 'igor@mail.com', 'null', '1997-04-09', 'Igor Claudino', '567765', '9887666677', 'secretario', 'igorc');
INSERT INTO public.users (id, cpf, crm, email, especialidade, nascimento, nome, senha, telefone, tipo, username) VALUES (3, '99999999999', 'null', 'igor@mail.com.br', 'null', '1997-04-09', 'Igor Claudino', '654321', '88999999999', 'secretario', 'igor');
INSERT INTO public.users (id, cpf, crm, email, especialidade, nascimento, nome, senha, telefone, tipo, username) VALUES (22, 'null', '123456', 'nenis@mail.com', 'Cirurgiã ', '1999-04-26', 'Nenis do Igor', '1234567', '919291921929', 'medico', 'nenis');


--
-- TOC entry 2028 (class 2606 OID 16421)
-- Name: paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id);


--
-- TOC entry 2030 (class 2606 OID 16431)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-06-24 17:08:38 -03

--
-- PostgreSQL database dump complete
--

