/*Proyecto Sweet Seasons*/

--Creacion de las tablas
--Tabla de Clientes
CREATE TABLE CLIENTE (
ID_CLIENTE NUMBER(10) NOT NULL,
NOMBRE VARCHAR2(30) NOT NULL,
PRIMER_APELLIDO VARCHAR2(30) NOT NULL,
SEGUNDO_APELLIDO VARCHAR2(30) NOT NULL,
CORREO VARCHAR2(30),
NUMERO_TELEFONICO NUMBER(8),
DIRECCION VARCHAR2(30),
CONSTRAINT CLIENTE_PK PRIMARY KEY (ID_CLIENTE));

--Tabla de Ventas
CREATE TABLE VENTAS (
ID_VENTA NUMBER (10) NOT NULL,
FECHA_VENTA DATE  NOT NULL,
CANTIDAD INT NOT NULL,
PRECIO INT NOT NULL,
ID_CLIENTE NUMBER(10) NOT NULL,
ID_PRODUCTOS NUMBER(10) NOT NULL,
CONSTRAINT VENTAS_PK PRIMARY KEY (ID_VENTA),
CONSTRAINT VENTAS_CLIENTE_FK FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE(ID_CLIENTE),
CONSTRAINT VENTAS_PRODUCTOS_FK FOREIGN KEY (ID_PRODUCTOS) REFERENCES PRODUCTOS(ID_PRODUCTOS)
);




--Creacion tabla ingredientes
CREATE TABLE INGREDIENTES(
ID_INGREDIENTE NUMBER NOT NULL,
NOMBRE_INGREDIENTE VARCHAR2(25)NOT NULL,
UNIDAD_MEDIDA VARCHAR2(20)NOT NULL,
PRECIO NUMBER NOT NULL,
CANTIDAD NUMBER NOT NULL,
ID_PROVEEDOR NUMBER NOT NULL
)

--CREACION TABLA PROVEEDORES
CREATE TABLE PROVEEDORES(
ID_PROVEEDOR NUMBER NOT NULL,
NOMBRE_PROVEEDOR VARCHAR2(50)NOT NULL,
PRIMER_APELLIDO VARCHAR2(50)NOT NULL,
SEGUNDO_APELLIDO VARCHAR2(50)NOT NULL,
NUMERO_TELEFONICO NUMBER(20) NOT NULL,
CORREO_ELECTRONICO VARCHAR2(50)NOT NULL,
ESTADO VARCHAR2(50)NOT NULL)

--Creacion Tabla de Categoria Productos
CREATE TABLE CATEGORIA_PRODUCTOS (
ID_CATEGORIA NUMBER(10) NOT NULL,
NOMBRE VARCHAR2(30) NOT NULL,
DESCRIPCION VARCHAR2(50) NOT NULL,
CONSTRAINT CAT_PRODUCTOS_PK PRIMARY KEY (ID_CATEGORIA)
);

--Creacion Tabla de Productos
CREATE TABLE PRODUCTOS (
ID_PRODUCTOS NUMBER(10) NOT NULL,
NOMBRE VARCHAR2(50) NOT NULL,
ID_CATEGORIA NUMBER(10) NOT NULL,
CANTIDAD NUMBER(10) NOT NULL,
DESCRIPCION VARCHAR2(100),
TAMANO VARCHAR(10),
PRECIO NUMBER(20),
CONSTRAINT PRODUCTOS_PK PRIMARY KEY (ID_PRODUCTOS),
CONSTRAINT CATEGORIA_PRODUCTOS_FK FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA_PRODUCTOS(ID_CATEGORIA)
);

CREATE TABLE COMPRAS(
    ID_COMPRA NUMBER NOT NULL,
    FECHA_COMPRA DATE,
    ID_PROVEEDOR NUMBER NOT NULL,
    ID_PRODUCTOS NUMBER NOT NULL,
    CANTIDAD INT NOT NULL,
    PRECIO INT NOT NULL,
    TOTAL INT NOT NULL,
    CONSTRAINT COMPRAS_PK PRIMARY KEY (ID_COMPRA),
    CONSTRAINT COMPRAS_PROVEEDORES_FK FOREIGN KEY (ID_PROVEEDOR) REFERENCES PROVEEDORES(ID_PROVEEDOR),
    CONSTRAINT COMPRAS_PRODUCTOS_FK FOREIGN KEY (ID_PRODUCTOS) REFERENCES PRODUCTOS(ID_PRODUCTOS)
);


--CREACION DE LLAVES PRIMARIAS
ALTER TABLE INGREDIENTES
ADD CONSTRAINT PK_INGREDIENTES PRIMARY KEY(ID_INGREDIENTE);

ALTER TABLE PROVEEDORES
ADD CONSTRAINT PK_PROVEEDORES PRIMARY KEY (ID_PROVEEDOR);
--CREACION DE LLAVES FORANEAS

ALTER TABLE INGREDIENTES
ADD CONSTRAINT FK_IDPROVEEDOR FOREIGN KEY (ID_PROVEEDOR) REFERENCES PROVEEDORES
(ID_PROVEEDOR);

