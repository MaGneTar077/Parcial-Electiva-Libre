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


Integrantes
Luis Santiago Gonzalezrubio Padilla
Habib Sebastian Gonzalez Julio
Daniel Andres Palacio Mercado
Gustavo Enrique Beltran Pulido
Juan David martienz Gracia
