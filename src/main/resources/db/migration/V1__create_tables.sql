create table associado (
    id integer not null primary key auto_increment,
    nome varchar(250)
);

create table pauta (
    id integer not null primary key auto_increment,
    titulo varchar(250)
);

create table sessao (
    id integer not null primary key auto_increment,
    duracao time,
    data_final time,
    id_pauta integer,
    foreign key (id_pauta) references pauta (id)
);

create table voto (
    id integer not null primary key auto_increment,
    voto char(3),
    id_associado integer not null,
    id_pauta integer not null,
    foreign key (id_associado) references associado (id),
    foreign key (id_pauta) references pauta (id)
);

insert into associado (nome) values ('Luiz Gustavo');
insert into associado (nome) values ('Ana Paula');

insert into pauta (titulo) values ('Abrir uma cooperativa Global?');
insert into pauta (titulo) values ('Fechar a cooperativa da cidade XYZ?');

insert into sessao (duracao, data_final, id_pauta) values ('00:30:00', null, 1);
insert into sessao (duracao, data_final, id_pauta) values ('00:45:00', null, 2);

insert into voto (voto, id_associado, id_pauta) values ('SIM', 1, 1);
insert into voto (voto, id_associado, id_pauta) values ('NAO', 2, 1);

insert into voto (voto, id_associado, id_pauta) values ('SIM', 1, 2);
insert into voto (voto, id_associado, id_pauta) values ('NAO', 2, 2);