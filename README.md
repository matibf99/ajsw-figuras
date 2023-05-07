# Aplicación Java sobre Web

Actividades del proyecto de figuras geométricas. Este proyecto es una aplicación Java que permite crear y manipular diferentes tipos de figuras geométricas. Para ejecutar la aplicación, se necesita tener Docker y docker-compose instalados en el sistema.

## Requisitos

- OpenJDK 20
- Docker
- docker-compose

## Ejecución

Para ejecutar la aplicación, es necesario seguir los siguientes pasos:

1. Clonar el repositorio en su computadora:

```bash
git clone https://github.com/matibf99/ajsw-figuras.git
```

2. En otro directorio distinto al de la aplicación, crear el archivo `docker-compose.yml` y copiar el siguiente contenido:

```yaml
version: '3.1'

services:
 db:
   image: mysql
   command: --default-authentication-plugin=mysql_native_password
   restart: always
   environment:
     MYSQL_ROOT_PASSWORD: password1234
     MYSQL_DATABASE: shapes
   ports:
     - 3306:3306
```

Este archivo define un contenedor de base de datos MySQL que se utilizará para almacenar las figuras.

3. En el directorio raíz donde se encuentra el archivo `docker-compose.yml`, ejecutar el siguiente comando:

```bash
docker-compose up
```

Este comando iniciará el contenedor de la base de datos. 

Después de crear la base de datos, la aplicación debería poder conectarse a ella y utilizarla para almacenar las figuras.

4. Ejecutar la aplicación Java.

Se puede ejecutar la aplicación desde un IDE como IntelliJ o, alternativamente, compilar y ejecutar la aplicación desde la línea de comandos con el siguiente comando en el directorio raíz del proyecto:

```bash
mvn spring-boot:run
```

## Funcionalidades

La aplicación permite realizar las siguientes operaciones:

- Crear figuras geométricas (círculos, rectángulos, triángulos, etc.).
- Editar figuras existentes.
- Eliminar figuras.
- Mostrar todas las figuras almacenadas en la base de datos.
