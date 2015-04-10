-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema akuavida
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `akuavida` ;

-- -----------------------------------------------------
-- Schema akuavida
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `akuavida` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `akuavida` ;

-- -----------------------------------------------------
-- Table `akuavida`.`Categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Categorias` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Categorias` (
  `ID_Categoria` INT NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria de categoria',
  `Nombre` VARCHAR(45) NOT NULL COMMENT 'nombre de la categoria ',
  `Activa` TINYINT(1) NOT NULL COMMENT 'Si la categoria Esta activa o esta incativa',
  `Pariente` INT NOT NULL COMMENT 'La categoria Padre ',
  PRIMARY KEY (`ID_Categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Producto` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Producto` (
  `ID_producto` VARCHAR(200) NOT NULL COMMENT 'Llave Primaria Del producto puede generarse por el codigo de barras del producto',
  `Nombre` VARCHAR(60) NOT NULL COMMENT 'Nombre Del producto',
  `Precio` FLOAT NOT NULL COMMENT 'Pecio del Producto',
  `Imagen` LONGBLOB NULL COMMENT 'imagen del producto jpg, png, gif',
  `Descripcion` LONGTEXT NOT NULL COMMENT 'descripcion Del Producto, y caracteristicas',
  `Cantidad` INT NOT NULL COMMENT 'Cantidad que hay en el inventario del producto',
  `Activo` TINYINT(1) NOT NULL DEFAULT 1 COMMENT 'Si el producto esta activo o inactivo',
  `impuesto` FLOAT NOT NULL COMMENT 'El IVA que contiene el producto',
  `Categorias_ID_Categoria` INT NOT NULL,
  PRIMARY KEY (`ID_producto`),
  INDEX `fk_Producto_Categorias1_idx` (`Categorias_ID_Categoria` ASC),
  CONSTRAINT `fk_Producto_Categorias1`
    FOREIGN KEY (`Categorias_ID_Categoria`)
    REFERENCES `akuavida`.`Categorias` (`ID_Categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Usuario` (
  `idUsusario` VARCHAR(200) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsusario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Cuenta` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Cuenta` (
  `Tipo_Documento` VARCHAR(10) NOT NULL COMMENT 'Llave Primaria compuesta de Tipo de documento',
  `Numero_Documento` VARCHAR(50) NOT NULL COMMENT 'Llave primaria Compuesta de numero  de documento',
  `Primer_Nombre` VARCHAR(60) NOT NULL COMMENT 'Primer Nombre del usuario',
  `Segundo_Nombre` VARCHAR(60) NULL COMMENT 'Segundo nombre del usuario (opcional)',
  `Primer_Apellido` VARCHAR(60) NOT NULL COMMENT 'Primer Apellido del usuario',
  `Segundo_Apellido` VARCHAR(60) NULL COMMENT 'Segundo apellido del Usuario (opcional)',
  `Direccion` VARCHAR(30) NOT NULL COMMENT 'Direccion de residencia  que ingresa el usuario ',
  `Telefono` VARCHAR(20) NULL COMMENT 'Telefono fijo que ingresa el usuario ',
  `Rool` VARCHAR(30) NOT NULL COMMENT 'con esto se especifica los diferentes roles de los usuarios',
  `Activo` TINYINT(1) NOT NULL COMMENT 'Si la cuenta existe o no existe ',
  `Ususario_idUsusario` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Tipo_Documento`, `Numero_Documento`),
  INDEX `fk_Cuenta_Ususario1_idx` (`Ususario_idUsusario` ASC),
  CONSTRAINT `fk_Cuenta_Ususario1`
    FOREIGN KEY (`Ususario_idUsusario`)
    REFERENCES `akuavida`.`Usuario` (`idUsusario`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Factura` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Factura` (
  `ID_Factura` INT NOT NULL AUTO_INCREMENT COMMENT 'Llave primaria de factura',
  `Fecha` DATE NULL COMMENT 'Fecha y hora en que se realiza la factura',
  `Cuenta_Tipo_Documento` VARCHAR(10) NOT NULL,
  `Cuenta_Numero_Documento` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID_Factura`),
  INDEX `fk_Factura_Cuenta1_idx` (`Cuenta_Tipo_Documento` ASC, `Cuenta_Numero_Documento` ASC),
  CONSTRAINT `fk_Factura_Cuenta1`
    FOREIGN KEY (`Cuenta_Tipo_Documento` , `Cuenta_Numero_Documento`)
    REFERENCES `akuavida`.`Cuenta` (`Tipo_Documento` , `Numero_Documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Pedido` (
  `Factura_ID_Factura` INT NOT NULL,
  `Fecha` DATE NULL COMMENT 'Fecha y Hora en que se realiza el pedido',
  `Subtotal` FLOAT NOT NULL COMMENT 'El subtotal del pedido',
  `Total` FLOAT NOT NULL COMMENT 'El total a pagar del pedido',
  INDEX `fk_Pedido_Factura1_idx` (`Factura_ID_Factura` ASC),
  PRIMARY KEY (`Factura_ID_Factura`),
  CONSTRAINT `fk_Pedido_Factura1`
    FOREIGN KEY (`Factura_ID_Factura`)
    REFERENCES `akuavida`.`Factura` (`ID_Factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Item` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Item` (
  `Producto_ID_producto` VARCHAR(200) NOT NULL COMMENT 'Llave foranea de Proucto',
  `Pedido_Factura_ID_Factura` INT NOT NULL,
  `Cantidad` INT NOT NULL COMMENT 'cantidad total de Items',
  `Costo_Total` FLOAT NOT NULL COMMENT 'Costo total de los Productos',
  `Costo_Unitario` FLOAT NOT NULL COMMENT 'Costo Unitario de los Productos',
  PRIMARY KEY (`Producto_ID_producto`, `Pedido_Factura_ID_Factura`),
  INDEX `fk_Producto_has_Pedido_Producto1_idx` (`Producto_ID_producto` ASC),
  INDEX `fk_Item_Pedido1_idx` (`Pedido_Factura_ID_Factura` ASC),
  CONSTRAINT `fk_Producto_has_Pedido_Producto1`
    FOREIGN KEY (`Producto_ID_producto`)
    REFERENCES `akuavida`.`Producto` (`ID_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_Pedido1`
    FOREIGN KEY (`Pedido_Factura_ID_Factura`)
    REFERENCES `akuavida`.`Pedido` (`Factura_ID_Factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Carrito_De_Compras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Carrito_De_Compras` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Carrito_De_Compras` (
  `ID_Carrito` VARCHAR(250) NOT NULL COMMENT 'Llave Primaria de carrito de compras',
  `Total` FLOAT NOT NULL COMMENT 'El total a pagar de productos en el carrito de compras',
  `Subtotal` FLOAT NOT NULL COMMENT 'Subtotal de la cantidad del mismo producto',
  PRIMARY KEY (`ID_Carrito`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Inventario` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Inventario` (
  `ID_Inventario` INT NOT NULL AUTO_INCREMENT COMMENT 'Llave Primaria de inventario',
  `Cantidad` INT NOT NULL COMMENT 'Cantidad que hay en el inventario de productos',
  `Producto_ID_producto` VARCHAR(200) NOT NULL COMMENT 'llave foranea del producto',
  `Cantidad_Producto_Comprado` FLOAT NOT NULL COMMENT 'Cantidad de Productos comprados',
  `Fecha_De_Compra` DATE NOT NULL COMMENT 'fecha en que se compro el producto',
  PRIMARY KEY (`ID_Inventario`, `Producto_ID_producto`),
  INDEX `fk_Inventario_Producto1_idx` (`Producto_ID_producto` ASC),
  CONSTRAINT `fk_Inventario_Producto1`
    FOREIGN KEY (`Producto_ID_producto`)
    REFERENCES `akuavida`.`Producto` (`ID_producto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`pago` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`pago` (
  `Factura_ID_Factura` INT NOT NULL,
  `Tipo_Pago` VARCHAR(45) NOT NULL COMMENT 'El tipo de pago que el usuario  selecciona',
  `Numero_Tarjeta` VARCHAR(100) NOT NULL COMMENT 'El numero de la tarjeta de credito del usuario',
  INDEX `fk_pago_Factura1_idx` (`Factura_ID_Factura` ASC),
  PRIMARY KEY (`Factura_ID_Factura`),
  CONSTRAINT `fk_pago_Factura1`
    FOREIGN KEY (`Factura_ID_Factura`)
    REFERENCES `akuavida`.`Factura` (`ID_Factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Promociones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Promociones` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Promociones` (
  `Id_Promocion` VARCHAR(200) NOT NULL COMMENT 'llave primaria de promocion',
  `Descuentos` FLOAT NOT NULL COMMENT 'descuentos que se le realizara al producto en promocion',
  `Nombre` VARCHAR(60) NOT NULL COMMENT 'Nombre de la promocion',
  `Precio` FLOAT NOT NULL COMMENT 'Precio total de la promocion',
  `Producto_ID_producto` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Id_Promocion`),
  INDEX `fk_Promociones_Producto1_idx` (`Producto_ID_producto` ASC),
  CONSTRAINT `fk_Promociones_Producto1`
    FOREIGN KEY (`Producto_ID_producto`)
    REFERENCES `akuavida`.`Producto` (`ID_producto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Departamento` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Departamento` (
  `idDepartamento` VARCHAR(200) NOT NULL,
  `Nombre_Departamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Municipio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Municipio` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Municipio` (
  `idMunicipio` VARCHAR(200) NOT NULL,
  `Nombre_Municipio` VARCHAR(45) NOT NULL,
  `Departamento_idDepartamento` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idMunicipio`),
  INDEX `fk_Municipio_Departamento1_idx` (`Departamento_idDepartamento` ASC),
  CONSTRAINT `fk_Municipio_Departamento1`
    FOREIGN KEY (`Departamento_idDepartamento`)
    REFERENCES `akuavida`.`Departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Domicilio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Domicilio` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Domicilio` (
  `Municipio_idMunicipio` VARCHAR(200) NOT NULL,
  `Cuenta_Tipo_Documento` VARCHAR(10) NOT NULL,
  `Cuenta_Numero_Documento` VARCHAR(50) NOT NULL,
  `Ciudad` VARCHAR(45) NOT NULL COMMENT 'llave primaria de domicilio',
  `Direccion` VARCHAR(45) NOT NULL COMMENT 'Lugar de residencia del Usuario',
  `Telefono` VARCHAR(30) NOT NULL COMMENT 'telefono fijo del usuario',
  INDEX `fk_Domicilio_Municipio1_idx` (`Municipio_idMunicipio` ASC),
  INDEX `fk_Domicilio_Cuenta1_idx` (`Cuenta_Tipo_Documento` ASC, `Cuenta_Numero_Documento` ASC),
  PRIMARY KEY (`Cuenta_Tipo_Documento`, `Cuenta_Numero_Documento`),
  CONSTRAINT `fk_Domicilio_Municipio1`
    FOREIGN KEY (`Municipio_idMunicipio`)
    REFERENCES `akuavida`.`Municipio` (`idMunicipio`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Domicilio_Cuenta1`
    FOREIGN KEY (`Cuenta_Tipo_Documento` , `Cuenta_Numero_Documento`)
    REFERENCES `akuavida`.`Cuenta` (`Tipo_Documento` , `Numero_Documento`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akuavida`.`Items_del_Carrito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akuavida`.`Items_del_Carrito` ;

CREATE TABLE IF NOT EXISTS `akuavida`.`Items_del_Carrito` (
  `Producto_ID_producto` VARCHAR(200) NOT NULL COMMENT 'Llave franea de producto',
  `Cantidad` INT ZEROFILL NOT NULL COMMENT 'cantidad de productos que se agragan al carrito de compras',
  `Costo_Unitario` FLOAT NOT NULL COMMENT 'Costo del producto Por valor unitario',
  `Costo_Total` FLOAT NOT NULL COMMENT 'Costo total del valor unitario de productos que hay en el carrito de compras',
  `Carrito_De_Compras_ID_Carrito` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`Producto_ID_producto`, `Carrito_De_Compras_ID_Carrito`),
  INDEX `fk_Producto_has_Carrito_De_Compras_Producto1_idx` (`Producto_ID_producto` ASC),
  INDEX `fk_Items_del_Carrito_Carrito_De_Compras1_idx` (`Carrito_De_Compras_ID_Carrito` ASC),
  CONSTRAINT `fk_Producto_has_Carrito_De_Compras_Producto1`
    FOREIGN KEY (`Producto_ID_producto`)
    REFERENCES `akuavida`.`Producto` (`ID_producto`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Items_del_Carrito_Carrito_De_Compras1`
    FOREIGN KEY (`Carrito_De_Compras_ID_Carrito`)
    REFERENCES `akuavida`.`Carrito_De_Compras` (`ID_Carrito`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
