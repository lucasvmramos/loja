create table usuario_rule(
    id bigint not null auto_increment,
    usuario_id bigint not null,
    rule_id bigint not null,
    primary key(id),
    foreign key(usuario_id) references usuario (id),
    foreign key(rule_id) references rule (id)
);