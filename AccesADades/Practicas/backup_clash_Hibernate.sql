PGDMP  "    '    
            }            clash    16.4    16.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16425    clash    DATABASE     x   CREATE DATABASE clash WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE clash;
                postgres    false            �            1259    16442    clan    TABLE     �   CREATE TABLE public.clan (
    idclan integer NOT NULL,
    tipusc character varying(255),
    copas integer,
    idadmin integer,
    nivell integer,
    nom character varying(50)
);
    DROP TABLE public.clan;
       public         heap    postgres    false            �            1259    16437    clans    TABLE     �   CREATE TABLE public.clans (
    idclan integer NOT NULL,
    tipusc character varying(255),
    copas integer,
    idadmin integer,
    nivell integer,
    nom character varying(50)
);
    DROP TABLE public.clans;
       public         heap    postgres    false            �            1259    16431    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    16426    jugadors    TABLE     �   CREATE TABLE public.jugadors (
    id integer NOT NULL,
    copes integer,
    estrelles integer,
    gemes integer,
    nivell integer,
    nom character varying(50),
    oro integer
);
    DROP TABLE public.jugadors;
       public         heap    postgres    false            �            1259    16432    partides    TABLE     �   CREATE TABLE public.partides (
    idpart integer NOT NULL,
    idjug1 integer,
    idjug2 integer,
    resultat character varying(50),
    temps character varying(50),
    tipus character varying(50)
);
    DROP TABLE public.partides;
       public         heap    postgres    false            �          0    16442    clan 
   TABLE DATA           K   COPY public.clan (idclan, tipusc, copas, idadmin, nivell, nom) FROM stdin;
    public          postgres    false    219   �       �          0    16437    clans 
   TABLE DATA           L   COPY public.clans (idclan, tipusc, copas, idadmin, nivell, nom) FROM stdin;
    public          postgres    false    218   �       �          0    16426    jugadors 
   TABLE DATA           Q   COPY public.jugadors (id, copes, estrelles, gemes, nivell, nom, oro) FROM stdin;
    public          postgres    false    215          �          0    16432    partides 
   TABLE DATA           R   COPY public.partides (idpart, idjug1, idjug2, resultat, temps, tipus) FROM stdin;
    public          postgres    false    217   R       �           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 4, true);
          public          postgres    false    216            c           2606    16446    clan clan_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.clan
    ADD CONSTRAINT clan_pkey PRIMARY KEY (idclan);
 8   ALTER TABLE ONLY public.clan DROP CONSTRAINT clan_pkey;
       public            postgres    false    219            a           2606    16441    clans clans_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.clans
    ADD CONSTRAINT clans_pkey PRIMARY KEY (idclan);
 :   ALTER TABLE ONLY public.clans DROP CONSTRAINT clans_pkey;
       public            postgres    false    218            ]           2606    16430    jugadors jugadors_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.jugadors
    ADD CONSTRAINT jugadors_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.jugadors DROP CONSTRAINT jugadors_pkey;
       public            postgres    false    215            _           2606    16436    partides partides_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.partides
    ADD CONSTRAINT partides_pkey PRIMARY KEY (idpart);
 @   ALTER TABLE ONLY public.partides DROP CONSTRAINT partides_pkey;
       public            postgres    false    217            �      x������ � �      �   '   x�3�(�,K,�424�4�44�H-�,�/����� ��      �   =   x�3�442�461�45�4�tN,��/�͌�L8���@INc΀Ԃ̒|N###�=... B�3      �   8   x�3�4�4�4�5�4�21�,�/�K�L�
%u9M�8s3�K�b���� �     