--Inserts 
--Inserts a Clientes
Insert into CLIENTE (ID_CLIENTE,NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,CORREO,NUMERO_TELEFONICO,DIRECCION) 
values (1,'Pablo','Lopez','Rodriguez','pablo.rodri@gmail.com',87349012,'Heredia Central');
INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION)
VALUES (2, 'Maria', 'Gomez', 'Fernandez', 'maria.fernandez@gmail.com', 78901234, 'San Jose');
INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION)
VALUES (3, 'Carlos', 'Martinez', 'Lopez', 'carlos.lopez@gmail.com', 65432178, 'Cartago');
INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION)
VALUES (4, 'Laura', 'Ramirez', 'Perez', 'laura.perez@gmail.com', 98761234, 'Alajuela');
INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION)
VALUES (5, 'Juan', 'Gonzalez', 'Sanchez', 'juan.sanchez@gmail.com', 12345678, 'Puntarenas');
INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION)
VALUES (6, 'Ana', 'Hernandez', 'Mendez', 'ana.mendez@gmail.com', 87654321, 'Guanacaste');
INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION)
VALUES (7, 'Diego', 'Castro', 'Jimenez', 'diego.jimenez@gmail.com', 56781234, 'Limon');
INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION)
VALUES (8, 'Sofia', 'Perez', 'Gonzalez', 'sofia.gonzalez@gmail.com', 89123456, 'San Jose');
INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION)
VALUES (9, 'Luis', 'Sanchez', 'Hernandez', 'luis.hernandez@gmail.com', 76543219, 'Heredia');
INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION)
VALUES (10, 'Monica', 'Jimenez', 'Ramirez', 'monica.ramirez@gmail.com', 91234567, 'Alajuela');

--Inserts a Ventas
INSERT INTO VENTAS (ID_VENTA,FECHA_VENTA,CANTIDAD,PRECIO,ID_CLIENTE,ID_PRODUCTOS) 
VALUES (1,'2023-10-21',2,10500.00,1,'1');
INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, CANTIDAD, PRECIO, ID_CLIENTE, ID_PRODUCTOS)
VALUES (2, '2023-10-22', 3, 7500.00, 2, 2);
INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, CANTIDAD, PRECIO, ID_CLIENTE, ID_PRODUCTOS)
VALUES (3, '2023-10-23', 1, 12000.00, 3, 3);
INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, CANTIDAD, PRECIO, ID_CLIENTE, ID_PRODUCTOS)
VALUES (4, '2023-10-24', 4, 9000.00, 4, 4);
INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, CANTIDAD, PRECIO, ID_CLIENTE, ID_PRODUCTOS)
VALUES (5, '2023-10-25', 2, 8000.00, 5, 5);
INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, CANTIDAD, PRECIO, ID_CLIENTE, ID_PRODUCTOS)
VALUES (6, '2023-10-26', 3, 9500.00, 6, 1);
INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, CANTIDAD, PRECIO, ID_CLIENTE, ID_PRODUCTOS)
VALUES (7, '2023-10-27', 1, 11000.00, 7, 2);
INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, CANTIDAD, PRECIO, ID_CLIENTE, ID_PRODUCTOS)
VALUES (8, '2023-10-28', 5, 8500.00, 8, 3);
INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, CANTIDAD, PRECIO, ID_CLIENTE, ID_PRODUCTOS)
VALUES (9, '2023-10-29', 2, 7500.00, 9, 4);
INSERT INTO VENTAS (ID_VENTA, FECHA_VENTA, CANTIDAD, PRECIO, ID_CLIENTE, ID_PRODUCTOS)
VALUES (10, '2023-10-30', 3, 10000.00, 10, 5);

--Inserts a Categorias de Productos:
Insert into CATEGORIA_PRODUCTOS (ID_CATEGORIA, NOMBRE, DESCRIPCION) 
values (1,'Cupcakes','Pequenos y deliciosos cupcakes');
Insert into CATEGORIA_PRODUCTOS (ID_CATEGORIA, NOMBRE, DESCRIPCION) 
values (2,'Brownies','Irresistibles brownies de chocolate');
Insert into CATEGORIA_PRODUCTOS (ID_CATEGORIA, NOMBRE, DESCRIPCION) 
values (3,'Panes','Panes frescos y deliciosos');
Insert into CATEGORIA_PRODUCTOS (ID_CATEGORIA, NOMBRE, DESCRIPCION) 
values (4,'Pasteles','Pasteles unicos y deliciosos');

