# flink-release-1.14.6-extra

Flink-connector-jdbc新增自定义connector

更新Flink-connector-jdbc的连接器，新增OpenGauss和达梦数据库的连接器

OpenGauss：

    tenv.executeSql(
      """
        |create table Person(
        | ID Integer,
        | Name STRING)
        | with (
        | 'connector' = 'jdbc',
        | 'url' = 'jdbc:opengauss://192.168.11.206:5433/postgres',
        | 'table-name' = 'Person',
        | 'username' = 'test',
        | 'password' = 'qazwsx.123'
        | )
        |""".stripMargin)     

DM:

     tenv.executeSql(
      """
        |create table CITY(
        | CITY_ID String,
        | CITY_NAME String,
        | REGION_ID Int)
        | with (
        | 'connector' = 'jdbc',
        | 'url' = 'jdbc:dm://10.10.81.14:5236/SYSDBA',
        | 'table-name' = 'CITY',
        | 'username' = 'SYSDBA',
        | 'password' = 'SYSDBA001'
        | )
        |""".stripMargin)
