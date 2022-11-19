FROM arm64v8/postgres
COPY init-script-postgres.sh /docker-entrypoint-initdb.d/init-script-postgres.sh