--Inserts a Productos:
-- Cupcakes
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (1, 'Cupcake Vainilla', 1, 30, 'Cupcake suave de vainilla', 'PEQUENO', 7000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (2, 'Cupcake Chocolate', 1, 25, 'Cupcake delicioso de chocolate', 'MEDIANO', 8500);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (3, 'Cupcake Fresa', 1, 20, 'Cupcake con relleno de fresa', 'GRANDE', 12000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (4, 'Cupcake Moka', 1, 18, 'Cupcake con sabor a moka', 'MEDIANO', 9500);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (5, 'Cupcake Caramelo', 1, 22, 'Cupcake con decoracion de caramelo', 'GRANDE', 13000);

-- Brownies
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (6, 'Brownie Nuez', 2, 15, 'Brownie de chocolate con nueces', 'PEQUENO', 5500);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (7, 'Brownie Chocolate Blanco', 2, 20, 'Brownie con chocolate blanco', 'MEDIANO', 7000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (8, 'Brownie Frutas Rojas', 2, 25, 'Brownie con frutas rojas', 'GRANDE', 11000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (9, 'Brownie Caramelo Salado', 2, 18, 'Brownie con caramelo salado', 'MEDIANO', 8000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (10, 'Brownie Menta', 2, 22, 'Brownie con sabor a menta', 'GRANDE', 15000);

-- Panes
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (11, 'Pan Integral', 3, 28, 'Pan integral recien horneado', 'MEDIANO', 7500);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (12, 'Pan Multicereales', 3, 35, 'Pan con una mezcla de cereales', 'GRANDE', 10000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (13, 'Pan Centeno', 3, 22, 'Pan de centeno con semillas', 'PEQUENO', 6000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (14, 'Pan Avena', 3, 30, 'Pan con copos de avena', 'MEDIANO', 8500);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (15, 'Pan Nuez y Miel', 3, 18, 'Pan con nueces y miel', 'GRANDE', 12000);

-- Pasteles
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (16, 'Pastel Fresa y Chocolate', 4, 20, 'Pastel con capas de fresa y chocolate', 'PEQUENO', 8000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (17, 'Pastel Tres Leches', 4, 25, 'Pastel esponjoso con tres tipos de leche', 'MEDIANO', 11000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (18, 'Pastel Zanahoria', 4, 30, 'Pastel de zanahoria con crema de queso', 'GRANDE', 15000);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (19, 'Pastel Manzana Canela', 4, 22, 'Pastel con manzanas y canela', 'MEDIANO', 9500);
Insert into PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO) 
values (20, 'Pastel Selva Negra', 4, 18, 'Pastel con capas de chocolate y cerezas', 'PEQUENO', 7000);


--Proveedores
-- Insertar proveedor 1
INSERT INTO PROVEEDORES (ID_PROVEEDOR, NOMBRE_PROVEEDOR, PRIMER_APELLIDO, SEGUNDO_APELLIDO, NUMERO_TELEFONICO, CORREO_ELECTRONICO, ESTADO)
VALUES (1, 'Juan', 'G�mez', 'L�pez', 123456789, 'juan.gomez@hotmail.com', 'Activo');
INSERT INTO PROVEEDORES (ID_PROVEEDOR, NOMBRE_PROVEEDOR, PRIMER_APELLIDO, SEGUNDO_APELLIDO, NUMERO_TELEFONICO, CORREO_ELECTRONICO, ESTADO)
VALUES (2, 'Mar�a', 'Hern�ndez', 'Mart�nez', 987654321, 'maria.hernandez@gmail.com', 'Inactivo');
INSERT INTO PROVEEDORES (ID_PROVEEDOR, NOMBRE_PROVEEDOR, PRIMER_APELLIDO, SEGUNDO_APELLIDO, NUMERO_TELEFONICO, CORREO_ELECTRONICO, ESTADO)
VALUES (3, 'Pedro', 'D�az', 'Garc�a', 555555555, 'pedro.diaz@hotmail.com', 'Activo');

--Compras
INSERT INTO COMPRAS (ID_COMPRA, FECHA_COMPRA, ID_PROVEEDOR, ID_PRODUCTOS, CANTIDAD, PRECIO, TOTAL)
VALUES (1, TO_DATE('01-01-2023', 'DD-MM-YYYY'), 1, 1, 10, 50, 500);
INSERT INTO COMPRAS (ID_COMPRA, FECHA_COMPRA, ID_PROVEEDOR, ID_PRODUCTOS, CANTIDAD, PRECIO, TOTAL)
VALUES (2, TO_DATE('05-01-2023', 'DD-MM-YYYY'), 3, 3, 15, 40, 600);
INSERT INTO COMPRAS (ID_COMPRA, FECHA_COMPRA, ID_PROVEEDOR, ID_PRODUCTOS, CANTIDAD, PRECIO, TOTAL)
VALUES (3, TO_DATE('10-01-2023', 'DD-MM-YYYY'), 1, 4, 20, 30, 600);
INSERT INTO COMPRAS (ID_COMPRA, FECHA_COMPRA, ID_PROVEEDOR, ID_PRODUCTOS, CANTIDAD, PRECIO, TOTAL)
VALUES (4, TO_DATE('15-01-2023', 'DD-MM-YYYY'), 2, 11, 12, 45, 540);
INSERT INTO COMPRAS (ID_COMPRA, FECHA_COMPRA, ID_PROVEEDOR, ID_PRODUCTOS, CANTIDAD, PRECIO, TOTAL)
VALUES (5, TO_DATE('20-01-2023', 'DD-MM-YYYY'), 3, 3, 18, 35, 630);


--Procedure para ingresar datos
--Clientes
CREATE OR REPLACE PROCEDURE INSERT_CLIENTES (
    IDE CLIENTE.ID_CLIENTE%TYPE,
    NOM CLIENTE.NOMBRE%TYPE,
    PRIMER_AP CLIENTE.PRIMER_APELLIDO%TYPE,
    SEGUNDO_AP CLIENTE.SEGUNDO_APELLIDO%TYPE,
    COR CLIENTE.CORREO%TYPE,
    NUMERO CLIENTE.NUMERO_TELEFONICO%TYPE,
    DIREC CLIENTE.DIRECCION%TYPE)
AS
BEGIN 
    INSERT INTO CLIENTE (ID_CLIENTE, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO,
    NUMERO_TELEFONICO, DIRECCION)
    VALUES (IDE, NOM, PRIMER_AP, SEGUNDO_AP, COR, NUMERO, DIREC);
    COMMIT;
END;
    
EXEC INSERT_CLIENTES (10, 'Monica', 'Jimenez', 'Ramirez', 'monica.ramirez@gmail.com', 91234567, 'Alajuela');

--Ventas
CREATE OR REPLACE PROCEDURE INSERT_VENTAS (
    IDE VENTAS.ID_VENTA%TYPE,
    FECHA VENTAS.FECHA_VENTA%TYPE,
    CANT VENTAS.CANTIDAD%TYPE,
    PREC VENTAS.PRECIO%TYPE,
    ID_C VENTAS.ID_CLIENTE%TYPE,
    ID_P VENTAS.ID_PRODUCTOS%TYPE)
AS
BEGIN 
    INSERT INTO VENTAS (ID_VENTA,FECHA_VENTA,CANTIDAD,PRECIO,ID_CLIENTE,ID_PRODUCTOS)
    VALUES (IDE, FECHA, CANT, PREC, ID_C, ID_P);
    COMMIT;
END;
    
EXEC INSERT_VENTAS (10, '2023-10-30', 3, 10000.00, 10, 5);

--PROCEDURE PARA ACTUALIZAR UN DATO
--Clientes
CREATE OR REPLACE PROCEDURE UPDATE_CLIENTES (
    IDE CLIENTE.ID_CLIENTE%TYPE,
    NOM CLIENTE.NOMBRE%TYPE,
    PRIMER_AP CLIENTE.PRIMER_APELLIDO%TYPE,
    SEGUNDO_AP CLIENTE.SEGUNDO_APELLIDO%TYPE,
    COR CLIENTE.CORREO%TYPE,
    NUMERO CLIENTE.NUMERO_TELEFONICO%TYPE,
    DIREC CLIENTE.DIRECCION%TYPE)
AS
BEGIN 
    UPDATE CLIENTE 
    SET NOMBRE = NOM,
        PRIMER_APELLIDO = PRIMER_AP,
        SEGUNDO_APELLIDO = SEGUNDO_AP,
        CORREO = COR,
        NUMERO_TELEFONICO = NUMERO,
        DIRECCION=DIREC
    WHERE ID_CLIENTE = IDE;
END;
    
EXEC INSERT_CLIENTES (10, 'Monica', 'Jimenez', 'Ramirez', 'monica.ramirez@gmail.com', 91234567, 'Alajuela');


--VIEW PARA READ
--CLIENTES
CREATE VIEW READ_CLIENTE AS
SELECT NOMBRE,PRIMER_APELLIDO, SEGUNDO_APELLIDO, CORREO, NUMERO_TELEFONICO, DIRECCION
FROM CLIENTE
ORDER BY NOMBRE;

--VENTAS
CREATE VIEW READ_VENTAS AS
SELECT FECHA_VENTA,CANTIDAD,PRECIO,ID_CLIENTE,ID_PRODUCTOS
FROM VENTAS
ORDER BY FECHA_VENTA;


-- FUNCTION PARA ELIMINAR DATOS DE UNA TABLA
--CLIENTES
CREATE OR REPLACE FUNCTION DELETE_CLIENTES (IDE VARCHAR2) RETURN VARCHAR2
IS
BEGIN
    DELETE FROM CLIENTE
    WHERE ID_CLIENTE = IDE;
    RETURN 'Datos eliminados correctamente';
END;

--Para ejecutarlo
CREATE OR REPLACE PROCEDURE Ej_Func_Client(IDE NUMBER)
IS
    resultado VARCHAR2(100);
BEGIN
    resultado := DELETE_CLIENTES(IDE); -- Llama a la función DELETE_CLIENTES
    DBMS_OUTPUT.PUT_LINE(resultado);
END;

EXEC Ej_Func_Client(10);

--VENTAS
CREATE OR REPLACE FUNCTION DELETE_VENTAS (IDE VARCHAR2) RETURN VARCHAR2
IS
BEGIN
    DELETE FROM VENTAS
    WHERE ID_VENTA = IDE;
    RETURN 'Datos eliminados correctamente';
END;


--Para ejecutarlo
CREATE OR REPLACE PROCEDURE Ej_Func_Vent(IDE NUMBER)
IS
    resultado VARCHAR2(100);
BEGIN
    resultado := DELETE_VENTAS(IDE); -- Llama a la función DELETE_VENTAS
    DBMS_OUTPUT.PUT_LINE(resultado);
END;

EXEC Ej_Func_Vent(10);

--CURSORES
--funcion para traer el nombre completo del cliente con el total que compro en una venta
DECLARE 
    cur_clie_to SYS_REFCURSOR;
    NOM CLIENTE.NOMBRE%TYPE;
    PRIMER_AP CLIENTE.PRIMER_APELLIDO%TYPE;
    SEGUNDO_AP CLIENTE.SEGUNDO_APELLIDO%TYPE;
    TOTAL_VEN VENTAS.TOTAL%TYPE;
    FECHA VENTAS.FECHA_VENTA%TYPE;
BEGIN 
    OPEN cur_clie_to FOR 
        SELECT c.NOMBRE, c.PRIMER_APELLIDO, c.SEGUNDO_APELLIDO, v.FECHA_VENTA, v.TOTAL 
        FROM CLIENTE c
        INNER JOIN VENTAS v ON c.ID_CLIENTE = v.ID_CLIENTE
        WHERE v.ID_VENTA = 9;
    
    FETCH cur_clie_to INTO NOM, PRIMER_AP, SEGUNDO_AP, FECHA, TOTAL_VEN;
    CLOSE cur_clie_to;
    
    DBMS_OUTPUT.PUT_LINE(NOM || ' ' || PRIMER_AP || ' ' || SEGUNDO_AP || 
        ' compr� en total ' || TOTAL_VEN || ' en la fecha ' || FECHA);
END;


--funcion para traer el nombre  del producto con el total que compro en una venta
DECLARE 
    cur_pro_ven SYS_REFCURSOR;
    NOM PRODUCTOS.NOMBRE%TYPE;
    FECHA VENTAS.FECHA_VENTA%TYPE;
    CANT VENTAS.CANTIDAD%TYPE;
    TOTAL_VEN VENTAS.TOTAL%TYPE;
BEGIN 
    OPEN cur_pro_ven FOR SELECT p.NOMBRE, v.CANTIDAD, v.FECHA_VENTA, v.TOTAL 
    FROM PRODUCTOS p
    INNER JOIN VENTAS v ON p.ID_PRODUCTOS = v.ID_PRODUCTOS
    WHERE v.ID_VENTA = 9;

    FETCH cur_pro_ven INTO NOM, CANT, FECHA, TOTAL_VEN;
    CLOSE cur_pro_ven;

    DBMS_OUTPUT.PUT_LINE('Se compr� ' || CANT || ' ' || NOM || ' en la fecha ' || 
    FECHA || ' con un total ' || TOTAL_VEN);
END;




--PROCEDIMIENTOS ALMACENADOS
--PROCEDIMIENTO PARA AGREGAR LOS DATOS DE PROVEEDORES
CREATE OR REPLACE PROCEDURE AGREGAR_PROVEEDOR(ID_PRO IN NUMBER,NOMBRE IN VARCHAR2,
PAPELLIDO IN VARCHAR2,SAPELLIDO IN VARCHAR2, TELEFONO IN NUMBER,CORREO IN VARCHAR2,
ESTADO IN VARCHAR2)
AS
BEGIN
INSERT INTO PROVEEDORES(ID_PROVEEDOR ,NOMBRE_PROVEEDOR ,PRIMER_APELLIDO,
SEGUNDO_APELLIDO ,NUMERO_TELEFONICO ,CORREO_ELECTRONICO ,ESTADO)
VALUES (ID_PRO,NOMBRE,PAPELLIDO,SAPELLIDO,TELEFONO,CORREO,ESTADO);
END;

--PRUEBA DEL PROCEDIMIENO
EXEC AGREGAR_PROVEEDOR(2,'JUAN','MORA','ABARCA',24101726,'ROBERTO@GMAIL.COM','ACTIVO');
--PROCEDIMIENTO PARA AGREGAR LOS DATOSDE INGREDIENTES
CREATE OR REPLACE PROCEDURE AGREGAR_INGREDIENTE(ID_INGREDIENTE IN NUMBER,NOMBRE IN VARCHAR2,
UNIDAD IN VARCHAR2, PRECIO NUMBER,CANTIDAD IN NUMBER,ID_PROVEEDOR IN NUMBER)
AS
BEGIN
INSERT INTO INGREDIENTES(ID_INGREDIENTE,NOMBRE_INGREDIENTE,UNIDAD_MEDIDA ,
PRECIO,CANTIDAD,ID_PROVEEDOR)
VALUES(ID_INGREDIENTE ,NOMBRE,UNIDAD, PRECIO,CANTIDAD,ID_PROVEEDOR);
END;
--PRUEBA DEL PROCEDIMIENO
EXEC AGREGAR_INGREDIENTE(1,'AZUCAR','KILOGRAMOS',700,2,2);
SELECT * FROM INGREDIENTES;
--PROCEDIMIENTO PARA ACTUALIZAR EL PRECIO DE UN INGREDIENTE
CREATE OR REPLACE PROCEDURE ACTUALIZAR_INGREDIENTE_PRECIO(IDINGRE IN NUMBER,PRECIONUEVO IN NUMBER)
AS
BEGIN
UPDATE INGREDIENTES SET PRECIO=PRECIONUEVO WHERE ID_INGREDIENTE=IDINGRE;
END;
--PRUEBA PROCEDIMEINTO ACUTUALIZAR PRECIO
EXEC ACTUALIZAR_INGREDIENTE_PRECIO(1,750);


--VISTA
CREATE VIEW VER_INGREDIENTES AS
SELECT * FROM INGREDIENTES ORDER BY ID_INGREDIENTE;

--PRUEBA VISTA
SELECT * FROM  VER_INGREDIENTES;

--CREACION DE FUNCIONES VER CANTIDAD DE PROVEEDORES
CREATE OR REPLACE FUNCTION CANTIDAD_PROVEEDORES
RETURN NUMBER
IS
    CANTIDAD NUMBER; 
    BEGIN
    SELECT COUNT(ID_PROVEEDOR) INTO CANTIDAD
    FROM PROVEEDORES;   
    RETURN CANTIDAD;
END;
--PROBAR FUNCION
SELECT CANTIDAD_PROVEEDORES FROM DUAL;
--FUNCION VER CANTIDAD DE INGREDIENTES
CREATE OR REPLACE FUNCTION CANTIDAD_INGREDIENTES
RETURN NUMBER
IS
    CANTIDAD NUMBER; 
    BEGIN
    SELECT COUNT(ID_INGREDIENTE) INTO CANTIDAD
    FROM INGREDIENTES;   
    RETURN CANTIDAD;
END;

--PROBAR FUNCION
SELECT CANTIDAD_INGREDIENTES FROM DUAL;



--CREACION DE CURSOR PARA ACTUALIZAR DATOS DEL PROVEEDOR
CREATE OR REPLACE PROCEDURE ACTUALIZAR_PROVE(ID_BUSCADO IN NUMBER,NOMBRE IN VARCHAR2,
PAPELLIDO IN VARCHAR2,SAPELLIDO IN VARCHAR2, NUMERO IN NUMBER,CORREO IN VARCHAR2,
EST IN VARCHAR2)
IS

CURSOR ACTUALIZAR_PROVEEDOR IS SELECT *
    FROM PROVEEDORES;
     PROVEEDOR_C ACTUALIZAR_PROVEEDOR%ROWTYPE;
 BEGIN    
     OPEN ACTUALIZAR_PROVEEDOR;  
     FETCH ACTUALIZAR_PROVEEDOR INTO PROVEEDOR_C;
        
     UPDATE PROVEEDORES
     SET NOMBRE_PROVEEDOR=NOMBRE, PRIMER_APELLIDO=PAPELLIDO,SEGUNDO_APELLIDO=SAPELLIDO,
     NUMERO_TELEFONICO=NUMERO,CORREO_ELECTRONICO=CORREO, ESTADO=EST
     WHERE ID_PROVEEDOR=ID_BUSCADO;
       
CLOSE ACTUALIZAR_PROVEEDOR;
END;    
 --PRUEBA    
EXEC ACTUALIZAR_PROVE(2,'JUAN','MORA','ABARCA',24101726,'JUAN@GMAIL.COM','INACTIVO');

--CURSOR PARA ELIMINAR UN INGREDIENTE
CREATE OR REPLACE PROCEDURE ELIMINAR_INGREDIENTE(ID_BUSCADO IN NUMBER)
IS

CURSOR ELIMINAR_INGREDIENTE IS SELECT *
    FROM INGREDIENTES;
     INGREDIENTE_C ELIMINAR_INGREDIENTE%ROWTYPE;
 BEGIN    
     OPEN ELIMINAR_INGREDIENTE;  
     FETCH ELIMINAR_INGREDIENTE INTO INGREDIENTE_C;
       
     DELETE FROM INGREDIENTES WHERE INGREDIENTE_C.ID_INGREDIENTE=ID_BUSCADO; 
         
CLOSE ELIMINAR_INGREDIENTE;
END;    

EXEC ELIMINAR_INGREDIENTE(1);
SELECT * FROM INGREDIENTES;



---------------- PROCEDIMIENTOS ALMACENADOS CATEGORIAS Y PRODUCTOS ---------------

-- SP para Categorias

-- 1) Procedimiento para agregar/insertar una categoria

CREATE OR REPLACE PROCEDURE ADD_CATEGORY (
    p_id_categoria IN NUMBER,
    p_nombre IN VARCHAR2,
    p_descripcion IN VARCHAR2
)
AS
BEGIN
    INSERT INTO CATEGORIA_PRODUCTOS (ID_CATEGORIA, NOMBRE, DESCRIPCION)
    VALUES (p_id_categoria, p_nombre, p_descripcion);    
    COMMIT;
END;

/* El siguiente EXEC para testeo nada mas! */
EXEC ADD_CATEGORY(6, 'TestName', 'Descripci�n de test Category');

-- 2) Procedimiento para eliminar una categoria

CREATE OR REPLACE PROCEDURE DELETE_CATEGORY (
    p_id_categoria IN NUMBER
)
AS
BEGIN
    DELETE FROM CATEGORIA_PRODUCTOS
    WHERE ID_CATEGORIA = p_id_categoria;
    COMMIT;
END;

/* El siguiente EXEC para testeo nada mas! */
EXEC DELETE_CATEGORY(6);

-- 3) Procedimiento para actualizar nombre de una categoria

CREATE OR REPLACE PROCEDURE UPDATE_CATEGORY_NAME (
    p_id_categoria IN NUMBER,
    p_nuevo_nombre IN VARCHAR2
)
AS
BEGIN
    UPDATE CATEGORIA_PRODUCTOS
    SET NOMBRE = p_nuevo_nombre
    WHERE ID_CATEGORIA = p_id_categoria;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Descripci�n de la categor�a actualizada con �xito.');
END;

/* El siguiente EXEC para testeo nada mas! */
EXEC UPDATE_CATEGORY_NAME(5, 'Nuevo nombre actualizada');

-- 4) Procedimiento para actualizar descripcion de una categoria

CREATE OR REPLACE PROCEDURE UPDATE_CATEGORY_DESCRIPTION (
    p_id_categoria IN NUMBER,
    p_nueva_descripcion IN VARCHAR2
)
AS
BEGIN
    UPDATE CATEGORIA_PRODUCTOS
    SET DESCRIPCION = p_nueva_descripcion
    WHERE ID_CATEGORIA = p_id_categoria;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Descripci�n de la categor�a actualizada con �xito.');
END;

/* El siguiente EXEC para testeo nada mas! */
EXEC UPDATE_CATEGORY_DESCRIPTION(5, 'Nueva descripci�n actualizada');

-- SP para Productos

-- 1) Procedimiento para agregar nuevos productos.

CREATE OR REPLACE PROCEDURE ADD_PRODUCTOS (
    p_id_producto IN NUMBER,
    p_nombre IN VARCHAR2,
    p_id_categoria IN NUMBER,
    p_cantidad IN NUMBER,
    p_descripcion IN VARCHAR2,
    p_tamano IN VARCHAR2,
    p_precio IN NUMBER
)
AS
BEGIN
    INSERT INTO PRODUCTOS (ID_PRODUCTOS, NOMBRE, ID_CATEGORIA, CANTIDAD, DESCRIPCION, TAMANO, PRECIO)
    VALUES (p_id_producto, p_nombre, p_id_categoria, p_cantidad, p_descripcion, p_tamano, p_precio);
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Producto agregado con �xito.');
END;

-- 2) Procedimiento para eliminar un producto.

CREATE OR REPLACE PROCEDURE DELETE_PRODUCTOS (
    p_id_producto IN NUMBER
)
AS
BEGIN
    DELETE FROM PRODUCTOS
    WHERE ID_PRODUCTOS = p_id_producto;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Producto eliminado con �xito.');
END;

-- 3) Procedimiento para actualizar la cantidad de un producto.

CREATE OR REPLACE PROCEDURE UPDATE_PRODUCTOS_CANTIDAD (
    p_id_producto IN NUMBER,
    p_nueva_cantidad IN NUMBER
)
AS
BEGIN
    UPDATE PRODUCTOS
    SET CANTIDAD = p_nueva_cantidad
    WHERE ID_PRODUCTOS = p_id_producto;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Cantidad del producto actualizada con �xito.');
END;


-- 4) Procedimiento para actualizar el tamano de un producto.

