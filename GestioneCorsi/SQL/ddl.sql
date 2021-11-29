
create table corsista(
    nome_corsista varchar2(30) not null,
    cognome_corsista varchar2(30) not null,
    cod_corsista int,
    precedenti_formativi int not null,
    constraint p_cod_corsista primary key(cod_corsista));

create table docente(
    nome_docente varchar2(30) not null,
    cognome_docente varchar2(30) not null,
    cv_docente varchar2(200) not null,
    cod_docente int,
    constraint p_cod_docente primary key(cod_docente));

create table admin(
    nome_admin varchar2(30) not null,
    cognome_admin varchar2(30) not null,
    username varchar2(30),
    password varchar2(500) not null,
    constraint p_username_admin primary key(username));

create table corso(
    cod_corso int primary key references docente(cod_docente),
    nome_corso varchar2(30) not null,
    data_inizio date not null,
    data_fine date not null,
    commento varchar2(200),
    aula_corso varchar2(30) not null);

create table corso_corsista(
    cod_corso int,
    cod_corsista int,
    constraint f_cod_corso foreign key(cod_corso) references corso(cod_corso) on delete cascade,
    constraint f_cod_corsista foreign key(cod_corsista) references corsista(cod_corsista) on delete cascade,
    constraint p_cod_corso_corsista primary key(cod_corso, cod_corsista));

    create sequence corsista_seq;