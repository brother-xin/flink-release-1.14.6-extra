package org.apache.flink.connector.jdbc;

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment;
import org.apache.flink.table.api.bridge.scala.StreamTableEnvironment;

import org.junit.Test;

public class MyAtomicTest {
    @Test
    public void testGauss(){
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(environment);
        String sql = "create table test(\n" +
                " id Integer,\n" +
                " name STRING)\n" +
                " with (\n" +
                " 'connector' = 'jdbc',\n" +
                " 'url' = 'jdbc:opengauss://192.168.11.206:5433/postgres',\n" +
                " 'table-name' = 'Person',\n" +
                " 'username' = 'test',\n" +
                " 'password' = 'qazwsx.123'\n" +
                ",'driver'='org.opengauss.Driver'\n" +
                " )" ;
        tableEnv.executeSql(sql);
        //tableEnv.executeSql("insert into test (id,name) values ("+RandomUtil.randomInt(3)+",'" + RandomUtil.randomString(5) + "')");
        tableEnv.executeSql("select * from test").print();
    }

    @Test
    public void testDM(){
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(environment);

        String sql = "create table CITY (CITY_ID String,\n" +
                "CITY_NAME String,\n" +
                "REGION_ID Int)\n" +
                "with (\n" +
                "'connector'='jdbc'\n" +
                ",'url'='jdbc:dm://10.10.81.14:5236/Test'\n" +
                ",'table-name'='CITY'\n" +
                ",'username'='SYSDBA'\n" +
                ",'password'='SYSDBA001'\n"+
                ")";
        tableEnv.executeSql(sql);
//        tableEnv.executeSql("insert into CITY (CITY_ID,CITY_NAME,REGION_ID) values ('023','chengdu',222)");
        tableEnv.executeSql("select * from CITY").print();
    }
    @Test
    public void testKingBase() {
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(environment);

        String sql = "create table test (id STRING,name STRING)\n" +
                "with (\n" +
                "'connector'='jdbc'\n" +
                ",'url'='jdbc:kingbase8://192.168.11.206:54321/test'\n" +
                ",'table-name'='helloword'\n" +
                ",'username'='system'\n" +
                ",'password'='system'\n" +
                ",'driver'='com.kingbase8.Driver'\n" +
                ")";
        tableEnv.executeSql(sql);
        //tableEnv.executeSql("insert into test (id,name) values ('" + IdUtil.fastSimpleUUID() + "','" + RandomUtil.randomString(5) + "')");
        tableEnv.executeSql("select * from test").print();
    }

}