CREATE OR REPLACE PROCEDURE UPDATE_PRODUCTOS_TAMANO (
    p_id_producto IN NUMBER,
    p_nuevo_tamano IN VARCHAR2
)
AS
BEGIN
    UPDATE PRODUCTOS
    SET TAMANO = p_nuevo_tamano
    WHERE ID_PRODUCTOS = p_id_producto;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Tama�o del producto actualizado con �xito.');
END;


-- 5) Procedimiento para actualizar el precio de un producto.

CREATE OR REPLACE PROCEDURE UPDATE_PRODUCTOS_PRECIO (
    p_id_producto IN NUMBER,
    p_nuevo_precio IN NUMBER
)
AS
BEGIN
    UPDATE PRODUCTOS
    SET PRECIO = p_nuevo_precio
    WHERE ID_PRODUCTOS = p_id_producto;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Precio del producto actualizado con �xito.');
END;


---------------- VISTAS CATEGORIAS Y PRODUCTOS ----------------------------

-- 1) Vista que muestra informacion detallada de productos con nombres de cateogira.

CREATE OR REPLACE VIEW VIEW_PRODUCTOS_CATEGORY AS
SELECT P.ID_PRODUCTOS, P.NOMBRE, P.CANTIDAD, P.DESCRIPCION, P.TAMANO, P.PRECIO, CP.NOMBRE AS NOMBRE_CATEGORIA
FROM PRODUCTOS P
JOIN CATEGORIA_PRODUCTOS CP ON P.ID_CATEGORIA = CP.ID_CATEGORIA;

