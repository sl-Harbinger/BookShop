-- schema owner
CREATE USER postgres WITH password 'postgres';

-- schema user
CREATE USER postgres_ms WITH password 'postgres_ms';

-- create schema
CREATE SCHEMA schema_book AUTHORIZATION postgres;

GRANT USAGE ON SCHEMA schema_book TO postgres_ms;

ALTER DEFAULT PRIVILEGES FOR USER postgres IN SCHEMA schema_book GRANT SELECT, INSERT, UPDATE, DELETE, TRUNCATE ON TABLES TO postgres_ms;
ALTER DEFAULT PRIVILEGES FOR USER postgres IN SCHEMA schema_book GRANT USAGE ON SEQUENCES TO postgres_ms;
ALTER DEFAULT PRIVILEGES FOR USER postgres IN SCHEMA schema_book GRANT EXECUTE ON FUNCTIONS TO postgres_ms;

alter user postgres_ms set search_path = 'schema_book';