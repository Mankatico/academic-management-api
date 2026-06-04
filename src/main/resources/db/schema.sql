CREATE TABLE estudiante (
    id              SERIAL PRIMARY KEY,
    nombre          VARCHAR(100) NOT NULL,
    apellido        VARCHAR(100) NOT NULL,
    documento       VARCHAR(20)  NOT NULL UNIQUE,
    email           VARCHAR(150) NOT NULL UNIQUE,
    fecha_nacimiento DATE,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE materia (
    id       SERIAL PRIMARY KEY,
    nombre   VARCHAR(150) NOT NULL,
    codigo   VARCHAR(20)  NOT NULL UNIQUE,
    creditos INT          NOT NULL CHECK (creditos > 0)
);

CREATE TABLE periodo (
    id           SERIAL PRIMARY KEY,
    nombre       VARCHAR(50) NOT NULL,
    fecha_inicio DATE        NOT NULL,
    fecha_fin    DATE        NOT NULL,
    activo       BOOLEAN     DEFAULT false
);

CREATE TABLE grupo (
    id             SERIAL PRIMARY KEY,
    materia_id     INT         NOT NULL REFERENCES materia(id),
    periodo_id     INT         NOT NULL REFERENCES periodo(id),
    docente        VARCHAR(150) NOT NULL,  -- simple por ahora
    numero_grupo   INT          NOT NULL DEFAULT 1,
    cupo           INT          NOT NULL CHECK (cupo >= 0)
);

CREATE TABLE matricula (
    id             SERIAL PRIMARY KEY,
    estudiante_id  INT  NOT NULL REFERENCES estudiante(id),
    grupo_id       INT  NOT NULL REFERENCES grupo(id),
    fecha_matricula DATE NOT NULL DEFAULT CURRENT_DATE,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(estudiante_id, grupo_id)
);

CREATE TABLE calificacion (
    id               SERIAL PRIMARY KEY,
    matricula_id     INT     NOT NULL REFERENCES matricula(id),
    nota             DECIMAL(4,2) NOT NULL CHECK (nota >= 0 AND nota <= 5),
    tipo_evaluacion  VARCHAR(50) NOT NULL,
    fecha            DATE    NOT NULL,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