-- 2) Vista para mostrar cantidad disponible de cada categoria:

CREATE OR REPLACE VIEW VIEW_CATEGORY_CANT_DISPONIBLE AS
SELECT CP.NOMBRE AS NOMBRE_CATEGORIA, SUM(P.CANTIDAD) AS CANTIDAD_TOTAL
FROM PRODUCTOS P
JOIN CATEGORIA_PRODUCTOS CP ON P.ID_CATEGORIA = CP.ID_CATEGORIA
GROUP BY CP.NOMBRE;

-- 3) Vista para mostrar cantidad de productos con cantidad baja

CREATE OR REPLACE VIEW VIEW_PRODUCTOS_CANT_BAJA AS
SELECT * FROM PRODUCTOS
WHERE CANTIDAD < 20;

-- 4) Vista para mostrar informacion de categorias con cantidad total de productos.

CREATE OR REPLACE VIEW VIEW_CATEGORY_CANT_TOTAL AS
SELECT CP.ID_CATEGORIA, CP.NOMBRE, CP.DESCRIPCION, COUNT(P.ID_PRODUCTOS) AS CANTIDAD_TOTAL
FROM CATEGORIA_PRODUCTOS CP
LEFT JOIN PRODUCTOS P ON CP.ID_CATEGORIA = P.ID_CATEGORIA
GROUP BY CP.ID_CATEGORIA, CP.NOMBRE, CP.DESCRIPCION;


