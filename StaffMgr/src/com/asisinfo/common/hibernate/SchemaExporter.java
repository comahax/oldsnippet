package com.asisinfo.common.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * ����hibernateӳ���ļ���Ӧ�Ľ������
 * @author johnson
 */
public class SchemaExporter {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SchemaExport schemaExport= new SchemaExport(cfg);
        schemaExport.setOutputFile("c://ra.sql");
        schemaExport.create(false, false);
    }
}
