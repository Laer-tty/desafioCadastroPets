create user 'desenvolvedor_sis_pet'@'localhost' identified by '12345678';
grant all privileges on db_pets.* to 'desenvolvedor_sis_pet'@'localhost';
flush privileges;