INSERT INTO ROLE (NAME) VALUES ('USER');

-- Le mot de passe a été haché avec BCrypt
INSERT INTO user (first_name, last_name, login, PASSWORD, role_id) 
SELECT 'Jean-Louis','Poupou','user','$2a$12$Mx.sUw4ErEC1M5bBx1y.UOBoI.gy4GjZN6/vk.WGBVh15o83.gMxC', ID
FROM ROLE
WHERE ROLE.NAME = 'USER';