web: java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT wishlist-service/target/*.war
release: java -jar target/dependency/liquibase.jar --changeLogFile=wishlist-service/src/main/resources/db/changelog/db.changelog-master.xml --url=$JDBC_DATABASE_URL --classpath=wishlist-service/target/dependency/postgres.jar update
