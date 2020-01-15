create database crm;
use crm;

create table if not exists tb_pessoa (
id int unsigned not null auto_increment primary key,
nome varchar(100) not null,
email varchar(150) not null,
telefone varchar(20) not null,
endereco varchar(255) not null
)engine = InnoDB;

create table if not exists tb_funcionario (
id int unsigned not null auto_increment primary key,
fk_id_pessoa int unsigned not null,
login_funcionario varchar(20) unique not null,
senha_funcionario varchar(10) not null,
ativado boolean not null,
admin boolean not null,
foreign key(fk_id_pessoa) references tb_pessoa(id)
)engine = InnoDB;

create table if not exists tb_visita (
id int unsigned not null auto_increment primary key,
fk_id_funcionario int unsigned not null,
fk_id_cliente int unsigned not null,
data_visita date not null,
concluido char(1),
detalhes mediumtext
)engine = InnoDB;

create table if not exists tb_cliente (
id int unsigned not null auto_increment primary key,
fk_id_pessoa int unsigned not null,
cpf varchar(30) unique not null
)engine = InnoDB;

create table if not exists tb_atendimento (
id int unsigned not null auto_increment primary key,
fk_id_cliente int unsigned not null,
fk_id_funcionario int unsigned not null,
fk_id_produto int unsigned not null,
data_atendimento date not null,
titulo_atendimento varchar(45) not null,
detalhes_atendimento mediumtext not null,
concluido char(1)
)engine = InnoDB;

create table if not exists tb_venda (
id int unsigned not null auto_increment primary key,
fk_id_cliente int unsigned not null,
data_venda date,
valor_venda decimal(7,2)
)engine = InnoDB;

create table if not exists tb_venda_produto (
id int unsigned not null auto_increment primary key,
fk_id_venda int unsigned not null,
fk_id_produto int unsigned not null,
qtde_vendida int not null,
preco_unidade decimal(7,2)
)engine = InnoDB;

create table if not exists tb_produto (
id int unsigned not null auto_increment primary key,
fk_id_fornecedor int unsigned not null,
nome_produto varchar(100) not null,
qtde_estoque int not null,
preco_custo decimal(7,2) not null,
preco_venda decimal(7,2)
)engine = InnoDB;

create table if not exists tb_fornecedor (
id int unsigned not null auto_increment primary key,
fk_id_pessoa int unsigned not null,
cnpj_fornecedor varchar(30) not null,
nome_contato varchar(100) not null
)engine = InnoDB;

alter table tb_cliente add constraint fk_pessoa_tbcliente 
foreign key(fk_id_pessoa) references tb_pessoa(id);

alter table tb_visita add constraint fk_funcionario_tbvisita 
foreign key(fk_id_funcionario) references tb_funcionario(id);

alter table tb_visita add constraint fk_cliente_tbvisita 
foreign key(fk_id_cliente) references tb_cliente(id);

alter table tb_venda_produto add constraint fk_venda 
foreign key(fk_id_venda) references tb_venda(id);

alter table tb_venda_produto add constraint fk_produto 
foreign key(fk_id_produto) references tb_produto(id);

alter table tb_venda add constraint fk_cliente_tbvenda 
foreign key(fk_id_cliente) references tb_cliente(id);

alter table tb_atendimento add constraint fk_cliente_tbatendimento 
foreign key(fk_id_cliente) references tb_cliente(id);

alter table tb_atendimento add constraint fk_funcionario_tbatendimento 
foreign key(fk_id_funcionario) references tb_funcionario(id);

alter table tb_produto add constraint fk_fornecedor 
foreign key(fk_id_fornecedor) references tb_fornecedor(id);

alter table tb_fornecedor add constraint fk_pessoa_tbfornecedor 
foreign key(fk_id_pessoa) references tb_pessoa(id);

alter table tb_atendimento add constraint fk_produto_tbatendimento 
foreign key(fk_id_produto) references tb_produto(id);






