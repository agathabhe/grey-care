--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.17
-- Dumped by pg_dump version 9.5.17

-- Started on 2019-05-21 22:58:58 -03

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
-- TOC entry 2154 (class 1262 OID 16384)
-- Name: grey_care; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE grey_care WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';


ALTER DATABASE grey_care OWNER TO postgres;

\connect grey_care

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
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 183 (class 1259 OID 16397)
-- Name: pacientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pacientes (
    id bigint NOT NULL,
    nome text,
    cpf text,
    nascimento text,
    estado_civil text,
    endereco text,
    cep text,
    email text,
    alergias text,
    tipo_sanguineo text,
    doador text,
    telefone text
);


ALTER TABLE public.pacientes OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 16403)
-- Name: paciente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.paciente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.paciente_id_seq OWNER TO postgres;

--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 184
-- Name: paciente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.paciente_id_seq OWNED BY public.pacientes.id;


--
-- TOC entry 181 (class 1259 OID 16385)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    username text,
    senha text,
    tipo text,
    nome text,
    crm text,
    telefone text,
    especialidade text,
    email text,
    nascimento text,
    cpf text
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16388)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 182
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 2030 (class 2604 OID 16405)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pacientes ALTER COLUMN id SET DEFAULT nextval('public.paciente_id_seq'::regclass);


--
-- TOC entry 2029 (class 2604 OID 16390)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 184
-- Name: paciente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.paciente_id_seq', 12, true);


--
-- TOC entry 2147 (class 0 OID 16397)
-- Dependencies: 183
-- Data for Name: pacientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pacientes (id, nome, cpf, nascimento, estado_civil, endereco, cep, email, alergias, tipo_sanguineo, doador, telefone) VALUES (5, 'AGATHA BHENARES ALVES MARTINS RODRIGUES''', '065.160.603-98''', '1999-04-26', 'solteiro', 'Rua Marechal Hermes, 116, A', '63700000', 'agathabmartinsr@gmail.com', 'sahdab', '2', 'sim', '88994527526');
INSERT INTO public.pacientes (id, nome, cpf, nascimento, estado_civil, endereco, cep, email, alergias, tipo_sanguineo, doador, telefone) VALUES (6, 'Agnes Bhenazir Alves Martins Rodrigues', '1923712389312', '1994-09-11', 'solteiro', 'Rua Marechal Hermes, 116, A', '63700000', 'agathabmartinsr@gmail.com', 'poeira', '1', 'nao', '88994527526');
INSERT INTO public.pacientes (id, nome, cpf, nascimento, estado_civil, endereco, cep, email, alergias, tipo_sanguineo, doador, telefone) VALUES (7, 'AGATHA BHENARES ALVES MARTINS RODRIGUES', '1728919', '1999-09-02', 'solteiro', 'Rua Marechal Hermes, 116, A', '63700000', 'agathabmartinsr@gmail.com', 'nada', '3', 'sim', '88994527526');
INSERT INTO public.pacientes (id, nome, cpf, nascimento, estado_civil, endereco, cep, email, alergias, tipo_sanguineo, doador, telefone) VALUES (8, 'Igor Claudino', '1239201010', '1997-04-09', 'solteiro', 'Rua Marechal Hermes', '63700000', 'igorclaudino@gmail.com', 'asdda', '7', 'sim', '88994527526');
INSERT INTO public.pacientes (id, nome, cpf, nascimento, estado_civil, endereco, cep, email, alergias, tipo_sanguineo, doador, telefone) VALUES (9, 'AGATHA BHENARES ALVES MARTINS RODRIGUES', '2323899824327', '1999-04-04', 'solteiro', 'Rua Marechal Hermes', '63700000', 'agathabmartinsr@gmail.com', 'NADA', '6', 'nao', '88994527526');
INSERT INTO public.pacientes (id, nome, cpf, nascimento, estado_civil, endereco, cep, email, alergias, tipo_sanguineo, doador, telefone) VALUES (10, 'AGATHA BHENARES ALVES MARTINS RODRIGUES', '23456789', '1999-04-09', 'solteiro', 'Rua Marechal Hermes', '63700000', 'agathabmartinsr@gmail.com', 'nada', '3', 'nao', '88994527526');
INSERT INTO public.pacientes (id, nome, cpf, nascimento, estado_civil, endereco, cep, email, alergias, tipo_sanguineo, doador, telefone) VALUES (11, 'AGATHA BHENARES ALVES MARTINS RODRIGUES', '0987654567', '1999-04-26', 'solteiro', 'Rua Marechal Hermes', '63700000', 'agathabmartinsr@gmail.com', 'nada', '7', 'nao', '88994527526');
INSERT INTO public.pacientes (id, nome, cpf, nascimento, estado_civil, endereco, cep, email, alergias, tipo_sanguineo, doador, telefone) VALUES (12, 'AGATHA BHENARES ALVES MARTINS RODRIGUES', '098765', '1999-04-26', 'solteiro', 'Rua Marechal Hermes', '63700000', 'agathabmartinsr@gmail.com', 'sfd', '8', 'sim', '88994527526');


