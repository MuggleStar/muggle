package tests;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.tenet.generator.utils.GeneratorHelp;
import org.junit.Test;

/**
 * @author MuggleStar
 * @date 2020/6/2 23:06
 */
public class GeneratorTest {

    @Test
    public void testExecute() {

        DataSourceConfig dataSourceConfig = new DataSourceConfig();

        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://mysql.tenet.com:3306/tenet-backend?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        GeneratorHelp generatorHelp = new GeneratorHelp(dataSourceConfig);
        generatorHelp.setAuthor("Madison");
        generatorHelp.setPackageName("com.tenet.backend");

        generatorHelp.execute("menu","bc_menu","");
        generatorHelp.execute("role","bc_role_menu","");
        generatorHelp.execute("role","bc_role","");
        generatorHelp.execute("user","bc_user_role","");
        generatorHelp.execute("user","bc_user","");

    }


}
