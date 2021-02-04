package com.tenet.generator.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MuggleStar
 * @date 2020/6/1 0:30
 */
@Data
public class GeneratorHelp {

    /**
     * 模板
     */
    private String template = "template/default";
    /**
     * 包名
     */
    private String packageName = "com.mugglestar";
    /**
     * 作者
     */
    private String author = "MuggleStar";
    /**
     * 生成文件主要工具类
     */
    private DataSourceConfig dataSourceConfig;
    /**
     *
     */
    private String filePath = System.getProperty("user.dir") + "./src/test/java/";

    private GeneratorHelp() {
    }

    public GeneratorHelp(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public void execute(String modelName, String tableName, String tablePrefix) {

        String filePath = this.filePath + packageName;
        AutoGenerator autoGenerator = new AutoGenerator();

        // 数据源配置
        autoGenerator.setDataSource(dataSourceConfig);

        // 全局配置

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(filePath);
        globalConfig.setAuthor(author);
        globalConfig.setOpen(false);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageName);
        packageConfig.setServiceImpl(packageConfig.getService() + "." + modelName + ".impl");
        packageConfig.setService(packageConfig.getService() + "." + modelName);
        packageConfig.setMapper(packageConfig.getMapper() + "." + modelName);
        packageConfig.setEntity(packageConfig.getEntity() + "." + modelName);

        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        fileOutConfigList.add(new FileOutConfig(template+"/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return filePath + "/entity/" + modelName
                        + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        fileOutConfigList.add(new FileOutConfig(template+"/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return filePath + "/mapper/" + modelName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });
        fileOutConfigList.add(new FileOutConfig(template+"/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return filePath + "/mapper/" + modelName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        fileOutConfigList.add(new FileOutConfig(template+"/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return filePath + "/service/" + modelName
                        + "/I" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });
        fileOutConfigList.add(new FileOutConfig(template+"/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return filePath + "/service/" + modelName
                        + "/impl/" + tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setTablePrefix(tablePrefix);
        strategyConfig.setInclude(tableName);

        // 禁用默认模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.disable(TemplateType.CONTROLLER,
                TemplateType.SERVICE,
                TemplateType.MAPPER,
                TemplateType.XML,
                TemplateType.ENTITY);

        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setCfg(injectionConfig);
        autoGenerator.setTemplate(templateConfig);
        autoGenerator.setStrategy(strategyConfig);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        autoGenerator.execute();

    }
}