--
-- TOC entry 2145 (class 0 OID 16385)
-- Dependencies: 181
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, username, senha, tipo, nome, crm, telefone, especialidade, email, nascimento, cpf) VALUES (2, 'yutydtkjh', 'gfhv', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO public.users (id, username, senha, tipo, nome, crm, telefone, especialidade, email, nascimento, cpf) VALUES (3, NULL, 'agathabhe', 'AGATHA BHENARES ALVES MARTINS RODRIGUES', '123456', '127189', '88994527526', 'clinico geral', 'agathabmartinsr@gmail.com', '1999-04-26', 'null');
INSERT INTO public.users (id, username, senha, tipo, nome, crm, telefone, especialidade, email, nascimento, cpf) VALUES (4, NULL, NULL, 'undefined', NULL, NULL, 'undefined', NULL, 'undefined', 'undefined', 'undefined');
INSERT INTO public.users (id, username, senha, tipo, nome, crm, telefone, especialidade, email, nascimento, cpf) VALUES (5, NULL, 'igor', 'Igor', '1234', '1239293', '88994527526', 'neurocirurgião', 'igor@mail.com', '1997-04-09', 'null');
INSERT INTO public.users (id, username, senha, tipo, nome, crm, telefone, especialidade, email, nascimento, cpf) VALUES (6, NULL, 'grakt', 'igorkasjdka', '1234', '23091293819', '2738127389', 'sdakksdal', 'igor@gmail.com', '1997-04-09', 'null');
INSERT INTO public.users (id, username, senha, tipo, nome, crm, telefone, especialidade, email, nascimento, cpf) VALUES (7, NULL, 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null');
INSERT INTO public.users (id, username, senha, tipo, nome, crm, telefone, especialidade, email, nascimento, cpf) VALUES (8, 'secretario', 'dasdad', 'asdjkasdha', '123123', 'null', '123123', 'null', 'igor@mail.com', '1997-04-09', '12312');
INSERT INTO public.users (id, username, senha, tipo, nome, crm, telefone, especialidade, email, nascimento, cpf) VALUES (9, 'medico', 'iudiu', 'iudiu filho', '123123', '98279', '8899999999', 'medico ofta', 'igor@mail.com', '1999-05-09', 'null');
INSERT INTO public.users (id, username, senha, tipo, nome, crm, telefone, especialidade, email, nascimento, cpf) VALUES (10, 'agathabhe', '123123', 'secretario', 'AGATHA BHENARES ALVES MARTINS RODRIGUES', 'null', '88994527526', 'null', 'agathabmartinsr@gmail.com', '1999-04-26', '9876543456789');


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 182
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 10, true);


--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-05-21 22:58:59 -03

--
-- PostgreSQL database dump complete
--