-------------- FUNCIONES CATEGORIAS Y PRODUCTOS --------------------------

-- Obtener (lectura) informacion de un producto por categoria

CREATE OR REPLACE FUNCTION READ_CATEGORY (
    p_id_categoria IN NUMBER
)
RETURN VARCHAR2
AS
    v_info_categoria VARCHAR2(200);
BEGIN
    SELECT 'ID: ' || ID_CATEGORIA || ', Nombre: ' || NOMBRE || ', Descripci�n: ' || DESCRIPCION
    INTO v_info_categoria
    FROM CATEGORIA_PRODUCTOS
    WHERE ID_CATEGORIA = p_id_categoria;

    RETURN v_info_categoria;
END;

-- Obtener (lectura) informacion de una categoria de producto.

CREATE OR REPLACE FUNCTION READ_PRODUCTOS (
    p_id_producto IN NUMBER
)
RETURN VARCHAR2
AS
    v_info_producto VARCHAR2(200);
BEGIN
    SELECT 'ID: ' || ID_PRODUCTOS || ', Nombre: ' || NOMBRE || ', Cantidad: ' || CANTIDAD ||
           ', Descripci�n: ' || DESCRIPCION || ', Tama�o: ' || TAMANO || ', Precio: ' || PRECIO
    INTO v_info_producto
    FROM PRODUCTOS
    WHERE ID_PRODUCTOS = p_id_producto;

    RETURN v_info_producto;
