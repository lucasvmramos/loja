  create table produto(
      id bigint not null auto_increment,
      nome varchar(50) not null,
      descricao varchar(100) not null,
      valor bigint not null,
      categoria_id bigint not null,
      primary key(id),
      foreign key(categoria_id) references categoria(id)
  );