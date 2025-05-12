USE db_mod_3;

-- Insertar datos en la tabla componentes (padre)
INSERT INTO componentes (id_componente, descripcion, marca, modelo, costo, precio_base, tipo_componente) VALUES
-- Discos duros
('DD001', 'Disco Duro SSD 500GB', 'Samsung', '870 EVO', 120.00, 199.99, 'DISCO_DURO'),
('DD002', 'Disco Duro NVMe 1TB', 'Western Digital', 'SN850X', 180.00, 299.99, 'DISCO_DURO'),
('DD003', 'Disco Duro HDD 2TB', 'Seagate', 'BarraCuda', 60.00, 89.99, 'DISCO_DURO'),

-- Monitores
('MON001', 'Monitor Gaming 27" 144Hz', 'ASUS', 'TUF VG27AQ', 250.00, 399.99, 'MONITOR'),
('MON002', 'Monitor 4K 32"', 'LG', '32UN650-W', 350.00, 499.99, 'MONITOR'),
('MON003', 'Monitor Curvo 34"', 'Samsung', 'Odyssey G5', 300.00, 449.99, 'MONITOR'),

-- Tarjetas de video
('GPU001', 'Tarjeta Gráfica RTX 3060', 'NVIDIA', 'RTX 3060', 300.00, 499.99, 'TARJETA_VIDEO'),
('GPU002', 'Tarjeta Gráfica RX 6700 XT', 'AMD', 'RX 6700 XT', 350.00, 549.99, 'TARJETA_VIDEO'),
('GPU003', 'Tarjeta Gráfica RTX 4090', 'NVIDIA', 'RTX 4090', 1200.00, 1999.99, 'TARJETA_VIDEO'),

-- PCs (componentes base)
('PC001', 'PC Gaming Alta Gama', 'Custom', 'NVIDIA Edition', 800.00, 1299.99, 'PC'),
('PC002', 'PC Oficina', 'Custom', 'Basic', 300.00, 499.99, 'PC'),
('PC003', 'PC Streaming', 'Custom', 'Stream Pro', 600.00, 899.99, 'PC');

-- Insertar datos específicos para discos duros
INSERT INTO discos_duros (id_componente, capacidad_alm) VALUES
('DD001', '500GB SSD'),
('DD002', '1TB NVMe'),
('DD003', '2TB HDD');

-- Insertar datos específicos para monitores
INSERT INTO monitores (id_componente, tamano_pantalla, resolucion, tipo_panel, tasa_refresco) VALUES
('MON001', '27"', '2560x1440', 'IPS', 144),
('MON002', '32"', '3840x2160', 'IPS', 60),
('MON003', '34"', '3440x1440', 'VA', 165);

-- Insertar datos específicos para tarjetas de video
INSERT INTO tarjetas_video (id_componente, memoria) VALUES
('GPU001', '12GB GDDR6'),
('GPU002', '12GB GDDR6'),
('GPU003', '24GB GDDR6X');

-- Insertar datos para PCs
INSERT INTO pcs (id_componente, descuento_precio_agregado) VALUES
('PC001', 15.00),  -- Descuento especial para PC gamer
('PC002', 20.00),  -- Descuento estándar
('PC003', 10.00);  -- Descuento menor para equipo streaming

-- Establecer relaciones entre PCs y componentes (configuraciones de equipos)
INSERT INTO pc_componentes (id_pc, id_componente, cantidad) VALUES
-- PC Gaming (RTX 4090 + Monitor gaming + SSD NVMe)
('PC001', 'GPU003', 1),
('PC001', 'MON001', 1),
('PC001', 'DD002', 1),
('PC001', 'DD001', 1),  -- SSD adicional

-- PC Oficina (Monitor 4K + HDD)
('PC002', 'MON002', 1),
('PC002', 'DD003', 1),

-- PC Streaming (Monitor curvo + GPU media + SSD)
('PC003', 'MON003', 1),
('PC003', 'GPU001', 1),
('PC003', 'DD001', 1);