END;


--------------- CURSORES CATEGORIAS Y PRODUCTOS ----------------------------

-- 1) Cursor para recorrer y mostrar todos los productos de la tabla.

DECLARE
   CURSOR c_productos IS
      SELECT * FROM PRODUCTOS;
   v_producto PRODUCTOS%ROWTYPE;
BEGIN
   OPEN c_productos;
   LOOP
      FETCH c_productos INTO v_producto;
      EXIT WHEN c_productos%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('ID: ' || v_producto.ID_PRODUCTOS ||
                           ', Nombre: ' || v_producto.NOMBRE ||
                           ', Cantidad: ' || v_producto.CANTIDAD ||
                           ', Descripci�n: ' || v_producto.DESCRIPCION ||
                           ', Tama�o: ' || v_producto.TAMANO ||
                           ', Precio: ' || v_producto.PRECIO);
   END LOOP;
   CLOSE c_productos;
END;

-- 2) Cursor para mostrar productos de una categoria especifica.

DECLARE
   CURSOR c_productos_categoria(p_id_categoria NUMBER) IS
      SELECT * FROM PRODUCTOS
      WHERE ID_CATEGORIA = p_id_categoria;
   v_producto PRODUCTOS%ROWTYPE;
BEGIN
   OPEN c_productos_categoria(2);
   LOOP
      FETCH c_productos_categoria INTO v_producto;
      EXIT WHEN c_productos_categoria%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('ID: ' || v_producto.ID_PRODUCTOS ||
                           ', Nombre: ' || v_producto.NOMBRE ||
                           ', Cantidad: ' || v_producto.CANTIDAD ||
                           ', Descripci�n: ' || v_producto.DESCRIPCION ||
                           ', Tama�o: ' || v_producto.TAMANO ||
                           ', Precio: ' || v_producto.PRECIO);
   END LOOP;
   CLOSE c_productos_categoria;
END;

-- 3) Cursor para actualizar los precios de los productos de una categoria especifica aumentando sus precios en un 5%.

DECLARE
   CURSOR AUMENTAR_PRECIO_PORCIENTO IS
      SELECT ID_PRODUCTOS, PRECIO
      FROM PRODUCTOS
      WHERE ID_CATEGORIA = 1;

