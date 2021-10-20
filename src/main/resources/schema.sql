create table employee
(
    id bigserial primary key,
    lastName varchar(100),
    firstName varchar(100),
    patronymicName varchar(100),
    job varchar(100)
);

create table assignment
(
    id bigserial primary key,
    subject  varchar(100),
    deadline DATE,
    controlSign varchar(100),
    executionSign varchar(100),
    textOfAssigment varchar(100),
    authorOfAssigment bigint,
    performersOfAssigment bigint,
    foreign key (authorOfAssigment) references employee(id),
    foreign key (performersOfAssigment) references employee(id)
);

create table organization
(
    id bigserial primary key,
    nameOrg  varchar(100),
    fizAdressOrg varchar(100),
    urAdressOrg varchar(100),
    supervisorOrg bigint,
    foreign key (supervisorOrg) references employee(id)
);

create table subdivision
(
    id bigserial primary key,
    nameSubdivision varchar(100),
    contactsSubdivision varchar(100),
    supervisorSubdivision bigint,
    foreign key (supervisorSubdivision) references employee(id)
);