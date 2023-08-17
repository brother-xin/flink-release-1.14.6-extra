package org.apache.flink.connector.jdbc.dialect;

import org.apache.flink.connector.jdbc.internal.converter.JdbcRowConverter;
import org.apache.flink.connector.jdbc.internal.converter.KingBaseConverter;
import org.apache.flink.table.types.logical.LogicalTypeRoot;
import org.apache.flink.table.types.logical.RowType;

import java.util.List;
import java.util.Optional;

public class KingBaseDialect extends  AbstractDialect{


    @Override
    public int maxDecimalPrecision() {
        return 0;
    }

    @Override
    public int minDecimalPrecision() {
        return 0;
    }

    @Override
    public int maxTimestampPrecision() {
        return 0;
    }

    @Override
    public int minTimestampPrecision() {
        return 0;
    }

    @Override
    public List<LogicalTypeRoot> unsupportedTypes() {
        return null;
    }


    
    @Override
    public String dialectName() {
        return "Kingbase";
    }

    
    @Override
    public boolean canHandle(String url) {
        return url.startsWith("jdbc:kingbase8:");
    }

    
    @Override
    public JdbcRowConverter getRowConverter(RowType rowType) {
        return new KingBaseConverter(rowType);
    }

    @Override
    public String getLimitClause(long limit) {
        return null;
    }

    
    @Override
    public Optional<String> defaultDriverName() {
        return Optional.of("com.kingbase8.Driver");
    }


    
//    @Override
//    public String getInsertIntoStatement(String tableName, String[] fieldNames) {
//        String columns =
//                Arrays.stream(fieldNames)
//                        .map(this::quoteIdentifier)
//                        .collect(Collectors.joining(", "));
//        String placeholders =
//                Arrays.stream(fieldNames).map(f -> ":" + f).collect(Collectors.joining(", "));
//        return "INSERT INTO "
//                + quoteIdentifier(tableName)
//                + "("
//                + columns
//                + ")"
//                + " VALUES ("
//                + placeholders
//                + ")";
//    }


    
    @Override
    public String quoteIdentifier(String identifier) {
        return super.quoteIdentifier(identifier);
    }
}
