package com.lori.mybatisdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String datasourceURL;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Bean
    public DataSource dataSource(Environment env){
        //设置真实数据源
        Map<String,DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("shardingJdbc0",buildDruidDataSource(env,"shardingJdbc0"));
        dataSourceMap.put("shardingJdbc1",buildDruidDataSource(env,"shardingJdbc1"));

        //配置分库分表规则
        TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration();
        tableRuleConfiguration.setLogicTable("user");
        tableRuleConfiguration.setActualDataNodes("shardingJdbc${0..1}.user${[0,1]}");
        //分库规则
        tableRuleConfiguration.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("city_id","shardingJdbc${city_id % 2}"));
        //分表规则
        tableRuleConfiguration.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id","user${user_id % 2}"));

        ShardingRuleConfiguration configuration = new ShardingRuleConfiguration();
        configuration.getTableRuleConfigs().add(tableRuleConfiguration);
        // 需要设置默认的数据源名称,否则一些表没有配置规则则无法使用数据源
        configuration.setDefaultDataSourceName("shardingJdbc0");

        DataSource dataSource;
        try {
            Properties properties = new Properties();
            properties.put("sql.show", "true");
            dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, configuration,new HashMap<>(),properties);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return dataSource;
    }

    private DataSource buildDruidDataSource(Environment env,final String dataSourceName){
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build(env, "spring.datasource.druid.");
        dataSource.setUrl(String.format(datasourceURL, dataSourceName));
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        return dataSource;
    }
}
