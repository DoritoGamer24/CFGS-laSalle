PGDMP  -    6    	            |            clash    16.4    16.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16399    clash    DATABASE     x   CREATE DATABASE clash WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE clash;
                postgres    false            �            1259    16400    jugadors    TABLE        CREATE TABLE public.jugadors (
    id integer NOT NULL,
    nom character varying(50) NOT NULL,
    nivell integer DEFAULT 1 NOT NULL,
    copes integer DEFAULT 0 NOT NULL,
    oro bigint DEFAULT 0 NOT NULL,
    gemes bigint DEFAULT 0 NOT NULL,
    estrelles bigint DEFAULT 0 NOT NULL
);
    DROP TABLE public.jugadors;
       public         heap    postgres    false            �          0    16400    jugadors 
   TABLE DATA           Q   COPY public.jugadors (id, nom, nivell, copes, oro, gemes, estrelles) FROM stdin;
    public          postgres    false    215   �       U           2606    16409    jugadors jugadors_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.jugadors
    ADD CONSTRAINT jugadors_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.jugadors DROP CONSTRAINT jugadors_pkey;
       public            postgres    false    215            �      x������ � �     