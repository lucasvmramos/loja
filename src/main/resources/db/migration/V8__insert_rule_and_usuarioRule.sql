insert into rule (id, nome) select 1 , 'READ_WRITE';

insert into usuario_rule (id, usuario_id, rule_id) select 1,1,1;