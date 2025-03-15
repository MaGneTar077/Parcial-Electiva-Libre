# Parcial-Electiva-Libre
Microservicio que permita crear un usuario gestionar tu cuenta hacer transacciones manejar errores y enviar notificaciones

BD PostgreSQL Microservicio Cuentas y Transacciones
CREATE TABLE account (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    bank_account_number VARCHAR(20) NOT NULL UNIQUE,
    account_holder VARCHAR(100) NOT NULL,
    cvc_encrypted TEXT NOT NULL,
    due_date VARCHAR(5) NOT NULL,
    user_id UUID NOT NULL, -- Ya no es FOREIGN KEY, solo un UUID referencial
    balance NUMERIC(15,2) NOT NULL DEFAULT 0.00
);

Crear cuenta:

http://localhost:8080/account

{
  "bankAccountNumber": "123456789",
  "accountHolder": "Luis Gonzalezrubio",
  "cvcEncrypted": "encryptedCVC",
  "dueDate": "12/25",
  "userId": "550e8400-e29b-41d4-a716-446655440000",
  "balance": 100.0
}

Get cuenta

http://localhost:8080/account/7f4a329a-7ac7-41fb-843b-edac5d02c162


Unido ya:
POST

http://localhost:8080/account

{
  "bankAccountNumber": "12345678910",
  "accountHolder": "John Doe",
  "cvcEncrypted": "encrypted-cvc",
  "dueDate": "2025-12-31",
  "userId": "f47ac10b-58cc-4372-a567-0e02b2c3d479",
  "balance": 1000.0
}

Get
http://localhost:8080/account/08db181f-c00f-4f0f-b480-abd962ba3b6d

POST
http://localhost:8080/account/purchase?accountId=08db181f-c00f-4f0f-b480-abd962ba3b6d&amount=200.0

POST
http://localhost:8080/account/recharge?accountId=08db181f-c00f-4f0f-b480-abd962ba3b6d&amount=500.0

GET
http://localhost:8080/transactions/

POST
http://localhost:8080/account/send?fromAccountId=08db181f-c00f-4f0f-b480-abd962ba3b6d&toAccountId=7e4a630f-7320-4493-b71d-3b519f94fb7d&amount=800.0

-----------------------------------------------------------------------------------------

Post
http://localhost:8080/user

{
  "name": "John",
  "lastname": "Doe",
  "age": 30,
  "email": "john.doe@example.com",
  "phone": "1234567890",
  "gender": "Male",
  "password": "password123"
}

Get
http://localhost:8080/user

Patch
http://localhost:8080/user/1

{
  "name": "John",
  "lastname": "Doe",
  "age": 35,
  "email": "john.doe@example.com",
  "phone": "1234567890",
  "gender": "Male",
  "password": "password123"
}

Post
http://localhost:8080/user/login?email=john.doe@example.com&password=password123


Post
http://localhost:8080/user/validate?userId=1

Post
http://localhost:8080/user/logout?userId=1

-------------------------------------------------------------------------------------------

Post
http://localhost:8080/api/notifications/send?destinatario=usuario@example.com&asunto=Prueba de notificación&contenido=Este es el contenido de la notificación.

Get
http://localhost:8080/api/notifications/4b076f04-7efd-487d-b571-d85975d4dc61

Get
http://localhost:8080/api/notifications

Get
http://localhost:8080/api/notifications/status/false

--------------------------------------------------------------------------------------------

Post
http://localhost:8080/Logs/

Get
http://localhost:8080/Logs/


Integrantes
Luis Santiago Gonzalezrubio Padilla
Habib Sebastian Gonzalez Julio
Daniel Andres Palacio Mercado
Gustavo Enrique Beltran Pulido
Juan David Martinez Gracia
