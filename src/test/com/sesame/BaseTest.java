package com.sesame;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *  setting - Other Setting - JUNIT
 *	${SOURCEPATH}    原类的路径，就是你自己写的类
 	${PACKAGE}       原类的包名，java包命名规范就是按照包名一级一级创建文件夹的嘛
 	${filename}      测试类的类名
 *
 * ${SOURCEPATH}/../../test/java/${PACKAGE}/${FILENAME}
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public abstract class BaseTest {
}