BEGIN
   FOR producto_rec IN AUMENTAR_PRECIO_PORCIENTO
   LOOP
      UPDATE PRODUCTOS
      SET PRECIO = producto_rec.PRECIO * 1.05
      WHERE ID_PRODUCTOS = producto_rec.ID_PRODUCTOS;
   END LOOP;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE('Precios aumentados en un 5% para la categor�a seleccionada.');
END;

-- 4) Cursor para actualizar los precios de una categoria especifica en reducirlos en un 10% en caso de un descuento promocion.

DECLARE
   
   CURSOR reducir_precio IS
      SELECT ID_PRODUCTOS, PRECIO
      FROM PRODUCTOS
      WHERE ID_CATEGORIA = 2; 
BEGIN
   FOR producto_rec IN reducir_precio
   LOOP
      UPDATE PRODUCTOS
      SET PRECIO = producto_rec.PRECIO * 0.9
      WHERE ID_PRODUCTOS = producto_rec.ID_PRODUCTOS;
   END LOOP;
   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Precios reducidos en un 10% para la categor�a seleccionada.');
END;


-----------------Procedimientos para COMPRAS----------------------------------

-- Procedimiento para insertar una nueva compra
CREATE OR REPLACE PROCEDURE insertar_compra(p_id_compra IN NUMBER,p_fecha_compra IN DATE,p_id_proveedor IN NUMBER,
  p_id_producto IN NUMBER,p_cantidad IN INT,p_precio IN INT,p_total IN INT) 
AS
BEGIN
  INSERT INTO COMPRAS (ID_COMPRA,FECHA_COMPRA,ID_PROVEEDOR,ID_PRODUCTOS,
  CANTIDAD,PRECIO,TOTAL) 
  VALUES (p_id_compra,p_fecha_compra,p_id_proveedor,p_id_producto,p_cantidad,
  p_precio,p_total);
END insertar_compra;

-- Procedimiento para actualizar una compra existente
CREATE OR REPLACE PROCEDURE actualizar_compra( p_id_compra IN NUMBER, 
p_cantidad IN INT, p_precio IN INT, p_total IN INT) 
AS
BEGIN
  UPDATE COMPRAS
  SET CANTIDAD = p_cantidad,
      PRECIO = p_precio,
      TOTAL = p_total
  WHERE ID_COMPRA = p_id_compra;
END actualizar_compra;


-----------------------------Vistas para COMPRAS--------------------------------
-- Vista para obtener informaci�n detallada de las compras
CREATE OR REPLACE VIEW vista_compras AS
SELECT C.ID_COMPRA, C.FECHA_COMPRA, C.ID_PROVEEDOR, P.NOMBRE_PROVEEDOR, C.ID_PRODUCTOS,
  C.CANTIDAD, C.PRECIO, C.TOTAL
FROM COMPRAS C
JOIN PROVEEDORES P ON C.ID_PROVEEDOR = P.ID_PROVEEDOR;



-----------------------------Funciones para COMPRAS-----------------------------

-- Funci�n para calcular el total de todas las compras
CREATE OR REPLACE FUNCTION calcular_total_compras RETURN INT 
AS
  v_total INT := 0;
BEGIN
  SELECT SUM(TOTAL) INTO v_total FROM COMPRAS;
  RETURN v_total;
END calcular_total_compras;

-- Funci�n para obtener el proveedor con m�s compras
CREATE OR REPLACE FUNCTION proveedor_con_mas_compras RETURN VARCHAR2 
AS
  v_proveedor VARCHAR2(50);
BEGIN
  SELECT P.NOMBRE_PROVEEDOR
  INTO v_proveedor
  FROM COMPRAS C
  JOIN PROVEEDORES P ON C.ID_PROVEEDOR = P.ID_PROVEEDOR
  GROUP BY P.NOMBRE_PROVEEDOR
  ORDER BY COUNT(C.ID_COMPRA) DESC
  FETCH FIRST 1 ROW ONLY;
  RETURN v_proveedor;
END proveedor_con_mas_compras;


-----------------------------Cursores para COMPRAS-----------------------------

-- Crear un bloque PL/SQL
DECLARE
  CURSOR c_compras IS
    SELECT ID_COMPRA, FECHA_COMPRA FROM COMPRAS;
  v_id_compra COMPRAS.ID_COMPRA%TYPE;
  v_fecha_compra COMPRAS.FECHA_COMPRA%TYPE;
BEGIN
  OPEN c_compras;
  LOOP
    FETCH c_compras INTO v_id_compra, v_fecha_compra;
    EXIT WHEN c_compras%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('ID Compra: ' || v_id_compra || ', Fecha Compra: ' || v_fecha_compra); 
  END LOOP;
  CLOSE c_compras;
END;



-- Cursor para obtener compras de un proveedor espec�fico
CREATE OR REPLACE PROCEDURE OBTENER_COMPRAS_POR_PROVEEDOR(p_id_proveedor IN NUMBER) IS
  CURSOR c_compras_proveedor IS
    SELECT ID_COMPRA, FECHA_COMPRA 
    FROM COMPRAS 
    WHERE ID_PROVEEDOR = p_id_proveedor;
  
  v_id_compra_proveedor COMPRAS.ID_COMPRA%TYPE;
  v_fecha_compra_proveedor COMPRAS.FECHA_COMPRA%TYPE;
BEGIN
  OPEN c_compras_proveedor;
  LOOP
    FETCH c_compras_proveedor INTO v_id_compra_proveedor, v_fecha_compra_proveedor;

    EXIT WHEN c_compras_proveedor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('ID Compra: ' || v_id_compra_proveedor || ', Fecha Compra: ' || v_fecha_compra_proveedor);
  END LOOP;
  CLOSE c_compras_proveedor;
END;


