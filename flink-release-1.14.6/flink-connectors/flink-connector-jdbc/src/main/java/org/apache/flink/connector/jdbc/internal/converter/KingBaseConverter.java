package org.apache.flink.connector.jdbc.internal.converter;

import org.apache.flink.table.types.logical.RowType;


public class KingBaseConverter extends AbstractJdbcRowConverter{

    
    public KingBaseConverter(RowType rowType) {
        super(rowType);
    }

    @Override
    public String converterName() {
        return "KingBase";
    }

}
