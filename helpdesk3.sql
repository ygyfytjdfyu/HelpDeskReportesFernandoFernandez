-- =====================================================================
--  Sistema HelpDesk - Esquema de base de datos
--  Base: helpdesk3   |   Motor: MySQL / MariaDB (XAMPP)
--
--  Para ejecutar:
--    1) Iniciar MySQL en el Panel de Control de XAMPP
--    2) Abrir phpMyAdmin -> pestaña "Importar" -> elegir este archivo
--       (o por consola:  mysql -u root < database/helpdesk3.sql )
--
--  NOTA: las contraseñas se guardan en texto plano para simplificar el
--  ejercicio. En un sistema real deben guardarse con hash (BCrypt).
-- =====================================================================

CREATE DATABASE IF NOT EXISTS helpdesk3
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_general_ci;

USE helpdesk3;

-- Se eliminan en orden inverso a las dependencias (por las llaves foráneas)
DROP TABLE IF EXISTS incidencia;
DROP TABLE IF EXISTS tecnico;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS especialidad;


-- ---------------------------------------------------------------------
-- ESPECIALIDAD : áreas de conocimiento de los técnicos
-- ---------------------------------------------------------------------
CREATE TABLE especialidad (
    id_especialidad INT AUTO_INCREMENT PRIMARY KEY,
    nombre          VARCHAR(60)  NOT NULL UNIQUE,
    descripcion     VARCHAR(200)
) ENGINE=InnoDB;


-- ---------------------------------------------------------------------
-- CATEGORIA : tipo de incidencia (Hardware, Software, Redes, ...)
-- ---------------------------------------------------------------------
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(60)  NOT NULL UNIQUE,
    descripcion  VARCHAR(200)
) ENGINE=InnoDB;


-- ---------------------------------------------------------------------
-- USUARIO : personas que reportan incidencias
-- ---------------------------------------------------------------------
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    ci         VARCHAR(20)  NOT NULL UNIQUE,
    nombre     VARCHAR(60)  NOT NULL,
    apellido   VARCHAR(60)  NOT NULL,
    telefono   VARCHAR(20),
    email      VARCHAR(100),
    cargo      VARCHAR(60),
    usuario    VARCHAR(40)  NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    estado     TINYINT(1)   NOT NULL DEFAULT 1
) ENGINE=InnoDB;


-- ---------------------------------------------------------------------
-- TECNICO : personal que atiende y resuelve las incidencias
-- ---------------------------------------------------------------------
CREATE TABLE tecnico (
    id_tecnico      INT AUTO_INCREMENT PRIMARY KEY,
    ci              VARCHAR(20)  NOT NULL UNIQUE,
    nombre          VARCHAR(60)  NOT NULL,
    apellido        VARCHAR(60)  NOT NULL,
    telefono        VARCHAR(20),
    email           VARCHAR(100),
    usuario         VARCHAR(40)  NOT NULL UNIQUE,
    password        VARCHAR(100) NOT NULL,
    id_especialidad INT,
    estado          TINYINT(1)   NOT NULL DEFAULT 1,
    CONSTRAINT fk_tecnico_especialidad
        FOREIGN KEY (id_especialidad)
        REFERENCES especialidad (id_especialidad)
        ON DELETE SET NULL
        ON UPDATE CASCADE
) ENGINE=InnoDB;


-- ---------------------------------------------------------------------
-- INCIDENCIA : el ticket reportado por un usuario
-- ---------------------------------------------------------------------
CREATE TABLE incidencia (
    id_incidencia  INT AUTO_INCREMENT PRIMARY KEY,
    titulo         VARCHAR(120) NOT NULL,
    descripcion    TEXT,
    fecha_registro DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_solucion DATETIME     NULL,
    prioridad      ENUM('BAJA','MEDIA','ALTA')                        NOT NULL DEFAULT 'MEDIA',
    estado         ENUM('PENDIENTE','EN_PROCESO','RESUELTO','CERRADO') NOT NULL DEFAULT 'PENDIENTE',
    solucion       TEXT,
    id_usuario     INT NOT NULL,
    id_tecnico     INT NULL,
    id_categoria   INT NULL,
    CONSTRAINT fk_incidencia_usuario
        FOREIGN KEY (id_usuario)   REFERENCES usuario (id_usuario),
    CONSTRAINT fk_incidencia_tecnico
        FOREIGN KEY (id_tecnico)   REFERENCES tecnico (id_tecnico)   ON DELETE SET NULL,
    CONSTRAINT fk_incidencia_categoria
        FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria) ON DELETE SET NULL
) ENGINE=InnoDB;


-- =====================================================================
--  DATOS DE PRUEBA
-- =====================================================================

INSERT INTO especialidad (nombre, descripcion) VALUES
    ('Soporte Hardware', 'Mantenimiento y reparación de equipos físicos'),
    ('Soporte Software', 'Instalación y configuración de programas'),
    ('Redes y Comunicaciones', 'Cableado, routers, switches y conectividad'),
    ('Base de Datos',   'Administración y respaldo de bases de datos'),
    ('Seguridad',       'Antivirus, firewall y control de accesos');

INSERT INTO categoria (nombre, descripcion) VALUES
    ('Hardware',   'Fallas en equipos e impresoras'),
    ('Software',   'Errores de sistema operativo o aplicaciones'),
    ('Red',        'Problemas de internet o red interna'),
    ('Correo',     'Incidencias con el correo institucional'),
    ('Accesos',    'Olvido de contraseñas y permisos');

INSERT INTO usuario (ci, nombre, apellido, telefono, email, cargo, usuario, password) VALUES
    ('7854123', 'Maria',  'Quispe',  '71234567', 'mquispe@empresa.com',  'Secretaria',  'mquispe',  '123'),
    ('6987412', 'Jorge',  'Vargas',  '72345678', 'jvargas@empresa.com',  'Contador',    'jvargas',  '123'),
    ('9123456', 'Lucia',  'Flores',  '73456789', 'lflores@empresa.com',  'Recepcion',   'lflores',  '123');

INSERT INTO tecnico (ci, nombre, apellido, telefono, email, usuario, password, id_especialidad) VALUES
    ('5412789', 'Santos', 'Mamani',  '76543210', 'smamani@empresa.com',  'santos',  'mamani', 1),
    ('4789561', 'Ana',    'Santos',  '75432109', 'asantos@empresa.com',  'asantos',  'admin', 2),
    ('8123654', 'Pedro',  'Choque',  '74321098', 'pchoque@empresa.com',  'pchoque',  'admin', 3);
