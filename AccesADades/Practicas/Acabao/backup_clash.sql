PGDMP      '    	             }            clash    16.4    16.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16399    clash    DATABASE     x   CREATE DATABASE clash WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE clash;
                postgres    false            �            1259    16417    cartes    TABLE     �   CREATE TABLE public.cartes (
    id integer NOT NULL,
    idjug integer NOT NULL,
    nom character varying,
    nivell integer DEFAULT 1,
    raresa character varying
);
    DROP TABLE public.cartes;
       public         heap    postgres    false            �            1259    16400    jugadors    TABLE        CREATE TABLE public.jugadors (
    id integer NOT NULL,
    nom character varying(50) NOT NULL,
    nivell integer DEFAULT 1 NOT NULL,
    copes integer DEFAULT 0 NOT NULL,
    oro bigint DEFAULT 0 NOT NULL,
    gemes bigint DEFAULT 0 NOT NULL,
    estrelles bigint DEFAULT 0 NOT NULL
);
    DROP TABLE public.jugadors;
       public         heap    postgres    false            �            1259    16410    partides    TABLE     �   CREATE TABLE public.partides (
    id integer NOT NULL,
    id_jug1 integer NOT NULL,
    id_jug2 integer NOT NULL,
    resultat character varying(3) NOT NULL,
    temps character varying(4) NOT NULL,
    tipus character varying NOT NULL
);
    DROP TABLE public.partides;
       public         heap    postgres    false            �          0    16417    cartes 
   TABLE DATA           @   COPY public.cartes (id, idjug, nom, nivell, raresa) FROM stdin;
    public          postgres    false    217   �       �          0    16400    jugadors 
   TABLE DATA           Q   COPY public.jugadors (id, nom, nivell, copes, oro, gemes, estrelles) FROM stdin;
    public          postgres    false    215   �       �          0    16410    partides 
   TABLE DATA           P   COPY public.partides (id, id_jug1, id_jug2, resultat, temps, tipus) FROM stdin;
    public          postgres    false    216          b           2606    16424    cartes cartes_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cartes
    ADD CONSTRAINT cartes_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cartes DROP CONSTRAINT cartes_pkey;
       public            postgres    false    217            ^           2606    16409    jugadors jugadors_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.jugadors
    ADD CONSTRAINT jugadors_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.jugadors DROP CONSTRAINT jugadors_pkey;
       public            postgres    false    215            `           2606    16416    partides partides_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.partides
    ADD CONSTRAINT partides_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.partides DROP CONSTRAINT partides_pkey;
       public            postgres    false    216            �   �   x�e���0�/O� �#B������V��
ϏQUb=��N�a'-��g[�v�b��K&E���0�epܲ?S2ʟ��c�j�j�9�j��!^ə)����H���TX��ف�����&8I?|�Gz�;����hc��k��gs�c^�D      �   �   x���
�@E����H�L��^p�P\e,+��������9�1�_��׺��`��#��_sۃs�0(�O�L�a�޾�|�aX
�(P��۲;�Cܗ��0%ý�鳲��)��5�.���:�6ĆC�y"��5$h      �   �   x�M���0�����t.��Yܰ0�	J"�<X�.g��oG�pHTXN	㳬۲���F�dW�s����Z��Z�my�e
�5�=K�\��.��S��빳31�:�_��u����(�(��%hv;���.�X��>���%���e6J     