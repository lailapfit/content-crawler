BEGIN TRANSACTION

CREATE TABLE content 
(
   id serial not null,
   url varchar not null,
   title varchar,
   body varchar,
   links varchar
);

rollback
commit;