CREATE DATABASE IF NOT EXISTS creditos;
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON creditos.* TO 'user'@'%';
FLUSH PRIVILEGES;