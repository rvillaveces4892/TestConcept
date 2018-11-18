DROP TABLE servicio_proveedor CASCADE CONSTRAINTS;

CREATE TABLE servicio_proveedor (
    servicio_id            NUMBER(10) NOT NULL,
    usuario_id_proveedor   NUMBER(10) NOT NULL
);

CREATE INDEX servicio_proveedor_pk ON
    servicio_proveedor (
        servicio_id
    ASC,
        usuario_id_proveedor
    ASC );

ALTER TABLE servicio_proveedor ADD CONSTRAINT servicio_proveedor_pk PRIMARY KEY ( servicio_id,
                                                                                  usuario_id_proveedor );

ALTER TABLE servicio_proveedor
    ADD CONSTRAINT servicio_proveedor_servicio_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicio ( servicio_id )
            ON DELETE CASCADE;

ALTER TABLE servicio_proveedor
    ADD CONSTRAINT servicio_proveedor_usuario_fk FOREIGN KEY ( usuario_id_proveedor )
        REFERENCES usuario ( usuario_id )
            ON DELETE CASCADE;
			
ALTER TABLE USUARIO
  ADD IDENTIFICACION VARCHAR2(20);
  
ALTER TABLE SERVICIO
  ADD NOMBRE VARCHAR2(50);
  
-- CONTASEÑA POR DEFECTO 'uan123*'
UPDATE USUARIO
SET PASSWORD = '8HFBMqY431DS/d/h/1uSmA==';
			