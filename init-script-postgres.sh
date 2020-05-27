#!/bin/sh
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	 create table reservation ( id bigserial PRIMARY KEY, name text);
EOSQL
