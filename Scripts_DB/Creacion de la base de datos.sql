-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS db_mod_3;
USE db_mod_3;

-- Tabla base Componente
CREATE TABLE IF NOT EXISTS componentes (
    id_componente VARCHAR(50) PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    costo DECIMAL(10,2) NOT NULL,
    precio_base DECIMAL(10,2) NOT NULL,
    tipo_componente ENUM('DISCO_DURO', 'MONITOR', 'PC', 'TARJETA_VIDEO') NOT NULL
);

-- Tabla para DiscoDuroDTO
CREATE TABLE IF NOT EXISTS discos_duros (
    id_componente VARCHAR(50) PRIMARY KEY,
    capacidad_alm VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_componente) REFERENCES componentes(id_componente) ON DELETE CASCADE
);

-- Tabla para MonitorDTO
CREATE TABLE IF NOT EXISTS monitores (
    id_componente VARCHAR(50) PRIMARY KEY,
    tamano_pantalla VARCHAR(20) NOT NULL,
    resolucion VARCHAR(20) NOT NULL,
    tipo_panel VARCHAR(30) NOT NULL,
    tasa_refresco INT NOT NULL,
    FOREIGN KEY (id_componente) REFERENCES componentes(id_componente) ON DELETE CASCADE
);

-- Tabla para TarjetaVideoDTO
CREATE TABLE IF NOT EXISTS tarjetas_video (
    id_componente VARCHAR(50) PRIMARY KEY,
    memoria VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_componente) REFERENCES componentes(id_componente) ON DELETE CASCADE
);

-- Tabla para PcDTO
CREATE TABLE IF NOT EXISTS pcs (
    id_componente VARCHAR(50) PRIMARY KEY,
    descuento_precio_agregado DECIMAL(5,2) DEFAULT 20.00,
    FOREIGN KEY (id_componente) REFERENCES componentes(id_componente) ON DELETE CASCADE
);

-- Tabla de relación entre PCs y Componentes (ahora relacionando con la tabla componentes)
CREATE TABLE IF NOT EXISTS pc_componentes (
    id_pc VARCHAR(50) NOT NULL,
    id_componente VARCHAR(50) NOT NULL,
    cantidad INT DEFAULT 1,
    PRIMARY KEY (id_pc, id_componente),
    FOREIGN KEY (id_pc) REFERENCES pcs(id_componente) ON DELETE CASCADE,
    FOREIGN KEY (id_componente) REFERENCES componentes(id_componente) ON DELETE CASCADE
);

-- Índices para mejorar el rendimiento
CREATE INDEX idx_componentes_tipo ON componentes(tipo_componente);
CREATE INDEX idx_componentes_marca ON componentes(marca);